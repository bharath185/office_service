package com.officeconnect.repository;

import com.officeconnect.entity.PageModuleMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageModuleMasterRepository extends JpaRepository<PageModuleMaster, Integer> {
    List<PageModuleMaster> findByIsDeleted(Boolean isDeleted);
    List<PageModuleMaster> findByPageModuleIdAndIsDeleted(Integer pageModuleId, Boolean isDeleted);
}