package com.officeconnect.controller;

import com.officeconnect.dto.*;
import com.officeconnect.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Shift")
public class ShiftController {

    @Autowired
    private ShiftService shiftService;

    @PostMapping("/GetAllShift")
    public ResponseEntity<?> getAllShift(@RequestBody ShiftMasterViewModel model) {
        try {
            List<ShiftMasterViewModel> result = shiftService.getAllShift(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddShift")
    public ResponseEntity<?> addShift(@RequestBody ShiftMasterViewModel model) {
        try {
            ShiftMasterViewModel result = shiftService.addShift(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateShift")
    public ResponseEntity<?> updateShift(@RequestBody ShiftMasterViewModel model) {
        try {
            ShiftMasterViewModel result = shiftService.updateShift(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteShift")
    public ResponseEntity<?> deleteShift(@RequestBody ShiftMasterViewModel model) {
        try {
            ShiftMasterViewModel result = shiftService.deleteShift(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetShift")
    public ResponseEntity<?> getShift(@RequestBody ShiftMasterViewModel model) {
        try {
            List<ShiftMasterViewModel> result = shiftService.getShift(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllShiftGrouping")
    public ResponseEntity<?> getAllShiftGrouping(@RequestBody ShiftGroupingMasterViewModel model) {
        try {
            List<ShiftGroupingMasterViewModel> result = shiftService.getAllShiftGrouping(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddShiftGrouping")
    public ResponseEntity<?> addShiftGrouping(@RequestBody ShiftGroupingMasterViewModel model) {
        try {
            ShiftGroupingMasterViewModel result = shiftService.addShiftGrouping(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDShift")
    public ResponseEntity<?> ddShift(@RequestBody ShiftGroupingMasterViewModel model) {
        try {
            List<ShiftMasterViewModel> result = shiftService.ddShift(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/CreateShift")
    public ResponseEntity<?> createShift(@RequestBody ShiftMasterViewModel model) {
        try {
            List<ShiftMasterViewModel> result = shiftService.createShift(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetShiftByEmployee")
    public ResponseEntity<?> getShiftByEmployee(@RequestBody ShiftMasterViewModel model) {
        try {
            List<ShiftMasterViewModel> result = shiftService.getShiftByEmployee(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AssignShift")
    public ResponseEntity<?> assignShift(@RequestBody ShiftMasterViewModel model) {
        try {
            ShiftMasterViewModel result = shiftService.assignShift(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddShiftEmployee")
    public ResponseEntity<?> addShiftEmployee(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = shiftService.addShiftEmployee(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllShiftEmployee")
    public ResponseEntity<?> getAllShiftEmployee(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = shiftService.getAllShiftEmployee(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/RemoveShiftEmployee")
    public ResponseEntity<?> removeShiftEmployee(@RequestBody Map<String, Object> model) {
        try {
            Map<String, Object> result = shiftService.removeShiftEmployee(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/LocationShiftGrouping")
    public ResponseEntity<?> locationShiftGrouping(@RequestBody Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = shiftService.locationShiftGrouping(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }
}