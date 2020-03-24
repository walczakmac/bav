package com.jav.service.resolution;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.jav.domain.entity.IbanPlus;
import com.jav.service.BankDetailsResolution;
import com.jav.presentation.response.GetBicResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AutoJsonRpcServiceImpl
@RequiredArgsConstructor
public class BankDetailsResolver implements BankDetailsResolution
{
    private final IbanPlusResolver resolver;

    @Override
    public GetBicResponse getBic(String iban) {
        try {
            IbanPlus ibanPlus = this.resolver.getIbanPlus(iban);

            return new GetBicResponse(ibanPlus.getIbanBic());
        } catch (Exception e) {
            return new GetBicResponse("");
        }
    }
}
