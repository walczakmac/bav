package com.jav.presentation.response;

import java.util.Objects;

public class ResolveBankDetailsExtendedResponse {
    private String bic8;
    private String branchBic;
    private String bic;
    private String nationalId;
    private String institutionName;
    private String branchInformation;
    private String pobNumber;
    private String streetAddress1;
    private String streetAddress2;
    private String streetAddress3;
    private String streetAddress4;
    private String city;
    private String zipCode;
    private String countryName;
    private String countryCode;

    public String getBic8() {
        return bic8;
    }

    public String getBranchBic() {
        return branchBic;
    }

    public String getBic() {
        return bic;
    }

    public String getNationalId() {
        return nationalId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public String getBranchInformation() {
        return branchInformation;
    }

    public String getPobNumber() {
        return pobNumber;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public String getStreetAddress3() {
        return streetAddress3;
    }

    public String getStreetAddress4() {
        return streetAddress4;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResolveBankDetailsExtendedResponse that = (ResolveBankDetailsExtendedResponse) o;
        return Objects.equals(bic8, that.bic8) &&
                Objects.equals(branchBic, that.branchBic) &&
                Objects.equals(bic, that.bic) &&
                Objects.equals(nationalId, that.nationalId) &&
                Objects.equals(institutionName, that.institutionName) &&
                Objects.equals(branchInformation, that.branchInformation) &&
                Objects.equals(pobNumber, that.pobNumber) &&
                Objects.equals(streetAddress1, that.streetAddress1) &&
                Objects.equals(streetAddress2, that.streetAddress2) &&
                Objects.equals(streetAddress3, that.streetAddress3) &&
                Objects.equals(streetAddress4, that.streetAddress4) &&
                Objects.equals(city, that.city) &&
                Objects.equals(zipCode, that.zipCode) &&
                Objects.equals(countryName, that.countryName) &&
                Objects.equals(countryCode, that.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bic8, branchBic, bic, nationalId, institutionName, branchInformation, pobNumber, streetAddress1, streetAddress2, streetAddress3, streetAddress4, city, zipCode, countryName, countryCode);
    }
}
