package com.officeconnect.repository;

import com.officeconnect.entity.PayrollSegment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollSegmentRepository extends JpaRepository<PayrollSegment, Integer> {
}