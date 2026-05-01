package com.officeconnect.repository;

import com.officeconnect.entity.EmpProbationTrackingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmpProbationTrackingHistoryRepository extends JpaRepository<EmpProbationTrackingHistory, Integer> {
    List<EmpProbationTrackingHistory> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
}
