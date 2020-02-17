package com.bav.repository;

import com.bav.entity.Structure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StructureRepository extends JpaRepository<Structure, Integer>, JpaSpecificationExecutor<Structure> {

}