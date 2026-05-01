package com.officeconnect.repository;

import com.officeconnect.entity.EmployeeEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeEducationRepository extends JpaRepository<EmployeeEducation, Integer> {
    List<EmployeeEducation> findByEmpIdAndIsActiveAndIsDeleted(Integer empId, Boolean isActive, Boolean isDeleted);
    List<EmployeeEducation> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
    List<EmployeeEducation> findByEmpIdAndDocIdAndIsActiveAndIsDeleted(Integer empId, Integer docId, Boolean isActive, Boolean isDeleted);
}
