package com.officeconnect.repository;

import com.officeconnect.entity.FPwdManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FPwdManagementRepository extends JpaRepository<FPwdManagement, Integer> {

    @Query("SELECT f FROM FPwdManagement f WHERE UPPER(f.empCode) = UPPER(?1) AND f.otp = ?2 AND f.expired = false AND f.isActive = true AND f.isDeleted = false")
    Optional<FPwdManagement> findActiveByEmpCodeAndOtp(String empCode, String otp);

    @Query("SELECT f FROM FPwdManagement f WHERE UPPER(f.empCode) = UPPER(?1) AND f.expired = false AND f.isActive = true AND f.isDeleted = false")
    List<FPwdManagement> findActiveByEmpCode(String empCode);
}