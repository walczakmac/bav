package com.jav.service.response;

public class GetBicResponse {
    String bic;

    public GetBicResponse(String bic) {
        this.bic = bic;
    }

    public String getBic() {
        return bic;
    }
}
