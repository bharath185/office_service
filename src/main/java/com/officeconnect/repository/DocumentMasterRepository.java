package com.officeconnect.repository;

import com.officeconnect.entity.DocumentMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DocumentMasterRepository extends JpaRepository<DocumentMaster, Integer> {
    List<DocumentMaster> findByIsActiveAndIsDeletedAndEduId(Boolean isActive, Boolean isDeleted, Integer eduId);
    List<DocumentMaster> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
}
