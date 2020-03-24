package com.jav.service.response;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IbanValidationResponse that = (IbanValidationResponse) o;
        return Objects.equals(errors, that.errors) &&
                Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(bicCode, that.bicCode);
    }
}
