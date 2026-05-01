package com.officeconnect.repository;

import com.officeconnect.entity.ShiftMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftMasterRepository extends JpaRepository<ShiftMaster, Integer> {
    List<ShiftMaster> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
    List<ShiftMaster> findByShiftId(Integer shiftId);
}