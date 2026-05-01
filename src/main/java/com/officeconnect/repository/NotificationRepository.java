package com.officeconnect.repository;

import com.officeconnect.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByIsDeleted(Boolean isDeleted);
    List<Notification> findByStatusAndIsDeleted(String status, Boolean isDeleted);
    List<Notification> findByNotificationTypeAndIsDeleted(String notificationType, Boolean isDeleted);
}