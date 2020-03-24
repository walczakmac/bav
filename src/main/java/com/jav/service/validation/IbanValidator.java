package com.jav.service.validation;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.jav.domain.entity.IbanPlus;
import com.jav.service.resolution.IbanPlusResolver;
import com.jav.service.IbanValidation;
import com.jav.service.response.IbanValidationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AutoJsonRpcServiceImpl
@RequiredArgsConstructor
public class IbanValidator implements IbanValidation
{
    private final IbanPlusResolver resolver;

    public static final String INVALID_CHECKSUM_MESSAGE = "Invalid checksum resolved from provided IBAN.";
    public static final String IBAN_VALIDATION_ERROR_MESSAGE = "This is not a valid International Bank Account Number (IBAN).";

    @Override
    public IbanValidationResponse validate(String iban)
    {
        List<String> errors = new ArrayList<>();
        if (iban.isEmpty()) {
            return new IbanValidationResponse(errors, "", "");
        }

        iban = this.normalizeIban(iban);

        if (1 != this.calculateChecksum(iban)) {
            errors.add(INVALID_CHECKSUM_MESSAGE);
            return new IbanValidationResponse(errors, "", "");
        }

        try {
            Optional<IbanPlus> ibanPlus = this.resolver.getIbanPlus(iban);

            return new IbanValidationResponse(errors, ibanPlus.get().getIsoCountryCode(), ibanPlus.get().getIbanBic());
        } catch (Exception e) {
            errors.add(IBAN_VALIDATION_ERROR_MESSAGE);
            return new IbanValidationResponse(errors, "", "");
        }
    }

    private String normalizeIban(String iban)
    {
        return iban.toUpperCase().replaceAll("[^a-zA-Z0-9]", "");
    }

    private int calculateChecksum(String iban)
    {
        iban = iban.substring(4) + iban.substring(0, 4);
        String checksum = "";
        for (char ch:iban.toCharArray()) {
            if (!Character.isLetter(ch)) {
                checksum += ch;
                continue;
            }

            checksum += (int) ch - 55;
        }

        return (new BigInteger(checksum)).mod(new BigInteger("97")).intValue();
    }
}
