package com.officeconnect.repository;

import com.officeconnect.entity.ModuleMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleMasterRepository extends JpaRepository<ModuleMaster, Integer> {
    List<ModuleMaster> findByIsDeleted(Boolean isDeleted);
    List<ModuleMaster> findByModuleIdAndIsDeleted(Integer moduleId, Boolean isDeleted);
}