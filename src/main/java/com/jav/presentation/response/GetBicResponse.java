package com.jav.presentation.response;

import java.util.Objects;

public class GetBicResponse {
    String bic;

    public GetBicResponse(String bic) {
        this.bic = bic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetBicResponse that = (GetBicResponse) o;
        return Objects.equals(bic, that.bic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bic);
    }
}
