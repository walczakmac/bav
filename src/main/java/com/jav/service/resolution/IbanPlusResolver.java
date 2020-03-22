package com.jav.service.resolution;

import com.jav.domain.entity.Exclusion;
import com.jav.domain.entity.Structure;
import com.jav.repository.ExclusionRepository;
import com.jav.repository.IbanPlusRepository;
import com.jav.repository.StructureRepository;
import com.jav.service.validation.IbanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IbanPlusResolver {
    @Autowired
    private StructureRepository structureRepository;
    @Autowired
    private ExclusionRepository exclusionRepository;
    @Autowired
    private IbanPlusRepository ibanPlusRepository;

    public Optional<com.jav.domain.entity.IbanPlus> getIbanPlus(String iban) throws Exception {
        Structure structure = this.structureRepository.findOneByCountryCode(iban.substring(0, 2));
        String nationalId = iban.substring(structure.getBankIdentifierPosition() - 1, structure.getBankIdentifierPosition() - 1 + structure.getNationalIdLength());
        Optional<Exclusion> exclusion = this.exclusionRepository.findOneByCountryCodeAndIbanNationalId(structure.getCountryCode(), nationalId);
        if (exclusion.isPresent()) {
            throw new Exception(IbanValidator.IBAN_VALIDATION_ERROR_MESSAGE);
        }

        Optional<com.jav.domain.entity.IbanPlus> ibanPlus = this.ibanPlusRepository.findOneByIbanIsoCountryCodeAndIbanNationalId(iban.substring(0, 2), nationalId);
        if (!ibanPlus.isPresent()) {
            throw new Exception(IbanValidator.IBAN_VALIDATION_ERROR_MESSAGE);
        }

        return ibanPlus;
    }
}
