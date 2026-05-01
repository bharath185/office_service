package com.officeconnect.repository;

import com.officeconnect.entity.PayrollPayoutType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollPayoutTypeRepository extends JpaRepository<PayrollPayoutType, Integer> {
}