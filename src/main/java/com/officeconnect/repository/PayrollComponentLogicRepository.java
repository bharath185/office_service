package com.officeconnect.repository;

import com.officeconnect.entity.PayrollComponentLogic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayrollComponentLogicRepository extends JpaRepository<PayrollComponentLogic, Integer> {

    List<PayrollComponentLogic> findByComponentIdAndIsActiveTrueAndIsDeletedFalseOrderBySno(Integer componentId);

    void deleteByComponentId(Integer componentId);
}
