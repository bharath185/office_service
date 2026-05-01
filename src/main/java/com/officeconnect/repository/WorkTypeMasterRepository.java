package com.officeconnect.repository;

import com.officeconnect.entity.WorkTypeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkTypeMasterRepository extends JpaRepository<WorkTypeMaster, Integer> {

    @Query("SELECT w FROM WorkTypeMaster w WHERE w.empId = ?1 AND w.isActive = true AND w.isDeleted = false ORDER BY w.createdDate DESC")
    List<WorkTypeMaster> findByEmpIdAndActiveAndNotDeleted(Integer empId);

    @Query("SELECT w FROM WorkTypeMaster w WHERE w.empId = ?1 AND w.workTypeId = ?2 AND w.isActive = true AND w.isDeleted = false")
    WorkTypeMaster findByEmpIdAndWorkTypeIdAndActiveAndNotDeleted(Integer empId, Integer workTypeId);

    @Query("SELECT w FROM WorkTypeMaster w WHERE w.empId = ?1 AND w.isApproved = true AND w.isEnd = false AND w.isActive = true AND w.isDeleted = false")
    List<WorkTypeMaster> findActiveApprovedWorkTypeByEmpId(Integer empId);

    @Query("SELECT w FROM WorkTypeMaster w WHERE w.workTypeId = ?1 AND w.isActive = true AND w.isDeleted = false")
    WorkTypeMaster findByWorkTypeIdAndActiveAndNotDeleted(Integer workTypeId);

    @Query("SELECT w FROM WorkTypeMaster w WHERE w.workTypeId = ?1 AND w.isApproved = false AND w.isRejected = false AND w.isActive = true AND w.isDeleted = false")
    WorkTypeMaster findPendingApprovalByWorkTypeId(Integer workTypeId);

    @Query("SELECT w FROM WorkTypeMaster w WHERE w.isActive = true AND w.isDeleted = false ORDER BY w.createdDate DESC")
    List<WorkTypeMaster> findAllActiveAndNotDeleted();
}
