package com.officeconnect.controller;

import com.officeconnect.dto.*;
import com.officeconnect.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/CreateNotification")
    public ResponseEntity<?> createNotification(@RequestBody NotificationViewModel model) {
        try {
            NotificationViewModel result = notificationService.createNotification(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllNotifications")
    public ResponseEntity<?> getAllNotifications(@RequestBody NotificationViewModel model) {
        try {
            List<NotificationViewModel> result = notificationService.getAllNotifications(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/MarkAsRead")
    public ResponseEntity<?> markAsRead(@RequestBody NotificationViewModel model) {
        try {
            NotificationViewModel result = notificationService.markAsRead(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteNotification")
    public ResponseEntity<?> deleteNotification(@RequestBody NotificationViewModel model) {
        try {
            NotificationViewModel result = notificationService.deleteNotification(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetMyNotifications")
    public ResponseEntity<?> getMyNotifications(@RequestBody NotificationViewModel model) {
        try {
            List<NotificationViewModel> result = notificationService.getMyNotifications(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetUnreadCount")
    public ResponseEntity<?> getUnreadCount(@RequestBody NotificationViewModel model) {
        try {
            Map<String, Object> result = notificationService.getUnreadCount(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetNotificationHistory")
    public ResponseEntity<?> getNotificationHistory(@RequestBody NotificationViewModel model) {
        try {
            List<NotificationViewModel> result = notificationService.getMyNotifications(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/MarkAllAsRead")
    public ResponseEntity<?> markAllAsRead(@RequestBody NotificationViewModel model) {
        try {
            NotificationViewModel result = notificationService.markAllAsRead(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/MarkMultipleAsRead")
    public ResponseEntity<?> markMultipleAsRead(@RequestBody NotificationViewModel model) {
        try {
            NotificationViewModel result = notificationService.markMultipleAsRead(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/CleanupOldNotifications")
    public ResponseEntity<?> cleanupOldNotifications(@RequestBody NotificationViewModel model) {
        try {
            NotificationViewModel result = notificationService.cleanupOldNotifications(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ToggleStar")
    public ResponseEntity<?> toggleStar(@RequestBody NotificationViewModel model) {
        try {
            NotificationViewModel result = notificationService.toggleStar(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetNotificationsByDateRange")
    public ResponseEntity<?> getNotificationsByDateRange(@RequestBody NotificationViewModel model) {
        try {
            List<NotificationViewModel> result = notificationService.getNotificationsByDateRange(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }
}
