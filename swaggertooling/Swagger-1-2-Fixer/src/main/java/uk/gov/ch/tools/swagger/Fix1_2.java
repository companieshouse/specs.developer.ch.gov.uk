package uk.gov.ch.tools.swagger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Small application to patch some of the badly formed Swagger 1.2 specifications to make them well
 * formed. The initial draft is based on the insolvency spec json
 */
public class Fix1_2 {

    private static ISource source;

    public static void main(String... args) {
        Fix1_2 fixer = new Fix1_2();
        fixer.parseArgs(args);
        fixer.fixFiles();
    }

    private static String readFile(final File path) {
        try {
            System.out.println("Reading: " + path);
            final byte[] encoded = Files.readAllBytes(path.toPath());
            return new String(encoded, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
            ex.printStackTrace();
            return null;
        }
    }

    static JsonNode fixJson(final File file) {
        final Path relativeToBase = getRelativeToBase(source.getWorkingDir(), file.getPath());
        final String jsonContent = readFile(relativeToBase.toFile());
        final JsonNodeExtractor ne = new JsonNodeExtractor(file.getName());
        return ne.convertJson(jsonContent);
    }

    private static Path getRelativeToBase(final Path base, final String file) {
        return base.resolve(file);
    }

    private void fixFiles() {
        source.getInputFiles().forEach(this::fixContent);
    }

    private void fixContent(final File fName) {
        final JsonNode fixedNode = fixJson(fName);
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            final String fixedString = objectMapper.writeValueAsString(fixedNode);
            final byte[] bytes = fixedString.getBytes(StandardCharsets.UTF_8);
            final String outDir = source.getOutputDir();
            Path outPath;
            if (outDir.isEmpty()) {
                outPath = Paths.get(fName + ".fixed.json");
            } else {
                outPath = getRelativeToBase(Paths.get(outDir),
                        fName.toPath().getFileName().toString());
            }
            System.out.println("Writing: " + outPath);
            Files.write(outPath, bytes);
        } catch (IOException e) {
            System.err.println("Fixing '" + fName + "'");
            e.printStackTrace();
        }
    }

    private void parseArgs(String[] args) {
        ArgPackager argPackager = new ArgPackager(args);
        source = argPackager.getSource();
    }

}

