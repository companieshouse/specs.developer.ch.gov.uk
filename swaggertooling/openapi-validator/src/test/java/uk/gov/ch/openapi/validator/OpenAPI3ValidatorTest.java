package uk.gov.ch.openapi.validator;

import java.io.File;
import org.junit.jupiter.api.Test;

class OpenAPI3ValidatorTest {

    @Test
    void mainBadInsolvency() throws Exception {
        final String workingDir = new File("target").getCanonicalPath();
        final String inputFile = "test-classes/badspecs/insolvency1.2.json";

        OpenAPI3Validator.main("-i", inputFile, "-w", workingDir);
    }

    @Test
    void mainBadJason() throws Exception {
        final String workingDir = new File("target").getCanonicalPath();
        final String inputFile = "test-classes/badspecs/badjson.json";

        OpenAPI3Validator.main("-i", inputFile, "-w", workingDir);
    }

}