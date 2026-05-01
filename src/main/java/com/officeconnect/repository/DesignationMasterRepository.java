package com.officeconnect.repository;

import com.officeconnect.entity.DesignationMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignationMasterRepository extends JpaRepository<DesignationMaster, Integer> {
    List<DesignationMaster> findByIsDeleted(Boolean isDeleted);
    List<DesignationMaster> findByDesignationIdAndIsDeleted(Integer designationId, Boolean isDeleted);
}