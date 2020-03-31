package com.jav.service.validation;

import java.util.ArrayList;
import java.util.List;

public class SwiftBicValidator {
    public static final int SHORT_SWIFT_BIC_LENGTH = 8;
    public static final int LONG_SWIFT_BIC_LENGTH = 11;

    public static final String EMPTY_SWIFT_BIC_MESSAGE = "Provided SWIFT BIC is empty";
    public static final String INVALID_CHARACTERS_MESSAGE = "Provided SWIFT BIC contains invalid characters";
    public static final String INVALID_LENGTH_MESSAGE = "Provided SWIFT BIC has invalid length.";
    public static final String INVALID_BANK_CODE_MESSAGE = "Provided SWIFT BIC contains invalid bank code";
    public static final String INVALID_COUNTRY_CODE_MESSAGE = "Provided SWIFT BIC contains invalid country code";

    public List<String> validate(String swiftBic) {
        List<String> errors = new ArrayList<>();

        swiftBic = swiftBic.replaceAll(" ", "").toUpperCase();

        if (swiftBic.isEmpty()) {
            errors.add(EMPTY_SWIFT_BIC_MESSAGE);
            return errors;
        }

        if (!swiftBic.matches("[A-Z0-9]+")) {
            errors.add(INVALID_CHARACTERS_MESSAGE);
            return errors;
        }

        if (swiftBic.length() != SHORT_SWIFT_BIC_LENGTH && swiftBic.length() != LONG_SWIFT_BIC_LENGTH) {
            errors.add(INVALID_LENGTH_MESSAGE);
            return errors;
        }

        if (!swiftBic.substring(0, 4).matches("[A-Z]+")) {
            errors.add(INVALID_BANK_CODE_MESSAGE);
            return errors;
        }

        if (!swiftBic.substring(4, 6).matches("[A-Z]+")) {
            errors.add(INVALID_COUNTRY_CODE_MESSAGE);
            return errors;
        }

        return errors;
    }
}
