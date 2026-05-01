package com.officeconnect.controller;

import com.officeconnect.dto.DashboardViewModel;
import com.officeconnect.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @PostMapping("/GetEmployeeEvents")
    public ResponseEntity<?> getEmployeeEvents(@RequestBody DashboardViewModel model) {
        try {
            DashboardViewModel result = dashboardService.getEmployeeEvents(model);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.ok(Map.of("Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllHRcount")
    public ResponseEntity<?> getAllHRcount(@RequestBody DashboardViewModel model) {
        try {
            DashboardViewModel result = dashboardService.getAllHRCount(model);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.ok(Map.of("Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetDashboardSummary")
    public ResponseEntity<?> getDashboardSummary(@RequestBody DashboardViewModel model) {
        try {
            DashboardViewModel result = dashboardService.getDashboardSummary(model);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.ok(Map.of("Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetLeaveStatistics")
    public ResponseEntity<?> getLeaveStatistics(@RequestBody DashboardViewModel model) {
        try {
            DashboardViewModel result = dashboardService.getLeaveStatistics(model);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.ok(Map.of("Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAttendanceStatistics")
    public ResponseEntity<?> getAttendanceStatistics(@RequestBody DashboardViewModel model) {
        try {
            DashboardViewModel result = dashboardService.getAttendanceStatistics(model);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.ok(Map.of("Message", ex.getMessage()));
        }
    }
}