package uk.gov.ch.tools.swagger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class JsonNodeExtractor {

    private static final String ARRAY = "array";
    private static final String MODELS = "models";
    private static final String DATE = "date";
    private static final String STRING = "string";
    private static final String FORMAT = "format";
    private static final String TYPE = "type";
    private static final Map<String, String> unmodifiableSubstitutions;
    private static final String OBJECT = "object";

    static {
        final Map<String, String> substitutions = new HashMap<>();
        substitutions.put("String", STRING);
        substitutions.put("Array", ARRAY);
        substitutions.put("List", ARRAY);
        substitutions.put("list", ARRAY);
        substitutions.put("<value>", OBJECT);
        unmodifiableSubstitutions = Collections.unmodifiableMap(substitutions);
    }

    private final String sourceName;

    JsonNodeExtractor(final String sourceName) {

        this.sourceName = sourceName;
    }

    private static void fixParentObjectType(final ObjectNode node) {
        final String type = node.get(TYPE).asText();
        final String subst = unmodifiableSubstitutions.getOrDefault(type, null);
        if (subst != null) {
            node.put(TYPE, subst);
        } else {
            if (type.equalsIgnoreCase(DATE)) {
                node.put(TYPE, STRING);
                node.put(FORMAT, DATE);
            }
        }
    }

    JsonNode convertJson(String jsonContent) {
        JsonNode node = null;
        try {
            final ObjectMapper mapper = new ObjectMapper();
            node = mapper.readTree(jsonContent);
            processExternalModels(node);
            processAtAt(node);
            processNames(node);
            processTypes(node);
            processHtml(node);
            processApiVersion(node);
            processInfoBlock(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return node;
    }

    private void processNames(final JsonNode rootNode) {
        final List<JsonNode> properties = rootNode.findValues("properties");
        properties.forEach(this::processPropertyNames);
    }

    private void processPropertyNames(final JsonNode property) {

        if (property.isObject()) {
            final List<String> nodeNames = new LinkedList<>();
            property.fields().forEachRemaining(entry -> nodeNames.add(entry.getKey()));
            try (Stream<String> badNames = nodeNames.stream()
                    .filter(Objects::nonNull)
                    .filter(name -> name.contains("<"))
                    .filter(name -> name.contains(">"))) {
                badNames.forEach(name -> renameBadProperty(property, name)
                );
            }
        }
    }

    private void renameBadProperty(JsonNode property, String name) {
        String newName = name.replace("<", "").replace(">", "");
        final JsonNode value = property.findValue(name);
        final ObjectNode objectNode = (ObjectNode) property;
        objectNode.remove(name);
        objectNode.replace(newName, value);
    }

    private void processInfoBlock(JsonNode rootNode) {
        ObjectNode info = (ObjectNode) rootNode.findValue("info");
        if (info == null) {
            final ObjectNode root = (ObjectNode) rootNode;
            info = root.putObject("info");
        }
        if (info.findValue("title") == null) {
            info.put("title", generatedTitle());
        }
        if (info.findValue("description") == null) {
            info.put("description",
                    "**This specification was generated from old data and may not reflect the actual API.**");
        }
    }

    private String generatedTitle() {
        String fName = sourceName;
        if (fName.endsWith(".json")) {
            fName = fName.substring(0, fName.length() - 5);
        }
        // Substitute spaces for punctuation
        for (int i = fName.length() - 1; i >= 0; i--) {
            final char ch = fName.charAt(i);
            if (!(Character.isAlphabetic(ch) || Character.isDigit(ch))) {
                fName = fName.replace(ch, ' ');
            }
        }
        return fName + " Specification";
    }

    private void processApiVersion(final JsonNode rootNode) {
        final JsonNode version = rootNode.findValue("apiVersion");
        if (version == null) {
            ((ObjectNode) rootNode).put("apiVersion", "0.0.1");
        }
    }

    /**
     * Search for embedded html markup and remove it, so that it does not
     */
    private void processHtml(final JsonNode node) {
        final Iterator<Entry<String, JsonNode>> nodeFields = node.fields();
        while (nodeFields.hasNext()) {
            final Entry<String, JsonNode> field = nodeFields.next();
            final String key = field.getKey();
            final JsonNode value = field.getValue();
            if (value.isTextual()) {
                final String originalValue = value.textValue();
                if (originalValue.contains("<")) {
                    HtmlCleaner htmlCleaner = new HtmlCleaner();
                    final String fixedValue = htmlCleaner.removeHtml(originalValue);
                    replaceTextNodeValue(node, key, value, fixedValue);
                }
            } else {
                processHtml(value);
            }
        }
    }

    private void replaceTextNodeValue(final JsonNode root, final String key, final JsonNode value,
            final String fixedValue) {
        final List<JsonNode> possibleParents = root.findParents(key);
        for (final JsonNode parent : possibleParents) {
            if (parent.get(key) == value) {
                ((ObjectNode) parent).replace(key, TextNode.valueOf(fixedValue));
            }
        }
    }

    private void processAtAt(final JsonNode node) {
        final ObjectNode baseParent = (ObjectNode) node.findParent("basePath");
        if (baseParent != null) {
            String value = baseParent.get("basePath").asText();
            if (value.startsWith("@@")) {
                value = "http://example.com/" + value.replace("@", "");
            }
            baseParent.replace("basePath", new TextNode(value));
        }
    }

    /**
     * Fix the non-standard external Models, by loading the external files into the correct part of
     * the JSON DOM so that the converter actually parses correctly and include referenced models.
     * This will act recursively as the internals of the included models may need to be fixed, in
     * their own right.
     */
    private void processExternalModels(JsonNode node) {
        final JsonNode external = node.get("externalModels");
        if (external != null && external.isArray()) {
            external.forEach(el -> includeModelFile(node, el));
            ((ObjectNode) node).remove("externalModels");
        }
    }

    private void includeModelFile(JsonNode root, JsonNode el) {
        final String target = el.get("path").asText(null);
        if (target != null) {
            String relativePath = target.startsWith("/") ? target.substring(1) : target;
            final File path = new File(relativePath);
            try {
                final JsonNode inclusion = Fix1_2.fixJson(path);
                final ObjectNode includeModels = (ObjectNode) inclusion.get(MODELS);
                final ObjectNode rootModels = getRootModel(root);
                Iterator<Entry<String, JsonNode>> it = includeModels.fields();
                while (it.hasNext()) {
                    final Entry<String, JsonNode> field = it.next();
                    rootModels.replace(field.getKey(), field.getValue());
                }
            } catch (final Exception ex) {
                System.err
                        .println("Problem including model file not found '" + path + "'");
                ex.printStackTrace();
            }
        }
    }

    private ObjectNode getRootModel(JsonNode root) {
        ObjectNode rootModels = (ObjectNode) root.get(MODELS);
        if (rootModels == null) {
            final ObjectNode oRoot = (ObjectNode) root;
            rootModels = oRoot.objectNode();
            oRoot.replace(MODELS, rootModels);
        }
        return rootModels;
    }

    private void processTypes(final JsonNode node) {
        substituteKnownBadTypes(node);
        processTypeProperties(node);
    }

    private void processTypeProperties(final JsonNode node) {
        final JsonNode models = node.findValue("models");
        if (models != null) {
            for (final JsonNode model : models) {
                final JsonNode properties = model.findValue("properties");
                for (final JsonNode property : properties) {
                    fixMissingParameterType(property);
                    fixEnums(property);
                }
            }
        }
    }

    private void fixEnums(final JsonNode property) {

        final JsonNode enumNode = property.findValue("enum");

        final List<String> enumValues = new LinkedList<>();
        if (enumNode != null && enumNode.isArray()) {
            enumNode.forEach(en -> enumValues.add(en.asText()));
            final List<String> distinctValues = enumValues.stream().distinct()
                    .collect(Collectors.toList());
            // are there duplicate enums values
            if (distinctValues.size() < enumValues.size()) {
                final ObjectNode oProperty = (ObjectNode) property;
                final ArrayNode aEnum = oProperty.putArray("enum");
                distinctValues.forEach(aEnum::add);
            }
        }
    }

    private void fixMissingParameterType(final JsonNode property) {
        if (!property.has(TYPE)) {
            ((ObjectNode) property).replace(TYPE, ((ObjectNode) property)
                    .textNode(property.has("items") ? ARRAY : OBJECT));
        }
    }

    private void substituteKnownBadTypes(final JsonNode node) {
        final List<JsonNode> typeParents = node.findParents(TYPE);
        typeParents.stream()
                .filter(n -> n instanceof ObjectNode)
                .map(on -> (ObjectNode) on)
                .forEach(JsonNodeExtractor::fixParentObjectType);
    }
}
