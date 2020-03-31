package com.jav.service;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.jav.presentation.response.ResolveBicResponse;

@JsonRpcService("/resolver")
public interface BankDetailsResolution {
    ResolveBicResponse resolveBic(String iban);
    void resolveBankDetails(String swiftBic);
    void resolveBankDetails(String countryCode, String nationalId, String branchBic);
    void resolveBankDetails(String countryCode, String institutionName, String swiftBic, String nationalId);
    void resolveBankDetails(String countryCode, String city, String bankName, String swiftCode, int limit, int offset, boolean mainBranches);
}
