package com.jav.repository;

import com.jav.domain.entity.Structure;
import org.springframework.data.repository.CrudRepository;

public interface StructureRepository extends CrudRepository<Structure, Integer> {
    public Structure findOneByCountryCode(String countryCode);
}