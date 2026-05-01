package com.officeconnect.controller;

import com.officeconnect.config.JwtAuthenticationFilter;
import com.officeconnect.dto.CheckAuthViewModel;
import com.officeconnect.dto.EmployeeMasterViewModel;
import com.officeconnect.dto.FRViewModel;
import com.officeconnect.dto.LoginDetailsViewModel;
import com.officeconnect.dto.LoginViewModel;
import com.officeconnect.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/Login")
    public ResponseEntity<?> login(@RequestBody LoginViewModel loginUser) {
        System.out.println("=== LOGIN REQUEST ===");
        System.out.println("userName: " + (loginUser != null ? loginUser.getUserName() : "NULL"));
        System.out.println("password: " + (loginUser != null ? loginUser.getPassword() : "NULL"));
        try {
            EmployeeMasterViewModel emp = loginService.checkLogin(loginUser);
            return ResponseEntity.ok(emp);
        } catch (RuntimeException ex) {
            String message = ex.getMessage();
            try {
                Map<String, Object> error = (Map<String, Object>) new com.fasterxml.jackson.databind.ObjectMapper()
                    .readValue(message, Map.class);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("StatusCode", 404, "Message", message));
            }
        }
    }

    @PostMapping("/LogOut")
    public ResponseEntity<?> logout(@RequestBody LoginViewModel loginUser) {
        try {
            EmployeeMasterViewModel emp = loginService.checkLogOut(loginUser);
            return ResponseEntity.ok(emp);
        } catch (RuntimeException ex) {
            String message = ex.getMessage();
            try {
                Map<String, Object> error = (Map<String, Object>) new com.fasterxml.jackson.databind.ObjectMapper()
                    .readValue(message, Map.class);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("StatusCode", 404, "Message", message));
            }
        }
    }

    @PostMapping("/CheckAuth")
    public ResponseEntity<?> checkAuth(@RequestBody LoginViewModel loginUser) {
        try {
            CheckAuthViewModel checkAuth = loginService.checkAuth(loginUser);
            return ResponseEntity.ok(checkAuth);
        } catch (RuntimeException ex) {
            String message = ex.getMessage();
            try {
                Map<String, Object> error = (Map<String, Object>) new com.fasterxml.jackson.databind.ObjectMapper()
                    .readValue(message, Map.class);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("StatusCode", 404, "Message", message));
            }
        }
    }

    @PostMapping("/ForgetPassword")
    public ResponseEntity<?> forgetPassword(@RequestBody FRViewModel model) {
        try {
            FRViewModel result = loginService.forgetPassword(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            String message = ex.getMessage();
            try {
                Map<String, Object> error = (Map<String, Object>) new com.fasterxml.jackson.databind.ObjectMapper()
                    .readValue(message, Map.class);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("StatusCode", 404, "Message", message));
            }
        }
    }

    @PostMapping("/FPwdVerify")
    public ResponseEntity<?> fpwdVerify(@RequestBody FRViewModel model) {
        try {
            FRViewModel result = loginService.fpwdVerify(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            String message = ex.getMessage();
            try {
                Map<String, Object> error = (Map<String, Object>) new com.fasterxml.jackson.databind.ObjectMapper()
                    .readValue(message, Map.class);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("StatusCode", 404, "Message", message));
            }
        }
    }

    @PostMapping("/ChangePassword")
    public ResponseEntity<?> changePassword(@RequestBody FRViewModel model) {
        try {
            FRViewModel result = loginService.changePassword(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            String message = ex.getMessage();
            try {
                Map<String, Object> error = (Map<String, Object>) new com.fasterxml.jackson.databind.ObjectMapper()
                    .readValue(message, Map.class);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("StatusCode", 404, "Message", message));
            }
        }
    }

    @PostMapping("/LoginDetails")
    public ResponseEntity<?> loginDetails(@RequestBody LoginDetailsViewModel model) {
        try {
            LoginDetailsViewModel result = loginService.getLoginDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            String message = ex.getMessage();
            try {
                Map<String, Object> error = (Map<String, Object>) new com.fasterxml.jackson.databind.ObjectMapper()
                    .readValue(message, Map.class);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("StatusCode", 404, "Message", message));
            }
        }
    }

    @PostMapping("/GenerateTestToken")
    public ResponseEntity<?> generateTestToken(@RequestBody LoginViewModel loginUser) {
        try {
            String token = JwtAuthenticationFilter.encodeAuthToken(loginUser.getUserName());
            return ResponseEntity.ok(Map.of(
                "token", token,
                "message", "Token generated - use this in Authorization header"
            ));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }
}