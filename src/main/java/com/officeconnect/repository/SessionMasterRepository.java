package com.officeconnect.repository;

import com.officeconnect.entity.SessionMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessionMasterRepository extends JpaRepository<SessionMaster, Integer> {

    @Query("SELECT s FROM SessionMaster s WHERE UPPER(s.username) = UPPER(?1) AND s.tockenId = ?2 AND s.status = true AND s.expired = false AND s.isActive = true AND s.isDeleted = false ORDER BY s.createdDate DESC")
    Optional<SessionMaster> findActiveSessionByUsernameAndToken(String username, String token);

    @Query("SELECT s FROM SessionMaster s WHERE UPPER(s.username) = UPPER(?1) AND s.tockenId = ?2 AND s.authKey = ?3 AND s.roleId = ?4 AND s.status = true AND s.expired = false AND s.isActive = true AND s.isDeleted = false ORDER BY s.createdDate DESC")
    Optional<SessionMaster> findActiveSessionByUsernameTokenAuthKeyAndRole(String username, String token, String authKey, Integer roleId);

    List<SessionMaster> findByUsernameIgnoreCaseAndIsActiveAndIsDeleted(String username, Boolean isActive, Boolean isDeleted);
}