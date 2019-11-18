package uk.gov.ch.swagger;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import uk.gov.utils.ValidationUtils;

class VersionConverterTest {

    @Test
    void generateOpenApiFile() throws Exception {
        final String workingDir = new File("target").getCanonicalPath();
        final String inputFile = "test-classes/spec/insolvency.json";
        final String outputDir = new File("target/openapi3/spec").getCanonicalPath();
        final Path outPath = Paths.get(outputDir);

        cleanDirectory(outPath);

        VersionConverter.main("-i", inputFile, "-o", outputDir, "-w", workingDir);

        assertTrue(Files.exists(outPath));
        CheckSchema(outPath.resolve("insolvency.json"));
    }

    private void CheckSchema(final Path destination) throws IOException, ProcessingException {
        File schemaFile = new File("target/test-classes/schema/openapi3schema.json");
        File jsonFile = destination.toFile();

        final JsonSchema schemaNode = ValidationUtils.getSchemaNode(schemaFile);
        final JsonNode jsonNode = ValidationUtils.getJsonNode(jsonFile);
        final ProcessingReport report = schemaNode.validate(jsonNode);
        for (final ProcessingMessage message : report) {
            System.err.println(message);
        }
        assertTrue(report.isSuccess());
    }

    @Test
    void generateOpenApiDirectory() throws Exception {
        final String workingDir = new File("target").getCanonicalPath();
        final String inputFile = "test-classes/spec";
        final String outputDir = new File("target/openapi3/spec").getCanonicalPath();
        final Path outPath = Paths.get(outputDir);

        cleanDirectory(outPath);

        VersionConverter.main("-i", inputFile, "-o", outputDir, "-w", workingDir);

        assertTrue(Files.exists(outPath));
    }


    private void cleanDirectory(final Path outPath) throws IOException {

        if (Files.exists(outPath)) {
            Files.walk(outPath)
                    .map(Path::toFile)
                    .sorted((o1, o2) -> -o1.compareTo(o2))
                    .forEach(File::delete);
            Files.deleteIfExists(outPath);
        }
    }
}