package com.officeconnect.repository;

import com.officeconnect.entity.PayrollFrequencyMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayrollFrequencyMasterRepository extends JpaRepository<PayrollFrequencyMaster, Integer> {

    List<PayrollFrequencyMaster> findByIsActiveTrue();
}
