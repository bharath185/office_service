package com.officeconnect.repository;

import com.officeconnect.entity.EmployeeCareerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeCareerDetailRepository extends JpaRepository<EmployeeCareerDetail, Integer> {
    List<EmployeeCareerDetail> findByEmpIdAndIsActiveAndIsDeletedOrderByCareerIdDesc(Integer empId, Boolean isActive, Boolean isDeleted);
    List<EmployeeCareerDetail> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
    List<EmployeeCareerDetail> findByIsActiveAndIsDeletedOrderByCareerIdDesc(Boolean isActive, Boolean isDeleted);
}
