package com.jav.repository;

import com.jav.domain.entity.Exclusion;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ExclusionRepository extends CrudRepository<Exclusion, Integer> {
    Optional<Exclusion> findOneByCountryCodeAndIbanNationalId(String countryCode, String nationalId);
}