package com.officeconnect.repository;

import com.officeconnect.entity.EmployeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EmployeeDetailRepository extends JpaRepository<EmployeeDetail, Integer> {
    Optional<EmployeeDetail> findByEmpIdAndIsActiveAndIsDeleted(Integer empId, Boolean isActive, Boolean isDeleted);
}
