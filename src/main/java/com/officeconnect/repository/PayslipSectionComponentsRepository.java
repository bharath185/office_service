package com.officeconnect.repository;

import com.officeconnect.entity.PayslipSectionComponents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayslipSectionComponentsRepository extends JpaRepository<PayslipSectionComponents, Integer> {
}