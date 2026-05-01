package com.officeconnect.controller;

import com.officeconnect.dto.*;
import com.officeconnect.service.AccessService;
import com.officeconnect.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Access")
public class AccessController {

    @Autowired
    private AccessService accessService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/GetAllPages")
    public ResponseEntity<?> getAllPages(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getAllPages();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/CreatePolicy")
    public ResponseEntity<?> createPolicy(@RequestBody AccessViewModel model) {
        try {
            AccessViewModel result = accessService.createPolicy(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllPolicies")
    public ResponseEntity<?> getAllPolicies(@RequestBody AccessViewModel model) {
        try {
            List<AccessViewModel> result = accessService.getAllPolicies(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdatePolicy")
    public ResponseEntity<?> updatePolicy(@RequestBody AccessViewModel model) {
        try {
            AccessViewModel result = accessService.updatePolicy(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeletePolicy")
    public ResponseEntity<?> deletePolicy(@RequestBody AccessViewModel model) {
        try {
            AccessViewModel result = accessService.deletePolicy(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddRole")
    public ResponseEntity<?> addRole(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.addRole(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAccessDetails")
    public ResponseEntity<?> getAccessDetails(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getAllAccess(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllRoles")
    public ResponseEntity<?> getAllRoles(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getAllRole(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllModules")
    public ResponseEntity<?> getAllModules(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getAllModule(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateRole")
    public ResponseEntity<?> updateRole(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.updateRole(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteRole")
    public ResponseEntity<?> deleteRole(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.deleteRole(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetRole")
    public ResponseEntity<?> getRole(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.getRole(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllRole")
    public ResponseEntity<?> getAllRole(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getAllRole(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAccessRoles")
    public ResponseEntity<?> getAccessRoles(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getAllRole(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllPermissions")
    public ResponseEntity<?> getAllPermissions(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getAllAccess(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDRole")
    public ResponseEntity<?> ddRole(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getDDRole(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddModule")
    public ResponseEntity<?> addModule(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.addModule(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateModule")
    public ResponseEntity<?> updateModule(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.updateModule(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteModule")
    public ResponseEntity<?> deleteModule(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.deleteModule(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetModule")
    public ResponseEntity<?> getModule(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.getModule(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllModule")
    public ResponseEntity<?> getAllModule(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getAllModule(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDModule")
    public ResponseEntity<?> ddModule(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getDDModule();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddSubModule")
    public ResponseEntity<?> addSubModule(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.addSubModule(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateSubModule")
    public ResponseEntity<?> updateSubModule(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.updateSubModule(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteSubModule")
    public ResponseEntity<?> deleteSubModule(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.deleteSubModule(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetSubModule")
    public ResponseEntity<?> getSubModule(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.getSubModule(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllSubModule")
    public ResponseEntity<?> getAllSubModule(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getAllSubModule(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDSubModule")
    public ResponseEntity<?> ddSubModule(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getDDSubModule();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddPageModule")
    public ResponseEntity<?> addPageModule(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.addPageModule(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdatePageModule")
    public ResponseEntity<?> updatePageModule(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.updatePageModule(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeletePageModule")
    public ResponseEntity<?> deletePageModule(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.deletePageModule(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetPageModule")
    public ResponseEntity<?> getPageModule(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.getPageModule(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllPageModule")
    public ResponseEntity<?> getAllPageModule(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getAllPageModule(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDPageModule")
    public ResponseEntity<?> ddPageModule(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getDDPageModule();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddDept")
    public ResponseEntity<?> addDept(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.addDept(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateDept")
    public ResponseEntity<?> updateDept(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.updateDept(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteDept")
    public ResponseEntity<?> deleteDept(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.deleteDept(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetDept")
    public ResponseEntity<?> getDept(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.getDept(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllDept")
    public ResponseEntity<?> getAllDept(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getAllDept(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDDept")
    public ResponseEntity<?> ddDept(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getDDDept();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDAccess")
    public ResponseEntity<?> ddAccess(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getDDAccess();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddAccess")
    public ResponseEntity<?> addAccess(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.addAccess(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteAccess")
    public ResponseEntity<?> deleteAccess(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.deleteAccess(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAccess")
    public ResponseEntity<?> getAccess(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.getAccess(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllAccess")
    public ResponseEntity<?> getAllAccess(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getAllAccess(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateAccess")
    public ResponseEntity<?> updateAccess(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = accessService.updateAccess(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAccessPolicy")
    public ResponseEntity<?> getAccessPolicy(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getAccessPolicy(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDCompany")
    public ResponseEntity<?> ddCompany(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getDDCompany();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDEmployee")
    public ResponseEntity<?> ddEmployee(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getDDEmployee();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDDepartmentEmployee")
    public ResponseEntity<?> ddDeptEmployee(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getDDDeptEmployee();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDDesignation")
    public ResponseEntity<?> ddDesignation(@RequestBody(required=false) Map<String, Object> payload) {
        try {
            Integer empId = 0;
            Integer deptId = 0;
            if (payload != null) {
                if (payload.containsKey("EmpId")) {
                    Object empIdObj = payload.get("EmpId");
                    if (empIdObj instanceof Integer) empId = (Integer) empIdObj;
                    else if (empIdObj instanceof String) {
                        try { empId = Integer.valueOf((String) empIdObj); } catch (NumberFormatException e) { empId = 0; }
                    }
                    else if (empIdObj instanceof Long) empId = ((Long) empIdObj).intValue();
                }
                if (payload.containsKey("DeptId")) {
                    Object deptIdObj = payload.get("DeptId");
                    if (deptIdObj instanceof Integer) deptId = (Integer) deptIdObj;
                    else if (deptIdObj instanceof String) {
                        try { deptId = Integer.valueOf((String) deptIdObj); } catch (NumberFormatException e) { deptId = 0; }
                    }
                    else if (deptIdObj instanceof Long) deptId = ((Long) deptIdObj).intValue();
                }
            }
            List<DDDesignationViewModel> result = accessService.getDDDesignation(empId, deptId);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDGrade")
    public ResponseEntity<?> ddGrade(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = accessService.getDDGrade();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    }
