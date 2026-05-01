package com.officeconnect.repository;

import com.officeconnect.entity.PerGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerGoalRepository extends JpaRepository<PerGoal, Integer> {
    List<PerGoal> findByEmpIdAndIsDeleted(Integer empId, Boolean isDeleted);
    List<PerGoal> findByEmpIdAndStatus(Integer empId, String status);
}