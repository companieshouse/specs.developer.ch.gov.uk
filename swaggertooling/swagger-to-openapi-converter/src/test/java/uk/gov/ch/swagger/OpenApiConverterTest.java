package uk.gov.ch.swagger;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class OpenApiConverterTest {

    @Test
    void codeGenUpgrade() throws IOException {
        final String inputFile = new File("test-resources/spec/insolvency.json").getCanonicalPath();
        final String outputDir = new File("target/openapi3/openAPI/spec").getCanonicalPath();

        final Path outPath = Paths.get(outputDir);
        Files.deleteIfExists(outPath);
        OpenApiConverter versionConverter = new OpenApiConverter();
        versionConverter
                .codeGenUpgrade("generate", "-i", inputFile, "-o", outputDir, "-l", "openapi");
        assertTrue(Files.exists(outPath));
    }
}