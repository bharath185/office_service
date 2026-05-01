package com.officeconnect.repository;

import com.officeconnect.entity.EmployeeAccDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeAccDetailRepository extends JpaRepository<EmployeeAccDetail, Integer> {
    List<EmployeeAccDetail> findByEmpIdAndIsActiveAndIsDeletedOrderByCreatedDateDesc(Integer empId, Boolean isActive, Boolean isDeleted);
    List<EmployeeAccDetail> findByIsActiveAndIsDeletedOrderByCreatedDateDesc(Boolean isActive, Boolean isDeleted);
}
