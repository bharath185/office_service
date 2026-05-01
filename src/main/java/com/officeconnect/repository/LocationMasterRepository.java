package com.officeconnect.repository;

import com.officeconnect.entity.LocationMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationMasterRepository extends JpaRepository<LocationMaster, Integer> {
    List<LocationMaster> findByBuIdAndIsActiveAndIsDeleted(Integer buId, Boolean isActive, Boolean isDeleted);
    List<LocationMaster> findByLeIdAndIsActiveAndIsDeleted(Integer leId, Boolean isActive, Boolean isDeleted);
    List<LocationMaster> findByCompIdAndIsActiveAndIsDeleted(Integer compId, Boolean isActive, Boolean isDeleted);
    List<LocationMaster> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
}