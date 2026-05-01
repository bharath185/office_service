package com.officeconnect.repository;

import com.officeconnect.entity.GenderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenderMasterRepository extends JpaRepository<GenderMaster, Integer> {
    List<GenderMaster> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
}
