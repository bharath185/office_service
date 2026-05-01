package com.officeconnect.repository;

import com.officeconnect.entity.EmpLeaveApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpLeaveApplicationRepository extends JpaRepository<EmpLeaveApplication, Integer> {
    @Query("SELECT e FROM EmpLeaveApplication e WHERE e.isDeleted = ?1")
    List<EmpLeaveApplication> findByIsDeleted(Boolean isDeleted);
    
    @Query("SELECT e FROM EmpLeaveApplication e WHERE e.empId = ?1")
    List<EmpLeaveApplication> findByEmpId(Integer empId);
    
    @Query("SELECT e FROM EmpLeaveApplication e WHERE e.empId = ?1 AND e.isDeleted = ?2")
    List<EmpLeaveApplication> findByEmpIdAndIsDeleted(Integer empId, Boolean isDeleted);
    
    @Query("SELECT e FROM EmpLeaveApplication e WHERE e.empId = ?1 AND e.status = ?2 AND e.isDeleted = ?3")
    List<EmpLeaveApplication> findByEmpIdAndStatusAndIsDeleted(Integer empId, String status, Boolean isDeleted);
    
    @Query("SELECT e FROM EmpLeaveApplication e WHERE e.approvedBy = ?1 AND e.isDeleted = ?2")
    List<EmpLeaveApplication> findByApprovedByAndIsDeleted(Integer approvedBy, Boolean isDeleted);
    
    @Query("SELECT e FROM EmpLeaveApplication e WHERE e.isDeleted = ?1 ORDER BY e.createdDate DESC")
    List<EmpLeaveApplication> findTop100ByIsDeletedOrderByCreatedDateDesc(Boolean isDeleted);
    
    @Query("SELECT e FROM EmpLeaveApplication e WHERE e.approvedBy = ?1 AND e.isDeleted = ?2 ORDER BY e.createdDate DESC")
    List<EmpLeaveApplication> findTop100ByApprovedByAndIsDeletedOrderByCreatedDateDesc(Integer approvedBy, Boolean isDeleted);
}