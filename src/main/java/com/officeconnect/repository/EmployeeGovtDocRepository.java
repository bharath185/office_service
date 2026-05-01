package com.officeconnect.repository;

import com.officeconnect.entity.EmployeeGovtDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeGovtDocRepository extends JpaRepository<EmployeeGovtDoc, Integer> {
    List<EmployeeGovtDoc> findByEmpIdAndIsActiveAndIsDeleted(Integer empId, Boolean isActive, Boolean isDeleted);
    List<EmployeeGovtDoc> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
    List<EmployeeGovtDoc> findByEmpIdAndDocIdAndIsActiveAndIsDeleted(Integer empId, Integer docId, Boolean isActive, Boolean isDeleted);
}
