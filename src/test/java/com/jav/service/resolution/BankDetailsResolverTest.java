package com.jav.service.resolution;

import com.jav.domain.entity.IbanPlus;
import com.jav.presentation.response.GetBicResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BankDetailsResolverTest {
    @Mock
    IbanPlusResolver ibanPlusResolver;

    @InjectMocks
    BankDetailsResolver bankDetailsResolver;

    @Test
    public void testException() throws Exception {
        Mockito.when(ibanPlusResolver.getIbanPlus("WRONG_IBAN")).thenThrow(new Exception());

        GetBicResponse expeced = new GetBicResponse("");
        GetBicResponse actual = bankDetailsResolver.getBic("WRONG_IBAN");

        Assertions.assertEquals(expeced, actual);
    }

    @Test
    public void testSuccess() throws Exception {
        IbanPlus ibanPlus = new IbanPlus();
        ibanPlus.setIbanBic("SWEDSESSXXX");

        Mockito.when(ibanPlusResolver.getIbanPlus("VALID_IBAN")).thenReturn(ibanPlus);
        GetBicResponse expected = new GetBicResponse("SWEDSESSXXX");
        GetBicResponse actual = bankDetailsResolver.getBic("VALID_IBAN");

        Assertions.assertEquals(expected, actual);
    }
}
