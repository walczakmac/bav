package com.jav.service.resolution;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.jav.domain.entity.IbanPlus;
import com.jav.service.BankDetailsResolution;
import com.jav.presentation.response.ResolveBicResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AutoJsonRpcServiceImpl
@RequiredArgsConstructor
public class BankDetailsResolver implements BankDetailsResolution
{
    private final IbanPlusResolver resolver;

    @Override
    public ResolveBicResponse resolveBic(String iban) {
        try {
            IbanPlus ibanPlus = this.resolver.getIbanPlus(iban);

            return new ResolveBicResponse(ibanPlus.getIbanBic());
        } catch (Exception e) {
            return new ResolveBicResponse("");
        }
    }

    @Override
    public void resolveBankDetails(String swiftBic) {

    }

    @Override
    public void resolveBankDetails(String countryCode, String nationalId, String branchBic) {

    }

    @Override
    public void resolveBankDetails(String countryCode, String institutionName, String swiftBic, String nationalId) {

    }

    @Override
    public void resolveBankDetails(String countryCode, String city, String bankName, String swiftCode, int limit, int offset, boolean mainBranches) {

    }
}
