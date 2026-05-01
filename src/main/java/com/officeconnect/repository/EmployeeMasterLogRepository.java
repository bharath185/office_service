package com.officeconnect.repository;

import com.officeconnect.entity.EmployeeMasterLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeMasterLogRepository extends JpaRepository<EmployeeMasterLog, Integer> {
    List<EmployeeMasterLog> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
}
