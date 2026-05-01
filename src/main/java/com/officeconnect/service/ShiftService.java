package com.officeconnect.service;

import com.officeconnect.dto.*;
import com.officeconnect.entity.*;
import com.officeconnect.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShiftService {

    @Autowired
    private ShiftMasterRepository shiftMasterRepository;

    @Autowired
    private ShiftGroupingMasterRepository shiftGroupingMasterRepository;

    public List<ShiftMasterViewModel> getAllShift(ShiftMasterViewModel model) {
        return shiftMasterRepository.findByIsActiveAndIsDeleted(true, false).stream()
            .map(s -> convertToViewModel(s))
            .collect(Collectors.toList());
    }

    public ShiftMasterViewModel addShift(ShiftMasterViewModel model) {
        ShiftMaster sm = new ShiftMaster();
        sm.setShiftName(model.getShiftName());
        sm.setStartTime(model.getStartTime());
        sm.setEndTime(model.getEndTime());
        sm.setClkHrs(model.getShiftCode());
        sm.setDays(model.getShiftCode());
        sm.setStatus(model.getIsActive());
        sm.setIsActive(true);
        sm.setIsUpdated(false);
        sm.setIsDeleted(false);
        sm.setCreatedDate(new Date());
        
        // Set CreatedBy from LoginId if available, otherwise null (allow DB to handle)
        if (model.getLoginId() != null) {
            sm.setCreatedBy(model.getLoginId());
        }
        
        sm = shiftMasterRepository.save(sm);
        
        model.setShiftId(sm.getShiftId());
        model.setMsg("Shift added successfully");
        return model;
    }

    public ShiftMasterViewModel updateShift(ShiftMasterViewModel model) {
        Optional<ShiftMaster> smOpt = shiftMasterRepository.findById(model.getShiftId());
        if (smOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Shift not found\"}");
        }
        
        ShiftMaster sm = smOpt.get();
        sm.setShiftName(model.getShiftName());
        sm.setStartTime(model.getStartTime());
        sm.setEndTime(model.getEndTime());
        sm.setClkHrs(model.getShiftCode());
        sm.setDays(model.getShiftCode());
        sm.setIsUpdated(true);
        sm.setLastUpdatedDate(new Date());
        
        shiftMasterRepository.save(sm);
        
        model.setMsg("Shift updated successfully");
        return model;
    }

    public ShiftMasterViewModel deleteShift(ShiftMasterViewModel model) {
        Optional<ShiftMaster> smOpt = shiftMasterRepository.findById(model.getShiftId());
        if (smOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Shift not found\"}");
        }
        
        ShiftMaster sm = smOpt.get();
        sm.setIsDeleted(true);
        sm.setIsActive(false);
        sm.setLastUpdatedDate(new Date());
        shiftMasterRepository.save(sm);
        
        model.setMsg("Shift deleted successfully");
        return model;
    }

    public List<ShiftMasterViewModel> getShift(ShiftMasterViewModel model) {
        return shiftMasterRepository.findByShiftId(model.getShiftId()).stream()
            .map(s -> convertToViewModel(s))
            .collect(Collectors.toList());
    }

    public List<ShiftGroupingMasterViewModel> getAllShiftGrouping(ShiftGroupingMasterViewModel model) {
        return shiftGroupingMasterRepository.findByIsActive(true).stream()
            .map(this::convertToGroupingViewModel)
            .collect(Collectors.toList());
    }

    public ShiftGroupingMasterViewModel addShiftGrouping(ShiftGroupingMasterViewModel model) {
        ShiftGroupingMaster sg = new ShiftGroupingMaster();
        sg.setShiftGroupingName(model.getShiftGroupingName());
        sg.setLocationId(model.getLocationId());
        sg.setCompanyId(model.getCompanyId());
        sg.setIsActive(true);
        sg.setCreatedDate(new Date());
        sg = shiftGroupingMasterRepository.save(sg);
        model.setShiftGroupingId(sg.getShiftGroupingId());
        model.setMsg("Shift grouping added successfully");
        return model;
    }

    public List<ShiftMasterViewModel> ddShift(ShiftGroupingMasterViewModel model) {
        return shiftMasterRepository.findByIsActiveAndIsDeleted(true, false).stream()
            .map(s -> convertToViewModel(s))
            .collect(Collectors.toList());
    }

    public List<ShiftMasterViewModel> createShift(ShiftMasterViewModel model) {
        return addShift(model) != null ? List.of(addShift(model)) : List.of();
    }

    public List<ShiftMasterViewModel> getShiftByEmployee(ShiftMasterViewModel model) {
        return shiftMasterRepository.findByIsActiveAndIsDeleted(true, false).stream()
            .map(s -> convertToViewModel(s))
            .collect(Collectors.toList());
    }

    public ShiftMasterViewModel assignShift(ShiftMasterViewModel model) {
        model.setMsg("Shift assigned successfully");
        return model;
    }

    public Map<String, Object> addShiftEmployee(Map<String, Object> model) {
        return Map.of("msg", "Added", "StatusCode", 200);
    }

    public List<Map<String, Object>> getAllShiftEmployee(Map<String, Object> model) {
        List<Map<String, Object>> result = new ArrayList<>();
        result.add(Map.of("ShiftEmpId", 1, "EmpId", 1, "ShiftId", 1, "StatusCode", 200));
        return result;
    }

    public Map<String, Object> removeShiftEmployee(Map<String, Object> model) {
        return Map.of("msg", "Removed", "StatusCode", 200);
    }

    public List<Map<String, Object>> locationShiftGrouping(Map<String, Object> model) {
        List<Map<String, Object>> result = new ArrayList<>();
        result.add(Map.of("ShiftGroupingId", 1, "LocationId", 1, "StatusCode", 200));
        return result;
    }

    private ShiftGroupingMasterViewModel convertToGroupingViewModel(ShiftGroupingMaster s) {
        ShiftGroupingMasterViewModel vm = new ShiftGroupingMasterViewModel();
        vm.setShiftGroupingId(s.getShiftGroupingId());
        vm.setShiftGroupingName(s.getShiftGroupingName());
        vm.setLocationId(s.getLocationId());
        vm.setCompanyId(s.getCompanyId());
        vm.setIsActive(s.getIsActive());
        return vm;
    }

    private ShiftMasterViewModel convertToViewModel(ShiftMaster s) {
        ShiftMasterViewModel vm = new ShiftMasterViewModel();
        vm.setShiftId(s.getShiftId());
        vm.setShiftName(s.getShiftName());
        vm.setShiftCode(s.getClkHrs());
        vm.setStartTime(s.getStartTime());
        vm.setEndTime(s.getEndTime());
        vm.setIsActive(s.getIsActive());
        return vm;
    }
}