package com.officeconnect.repository;

import com.officeconnect.entity.AccessPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessPolicyRepository extends JpaRepository<AccessPolicy, Integer> {
    List<AccessPolicy> findByRoleIdAndIsDeleted(Integer roleId, Boolean isDeleted);
    List<AccessPolicy> findByModuleIdAndIsDeleted(Integer moduleId, Boolean isDeleted);
    List<AccessPolicy> findByDeptIdAndRoleIdAndIsDeleted(Integer deptId, Integer roleId, Boolean isDeleted);
}