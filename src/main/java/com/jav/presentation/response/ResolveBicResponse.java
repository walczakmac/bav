package com.jav.presentation.response;

import java.util.Objects;

public class ResolveBicResponse {
    String bic;

    public ResolveBicResponse(String bic) {
        this.bic = bic;
    }

    public String getBic() {
        return bic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResolveBicResponse that = (ResolveBicResponse) o;
        return Objects.equals(bic, that.bic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bic);
    }
}
