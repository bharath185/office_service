package com.officeconnect.repository;

import com.officeconnect.entity.QuaterMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuaterMasterRepository extends JpaRepository<QuaterMaster, Integer> {
    List<QuaterMaster> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
}