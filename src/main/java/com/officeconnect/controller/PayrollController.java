package com.officeconnect.controller;

import com.officeconnect.dto.*;
import com.officeconnect.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Payroll")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    private Integer parseSafeInt(Object value) {
        if (value == null) return null;
        if (value instanceof Integer) return (Integer) value;
        if (value instanceof String) {
            String str = ((String) value).trim();
            if (str.isEmpty() || str.equalsIgnoreCase("undefined") || str.equalsIgnoreCase("null")) return null;
            try { return Integer.valueOf(str); } catch (NumberFormatException e) { return null; }
        }
        if (value instanceof Number) return ((Number) value).intValue();
        return null;
    }

    @PostMapping("/GetAllComponents")
    public ResponseEntity<?> getAllComponents(@RequestBody PayrollComponentViewModel model) {
        try {
            List<PayrollComponentViewModel> result = payrollService.getAllComponents(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddComponent")
    public ResponseEntity<?> addComponent(@RequestBody PayrollComponentViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            PayrollComponentViewModel result = payrollService.addComponent(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateComponent")
    public ResponseEntity<?> updateComponent(@RequestBody PayrollComponentViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer compId = parseSafeInt(model.getComponentId());
            if (loginId == null) model.setLoginId(0);
            if (compId == null) model.setComponentId(0);
            PayrollComponentViewModel result = payrollService.updateComponent(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteComponent")
    public ResponseEntity<?> deleteComponent(@RequestBody PayrollComponentViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer compId = parseSafeInt(model.getComponentId());
            if (loginId == null) model.setLoginId(0);
            if (compId == null) model.setComponentId(0);
            PayrollComponentViewModel result = payrollService.deleteComponent(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDPayrollSymbols")
    public ResponseEntity<?> ddPayrollSymbols(@RequestBody PayrolAccessViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            List<Map<String, Object>> result = payrollService.getDDPayrollSymbols(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDPayrollFrequency")
    public ResponseEntity<?> ddPayrollFrequency(@RequestBody PayrolAccessViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            List<Map<String, Object>> result = payrollService.getDDPayrollFrequency();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDPayrollPayoutType")
    public ResponseEntity<?> ddPayrollPayoutType(@RequestBody PayrollPayoutTypeViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            List<DDPayrollPayoutTypeViewModel> result = payrollService.ddPayrollPayoutType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllPayrollPayoutType")
    public ResponseEntity<?> getAllPayrollPayoutType(@RequestBody PayrollPayoutTypeViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            List<PayrollPayoutTypeViewModel> result = payrollService.getAllPayrollPayoutType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetPayrollPayoutType")
    public ResponseEntity<?> getPayrollPayoutType(@RequestBody PayrollPayoutTypeViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer ptId = parseSafeInt(model.getPayoutTypeId());
            if (loginId == null) model.setLoginId(0);
            if (ptId == null) model.setPayoutTypeId(0);
            PayrollPayoutTypeViewModel result = payrollService.getPayrollPayoutType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddPayrollPayoutType")
    public ResponseEntity<?> addPayrollPayoutType(@RequestBody PayrollPayoutTypeViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            PayrollResponseViewModel result = payrollService.addPayrollPayoutType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdatePayrollPayoutType")
    public ResponseEntity<?> updatePayrollPayoutType(@RequestBody PayrollPayoutTypeViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer ptId = parseSafeInt(model.getPayoutTypeId());
            if (loginId == null) model.setLoginId(0);
            if (ptId == null) model.setPayoutTypeId(0);
            PayrollResponseViewModel result = payrollService.updatePayrollPayoutType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeletePayrollPayoutType")
    public ResponseEntity<?> deletePayrollPayoutType(@RequestBody PayrollPayoutTypeViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer ptId = parseSafeInt(model.getPayoutTypeId());
            if (loginId == null) model.setLoginId(0);
            if (ptId == null) model.setPayoutTypeId(0);
            PayrollResponseViewModel result = payrollService.deletePayrollPayoutType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDPayrollSegment")
    public ResponseEntity<?> ddPayrollSegment(@RequestBody PayrollSegmentViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer ptId = parseSafeInt(model.getPayoutTypeId());
            if (loginId == null) model.setLoginId(0);
            if (ptId == null) model.setPayoutTypeId(0);
            List<DDPayrollSegmentViewModel> result = payrollService.ddPayrollSegment(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllPayrollSegment")
    public ResponseEntity<?> getAllPayrollSegment(@RequestBody PayrollSegmentViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            List<PayrollSegmentViewModel> result = payrollService.getAllPayrollSegment(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetPayrollSegment")
    public ResponseEntity<?> getPayrollSegment(@RequestBody PayrollSegmentViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer segId = parseSafeInt(model.getSegmentId());
            if (loginId == null) model.setLoginId(0);
            if (segId == null) model.setSegmentId(0);
            PayrollSegmentViewModel result = payrollService.getPayrollSegment(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddPayrollSegment")
    public ResponseEntity<?> addPayrollSegment(@RequestBody PayrollSegmentViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            PayrollResponseViewModel result = payrollService.addPayrollSegment(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdatePayrollSegment")
    public ResponseEntity<?> updatePayrollSegment(@RequestBody PayrollSegmentViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer segId = parseSafeInt(model.getSegmentId());
            if (loginId == null) model.setLoginId(0);
            if (segId == null) model.setSegmentId(0);
            PayrollResponseViewModel result = payrollService.updatePayrollSegment(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeletePayrollSegment")
    public ResponseEntity<?> deletePayrollSegment(@RequestBody PayrollSegmentViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer segId = parseSafeInt(model.getSegmentId());
            if (loginId == null) model.setLoginId(0);
            if (segId == null) model.setSegmentId(0);
            PayrollResponseViewModel result = payrollService.deletePayrollSegment(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDPayrollEmpList")
    public ResponseEntity<?> ddPayrollEmpList(@RequestBody PayrollComponentViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            List<DDPayrollEmpListViewModel> result = payrollService.ddPayrollEmpList(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDPayrollComponent")
    public ResponseEntity<?> ddPayrollComponent(@RequestBody PayrollComponentViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            List<DDPayrollComponentViewModel> result = payrollService.ddPayrollComponent(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllComponentDetails")
    public ResponseEntity<?> getAllComponentDetails(@RequestBody PayrollALLComponentViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            List<PayrollALLComponentViewModel> result = payrollService.getAllComponentDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/EmpCTCCalculation")
    public ResponseEntity<?> empCTCCalculation(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = payrollService.empCTCCalculation(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/EmpPayslipGeneration")
    public ResponseEntity<?> empPayslipGeneration(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = payrollService.empPayslipGeneration(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDPayslipSection")
    public ResponseEntity<?> ddPayslipSection(@RequestBody PayslipSectionViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            List<DDPayslipSectionViewModel> result = payrollService.ddPayslipSection(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllPayslipSection")
    public ResponseEntity<?> getAllPayslipSection(@RequestBody PayslipSectionViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            List<PayslipSectionViewModel> result = payrollService.getAllPayslipSection(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetPayslipSection")
    public ResponseEntity<?> getPayslipSection(@RequestBody PayslipSectionViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer secId = parseSafeInt(model.getSectionId());
            if (loginId == null) model.setLoginId(0);
            if (secId == null) model.setSectionId(0);
            PayslipSectionViewModel result = payrollService.getPayslipSection(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddPayslipSection")
    public ResponseEntity<?> addPayslipSection(@RequestBody PayslipSectionViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            PayrollResponseViewModel result = payrollService.addPayslipSection(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdatePayslipSection")
    public ResponseEntity<?> updatePayslipSection(@RequestBody PayslipSectionViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer secId = parseSafeInt(model.getSectionId());
            if (loginId == null) model.setLoginId(0);
            if (secId == null) model.setSectionId(0);
            PayrollResponseViewModel result = payrollService.updatePayslipSection(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeletePayslipSection")
    public ResponseEntity<?> deletePayslipSection(@RequestBody PayslipSectionViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer secId = parseSafeInt(model.getSectionId());
            if (loginId == null) model.setLoginId(0);
            if (secId == null) model.setSectionId(0);
            PayrollResponseViewModel result = payrollService.deletePayslipSection(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllPayslipSectionComponent")
    public ResponseEntity<?> getAllPayslipSectionComponent(@RequestBody PayslipSectionComponentViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            List<PayslipSectionComponentViewModel> result = payrollService.getAllPayslipSectionComponent(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetPayslipSectionComponent")
    public ResponseEntity<?> getPayslipSectionComponent(@RequestBody PayslipSectionComponentViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer scId = parseSafeInt(model.getSectionComponentId());
            if (loginId == null) model.setLoginId(0);
            if (scId == null) model.setSectionComponentId(0);
            PayslipSectionComponentViewModel result = payrollService.getPayslipSectionComponent(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddPayslipSectionComponent")
    public ResponseEntity<?> addPayslipSectionComponent(@RequestBody PayslipSectionComponentViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            PayrollResponseViewModel result = payrollService.addPayslipSectionComponent(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdatePayslipSectionComponent")
    public ResponseEntity<?> updatePayslipSectionComponent(@RequestBody PayslipSectionComponentViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer scId = parseSafeInt(model.getSectionComponentId());
            if (loginId == null) model.setLoginId(0);
            if (scId == null) model.setSectionComponentId(0);
            PayrollResponseViewModel result = payrollService.updatePayslipSectionComponent(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeletePayslipSectionComponent")
    public ResponseEntity<?> deletePayslipSectionComponent(@RequestBody PayslipSectionComponentViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer scId = parseSafeInt(model.getSectionComponentId());
            if (loginId == null) model.setLoginId(0);
            if (scId == null) model.setSectionComponentId(0);
            PayrollResponseViewModel result = payrollService.deletePayslipSectionComponent(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllEmployeeSalaryDetails")
    public ResponseEntity<?> getAllEmployeeSalaryDetails(@RequestBody EmployeeSalaryDetailsViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            List<EmployeeSalaryDetailsViewModel> result = payrollService.getAllEmployeeSalaryDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmployeeSalaryDetails")
    public ResponseEntity<?> getEmployeeSalaryDetails(@RequestBody EmployeeSalaryDetailsViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer salId = parseSafeInt(model.getSalaryId());
            if (loginId == null) model.setLoginId(0);
            if (salId == null) model.setSalaryId(0);
            EmployeeSalaryDetailsViewModel result = payrollService.getEmployeeSalaryDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddEmployeeSalaryDetails")
    public ResponseEntity<?> addEmployeeSalaryDetails(@RequestBody EmployeeSalaryDetailsViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            PayrollResponseViewModel result = payrollService.addEmployeeSalaryDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateEmployeeSalaryDetails")
    public ResponseEntity<?> updateEmployeeSalaryDetails(@RequestBody EmployeeSalaryDetailsViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer salId = parseSafeInt(model.getSalaryId());
            if (loginId == null) model.setLoginId(0);
            if (salId == null) model.setSalaryId(0);
            PayrollResponseViewModel result = payrollService.updateEmployeeSalaryDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteEmployeeSalaryDetails")
    public ResponseEntity<?> deleteEmployeeSalaryDetails(@RequestBody EmployeeSalaryDetailsViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer salId = parseSafeInt(model.getSalaryId());
            if (loginId == null) model.setLoginId(0);
            if (salId == null) model.setSalaryId(0);
            PayrollResponseViewModel result = payrollService.deleteEmployeeSalaryDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllPayoutMappingMaster")
    public ResponseEntity<?> getAllPayoutMappingMaster(@RequestBody PayoutMappingMasterViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            List<PayoutMappingMasterViewModel> result = payrollService.getAllPayoutMappingMaster(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetPayoutMappingMaster")
    public ResponseEntity<?> getPayoutMappingMaster(@RequestBody PayoutMappingMasterViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer mapId = parseSafeInt(model.getMapId());
            if (loginId == null) model.setLoginId(0);
            if (mapId == null) model.setMapId(0);
            PayoutMappingMasterViewModel result = payrollService.getPayoutMappingMaster(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddPayoutMappingMaster")
    public ResponseEntity<?> addPayoutMappingMaster(@RequestBody PayoutMappingMasterViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            PayrollResponseViewModel result = payrollService.addPayoutMappingMaster(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdatePayoutMappingMaster")
    public ResponseEntity<?> updatePayoutMappingMaster(@RequestBody PayoutMappingMasterViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer mapId = parseSafeInt(model.getMapId());
            if (loginId == null) model.setLoginId(0);
            if (mapId == null) model.setMapId(0);
            PayrollResponseViewModel result = payrollService.updatePayoutMappingMaster(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeletePayoutMappingMaster")
    public ResponseEntity<?> deletePayoutMappingMaster(@RequestBody PayoutMappingMasterViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer mapId = parseSafeInt(model.getMapId());
            if (loginId == null) model.setLoginId(0);
            if (mapId == null) model.setMapId(0);
            PayrollResponseViewModel result = payrollService.deletePayoutMappingMaster(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/PayrollReportforALL")
    public ResponseEntity<?> payrollReportforALL(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = payrollService.payrollReportforALL(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDLegalEntity")
    public ResponseEntity<?> ddLegalEntity(@RequestBody PayrollPayoutTypeViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            List<DDLegalEntityPayrollViewModel> result = payrollService.ddLegalEntity(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDLocation")
    public ResponseEntity<?> ddLocation(@RequestBody Map<String, Object> model) {
        try {
            List<DDLocationViewModel> result = payrollService.getDDLocation();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetPayrollComponents")
    public ResponseEntity<?> getPayrollComponents(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = payrollService.getPayrollComponents();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/CalculatePayroll")
    public ResponseEntity<?> calculatePayroll(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = payrollService.calculatePayroll(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GeneratePayslip")
    public ResponseEntity<?> generatePayslip(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = payrollService.generatePayslip(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetPayslipByEmployee")
    public ResponseEntity<?> getPayslipByEmployee(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = payrollService.getPayslipByEmployee(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ProcessPayroll")
    public ResponseEntity<?> processPayroll(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = payrollService.processPayroll(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ActivatePayrollPayoutType")
    public ResponseEntity<?> activatePayrollPayoutType(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = payrollService.activatePayrollPayoutType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeactivatePayrollPayoutType")
    public ResponseEntity<?> deactivatePayrollPayoutType(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = payrollService.deactivatePayrollPayoutType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddPayrollVariable")
    public ResponseEntity<?> addPayrollVariable(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = payrollService.addPayrollVariable(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdatePayrollVariable")
    public ResponseEntity<?> updatePayrollVariable(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = payrollService.updatePayrollVariable(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeletePayrollVariable")
    public ResponseEntity<?> deletePayrollVariable(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = payrollService.deletePayrollVariable(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetPayrollVariable")
    public ResponseEntity<?> getPayrollVariable(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = payrollService.getPayrollVariable(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllPayrollVariable")
    public ResponseEntity<?> getAllPayrollVariable(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = payrollService.getAllPayrollVariable(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDPayrollVariable")
    public ResponseEntity<?> ddPayrollVariable(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = payrollService.ddPayrollVariable(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddPayrollVariableHistory")
    public ResponseEntity<?> addPayrollVariableHistory(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = payrollService.addPayrollVariableHistory(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdatePayrollVariableHistory")
    public ResponseEntity<?> updatePayrollVariableHistory(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = payrollService.updatePayrollVariableHistory(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeletePayrollVariableHistory")
    public ResponseEntity<?> deletePayrollVariableHistory(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = payrollService.deletePayrollVariableHistory(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/PayrollVariableHistory")
    public ResponseEntity<?> payrollVariableHistory(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = payrollService.payrollVariableHistory(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllPayrollPayoutTypeSegment")
    public ResponseEntity<?> getAllPayrollPayoutTypeSegment(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = payrollService.getAllPayrollPayoutTypeSegment(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }
}
