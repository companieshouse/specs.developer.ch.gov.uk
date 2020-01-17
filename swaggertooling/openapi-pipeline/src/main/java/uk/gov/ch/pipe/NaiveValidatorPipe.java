package uk.gov.ch.pipe;

import uk.gov.ch.openapi.validator.OpenAPI3Validator;

public class NaiveValidatorPipe extends AbstractAPIPipe {

    void validate(String... args) {
        OpenAPI3Validator.main(args);
    }

    @Override
    protected void handle() {
        validate("-o", getArgs().getOutputDir());
    }
}
