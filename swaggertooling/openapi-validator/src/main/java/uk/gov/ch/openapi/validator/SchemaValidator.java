package uk.gov.ch.openapi.validator;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import java.io.File;
import java.io.IOException;
import uk.gov.ch.utils.ValidationUtils;

public class SchemaValidator {

    private final File schemaFile;
    private final JsonSchema schemaNode;

    SchemaValidator() throws IOException, ProcessingException {
        this(new File("target/classes/schema/openapi3schema.json").getCanonicalFile());
    }

    public SchemaValidator(final File schema) throws IOException, ProcessingException {
        schemaFile = schema;
        schemaNode = ValidationUtils.getSchemaNode(schemaFile);
    }

    public ProcessingReport checkSchema(final File source) throws IOException, ProcessingException {
        return checkSchema(source, schemaFile);
    }

    public ProcessingReport checkSchema(final File source, final File schemaFile)
            throws IOException, ProcessingException {

        final JsonNode jsonNode = ValidationUtils.getJsonNode(source);
        final ProcessingReport report = schemaNode.validate(jsonNode);

        return report;
    }
}
