package com.officeconnect.repository;

import com.officeconnect.entity.LegalEntityMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LegalEntityMasterRepository extends JpaRepository<LegalEntityMaster, Integer> {
    List<LegalEntityMaster> findByCompIdAndIsActiveAndIsDeleted(Integer compId, Boolean isActive, Boolean isDeleted);
    List<LegalEntityMaster> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
}