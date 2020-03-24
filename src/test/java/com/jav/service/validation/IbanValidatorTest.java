package com.jav.service.validation;

import com.jav.domain.entity.IbanPlus;
import com.jav.service.resolution.IbanPlusResolver;
import com.jav.service.response.IbanValidationResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class IbanValidatorTest {
    @Mock
    IbanPlusResolver resolver;
    @InjectMocks
    IbanValidator ibanValidator;
    List<String> errors;

    @BeforeEach
    void setUp() {
        this.errors = new ArrayList<>();
    }

    @Test
    public void testEmptyIban() {
        IbanValidationResponse expected = new IbanValidationResponse(this.errors, "", "");
        IbanValidationResponse actual = this.ibanValidator.validate("");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testInvalidChecksum() {
        this.errors.add(IbanValidator.INVALID_CHECKSUM_MESSAGE);
        IbanValidationResponse expected = new IbanValidationResponse(this.errors, "", "");
        IbanValidationResponse actual = this.ibanValidator.validate("WRONG_IBAN");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testValid() throws Exception {
        IbanPlus ibanPlus = new IbanPlus();
        ibanPlus.setIsoCountryCode("SE");
        ibanPlus.setIbanBic("SWEDSESSXXX");
        Mockito.when(resolver.getIbanPlus("SE7780000827015041234641")).thenReturn(Optional.of(ibanPlus));

        IbanValidationResponse expected = new IbanValidationResponse(this.errors, "SE", "SWEDSESSXXX");
        IbanValidationResponse actual = this.ibanValidator.validate("SE7780000827015041234641");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testInvalid() throws Exception {
        Mockito.when(resolver.getIbanPlus("SE7780000827015041234641")).thenThrow(new Exception());

        this.errors.add(IbanValidator.IBAN_VALIDATION_ERROR_MESSAGE);
        IbanValidationResponse expected = new IbanValidationResponse(this.errors, "", "");
        IbanValidationResponse actual = this.ibanValidator.validate("SE7780000827015041234641");

        Assertions.assertEquals(expected, actual);
    }
}
