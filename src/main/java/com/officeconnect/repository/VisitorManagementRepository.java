package com.officeconnect.repository;

import com.officeconnect.entity.VisitorManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitorManagementRepository extends JpaRepository<VisitorManagement, Integer> {
    List<VisitorManagement> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
    List<VisitorManagement> findByWhomToMeetAndIsDeleted(Integer whomToMeet, Boolean isDeleted);
}