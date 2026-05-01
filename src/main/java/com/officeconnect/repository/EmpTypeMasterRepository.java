package com.officeconnect.repository;

import com.officeconnect.entity.EmpTypeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpTypeMasterRepository extends JpaRepository<EmpTypeMaster, Integer> {
    List<EmpTypeMaster> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
}