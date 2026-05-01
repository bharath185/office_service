package com.officeconnect.repository;

import com.officeconnect.entity.SubModuleMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubModuleMasterRepository extends JpaRepository<SubModuleMaster, Integer> {
    List<SubModuleMaster> findByIsDeleted(Boolean isDeleted);
    List<SubModuleMaster> findBySubModuleIdAndIsDeleted(Integer subModuleId, Boolean isDeleted);
}