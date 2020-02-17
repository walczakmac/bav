package com.bav.repository;

import com.bav.entity.Exclusion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ExclusionRepository extends JpaRepository<Exclusion, Integer>, JpaSpecificationExecutor<Exclusion> {

}