package com.bav.repository;

import com.bav.entity.IbanPlus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IbanPlusRepository extends JpaRepository<IbanPlus, Integer>, JpaSpecificationExecutor<IbanPlus> {

}