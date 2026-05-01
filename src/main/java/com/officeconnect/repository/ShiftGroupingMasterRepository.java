package com.officeconnect.repository;

import com.officeconnect.entity.ShiftGroupingMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftGroupingMasterRepository extends JpaRepository<ShiftGroupingMaster, Integer> {
    List<ShiftGroupingMaster> findByIsActive(Boolean isActive);
}