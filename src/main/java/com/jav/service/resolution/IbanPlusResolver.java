package com.jav.service.resolution;

import com.jav.domain.entity.Exclusion;
import com.jav.domain.entity.IbanPlus;
import com.jav.domain.entity.Structure;
import com.jav.repository.ExclusionRepository;
import com.jav.repository.IbanPlusRepository;
import com.jav.repository.StructureRepository;
import com.jav.service.validation.IbanValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IbanPlusResolver
{
    private final StructureRepository structures;
    private final ExclusionRepository exclusions;
    private final IbanPlusRepository ibanPluses;

    public Optional<IbanPlus> getIbanPlus(String iban) throws Exception {
        Structure structure = this.structures.findOneByCountryCode(iban.substring(0, 2));
        String nationalId = iban.substring(structure.getBankIdentifierPosition() - 1, structure.getBankIdentifierPosition() - 1 + structure.getNationalIdLength());
        Optional<Exclusion> exclusion = this.exclusions.findOneByCountryCodeAndIbanNationalId(structure.getCountryCode(), nationalId);
        if (exclusion.isPresent()) {
            throw new Exception(IbanValidator.IBAN_VALIDATION_ERROR_MESSAGE);
        }

        Optional<IbanPlus> ibanPlus = this.ibanPluses.findOneByIbanIsoCountryCodeAndIbanNationalId(iban.substring(0, 2), nationalId);
        if (!ibanPlus.isPresent()) {
            throw new Exception(IbanValidator.IBAN_VALIDATION_ERROR_MESSAGE);
        }

        return ibanPlus;
    }
}
