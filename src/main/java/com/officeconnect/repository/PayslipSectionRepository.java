package com.officeconnect.repository;

import com.officeconnect.entity.PayslipSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayslipSectionRepository extends JpaRepository<PayslipSection, Integer> {
}