package com.officeconnect.repository;

import com.officeconnect.entity.PassHistoryManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassHistoryManagementRepository extends JpaRepository<PassHistoryManagement, Integer> {

    @Query("SELECT p FROM PassHistoryManagement p WHERE UPPER(p.empCode) = UPPER(?1) AND p.expired = false AND p.isActive = true AND p.isDeleted = false")
    List<PassHistoryManagement> findActiveByEmpCode(String empCode);

    @Query("SELECT p FROM PassHistoryManagement p WHERE UPPER(p.empCode) = UPPER(?1) AND p.isActive = true AND p.isDeleted = false")
    List<PassHistoryManagement> findAllByEmpCode(String empCode);
}