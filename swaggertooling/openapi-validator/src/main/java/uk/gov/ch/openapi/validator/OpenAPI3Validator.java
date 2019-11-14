package uk.gov.ch.openapi.validator;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import java.io.File;
import java.io.IOException;
import uk.gov.ch.utils.ValidationUtils;

public class OpenAPI3Validator {

    static public void main(String... args) {
        try {
            final OpenAPI3Validator openAPI3Validator = new OpenAPI3Validator();
            openAPI3Validator.checkSchema(new File("fred"));
        } catch (IOException | ProcessingException e) {
            e.printStackTrace();
        }
    }

    private void checkSchema(final File source) throws IOException, ProcessingException {
        String root = "/Users/dclarke/dev/specs.developer.ch.gov.uk/swaggertooling/openapi-validator/";
        File schemaFile = new File("target/classes/schema/openapi3schema.json").getCanonicalFile();
        checkSchema(source, schemaFile);
    }

    private void checkSchema(final File source, final File schemaFile)
            throws IOException, ProcessingException {

        final JsonSchema schemaNode = ValidationUtils.getSchemaNode(schemaFile);
        final JsonNode jsonNode = ValidationUtils.getJsonNode(source);
        final ProcessingReport report = schemaNode.validate(jsonNode);
        for (final ProcessingMessage message : report) {
            System.err.println(message);
        }
    }

}
