package com.officeconnect.repository;

import com.officeconnect.entity.SalutationMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalutationMasterRepository extends JpaRepository<SalutationMaster, Integer> {
    List<SalutationMaster> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
}