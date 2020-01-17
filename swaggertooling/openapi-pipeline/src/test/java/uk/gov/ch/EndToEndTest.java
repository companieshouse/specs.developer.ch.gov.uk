package uk.gov.ch;

import org.junit.jupiter.api.Test;
import uk.gov.ch.openapi.validator.OpenAPI3Validator;
import uk.gov.ch.openapi.validator.ValidationResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EndToEndTest {

    @Test
    void fullTest() throws IOException {
        String spec = "spec";
        File workingFile = new File("target/test-classes");
        String specOut = "specsOutput";

        APIValidatorPipeline.main("-i", spec, "-o", specOut, "-w", workingFile.getCanonicalPath());


        File specOutDir = workingFile.toPath().resolve(specOut).toFile();
        assertTrue(specOutDir.isDirectory());
        File specOutBadDir = specOutDir.toPath().resolve("unconvertable").toFile();
        assertTrue(specOutBadDir.isDirectory());

        File specsDir = workingFile.toPath().resolve(spec).toFile();
        assertTrue(specOutDir.isDirectory());

        final List<File> goodFiles = Arrays.asList(specOutDir.listFiles());
        final List<File> badFiles = Arrays.asList(specOutBadDir.listFiles());
        final List<File> tempAllFiles = new ArrayList<>(goodFiles);
        tempAllFiles.addAll(badFiles);
        final List<File> allFiles = Collections.unmodifiableList
                (tempAllFiles);
        final List<File> specFiles = Arrays.asList(specsDir.listFiles());
        assertEquals(specFiles.size(), allFiles.size());
        specFiles.forEach(file -> assertTrue(matchesInGoodOrBad(file, allFiles)));
        goodFiles.forEach(file -> {
            if (!file.isDirectory()) {
                try {
                    final String canonicalPath = file.getCanonicalPath();
                    final int validationResult = OpenAPI3Validator.main("-i", canonicalPath);
                    assertEquals(ValidationResult.PASS.resultValue, validationResult);
                } catch (IOException e) {
                    fail(e);
                }
            }
        });
        badFiles.forEach(file -> {
            if (!file.isDirectory()) {
                try {
                    final String canonicalPath = file.getCanonicalPath();
                    final int validationResult = OpenAPI3Validator.main("-i", canonicalPath);
                    assertNotEquals(ValidationResult.PASS.resultValue, validationResult);
                } catch (IOException e) {
                    fail(e);
                }
            }
        });
    }

    private boolean matchesInGoodOrBad(File f, List<File> allFiles) {
        if (f.isDirectory()) {
            return true;
        } else {
            return allFiles.stream().anyMatch(af -> af.getName().equals(f.getName()));
        }
    }
}
