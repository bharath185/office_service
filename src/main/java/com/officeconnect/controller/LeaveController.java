package com.officeconnect.controller;

import com.officeconnect.dto.*;
import com.officeconnect.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Leave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping("/GetAllLeaveType")
    public ResponseEntity<?> getAllLeaveType(@RequestBody LeaveTypeViewModel model) {
        try {
            List<LeaveTypeViewModel> result = leaveService.getAllLeaveType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllLeaveTypes")
    public ResponseEntity<?> getAllLeaveTypes(@RequestBody LeaveTypeViewModel model) {
        try {
            List<LeaveTypeViewModel> result = leaveService.getAllLeaveType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDLeaveType")
    public ResponseEntity<?> ddLeaveType(@RequestBody DDLeaveTypePayloadViewModel model) {
        try {
            List<LeaveTypeViewModel> result = leaveService.getDDLeaveType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddLeaveType")
    public ResponseEntity<?> addLeaveType(@RequestBody LeaveTypeViewModel model) {
        try {
            LeaveTypeViewModel result = leaveService.addLeaveType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateLeaveType")
    public ResponseEntity<?> updateLeaveType(@RequestBody LeaveTypeViewModel model) {
        try {
            LeaveTypeViewModel result = leaveService.updateLeaveType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteLeaveType")
    public ResponseEntity<?> deleteLeaveType(@RequestBody LeaveTypeViewModel model) {
        try {
            LeaveTypeViewModel result = leaveService.deleteLeaveType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ApplyLeave")
    public ResponseEntity<?> applyLeave(@RequestBody EmpLeaveApplicationViewModel model) {
        try {
            EmpLeaveApplicationViewModel result = leaveService.applyLeave(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DraftLeave")
    public ResponseEntity<?> draftLeave(@RequestBody EmpLeaveApplicationViewModel model) {
        try {
            EmpLeaveApplicationViewModel result = leaveService.draftLeave(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllLeave")
    public ResponseEntity<?> getAllLeave(@RequestBody EmpLeaveApplicationViewModel model) {
        try {
            List<EmpLeaveApplicationViewModel> result = leaveService.getAllEmpLeave(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllManagerLeave")
    public ResponseEntity<?> getAllManagerLeave(@RequestBody EmpLeaveApplicationViewModel model) {
        try {
            List<EmpLeaveApplicationViewModel> result = leaveService.getAllManagerLeave(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ApproveLeaveByManager")
    public ResponseEntity<?> approveLeaveByManager(@RequestBody ApproveLeaveViewModel model) {
        try {
            ApproveLeaveViewModel result = leaveService.approveLeaveByManager(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ApproveLeaveByHR")
    public ResponseEntity<?> approveLeaveByHR(@RequestBody ApproveLeaveViewModel model) {
        try {
            ApproveLeaveViewModel result = leaveService.approveLeaveByHR(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/CompOffLeave")
    public ResponseEntity<?> compOffLeave(@RequestBody CompOffRequestViewModel model) {
        try {
            CompOffRequestViewModel result = leaveService.compOffLeave(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ApproveCompOff")
    public ResponseEntity<?> approveCompOff(@RequestBody ApproveLeaveViewModel model) {
        try {
            CompOffRequestViewModel result = leaveService.approveCompOff(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/WithDrawLeave")
    public ResponseEntity<?> withDrawLeave(@RequestBody EmpLeaveApplicationViewModel model) {
        try {
            EmpLeaveApplicationViewModel result = leaveService.draftLeave(model);
            result.setStatus("Withdrawn");
            result.setMsg("Leave withdrawn successfully");
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/CancelLeave")
    public ResponseEntity<?> cancelLeave(@RequestBody EmpLeaveApplicationViewModel model) {
        try {
            EmpLeaveApplicationViewModel result = leaveService.draftLeave(model);
            result.setStatus("Cancelled");
            result.setMsg("Leave cancelled successfully");
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ActivateLeaveType")
    public ResponseEntity<?> activateLeaveType(@RequestBody LeaveTypeViewModel model) {
        try {
            LeaveTypeViewModel result = leaveService.activateLeaveType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeactivateLeaveType")
    public ResponseEntity<?> deactivateLeaveType(@RequestBody LeaveTypeViewModel model) {
        try {
            LeaveTypeViewModel result = leaveService.deactivateLeaveType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/RejectCompOff")
    public ResponseEntity<?> rejectCompOff(@RequestBody ApproveLeaveViewModel model) {
        try {
            CompOffRequestViewModel result = leaveService.rejectCompOff(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DraftApplyLeave")
    public ResponseEntity<?> draftApplyLeave(@RequestBody EmpLeaveApplicationViewModel model) {
        try {
            EmpLeaveApplicationViewModel result = leaveService.draftApplyLeave(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDApproveManager")
    public ResponseEntity<?> ddApproveManager(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = leaveService.getDDApproveManager();
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/CompOffHours")
    public ResponseEntity<?> compOffHours(@RequestBody CompOffRequestViewModel model) {
        try {
            CompOffRequestViewModel result = leaveService.getCompOffHours(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllEmpCompOffLeave")
    public ResponseEntity<?> getAllEmpCompOffLeave(@RequestBody CompOffRequestViewModel model) {
        try {
            List<CompOffRequestViewModel> result = leaveService.getAllEmpCompOffLeave(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllCompOffLeave")
    public ResponseEntity<?> getAllCompOffLeave(@RequestBody CompOffRequestViewModel model) {
        try {
            List<CompOffRequestViewModel> result = leaveService.getAllCompOffLeave(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetLeaveType")
    public ResponseEntity<?> getLeaveType(@RequestBody LeaveTypeViewModel model) {
        try {
            LeaveTypeViewModel result = leaveService.getLeaveType(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteDraftLeave")
    public ResponseEntity<?> deleteDraftLeave(@RequestBody EmpLeaveApplicationViewModel model) {
        try {
            EmpLeaveApplicationViewModel result = leaveService.deleteDraftLeave(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllApplyManagerLeave")
    public ResponseEntity<?> getAllApplyManagerLeave(@RequestBody EmpLeaveApplicationViewModel model) {
        try {
            List<EmpLeaveApplicationViewModel> result = leaveService.getAllApplyManagerLeave(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/RejectLeaveByManager")
    public ResponseEntity<?> rejectLeaveByManager(@RequestBody ApproveLeaveViewModel model) {
        try {
            ApproveLeaveViewModel result = leaveService.rejectLeaveByManager(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllApplyHRLeave")
    public ResponseEntity<?> getAllApplyHRLeave(@RequestBody EmpLeaveApplicationViewModel model) {
        try {
            List<EmpLeaveApplicationViewModel> result = leaveService.getAllApplyHRLeave(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllHRLeave")
    public ResponseEntity<?> getAllHRLeave(@RequestBody EmpLeaveApplicationViewModel model) {
        try {
            List<EmpLeaveApplicationViewModel> result = leaveService.getAllHRLeave(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/IndividualLeaveCount")
    public ResponseEntity<?> individualLeaveCount(@RequestBody EmpLeaveApplicationViewModel model) {
        try {
            Map<String, Object> result = leaveService.getIndividualLeaveCount(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/LeaveBalReport")
    public ResponseEntity<?> leaveBalReport(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = leaveService.leaveBalReport(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/RejectLeaveByHR")
    public ResponseEntity<?> rejectLeaveByHR(@RequestBody ApproveLeaveViewModel model) {
        try {
            ApproveLeaveViewModel result = leaveService.rejectLeaveByHR(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UploadFileLeave")
    public ResponseEntity<?> uploadFileLeave(@RequestBody Map<String, Object> model) {
        return ResponseEntity.ok(Map.of("StatusCode", 200, "Message", "UploadFileLeave accepted"));
    }
}