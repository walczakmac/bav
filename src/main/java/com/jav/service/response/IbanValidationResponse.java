package com.jav.service.response;

import java.io.Serializable;
import java.util.List;

public class IbanValidationResponse implements Serializable {
    List<String> errors;
    String countryCode;
    String bicCode;

    public IbanValidationResponse(List<String> errors, String countryCode, String bicCode) {
        this.errors = errors;
        this.countryCode = countryCode;
        this.bicCode = bicCode;
    }

    public List<String> getErrors() {
        return errors;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getBicCode() {
        return bicCode;
    }
}
