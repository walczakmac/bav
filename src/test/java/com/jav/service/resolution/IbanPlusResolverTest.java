package com.jav.service.resolution;

import com.jav.domain.entity.Exclusion;
import com.jav.domain.entity.IbanPlus;
import com.jav.domain.entity.Structure;
import com.jav.repository.ExclusionRepository;
import com.jav.repository.IbanPlusRepository;
import com.jav.repository.StructureRepository;
import com.jav.service.validation.IbanValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class IbanPlusResolverTest {
    @Mock
    StructureRepository structures;
    @Mock
    ExclusionRepository exclusions;
    @Mock
    IbanPlusRepository ibanPluses;

    @InjectMocks
    IbanPlusResolver ibanPlusResolver;

    String iban = "SE7780000827015041234641";
    Structure structure;

    @BeforeEach
    void setUp() {
        this.structure = new Structure();
        this.structure.setBankIdentifierPosition(5);
        this.structure.setNationalIdLength(3);
        this.structure.setCountryCode("SE");
    }

    @Test
    public void testExclusionPresent() {
        Mockito.when(this.structures.findOneByCountryCode("SE")).thenReturn(this.structure);
        Mockito.when(this.exclusions.findOneByCountryCodeAndIbanNationalId("SE", "800")).thenReturn(Optional.of(new Exclusion()));

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            this.ibanPlusResolver.getIbanPlus(this.iban);
        });

        Assertions.assertEquals(IbanValidator.IBAN_VALIDATION_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    public void testIbanPlusNotPresent() {
        Mockito.when(this.structures.findOneByCountryCode("SE")).thenReturn(this.structure);
        Mockito.when(this.exclusions.findOneByCountryCodeAndIbanNationalId("SE", "800")).thenReturn(Optional.empty());
        Mockito.when(this.ibanPluses.findOneByIbanIsoCountryCodeAndIbanNationalId("SE", "800")).thenReturn(Optional.empty());

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            this.ibanPlusResolver.getIbanPlus(this.iban);
        });

        Assertions.assertEquals(IbanValidator.IBAN_VALIDATION_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    public void tetsIbanPlusPresent() throws Exception {
        Mockito.when(this.structures.findOneByCountryCode("SE")).thenReturn(this.structure);
        Mockito.when(this.exclusions.findOneByCountryCodeAndIbanNationalId("SE", "800")).thenReturn(Optional.empty());

        IbanPlus expected = new IbanPlus();
        expected.setIsoCountryCode("SE");
        expected.setIbanNationalId("800");
        Mockito.when(this.ibanPluses.findOneByIbanIsoCountryCodeAndIbanNationalId("SE", "800")).thenReturn(Optional.of(expected));

        IbanPlus actual = this.ibanPlusResolver.getIbanPlus(this.iban);
        Assertions.assertEquals(expected, actual);
    }
}
