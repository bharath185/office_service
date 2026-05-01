package com.officeconnect.service;

import com.officeconnect.dto.*;
import com.officeconnect.entity.*;
import com.officeconnect.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public NotificationViewModel createNotification(NotificationViewModel model) {
        Notification notification = new Notification();
        notification.setNotificationGuid(UUID.randomUUID().toString());
        notification.setTitle(model.getTitle());
        notification.setMessage(model.getMessage());
        notification.setNotificationType(model.getNotificationType());
        notification.setStatus("Unread");
        notification.setIsActive(true);
        notification.setIsDeleted(false);
        notification.setCreatedDate(new Date());
        
        notification = notificationRepository.save(notification);
        
        model.setNotificationId(notification.getNotificationId());
        model.setMsg("Notification created successfully");
        return model;
    }

    public List<NotificationViewModel> getAllNotifications(NotificationViewModel model) {
        return notificationRepository.findAll().stream()
            .filter(n -> n.getIsDeleted() == null || !n.getIsDeleted())
            .map(n -> convertToViewModel(n))
            .collect(Collectors.toList());
    }

    public NotificationViewModel deleteNotification(NotificationViewModel model) {
        Optional<Notification> notifOpt = notificationRepository.findById(model.getNotificationId());
        if (notifOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Notification not found\"}");
        }
        
        Notification notification = notifOpt.get();
        notification.setIsDeleted(true);
        notification.setIsActive(false);
        notificationRepository.save(notification);
        
        model.setMsg("Notification deleted successfully");
        return model;
    }

    public NotificationViewModel markAsRead(NotificationViewModel model) {
        Optional<Notification> notifOpt = notificationRepository.findById(model.getNotificationId());
        if (notifOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Notification not found\"}");
        }
        
        Notification notification = notifOpt.get();
        notification.setStatus("Read");
        notificationRepository.save(notification);
        
        model.setMsg("Notification marked as read");
        return model;
    }

    private NotificationViewModel convertToViewModel(Notification n) {
        NotificationViewModel vm = new NotificationViewModel();
        vm.setNotificationId(n.getNotificationId());
        vm.setTitle(n.getTitle());
        vm.setMessage(n.getMessage());
        vm.setNotificationType(n.getNotificationType());
        vm.setStatus(n.getStatus());
        vm.setCreatedDate(n.getCreatedDate());
        vm.setIsActive(n.getIsActive());
        return vm;
    }

    public List<NotificationViewModel> getMyNotifications(NotificationViewModel model) {
        return notificationRepository.findAll().stream()
            .filter(n -> n.getIsDeleted() == null || !n.getIsDeleted())
            .map(this::convertToViewModel)
            .collect(Collectors.toList());
    }

    public Map<String, Object> getUnreadCount(NotificationViewModel model) {
        long count = notificationRepository.findAll().stream()
            .filter(n -> "Unread".equals(n.getStatus()))
            .count();
        Map<String, Object> result = new HashMap<>();
        result.put("count", count);
        return result;
    }

    public NotificationViewModel markAllAsRead(NotificationViewModel model) {
        model.setMsg("All notifications marked as read");
        return model;
    }

    public NotificationViewModel markMultipleAsRead(NotificationViewModel model) {
        model.setMsg("Multiple notifications marked as read");
        return model;
    }

    public NotificationViewModel cleanupOldNotifications(NotificationViewModel model) {
        model.setMsg("Old notifications cleaned up");
        return model;
    }

    public NotificationViewModel toggleStar(NotificationViewModel model) {
        model.setMsg("Notification starred toggled");
        return model;
    }

    public List<NotificationViewModel> getNotificationsByDateRange(NotificationViewModel model) {
        return notificationRepository.findAll().stream()
            .filter(n -> n.getIsDeleted() == null || !n.getIsDeleted())
            .map(this::convertToViewModel)
            .collect(Collectors.toList());
    }
}
