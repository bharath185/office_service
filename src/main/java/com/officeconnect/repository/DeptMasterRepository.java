package com.officeconnect.repository;

import com.officeconnect.entity.DeptMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptMasterRepository extends JpaRepository<DeptMaster, Integer> {
    List<DeptMaster> findByIsDeleted(Boolean isDeleted);
    List<DeptMaster> findByDeptIdAndIsDeleted(Integer deptId, Boolean isDeleted);
}