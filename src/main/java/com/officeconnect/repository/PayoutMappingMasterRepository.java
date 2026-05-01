package com.officeconnect.repository;

import com.officeconnect.entity.PayoutMappingMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayoutMappingMasterRepository extends JpaRepository<PayoutMappingMaster, Integer> {
}