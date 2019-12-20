package uk.gov.ch.pipe;

import uk.gov.ch.AbstractAPIPipe;
import uk.gov.ch.openapi.validator.OpenAPI3Validator;

import java.io.IOException;

public class NaiveValidatorPipe extends AbstractAPIPipe {
    void validate(String... args) {
        OpenAPI3Validator.main(args);
    }

    @Override
    protected void handle() {
        try {
            validate(getArgs().getArgs("-o"));
        } catch (IOException e) {
            e.printStackTrace();
            abort();
        }
    }
}
