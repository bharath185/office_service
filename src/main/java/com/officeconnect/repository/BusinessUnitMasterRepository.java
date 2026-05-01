package com.officeconnect.repository;

import com.officeconnect.entity.BusinessUnitMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessUnitMasterRepository extends JpaRepository<BusinessUnitMaster, Integer> {
    List<BusinessUnitMaster> findByLeIdAndIsActiveAndIsDeleted(Integer leId, Boolean isActive, Boolean isDeleted);
    List<BusinessUnitMaster> findByCompIdAndIsActiveAndIsDeleted(Integer compId, Boolean isActive, Boolean isDeleted);
    List<BusinessUnitMaster> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
}