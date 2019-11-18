package uk.gov.ch.openapi.validator;

public enum ValidationResult {
    PASS(0),
    WARNINGS(+1),
    ERRORS(-1);
    public final int resultValue;

    ValidationResult(final int result) {
        resultValue = result;
    }
}
