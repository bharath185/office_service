package com.officeconnect.repository;

import com.officeconnect.entity.LeaveCarryForwardMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveCarryForwardMasterRepository extends JpaRepository<LeaveCarryForwardMaster, Integer> {
    
    @Query("SELECT c FROM LeaveCarryForwardMaster c WHERE c.empId = ?1 AND c.leaveTypeId = ?2 AND c.leaveYear = ?3 AND c.leaveMonth = ?4 AND c.isActive = true AND c.isDeleted = false")
    LeaveCarryForwardMaster findByEmpIdAndLeaveTypeIdAndLeaveYearAndLeaveMonth(Integer empId, Integer leaveTypeId, Integer leaveYear, Integer leaveMonth);
    
    @Query("SELECT c FROM LeaveCarryForwardMaster c WHERE c.empId = ?1 AND c.leaveTypeId = ?2 AND c.leaveYear = ?3 AND c.isActive = true AND c.isDeleted = false")
    List<LeaveCarryForwardMaster> findByEmpIdAndLeaveTypeIdAndLeaveYear(Integer empId, Integer leaveTypeId, Integer leaveYear);
    
    @Query("SELECT c FROM LeaveCarryForwardMaster c WHERE c.empId = ?1 AND c.isActive = true AND c.isDeleted = false")
    List<LeaveCarryForwardMaster> findByEmpId(Integer empId);
}