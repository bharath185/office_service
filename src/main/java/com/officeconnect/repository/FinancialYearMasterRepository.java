package com.officeconnect.repository;

import com.officeconnect.entity.FinancialYearMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialYearMasterRepository extends JpaRepository<FinancialYearMaster, Integer> {
    List<FinancialYearMaster> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
    List<FinancialYearMaster> findByStatus(Boolean status);
}