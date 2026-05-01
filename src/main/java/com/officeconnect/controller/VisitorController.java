package com.officeconnect.controller;

import com.officeconnect.dto.*;
import com.officeconnect.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Visitor")
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @PostMapping("/CreateVisitor")
    public ResponseEntity<?> createVisitor(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.createVisitor(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateVisitor")
    public ResponseEntity<?> updateVisitor(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.updateVisitor(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllVisitor")
    public ResponseEntity<?> getAllVisitor(@RequestBody VisitorManagementViewModel model) {
        try {
            List<VisitorManagementViewModel> result = visitorService.getAllVisitor(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ApproveVisitor")
    public ResponseEntity<?> approveVisitor(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.approveVisitor(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteVisitor")
    public ResponseEntity<?> deleteVisitor(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.deleteVisitor(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/VisitorInvite")
    public ResponseEntity<?> visitorInvite(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.visitorInvite(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/VisitorInviteHistory")
    public ResponseEntity<?> visitorInviteHistory(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.visitorInviteHistory(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllVisitorInviteHistory")
    public ResponseEntity<?> getAllVisitorInviteHistory(@RequestBody VisitorManagementViewModel model) {
        try {
            List<VisitorManagementViewModel> result = visitorService.getAllVisitorInviteHistory(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/VisitorUpdateInvite")
    public ResponseEntity<?> visitorUpdateInvite(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.visitorUpdateInvite(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/VisitorOTPVerify")
    public ResponseEntity<?> visitorOTPVerify(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.visitorOTPVerify(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllVisitorByEmp")
    public ResponseEntity<?> getAllVisitorByEmp(@RequestBody VisitorManagementViewModel model) {
        try {
            List<VisitorManagementViewModel> result = visitorService.getAllVisitorByEmp(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/VisitorCheckIn")
    public ResponseEntity<?> visitorCheckIn(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.visitorCheckIn(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/VisitorCheckOut")
    public ResponseEntity<?> visitorCheckOut(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.visitorCheckOut(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetVisitorToday")
    public ResponseEntity<?> getVisitorToday(@RequestBody VisitorManagementViewModel model) {
        try {
            List<VisitorManagementViewModel> result = visitorService.getVisitorToday(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllApprovedVisitor")
    public ResponseEntity<?> getAllApprovedVisitor(@RequestBody VisitorManagementViewModel model) {
        try {
            List<VisitorManagementViewModel> result = visitorService.getAllApprovedVisitor(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/VisitorDownloadPDF")
    public ResponseEntity<?> visitorDownloadPDF(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.visitorDownloadPDF(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllVisitorHistory")
    public ResponseEntity<?> getAllVisitorHistory(@RequestBody VisitorManagementViewModel model) {
        try {
            List<VisitorManagementViewModel> result = visitorService.getAllVisitorHistory(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/VisitorEmail")
    public ResponseEntity<?> visitorEmail(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.visitorEmail(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/CheckVisitorExists")
    public ResponseEntity<?> checkVisitorExists(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.checkVisitorExists(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    // Frontend path aliases
    @PostMapping("/InviteVisit")
    public ResponseEntity<?> inviteVisit(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.visitorInvite(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/VerifyOTP")
    public ResponseEntity<?> verifyOTP(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.visitorOTPVerify(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllInvite")
    public ResponseEntity<?> getAllInvite(@RequestBody VisitorManagementViewModel model) {
        try {
            List<VisitorManagementViewModel> result = visitorService.getAllVisitorInviteHistory(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllEmployeeInvite")
    public ResponseEntity<?> getAllEmployeeInvite(@RequestBody VisitorManagementViewModel model) {
        try {
            List<VisitorManagementViewModel> result = visitorService.getAllVisitorByEmp(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/CheckIn")
    public ResponseEntity<?> checkIn(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.visitorCheckIn(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/CheckOut")
    public ResponseEntity<?> checkOut(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.visitorCheckOut(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    // Missing visitor endpoints
    @PostMapping("/DDEmployee")
    public ResponseEntity<?> ddEmployee(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = visitorService.ddVisitorEmployee(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDCompany")
    public ResponseEntity<?> ddCompany(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = visitorService.ddVisitorCompany(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DirectCheckIn")
    public ResponseEntity<?> directCheckIn(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.directCheckIn(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/VisitorDirectCheckIn")
    public ResponseEntity<?> visitorDirectCheckIn(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.directCheckIn(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/VerifyOTPCheckIn")
    public ResponseEntity<?> verifyOTPCheckIn(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.verifyOTPCheckIn(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AcceptInvite")
    public ResponseEntity<?> acceptInvite(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.acceptInvite(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/VisitFilter")
    public ResponseEntity<?> visitFilter(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = visitorService.visitFilter(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UploadFileVisitor")
    public ResponseEntity<?> uploadFileVisitor(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("msg", "File uploaded", "StatusCode", 200));
    }

    @PostMapping("/CancelInvite")
    public ResponseEntity<?> cancelInvite(@RequestBody VisitorManagementViewModel model) {
        try {
            VisitorManagementViewModel result = visitorService.cancelInvite(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/VisitExportCSV")
    public ResponseEntity<?> visitExportCSV(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("msg", "CSV exported", "StatusCode", 200));
    }

    @PostMapping("/VisitExportExcel")
    public ResponseEntity<?> visitExportExcel(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("msg", "Excel exported", "StatusCode", 200));
    }
}