package com.officeconnect.controller;

import com.officeconnect.dto.*;
import com.officeconnect.dto.EmployeeSelectViewModel;
import com.officeconnect.service.EmployeeService;
import com.officeconnect.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private HolidayService holidayService;

    @PostMapping("/GetAllHolidays")
    public ResponseEntity<?> getAllHolidays(@RequestBody(required = false) Map<String, Object> payload) {
        try {
            HolidayViewModel model = new HolidayViewModel();
            if (payload != null) {
                if (payload.containsKey("LoginId")) {
                    Object loginId = payload.get("LoginId");
                    if (loginId instanceof Integer) model.setLoginId((Integer) loginId);
                    else if (loginId instanceof String) {
                        try { model.setLoginId(Integer.valueOf((String) loginId)); } catch (NumberFormatException e) { model.setLoginId(0); }
                    }
                    else if (loginId instanceof Long) model.setLoginId(((Long) loginId).intValue());
                }
            }
            List<HolidayViewModel> result = holidayService.getAllHoliday(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

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

    @PostMapping("/DDAuthorisedEntity")
    public ResponseEntity<?> ddAuthorisedEntity(@RequestBody DDAuthorisedEntityViewModel model) {
        try {
            List<DDAuthorisedEntityViewModel> result = employeeService.getAuthorizedEntity(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDBusinessUnit")
    public ResponseEntity<?> ddBusinessUnit(@RequestBody(required=false) Map<String, Object> payload) {
        try {
            DDBusinessUnitViewModel model = new DDBusinessUnitViewModel();
            if (payload != null && payload.containsKey("EmpId")) {
                Object empId = payload.get("EmpId");
                if (empId instanceof Integer) model.setEmpId((Integer) empId);
                else if (empId instanceof String) model.setEmpId(Integer.valueOf((String) empId));
                else if (empId instanceof Long) model.setEmpId(((Long) empId).intValue());
            }
            List<DDBusinessUnitViewModel> result = employeeService.getDDBusinessUnit(model);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("StatusCode", 500, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDLocation")
    public ResponseEntity<?> ddLocation(@RequestBody(required=false) Map<String, Object> payload) {
        try {
            DDLocationViewModel model = new DDLocationViewModel();
            List<DDLocationViewModel> result = employeeService.getDDLocation(model);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("StatusCode", 500, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UploadAttendance")
    public ResponseEntity<?> uploadAttendance(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("StatusCode", 200, "Message", "UploadAttendance accepted"));
    }

    @PostMapping("/UploadFileCareer")
    public ResponseEntity<?> uploadFileCareer(
            @RequestParam("EmpId") Integer empId,
            @RequestParam("DocName") String docName,
            @RequestParam("File") MultipartFile file) {
        try {
            Map<String, Object> result = employeeService.uploadFileCareer(empId, docName, file);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("StatusCode", 500, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UploadFileEducation")
    public ResponseEntity<?> uploadFileEducation(
            @RequestParam("EmpId") Integer empId,
            @RequestParam("DocName") String docName,
            @RequestParam("File") MultipartFile file) {
        try {
            Map<String, Object> result = employeeService.uploadFileEducation(empId, docName, file);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("StatusCode", 500, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UploadFileGovt")
    public ResponseEntity<?> uploadFileGovt(
            @RequestParam("EmpId") Integer empId,
            @RequestParam("DocName") String docName,
            @RequestParam("File") MultipartFile file) {
        try {
            Map<String, Object> result = employeeService.uploadFileGovt(empId, docName, file);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("StatusCode", 500, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UploadImage")
    public ResponseEntity<?> uploadImage(
            @RequestParam("EmpId") Integer empId,
            @RequestParam(value = "ImageType", defaultValue = "PROFILEPIC") String imageType,
            @RequestParam("File") MultipartFile file) {
        try {
            Map<String, Object> result = employeeService.uploadImage(empId, imageType, file);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("StatusCode", 500, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UploadMultiAttendance")
    public ResponseEntity<?> uploadMultiAttendance(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("StatusCode", 200, "Message", "UploadMultiAttendance accepted"));
    }

    @PostMapping("/UploadSingleAttendance")
    public ResponseEntity<?> uploadSingleAttendance(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("StatusCode", 200, "Message", "UploadSingleAttendance accepted"));
    }

    @PostMapping("/ERPContractAttendanceDetails")
    public ResponseEntity<?> erpContractAttendanceDetails(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("StatusCode", 200, "Message", "ERPContractAttendanceDetails accepted"));
    }

    @PostMapping("/ERPProjectmappingDetails")
    public ResponseEntity<?> erpProjectMappingDetails(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("StatusCode", 200, "Message", "ERPProjectmappingDetails accepted"));
    }

    @PostMapping("/FetchEmployee")
    public ResponseEntity<?> fetchEmployee(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("StatusCode", 200, "Message", "FetchEmployee accepted"));
    }

    @PostMapping("/GetAllEducationDoc")
    public ResponseEntity<?> getAllEducationDoc(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("NotImplemented", true, "route", "Employee/GetAllEducationDoc"));
    }

    @PostMapping("/GetAllEmpAccDetails")
    public ResponseEntity<?> getAllEmpAccDetails(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getAllEmpAccDetails();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllEmpCareerDetails")
    public ResponseEntity<?> getAllEmpCareerDetails(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getAllEmpCareerDetails();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllFinanceMaster")
    public ResponseEntity<?> getAllFinanceMaster(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getAllFinanceMaster(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmpProjects")
    public ResponseEntity<?> getEmpProjects(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getEmpProjects(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmpEducationDetails")
    public ResponseEntity<?> getEmpEducationDetails(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getEmpEducationDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmpDocuments")
    public ResponseEntity<?> getEmpDocuments(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getEmpDocuments(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmployeeTimeline")
    public ResponseEntity<?> getEmployeeTimeline(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getEmployeeTimeline(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmployeeStatusHistory")
    public ResponseEntity<?> getEmployeeStatusHistory(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getEmployeeStatusHistory(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ExportEmployeeList")
    public ResponseEntity<?> exportEmployeeList(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.exportEmployeeList(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmpAddressDetails")
    public ResponseEntity<?> getEmpAddressDetails(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getEmpAddressDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmpPhoneDetails")
    public ResponseEntity<?> getEmpPhoneDetails(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getEmpPhoneDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmpEmergencyContacts")
    public ResponseEntity<?> getEmpEmergencyContacts(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getEmpEmergencyContacts(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllEmployeeProjectsSkeleton")
    public ResponseEntity<?> getAllEmployeeProjectsSkeleton(@RequestBody Map<String, Object> model) {
        List<Map<String, Object>> result = new java.util.ArrayList<>();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/NewDDCompany")
    public ResponseEntity<?> newDDCompany(@RequestBody NewDDCompanyViewModel model) {
        try {
            List<NewDDCompanyViewModel> result = employeeService.getNewDDCompany(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/NewDDLegalEntity")
    public ResponseEntity<?> newDDLegalEntity(@RequestBody NewDDLegalEntityViewModel model) {
        try {
            List<NewDDLegalEntityViewModel> result = employeeService.getNewDDLegalEntity(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/NewDDBusinessUnit")
    public ResponseEntity<?> newDDBusinessUnit(@RequestBody NewDDBusinessUnitViewModel model) {
        try {
            List<NewDDBusinessUnitViewModel> result = employeeService.getNewDDBusinessUnit(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/NewDDLocation")
    public ResponseEntity<?> newDDLocation(@RequestBody NewDDLocationViewModel model) {
        try {
            List<NewDDLocationViewModel> result = employeeService.getNewDDLocation(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddEmployee")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeMasterViewModel model) {
        try {
            EmployeeMasterViewModel result = employeeService.saveEmployee(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateEmployee")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeMasterViewModel model) {
        try {
            EmployeeMasterViewModel result = employeeService.updateEmployee(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllEmployee")
    public ResponseEntity<?> getAllEmployee(@RequestBody EmployeeMasterViewModel model) {
        try {
            List<EmployeeMasterViewModel> result = employeeService.getAllEmployees(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmployee")
    public ResponseEntity<?> getEmployee(@RequestBody EmployeeMasterViewModel model) {
        try {
            EmployeeMasterViewModel result = employeeService.getEmployeeById(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmployeeDetails")
    public ResponseEntity<?> getEmployeeDetails(@RequestBody EmployeeMasterViewModel model) {
        try {
            EmployeeMasterViewModel result = employeeService.getEmployeeById(model);
            List<EmployeeMasterViewModel> resultList = new java.util.ArrayList<>();
            if (result != null) {
                resultList.add(result);
            }
            return ResponseEntity.ok(resultList);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteEmployee")
    public ResponseEntity<?> deleteEmployee(@RequestBody EmployeeMasterViewModel model) {
        try {
            EmployeeMasterViewModel result = employeeService.deleteEmployee(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDSalutation")
    public ResponseEntity<?> ddSalutation(@RequestBody(required=false) Map<String, Object> payload) {
        try {
            Integer empId = 0;
            if (payload != null && payload.containsKey("EmpId")) {
                Object empIdObj = payload.get("EmpId");
                if (empIdObj instanceof Integer) empId = (Integer) empIdObj;
                else if (empIdObj instanceof String) {
                    try { empId = Integer.valueOf((String) empIdObj); } catch (NumberFormatException e) { empId = 0; }
                }
                else if (empIdObj instanceof Long) empId = ((Long) empIdObj).intValue();
            }
            List<DDSalutationViewModel> result = employeeService.getDDSalutation(empId);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDGender")
    public ResponseEntity<?> ddGender(@RequestBody(required=false) Map<String, Object> payload) {
        try {
            Integer empId = 0;
            if (payload != null && payload.containsKey("EmpId")) {
                Object empIdObj = payload.get("EmpId");
                if (empIdObj instanceof Integer) empId = (Integer) empIdObj;
                else if (empIdObj instanceof String) {
                    try { empId = Integer.valueOf((String) empIdObj); } catch (NumberFormatException e) { empId = 0; }
                }
                else if (empIdObj instanceof Long) empId = ((Long) empIdObj).intValue();
            }
            List<DDGenderViewModel> result = employeeService.getDDGender(empId);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDEmpType")
    public ResponseEntity<?> ddEmpType(@RequestBody Map<String, Object> model) {
        try {
            List<DDEmpTypeViewModel> result = employeeService.getDDEmpType();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDApprover")
    public ResponseEntity<?> ddApprover(@RequestBody(required=false) Map<String, Object> payload) {
        try {
            DDApproverViewModel model = new DDApproverViewModel();
            if (payload != null) {
                if (payload.containsKey("EmpId")) {
                    Object empId = payload.get("EmpId");
                    if (empId instanceof Integer) model.setEmpId((Integer) empId);
                    else if (empId instanceof String) {
                        try { model.setEmpId(Integer.valueOf((String) empId)); } catch (NumberFormatException e) { model.setEmpId(0); }
                    }
                    else if (empId instanceof Long) model.setEmpId(((Long) empId).intValue());
                }
                if (payload.containsKey("CompId")) {
                    Object compId = payload.get("CompId");
                    if (compId instanceof Integer) model.setCompId((Integer) compId);
                    else if (compId instanceof String) {
                        try { model.setCompId(Integer.valueOf((String) compId)); } catch (NumberFormatException e) { model.setCompId(0); }
                    }
                    else if (compId instanceof Long) model.setCompId(((Long) compId).intValue());
                }
                if (payload.containsKey("LEId")) {
                    Object leId = payload.get("LEId");
                    if (leId instanceof Integer) model.setLEId((Integer) leId);
                    else if (leId instanceof String) {
                        try { model.setLEId(Integer.valueOf((String) leId)); } catch (NumberFormatException e) { model.setLEId(0); }
                    }
                    else if (leId instanceof Long) model.setLEId(((Long) leId).intValue());
                }
                if (payload.containsKey("BUId")) {
                    Object buId = payload.get("BUId");
                    if (buId instanceof Integer) model.setBUId((Integer) buId);
                    else if (buId instanceof String) {
                        try { model.setBUId(Integer.valueOf((String) buId)); } catch (NumberFormatException e) { model.setBUId(0); }
                    }
                    else if (buId instanceof Long) model.setBUId(((Long) buId).intValue());
                }
                if (payload.containsKey("LocationId")) {
                    Object locationId = payload.get("LocationId");
                    if (locationId instanceof Integer) model.setLocationId((Integer) locationId);
                    else if (locationId instanceof String) {
                        try { model.setLocationId(Integer.valueOf((String) locationId)); } catch (NumberFormatException e) { model.setLocationId(0); }
                    }
                    else if (locationId instanceof Long) model.setLocationId(((Long) locationId).intValue());
                }
                if (payload.containsKey("AuthorisedEntity")) {
                    model.setAuthorisedEntity(payload.get("AuthorisedEntity") != null ? payload.get("AuthorisedEntity").toString() : null);
                }
            }
            List<DDApproverViewModel> result = employeeService.getDDApprover(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ActiveEmployee")
    public ResponseEntity<?> activeEmployee(@RequestBody EmployeeMasterViewModel model) {
        try {
            EmployeeMasterViewModel result = employeeService.activeEmployee(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeActiveEmployee")
    public ResponseEntity<?> deActiveEmployee(@RequestBody EmployeeMasterViewModel model) {
        try {
            EmployeeMasterViewModel result = employeeService.deActiveEmployee(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/SelectEmployee")
    public ResponseEntity<?> selectEmployee(@RequestBody EmployeeMasterViewModel model) {
        try {
            List<EmployeeSelectViewModel> result = employeeService.selectEmployee(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetTotalEmployeeCount")
    public ResponseEntity<?> getTotalEmployeeCount(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.getTotalEmployeeCount();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDGetLocation")
    public ResponseEntity<?> ddGetLocation(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getDDGetLocation();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDselectEmployee")
    public ResponseEntity<?> ddSelectEmployee(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getDDselectEmployee();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDEmployeeList")
    public ResponseEntity<?> ddEmployeeList(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getDDEmployeeList();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDReporterList")
    public ResponseEntity<?> ddReporterList(@RequestBody(required = false) Map<String, Object> payload) {
        try {
            DDReporterListViewModel model = new DDReporterListViewModel();
            if (payload != null) {
                if (payload.containsKey("LoginId")) {
                    Object loginId = payload.get("LoginId");
                    if (loginId instanceof Integer) model.setLoginId((Integer) loginId);
                    else if (loginId instanceof String) {
                        try { model.setLoginId(Integer.valueOf((String) loginId)); } catch (NumberFormatException e) { model.setLoginId(0); }
                    }
                    else if (loginId instanceof Long) model.setLoginId(((Long) loginId).intValue());
                }
                if (payload.containsKey("LEId")) {
                    Object leId = payload.get("LEId");
                    if (leId instanceof Integer) model.setLEId((Integer) leId);
                    else if (leId instanceof String) {
                        try { model.setLEId(Integer.valueOf((String) leId)); } catch (NumberFormatException e) { model.setLEId(0); }
                    }
                    else if (leId instanceof Long) model.setLEId(((Long) leId).intValue());
                }
                if (payload.containsKey("BUId")) {
                    Object buId = payload.get("BUId");
                    if (buId instanceof Integer) model.setBUId((Integer) buId);
                    else if (buId instanceof String) {
                        try { model.setBUId(Integer.valueOf((String) buId)); } catch (NumberFormatException e) { model.setBUId(0); }
                    }
                    else if (buId instanceof Long) model.setBUId(((Long) buId).intValue());
                }
                if (payload.containsKey("LocationId")) {
                    Object locationId = payload.get("LocationId");
                    if (locationId instanceof Integer) model.setLocationId((Integer) locationId);
                    else if (locationId instanceof String) {
                        try { model.setLocationId(Integer.valueOf((String) locationId)); } catch (NumberFormatException e) { model.setLocationId(0); }
                    }
                    else if (locationId instanceof Long) model.setLocationId(((Long) locationId).intValue());
                }
                if (payload.containsKey("DeptId")) {
                    Object deptId = payload.get("DeptId");
                    if (deptId instanceof Integer) model.setDeptId((Integer) deptId);
                    else if (deptId instanceof String) {
                        try { model.setDeptId(Integer.valueOf((String) deptId)); } catch (NumberFormatException e) { model.setDeptId(0); }
                    }
                    else if (deptId instanceof Long) model.setDeptId(((Long) deptId).intValue());
                }
                if (payload.containsKey("DesignationId")) {
                    Object designationId = payload.get("DesignationId");
                    if (designationId instanceof Integer) model.setDesignationId((Integer) designationId);
                    else if (designationId instanceof String) {
                        try { model.setDesignationId(Integer.valueOf((String) designationId)); } catch (NumberFormatException e) { model.setDesignationId(0); }
                    }
                    else if (designationId instanceof Long) model.setDesignationId(((Long) designationId).intValue());
                }
            }
            List<DDReporterListViewModel> result = employeeService.getDDReporterList(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DashboardEmployee")
    public ResponseEntity<?> dashboardEmployee(@RequestBody EmployeeMasterViewModel model) {
        try {
            List<EmployeeMasterViewModel> result = employeeService.dashboardEmployee(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllWorkType")
    public ResponseEntity<?> getAllWorkType(@RequestBody WorkTypeMasterViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            List<WorkTypeMasterViewModel> result = employeeService.getAllWorkType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetWorkType")
    public ResponseEntity<?> getWorkType(@RequestBody WorkTypeMasterViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer empId = parseSafeInt(model.getEmpId());
            Integer wid = parseSafeInt(model.getWorkTypeId());
            if (loginId == null) model.setLoginId(0);
            if (empId == null) model.setEmpId(0);
            if (wid == null) model.setWorkTypeId(0);
            WorkTypeMasterViewModel result = employeeService.getWorkType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddWorkType")
    public ResponseEntity<?> addWorkType(@RequestBody WorkTypeMasterViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer empId = parseSafeInt(model.getEmpId());
            if (loginId == null) model.setLoginId(0);
            if (empId == null) model.setEmpId(0);
            WorkTypeMasterViewModel result = employeeService.addWorkType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateWorkType")
    public ResponseEntity<?> updateWorkType(@RequestBody WorkTypeMasterViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer empId = parseSafeInt(model.getEmpId());
            Integer wid = parseSafeInt(model.getWorkTypeId());
            if (loginId == null) model.setLoginId(0);
            if (empId == null) model.setEmpId(0);
            if (wid == null) model.setWorkTypeId(0);
            WorkTypeMasterViewModel result = employeeService.updateWorkType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteWorkType")
    public ResponseEntity<?> deleteWorkType(@RequestBody WorkTypeMasterViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer wid = parseSafeInt(model.getWorkTypeId());
            if (loginId == null) model.setLoginId(0);
            if (wid == null) model.setWorkTypeId(0);
            WorkTypeMasterViewModel result = employeeService.deleteWorkType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllApproverWorkType")
    public ResponseEntity<?> getAllApproverWorkType(@RequestBody WorkTypeMasterViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            List<WorkTypeMasterViewModel> result = employeeService.getAllApproverWorkType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ApproveWorkType")
    public ResponseEntity<?> approveWorkType(@RequestBody WorkTypeMasterViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer wid = parseSafeInt(model.getWorkTypeId());
            if (loginId == null) model.setLoginId(0);
            if (wid == null) model.setWorkTypeId(0);
            WorkTypeMasterViewModel result = employeeService.approveWorkType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/RejectWorkType")
    public ResponseEntity<?> rejectWorkType(@RequestBody WorkTypeMasterViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer wid = parseSafeInt(model.getWorkTypeId());
            if (loginId == null) model.setLoginId(0);
            if (wid == null) model.setWorkTypeId(0);
            WorkTypeMasterViewModel result = employeeService.rejectWorkType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDEmployeeApprover")
    public ResponseEntity<?> ddEmployeeApprover(@RequestBody DDEmployeeViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            if (loginId == null) model.setLoginId(0);
            List<DDEmployeeViewModel> result = employeeService.ddEmployeeApprover(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/EmployeeAttendance")
    public ResponseEntity<?> employeeAttendance(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.employeeAttendance();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AttendanceFilter")
    public ResponseEntity<?> attendanceFilter(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.attendanceFilter();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/EachEmployeeAttendance")
    public ResponseEntity<?> eachEmployeeAttendance(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.eachEmployeeAttendance();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ReportingEmployeeAttendance")
    public ResponseEntity<?> reportingEmployeeAttendance(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.reportingEmployeeAttendance(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/OnSiteLogin")
    public ResponseEntity<?> onSiteLogin(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.onSiteLogin(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/OnSiteLogout")
    public ResponseEntity<?> onSiteLogout(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.onSiteLogout(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllLoginLogs")
    public ResponseEntity<?> getAllLoginLogs(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getAllLoginLogs();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UploadProfilePicture")
    public ResponseEntity<?> uploadProfilePicture(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("NotImplemented", true, "route", "Employee/UploadProfilePicture"));
    }

    @PostMapping("/UpdateProfilePhoto")
    public ResponseEntity<?> updateProfilePhoto(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("NotImplemented", true, "route", "Employee/UpdateProfilePhoto"));
    }
    // Skeleton removed: duplicate UploadImage endpoint

    // Skeleton removed: duplicate WFHUploadImage endpoint

    // Skeleton removed: duplicate UploadFileEducation endpoint

    // Skeleton removed: duplicate UploadFileGovt endpoint

    // Skeleton removed: duplicate UploadFileCareer endpoint

    @PostMapping("/DDEducationDoc")
    public ResponseEntity<?> ddEducationDoc(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.ddEducationDoc(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDGovtDoc")
    public ResponseEntity<?> ddGovtDoc(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.ddGovtDoc(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    // Skeleton removed: duplicate GetAllEducationDoc

    @PostMapping("/GetEducationDoc")
    public ResponseEntity<?> getEducationDoc(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getEducationDoc(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddEducationDoc")
    public ResponseEntity<?> addEducationDoc(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.addEducationDoc(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateEducationDoc")
    public ResponseEntity<?> updateEducationDoc(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.updateEducationDoc(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteEducationDoc")
    public ResponseEntity<?> deleteEducationDoc(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.deleteEducationDoc(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllGovtDoc")
    public ResponseEntity<?> getAllGovtDoc(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getAllGovtDoc();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetGovtDoc")
    public ResponseEntity<?> getGovtDoc(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getGovtDoc(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddGovtDoc")
    public ResponseEntity<?> addGovtDoc(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.addGovtDoc(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateGovtDoc")
    public ResponseEntity<?> updateGovtDoc(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.updateGovtDoc(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteGovtDoc")
    public ResponseEntity<?> deleteGovtDoc(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.deleteGovtDoc(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    // Skeleton removed: duplicate GetAllEmpAccDetails

    @PostMapping("/GetEmpAccDetails")
    public ResponseEntity<?> getEmpAccDetails(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getEmpAccDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddEmpAccDetails")
    public ResponseEntity<?> addEmpAccDetails(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.addEmpAccDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateEmpAccDetails")
    public ResponseEntity<?> updateEmpAccDetails(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.updateEmpAccDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteEmpAccDetails")
    public ResponseEntity<?> deleteEmpAccDetails(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.deleteEmpAccDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    // Skeleton removed: duplicate GetAllEmpCareerDetails

    @PostMapping("/GetEmpCareerDetails")
    public ResponseEntity<?> getEmpCareerDetails(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getEmpCareerDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddEmpCareerDetails")
    public ResponseEntity<?> addEmpCareerDetails(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.addEmpCareerDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateEmpCareerDetails")
    public ResponseEntity<?> updateEmpCareerDetails(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.updateEmpCareerDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteEmpCareerDetails")
    public ResponseEntity<?> deleteEmpCareerDetails(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.deleteEmpCareerDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/RelievedEmployee")
    public ResponseEntity<?> relievedEmployee(@RequestBody EmployeeMasterViewModel model) {
        try {
            EmployeeMasterViewModel result = employeeService.relievedEmployee(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAttendanceSource")
    public ResponseEntity<?> getAttendanceSource(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getAttendanceSource();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetConsolidatedAttendanceData")
    public ResponseEntity<?> getConsolidatedAttendanceData(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getConsolidatedAttendanceData();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DashboardDetails")
    public ResponseEntity<?> dashboardDetails(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.dashboardDetails();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/CreateShift")
    public ResponseEntity<?> createShift(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.createShift(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/CreateCompanySetting")
    public ResponseEntity<?> createCompanySetting(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.createCompanySetting(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/CheckHalfDayLoss")
    public ResponseEntity<?> checkHalfDayLoss(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.checkHalfDayLoss(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetWorkHours")
    public ResponseEntity<?> getWorkHours(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.getWorkHours();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

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

    @PostMapping("/SubmitAccessControls")
    public ResponseEntity<?> submitAccessControls(@RequestBody List<Map<String, Object>> models) {
        try {
            Map<String, Object> result = employeeService.submitAccessControls(models);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllEmployeeContactInformation")
    public ResponseEntity<?> getAllEmployeeContactInformation(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getAllEmployeeContactInformation();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmployeeContactInformation")
    public ResponseEntity<?> getEmployeeContactInformation(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.getEmployeeContactInformation(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddEmployeeContactInformation")
    public ResponseEntity<?> addEmployeeContactInformation(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.addEmployeeContactInformation(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateEmployeeContactInformation")
    public ResponseEntity<?> updateEmployeeContactInformation(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.updateEmployeeContactInformation(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteEmployeeContactInformation")
    public ResponseEntity<?> deleteEmployeeContactInformation(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.deleteEmployeeContactInformation(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetOnSiteData")
    public ResponseEntity<?> getOnSiteData(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getOnSiteData();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddOnSiteData")
    public ResponseEntity<?> addOnSiteData(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.addOnSiteData(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/PCGetAllEmployee")
    public ResponseEntity<?> pcGetAllEmployee(@RequestBody EmployeeMasterViewModel model) {
        try {
            List<EmployeeMasterViewModel> result = employeeService.pcGetAllEmployee(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/PCAddAllEmployee")
    public ResponseEntity<?> pcAddAllEmployee(@RequestBody EmployeeMasterViewModel model) {
        try {
            List<EmployeeMasterViewModel> result = employeeService.pcAddAllEmployee(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllWorkTypeFilter")
    public ResponseEntity<?> getAllWorkTypeFilter(@RequestBody WorkTypeFilterViewModel model) {
        try {
            Integer loginId = parseSafeInt(model.getLoginId());
            Integer empId = parseSafeInt(model.getEmpId());
            if (loginId == null) model.setLoginId(0);
            if (empId == null) model.setEmpId(0);
            List<WorkTypeMasterViewModel> result = employeeService.getAllWorkTypeFilter(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetLoginLogs")
    public ResponseEntity<?> getLoginLogs(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getLoginLogs();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/CreateHoliday")
    public ResponseEntity<?> createHoliday(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.createHoliday(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateHoliday")
    public ResponseEntity<?> updateHoliday(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.updateHoliday(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteHoliday")
    public ResponseEntity<?> deleteHoliday(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.deleteHoliday(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllHoliday")
    public ResponseEntity<?> getAllHoliday(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.getAllHolidayEMP(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateHolidayStatus")
    public ResponseEntity<?> updateHolidayStatus(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.updateHoliday(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetPageById")
    public ResponseEntity<?> getPageById(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.getPageById(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdatePageModules")
    public ResponseEntity<?> updatePageModules(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.updatePageModules(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeletePageModules")
    public ResponseEntity<?> deletePageModules(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.deletePageModules(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetBehaviouralGoal")
    public ResponseEntity<?> getBehaviouralGoal(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.getBehaviouralGoal(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddBehaviouralGoal")
    public ResponseEntity<?> addBehaviouralGoal(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.addBehaviouralGoal(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateBehaviouralGoal")
    public ResponseEntity<?> updateBehaviouralGoal(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.updateBehaviouralGoal(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteBehaviouralGoal")
    public ResponseEntity<?> deleteBehaviouralGoal(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.deleteBehaviouralGoal(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllBehaviouralGoal")
    public ResponseEntity<?> getAllBehaviouralGoal(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getAllBehaviouralGoal();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmployeeGoalHistory")
    public ResponseEntity<?> getEmployeeGoalHistory(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getEmployeeGoalHistory();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmployeeQuarterDetails")
    public ResponseEntity<?> getEmployeeQuarterDetails(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.getEmployeeQuarterDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmployeeSalaryDetails")
    public ResponseEntity<?> getEmployeeSalaryDetails(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.getEmployeeSalaryDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddEmployeeSalaryDetails")
    public ResponseEntity<?> addEmployeeSalaryDetails(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.addEmployeeSalaryDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateEmployeeSalaryDetails")
    public ResponseEntity<?> updateEmployeeSalaryDetails(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.updateEmployeeSalaryDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteEmployeeSalaryDetails")
    public ResponseEntity<?> deleteEmployeeSalaryDetails(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.deleteEmployeeSalaryDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllEmployeeSalaryDetails")
    public ResponseEntity<?> getAllEmployeeSalaryDetails(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getAllEmployeeSalaryDetails();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllEmployeeNomineeDetails")
    public ResponseEntity<?> getAllEmployeeNomineeDetails(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getAllEmployeeNomineeDetails();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddEmployeeNomineeDetails")
    public ResponseEntity<?> addEmployeeNomineeDetails(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.addEmployeeNomineeDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmployeeNomineeDetails")
    public ResponseEntity<?> getEmployeeNomineeDetails(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.getEmployeeNomineeDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateEmployeeNomineeDetails")
    public ResponseEntity<?> updateEmployeeNomineeDetails(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.updateEmployeeNomineeDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteEmployeeNomineeDetails")
    public ResponseEntity<?> deleteEmployeeNomineeDetails(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.deleteEmployeeNomineeDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllEmpProbationTrackingHistory")
    public ResponseEntity<?> getAllEmpProbationTrackingHistory(@RequestBody EmpProbationTrackingHistoryViewModel model) {
        try {
            EmpProbationTrackingHistoryListViewModel result = employeeService.getAllEmpProbationTrackingHistory(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllEmployeeLogHistory")
    public ResponseEntity<?> getAllEmployeeLogHistory(@RequestBody EmployeeMasterViewModel model) {
        try {
            List<Map<String, Object>> result = employeeService.getAllEmployeeLogHistory(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDEmpList")
    public ResponseEntity<?> ddEmpList(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getDDEmployeeList();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllManualAttendance")
    public ResponseEntity<?> getAllManualAttendance(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getAllManualAttendance(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/SPAttendance")
    public ResponseEntity<?> spAttendance(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.spAttendance(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AttendanceDeptReport")
    public ResponseEntity<?> attendanceDeptReport(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.attendanceDeptReport(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ContractAttendanceChecking")
    public ResponseEntity<?> contractAttendanceChecking(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.contractAttendanceChecking(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddContractAttendance")
    public ResponseEntity<?> addContractAttendance(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.addContractAttendance(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ContractAttendanceManager")
    public ResponseEntity<?> contractAttendanceManager(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.contractAttendanceManager(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ApprovedbyManager")
    public ResponseEntity<?> approvedbyManager(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.approvedbyManager(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/LogoutbyManager")
    public ResponseEntity<?> logoutbyManager(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.logoutbyManager(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ApprovedHrbyManager")
    public ResponseEntity<?> approvedHrbyManager(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.approvedHrbyManager(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDVendorList")
    public ResponseEntity<?> ddVendorList(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.ddVendorList(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDSiteList")
    public ResponseEntity<?> ddSiteList(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.ddSiteList(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDProjectList")
    public ResponseEntity<?> ddProjectList(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.ddProjectList(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ConfirmProbation")
    public ResponseEntity<?> confirmProbation(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.confirmProbation(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetDesignationHierarchy")
    public ResponseEntity<?> getDesignationHierarchy(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getDesignationHierarchy(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddHoliday")
    public ResponseEntity<?> addHoliday(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.addHoliday(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetHolidayById")
    public ResponseEntity<?> getHolidayById(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.getHolidayById(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/CreateWeekHoliday")
    public ResponseEntity<?> createWeekHoliday(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.createWeekHoliday(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateWeekHoliday")
    public ResponseEntity<?> updateWeekHoliday(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.updateWeekHoliday(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteWeekHoliday")
    public ResponseEntity<?> deleteWeekHoliday(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.deleteWeekHoliday(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllWeekHolidays")
    public ResponseEntity<?> getAllWeekHolidays(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getAllWeekHolidays(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetWeekHolidayById")
    public ResponseEntity<?> getWeekHolidayById(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.getWeekHolidayById(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetGradeWiseHierarchy")
    public ResponseEntity<?> getGradeWiseHierarchy(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.getGradeWiseHierarchy(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/FetchAttendance")
    public ResponseEntity<?> fetchAttendance(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.fetchAttendance();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/CFLeaveCredits")
    public ResponseEntity<?> cfLeaveCredits(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.cfLeaveCredits();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddVendorList")
    public ResponseEntity<?> addVendorList(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.addVendorList(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddProjectList")
    public ResponseEntity<?> addProjectList(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = employeeService.addProjectList(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmpHolidays")
    public ResponseEntity<?> getEmpHolidays(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = employeeService.getEmpHolidays(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/WFHUploadImage")
    public ResponseEntity<?> wfhUploadImage(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("StatusCode", 200, "Message", "WFHUploadImage accepted"));
    }

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
}
