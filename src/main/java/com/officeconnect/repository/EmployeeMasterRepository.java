package com.officeconnect.repository;

import com.officeconnect.entity.EmployeeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMasterRepository extends JpaRepository<EmployeeMaster, Integer> {

    List<EmployeeMaster> findByUserNameIgnoreCaseAndIsActiveAndIsDeleted(String userName, Boolean isActive, Boolean isDeleted);

    @Query("SELECT e FROM EmployeeMaster e WHERE e.isActive = true AND e.isDeleted = false")
    List<EmployeeMaster> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);

    @Query("SELECT e FROM EmployeeMaster e WHERE e.userName = ?1 AND e.isActive = true AND e.isDeleted = false")
    List<EmployeeMaster> findActiveUserByUserName(String userName);

    @Query("SELECT e FROM EmployeeMaster e WHERE e.reportId = ?1 AND e.empCode LIKE ?2 AND e.isActive = true AND e.isDeleted = false")
    List<EmployeeMaster> findByReportIdAndEmpCodeStartingWith(Integer reportId, String empCodePrefix);

    @Query("SELECT e FROM EmployeeMaster e WHERE e.reportId = ?1 AND e.isActive = true AND e.isDeleted = false")
    List<EmployeeMaster> findByReportId(Integer reportId);

    @Query("SELECT e FROM EmployeeMaster e WHERE e.empId = ?1 AND e.empStatus = 'ACTIVE' AND e.isActive = true AND e.isDeleted = false")
    EmployeeMaster findByEmpIdAndActive(Integer empId);

    List<EmployeeMaster> findByCompId(Integer compId);

    @Query("SELECT e FROM EmployeeMaster e WHERE e.compId = ?1 AND e.isActive = true AND e.isDeleted = false")
    List<EmployeeMaster> findByCompIdAndIsActiveAndIsDeleted(Integer compId, Boolean isActive, Boolean isDeleted);

    List<EmployeeMaster> findByCategoryId(Integer categoryId);

    List<EmployeeMaster> findByDesignationId(Integer designationId);
}