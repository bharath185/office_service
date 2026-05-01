package com.officeconnect.repository;

import com.officeconnect.entity.PayrollComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayrollComponentRepository extends JpaRepository<PayrollComponent, Integer> {
}