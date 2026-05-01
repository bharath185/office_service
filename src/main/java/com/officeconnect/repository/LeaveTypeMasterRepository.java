package com.officeconnect.repository;

import com.officeconnect.entity.LeaveTypeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveTypeMasterRepository extends JpaRepository<LeaveTypeMaster, Integer> {
    List<LeaveTypeMaster> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
    LeaveTypeMaster findByShortNameAndIsActiveAndIsDeleted(String shortName, Boolean isActive, Boolean isDeleted);
}