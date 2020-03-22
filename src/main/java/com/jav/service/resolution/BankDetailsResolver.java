package com.jav.service.resolution;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.jav.service.BankDetailsResolution;
import com.jav.service.response.GetBicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AutoJsonRpcServiceImpl
public class BankDetailsResolver implements BankDetailsResolution {
    @Autowired
    private IbanPlusResolver resolver;

    @Override
    public GetBicResponse getBic(String iban) {
        try {
            Optional<com.jav.domain.entity.IbanPlus> ibanPlus = this.resolver.getIbanPlus(iban);

            return new GetBicResponse(ibanPlus.get().getIbanBic());
        } catch (Exception e) {
            return new GetBicResponse("");
        }
    }
}
