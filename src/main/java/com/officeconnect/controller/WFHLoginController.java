package com.officeconnect.controller;

import com.officeconnect.dto.LoginViewModel;
import com.officeconnect.dto.EmployeeMasterViewModel;
import com.officeconnect.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/WFHLogin")
public class WFHLoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/Login")
    public ResponseEntity<?> wfhLogin(@RequestBody LoginViewModel loginUser) {
        try {
            EmployeeMasterViewModel emp = loginService.checkLogin(loginUser);
            return ResponseEntity.ok(emp);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/LogOut")
    public ResponseEntity<?> wfhLogout(@RequestBody LoginViewModel loginUser) {
        try {
            EmployeeMasterViewModel emp = loginService.checkLogOut(loginUser);
            return ResponseEntity.ok(emp);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllWFHDetails")
    public ResponseEntity<?> getAllWFHDetails(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = loginService.getAllWFHDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllWFHAnalysis")
    public ResponseEntity<?> getAllWFHAnalysis(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = loginService.getAllWFHAnalysis(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllWFHFilterDetails")
    public ResponseEntity<?> getAllWFHFilterDetails(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = loginService.getAllWFHFilterDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/SaveWFHAnalysis")
    public ResponseEntity<?> saveWFHAnalysis(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = loginService.saveWFHAnalysis(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/WFHEmpList")
    public ResponseEntity<?> wfhEmpList(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = loginService.wfhEmpList(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllWFHDays")
    public ResponseEntity<?> getAllWFHDays(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = loginService.getAllWFHDays(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ViewScreenShots")
    public ResponseEntity<?> viewScreenShots(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = loginService.viewScreenShots(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }
}
