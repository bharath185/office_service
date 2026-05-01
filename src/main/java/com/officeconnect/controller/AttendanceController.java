package com.officeconnect.controller;

import com.officeconnect.dto.*;
import com.officeconnect.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/GetAllAttendance")
    public ResponseEntity<?> getAllAttendance(@RequestBody Map<String, Object> payload) {
        try {
            List<?> result = attendanceService.getAllAttendance(payload);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAttendanceByEmployee")
    public ResponseEntity<?> getAttendanceByEmployee(@RequestBody Map<String, Object> payload) {
        try {
            List<?> result = attendanceService.getAttendanceByEmployee(payload);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAttendanceByDate")
    public ResponseEntity<?> getAttendanceByDate(@RequestBody Map<String, Object> payload) {
        try {
            List<?> result = attendanceService.getAttendanceByDate(payload);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAttendanceByMonth")
    public ResponseEntity<?> getAttendanceByMonth(@RequestBody Map<String, Object> payload) {
        return ResponseEntity.ok(Map.of("NotImplemented", true, "route", "Attendance/GetAttendanceByMonth"));
    }

    @PostMapping("/GetAttendanceByQuarter")
    public ResponseEntity<?> getAttendanceByQuarter(@RequestBody Map<String, Object> payload) {
        return ResponseEntity.ok(Map.of("NotImplemented", true, "route", "Attendance/GetAttendanceByQuarter"));
    }

    @PostMapping("/GetAttendanceYearly")
    public ResponseEntity<?> getAttendanceYearly(@RequestBody Map<String, Object> payload) {
        return ResponseEntity.ok(Map.of("NotImplemented", true, "route", "Attendance/GetAttendanceYearly"));
    }
    @PostMapping("/ProcessAttendance")
    public ResponseEntity<?> processAttendance(@RequestBody Map<String, Object> payload) {
        try {
            Map<String, Object> result = attendanceService.processAttendance(payload);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ManualAttendance")
    public ResponseEntity<?> manualAttendance(@RequestBody Map<String, Object> payload) {
        try {
            Map<String, Object> result = attendanceService.manualAttendance(payload);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAttendanceSummary")
    public ResponseEntity<?> getAttendanceSummary(@RequestBody Map<String, Object> payload) {
        try {
            List<?> result = attendanceService.getAttendanceSummary(payload);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetMonthlyAttendance")
    public ResponseEntity<?> getMonthlyAttendance(@RequestBody Map<String, Object> payload) {
        try {
            List<?> result = attendanceService.getMonthlyAttendance(payload);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAttendanceByMonthYear")
    public ResponseEntity<?> getAttendanceByMonthYear(@RequestBody Map<String, Object> payload) {
        try {
            List<?> result = attendanceService.getAttendanceByMonthYear(payload);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAttendanceByWeek")
    public ResponseEntity<?> getAttendanceByWeek(@RequestBody Map<String, Object> payload) {
        try {
            List<?> result = attendanceService.getAttendanceByWeek(payload);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAttendanceByDateRange")
    public ResponseEntity<?> getAttendanceByDateRange(@RequestBody Map<String, Object> payload) {
        try {
            List<?> result = attendanceService.getAttendanceByDateRange(payload);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAttendanceByDepartment")
    public ResponseEntity<?> getAttendanceByDepartment(@RequestBody Map<String, Object> payload) {
        try {
            List<?> result = attendanceService.getAttendanceByDepartment(payload);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetOvertimeAttendance")
    public ResponseEntity<?> getOvertimeAttendance(@RequestBody Map<String, Object> payload) {
        try {
            List<?> result = attendanceService.getOvertimeAttendance(payload);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetExceptionAttendance")
    public ResponseEntity<?> getExceptionAttendance(@RequestBody Map<String, Object> payload) {
        try {
            List<?> result = attendanceService.getExceptionAttendance(payload);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAttendanceByLocation")
    public ResponseEntity<?> getAttendanceByLocation(@RequestBody Map<String, Object> payload) {
        try {
            List<?> result = attendanceService.getAttendanceByLocation(payload);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAttendanceByTeam")
    public ResponseEntity<?> getAttendanceByTeam(@RequestBody Map<String, Object> payload) {
        try {
            List<?> result = attendanceService.getAttendanceByTeam(payload);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    }
