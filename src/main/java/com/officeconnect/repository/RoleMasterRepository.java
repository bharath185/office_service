package com.officeconnect.repository;

import com.officeconnect.entity.RoleMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMasterRepository extends JpaRepository<RoleMaster, Integer> {
    List<RoleMaster> findByIsDeleted(Boolean isDeleted);
    List<RoleMaster> findByRoleIdAndIsDeleted(Integer roleId, Boolean isDeleted);
}