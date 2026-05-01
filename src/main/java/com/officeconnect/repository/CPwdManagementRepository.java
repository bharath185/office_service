package com.officeconnect.repository;

import com.officeconnect.entity.CPwdManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CPwdManagementRepository extends JpaRepository<CPwdManagement, Integer> {

    @Query("SELECT c FROM CPwdManagement c WHERE UPPER(c.empCode) = UPPER(?1) AND c.cpwd = true AND c.expired = false AND c.isActive = true AND c.isDeleted = false")
    List<CPwdManagement> findActiveCPwdByEmpCode(String empCode);

    @Query("SELECT c FROM CPwdManagement c WHERE UPPER(c.empCode) = UPPER(?1) AND c.cpwd = true AND c.expired = false AND c.isActive = true AND c.isDeleted = false")
    Optional<CPwdManagement> findActiveCPwd(String empCode);
}