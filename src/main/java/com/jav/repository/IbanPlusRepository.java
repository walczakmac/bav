package com.jav.repository;

import com.jav.domain.entity.IbanPlus;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IbanPlusRepository extends CrudRepository<IbanPlus, Integer> {
    Optional<IbanPlus> findOneByIbanIsoCountryCodeAndIbanNationalId(String countryCode, String nationalId);
}