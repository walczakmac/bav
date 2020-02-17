package com.bav.repository;

import com.bav.entity.BankDirectory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BankDirectoryRepository extends JpaRepository<BankDirectory, Integer>, JpaSpecificationExecutor<BankDirectory> {

}