package com.officeconnect.controller;

import com.officeconnect.dto.*;
import com.officeconnect.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/BusinessEntity")
public class BusinessEntityController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/DDCompany")
    public ResponseEntity<?> ddCompany(@RequestBody DDCompanyViewModel model) {
        try {
            List<DDCompanyViewModel> result = employeeService.getDDCompany(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDLegalEntity")
    public ResponseEntity<?> ddLegalEntity(@RequestBody DDLegalEntityViewModel model) {
        try {
            List<DDLegalEntityViewModel> result = employeeService.getDDLegalEntity(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDBusinessUnit")
    public ResponseEntity<?> ddBusinessUnit(@RequestBody DDBusinessUnitViewModel model) {
        try {
            List<DDBusinessUnitViewModel> result = employeeService.getDDBusinessUnit(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDLocation")
    public ResponseEntity<?> ddLocation(@RequestBody DDLocationViewModel model) {
        try {
            List<DDLocationViewModel> result = employeeService.getDDLocation(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    // Skeleton endpoints to align with .NET endpoints (Not implemented yet)
    @PostMapping("/GetAllCompany")
    public ResponseEntity<?> getAllCompany(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getAllCompany(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddCompany")
    public ResponseEntity<?> addCompany(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("NotImplemented", true, "route", "BusinessEntity/AddCompany"));
    }

    @PostMapping("/UpdateCompany")
    public ResponseEntity<?> updateCompany(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("NotImplemented", true, "route", "BusinessEntity/UpdateCompany"));
    }

    @PostMapping("/DeleteCompany")
    public ResponseEntity<?> deleteCompany(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("NotImplemented", true, "route", "BusinessEntity/DeleteCompany"));
    }

    @PostMapping("/GetCompany")
    public ResponseEntity<?> getCompany(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("NotImplemented", true, "route", "BusinessEntity/GetCompany"));
    }

    @PostMapping("/GetAllLegalEntity")
    public ResponseEntity<?> getAllLegalEntity(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getAllLegalEntity(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddLegalEntity")
    public ResponseEntity<?> addLegalEntity(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("NotImplemented", true, "route", "BusinessEntity/AddLegalEntity"));
    }

    @PostMapping("/UpdateLegalEntity")
    public ResponseEntity<?> updateLegalEntity(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("NotImplemented", true, "route", "BusinessEntity/UpdateLegalEntity"));
    }

    @PostMapping("/DeleteLegalEntity")
    public ResponseEntity<?> deleteLegalEntity(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("NotImplemented", true, "route", "BusinessEntity/DeleteLegalEntity"));
    }

    @PostMapping("/GetLegalEntity")
    public ResponseEntity<?> getLegalEntity(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("NotImplemented", true, "route", "BusinessEntity/GetLegalEntity"));
    }

    @PostMapping("/GetAllLocation")
    public ResponseEntity<?> getAllLocation(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getAllLocationBE(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }
}
