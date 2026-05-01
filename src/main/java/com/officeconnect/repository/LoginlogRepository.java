package com.officeconnect.repository;

import com.officeconnect.entity.Loginlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface LoginlogRepository extends JpaRepository<Loginlog, Integer> {
    List<Loginlog> findByEmpIdAndActionTypeAndIsActiveAndIsDeletedOrderByCreatedDateDesc(Integer empId, String actionType, Boolean isActive, Boolean isDeleted);
    Optional<Loginlog> findByEmpIdAndActionTypeAndIdAndIsActiveAndIsDeleted(Integer empId, String actionType, Integer id, Boolean isActive, Boolean isDeleted);
    List<Loginlog> findByIsActiveAndIsDeletedOrderByCreatedDateDesc(Boolean isActive, Boolean isDeleted);
    List<Loginlog> findByEmpIdAndIsActiveAndIsDeletedOrderByCreatedDateDesc(Integer empId, Boolean isActive, Boolean isDeleted);
}
