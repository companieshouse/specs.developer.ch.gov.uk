package uk.gov.ch.openapi.validator;

import java.io.File;
import org.junit.jupiter.api.Test;

class OpenAPI3ValidatorTest {

    @Test
    void mainInsolvency1_2() throws Exception {
        final String workingDir = new File("target").getCanonicalPath();
        final String inputFile = "test-classes/badspecs/insolvency1.2.json";

        int retval = OpenAPI3Validator.main("-i", inputFile, "-w", workingDir);
        org.junit.jupiter.api.Assertions
                .assertEquals(ValidationResult.WARNINGS.resultValue, retval);
    }

    @Test
    void mainInsolvencyMissingTitle() throws Exception {
        final String workingDir = new File("target").getCanonicalPath();
        final String inputFile = "test-classes/badspecs/insolvencyMissingTitle.json";

        int retval = OpenAPI3Validator.main("-i", inputFile, "-w", workingDir);
        org.junit.jupiter.api.Assertions
                .assertEquals(ValidationResult.WARNINGS.resultValue, retval);
    }

    @Test
    void mainBadJason() throws Exception {
        final String workingDir = new File("target").getCanonicalPath();
        final String inputFile = "test-classes/badspecs/badjson.json";

        int retval = OpenAPI3Validator.main("-i", inputFile, "-w", workingDir);
        org.junit.jupiter.api.Assertions.assertEquals(ValidationResult.ERRORS.resultValue, retval);
    }

    @Test
    void mainBadDirectory() throws Exception {
        final String workingDir = new File("target").getCanonicalPath();
        final String inputFile = "test-classes/badspecs";

        int retval = OpenAPI3Validator.main("-i", inputFile, "-w", workingDir);
        org.junit.jupiter.api.Assertions.assertEquals(ValidationResult.ERRORS.resultValue, retval);
    }

    @Test
    void mainGoodDirectory() throws Exception {
        final String workingDir = new File("target").getCanonicalPath();
        final String inputFile = "test-classes/spec";

        int retval = OpenAPI3Validator.main("-i", inputFile, "-w", workingDir);
        org.junit.jupiter.api.Assertions.assertEquals(ValidationResult.PASS.resultValue, retval);
    }

    @Test
    void mainGoodFile() throws Exception {
        final String workingDir = new File("target").getCanonicalPath();
        final String inputFile = "test-classes/spec/companyAddress.json";
        int retval = OpenAPI3Validator.main("-i", inputFile, "-w", workingDir);
        org.junit.jupiter.api.Assertions.assertEquals(ValidationResult.PASS.resultValue, retval);
    }

}