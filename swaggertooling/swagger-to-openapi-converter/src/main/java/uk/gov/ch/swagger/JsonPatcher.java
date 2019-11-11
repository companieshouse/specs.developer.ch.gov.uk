package uk.gov.ch.swagger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonPatcher {

    public static final String TITLE = "title";
    public static final String INFO = "info";
    public static final String VERSION = "version";
    public static final String JSON = ".json";
    private final Path source;
    private final File inputFile;
    private final JsonNode rootNode;

    public JsonPatcher(final Path source, final File inputFile) {
        this.source = source;
        this.inputFile = inputFile;
        final String jsonData = readFile(source.toFile());
        rootNode = convertToJson(jsonData);
    }

    private static String readFile(final File path) {
        try {
            System.out.println("Reading: " + path);
            final byte[] encoded = Files.readAllBytes(path.toPath());
            return new String(encoded, StandardCharsets.UTF_8);
        } catch (final Exception ex) {
            System.err.println(ex.getLocalizedMessage());
            ex.printStackTrace();
            return null;
        }
    }

    private JsonNode convertToJson(final String jsonContent) {
        JsonNode node = null;
        try {
            final ObjectMapper mapper = new ObjectMapper();
            node = mapper.readTree(jsonContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return node;
    }

    public JsonNode patchInfo() {
        final ObjectNode info = (ObjectNode) rootNode.findValue(INFO);
        if (info != null) {
            if (info.findValue(TITLE) == null) {
                info.put(TITLE, generatedTitle());
            }
            if (info.findValue(VERSION) == null) {
                info.put(VERSION, generatedVersion());
            }
        }
        return rootNode;
    }

    private String generatedVersion() {
        return "0.0.1";
    }

    private String generatedTitle() {
        String fName = inputFile.getName();
        if (fName.endsWith(JSON)) {
            fName = fName.substring(0, fName.length() - 5);
        }
        // Substitute spaces for punctuation
        for (int i = fName.length() - 1; i >= 0; i--) {
            final Character ch = fName.charAt(i);
            if (!(Character.isAlphabetic(ch) || Character.isDigit(ch))) {
                fName = fName.replace(ch, ' ');
            }
        }
        return fName + " Specification";
    }
}
