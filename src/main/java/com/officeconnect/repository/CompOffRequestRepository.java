package com.officeconnect.repository;

import com.officeconnect.entity.CompOffRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompOffRequestRepository extends JpaRepository<CompOffRequest, Integer> {
    List<CompOffRequest> findByEmpIdAndIsDeleted(Integer empId, Boolean isDeleted);
    List<CompOffRequest> findByEmpIdAndStatusAndIsDeleted(Integer empId, String status, Boolean isDeleted);
}