package com.jav.presentation.response;

import java.util.Objects;

public class ResolveBankDetailsBasicResponse {
    private String institutionName;
    private String bic;
    private String bic8;
    private String branchBic;
    private String isoCountryCode;
    private String nationalId;

    public String getInstitutionName() {
        return institutionName;
    }

    public String getBic() {
        return bic;
    }

    public String getBic8() {
        return bic8;
    }

    public String getBranchBic() {
        return branchBic;
    }

    public String getIsoCountryCode() {
        return isoCountryCode;
    }

    public String getNationalId() {
        return nationalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResolveBankDetailsBasicResponse that = (ResolveBankDetailsBasicResponse) o;
        return Objects.equals(institutionName, that.institutionName) &&
                Objects.equals(bic, that.bic) &&
                Objects.equals(bic8, that.bic8) &&
                Objects.equals(branchBic, that.branchBic) &&
                Objects.equals(isoCountryCode, that.isoCountryCode) &&
                Objects.equals(nationalId, that.nationalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(institutionName, bic, bic8, branchBic, isoCountryCode, nationalId);
    }
}
