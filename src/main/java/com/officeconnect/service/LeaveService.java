package com.officeconnect.service;

import com.officeconnect.dto.*;
import com.officeconnect.entity.*;
import com.officeconnect.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LeaveService {

    @Autowired
    private LeaveTypeMasterRepository leaveTypeMasterRepository;

    @Autowired
    private EmpLeaveApplicationRepository empLeaveApplicationRepository;

    @Autowired
    private CompOffRequestRepository compOffRequestRepository;

    @Autowired
    private EmployeeMasterRepository employeeMasterRepository;

    @Autowired
    private LeaveCarryForwardMasterRepository leaveCarryForwardMasterRepository;

    public List<LeaveTypeViewModel> getAllLeaveType(LeaveTypeViewModel model) {
        return leaveTypeMasterRepository.findByIsActiveAndIsDeleted(true, false).stream()
            .map(lt -> {
                LeaveTypeViewModel vm = new LeaveTypeViewModel();
                vm.setLeaveTypeId(lt.getLeaveTypeId());
                vm.setLeaveType(lt.getLeaveType());
                vm.setDescription(lt.getDescription());
                vm.setLeaveCount(lt.getCredit() != null ? lt.getCredit() : 0);
                return vm;
            })
            .collect(Collectors.toList());
    }

    public List<LeaveTypeViewModel> getDDLeaveType(DDLeaveTypePayloadViewModel model) {
        return leaveTypeMasterRepository.findByIsActiveAndIsDeleted(true, false).stream()
            .map(lt -> {
                LeaveTypeViewModel vm = new LeaveTypeViewModel();
                vm.setLeaveTypeId(lt.getLeaveTypeId());
                vm.setLeaveType(lt.getLeaveType());
                return vm;
            })
            .collect(Collectors.toList());
    }

    public LeaveTypeViewModel addLeaveType(LeaveTypeViewModel model) {
        LeaveTypeMaster lt = new LeaveTypeMaster();
        lt.setLeaveType(model.getLeaveType());
        lt.setDescription(model.getDescription());
        lt.setCredit(model.getLeaveCount());
        lt.setMaxApply(model.getLeaveCount());
        lt.setIsPaid(true);
        lt.setIsActive(true);
        lt.setIsUpdated(false);
        lt.setIsDeleted(false);
        lt.setCreatedDate(new Date());
        
        lt = leaveTypeMasterRepository.save(lt);
        
        model.setLeaveTypeId(lt.getLeaveTypeId());
        model.setMsg("Leave type added successfully");
        return model;
    }

    public LeaveTypeViewModel updateLeaveType(LeaveTypeViewModel model) {
        Optional<LeaveTypeMaster> ltOpt = leaveTypeMasterRepository.findById(model.getLeaveTypeId());
        if (ltOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Leave type not found\"}");
        }
        
        LeaveTypeMaster lt = ltOpt.get();
        lt.setLeaveType(model.getLeaveType());
        lt.setDescription(model.getDescription());
        lt.setCredit(model.getLeaveCount());
        lt.setMaxApply(model.getLeaveCount());
        lt.setIsUpdated(true);
        lt.setLastUpdatedDate(new Date());
        
        leaveTypeMasterRepository.save(lt);
        
        model.setMsg("Leave type updated successfully");
        return model;
    }

    public LeaveTypeViewModel deleteLeaveType(LeaveTypeViewModel model) {
        Optional<LeaveTypeMaster> ltOpt = leaveTypeMasterRepository.findById(model.getLeaveTypeId());
        if (ltOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Leave type not found\"}");
        }
        
        LeaveTypeMaster lt = ltOpt.get();
        lt.setIsDeleted(true);
        lt.setIsActive(false);
        lt.setLastUpdatedDate(new Date());
        leaveTypeMasterRepository.save(lt);
        
        model.setMsg("Leave type deleted successfully");
        return model;
    }

    public EmpLeaveApplicationViewModel applyLeave(EmpLeaveApplicationViewModel model) {
        EmpLeaveApplication ela = new EmpLeaveApplication();
        ela.setEmpId(model.getEmpId());
        ela.setLeaveTypeId(model.getLeaveTypeId());
        ela.setFromDate(model.getFromDate());
        ela.setToDate(model.getToDate());
        ela.setNoOfDays(model.getNoOfDays());
        ela.setReason(model.getReason());
        ela.setStatus("Pending");
        ela.setIsActive(true);
        ela.setIsUpdated(false);
        ela.setIsDeleted(false);
        ela.setCreatedDate(new Date());
        
        ela = empLeaveApplicationRepository.save(ela);
        
        model.setEmpLeaveId(ela.getEmpLeaveId());
        model.setStatus("Pending");
        model.setMsg("Leave applied successfully");
        return model;
    }

    public EmpLeaveApplicationViewModel draftLeave(EmpLeaveApplicationViewModel model) {
        EmpLeaveApplication ela = new EmpLeaveApplication();
        ela.setEmpId(model.getEmpId());
        ela.setLeaveTypeId(model.getLeaveTypeId());
        ela.setFromDate(model.getFromDate());
        ela.setToDate(model.getToDate());
        ela.setNoOfDays(model.getNoOfDays());
        ela.setReason(model.getReason());
        ela.setStatus("Draft");
        ela.setIsActive(true);
        ela.setIsUpdated(false);
        ela.setIsDeleted(false);
        ela.setCreatedDate(new Date());
        
        ela = empLeaveApplicationRepository.save(ela);
        
        model.setEmpLeaveId(ela.getEmpLeaveId());
        model.setStatus("Draft");
        model.setMsg("Leave saved as draft");
        return model;
    }

    public List<EmpLeaveApplicationViewModel> getAllLeave(EmpLeaveApplicationViewModel model) {
        if (model.getLoginId() == null || model.getLoginId() == 0) {
            throw new RuntimeException("LoginId is Missing");
        }
        
        Integer empId = model.getEmpId();
        List<EmpLeaveApplication> leaveList;
        
        if (empId != null && empId != 0) {
            leaveList = empLeaveApplicationRepository.findByEmpId(empId);
        } else {
            leaveList = empLeaveApplicationRepository.findAll();
        }
        
        return leaveList.stream()
            .filter(ela -> (ela.getIsActive() != null && ela.getIsActive() && ela.getIsDeleted() != null && !ela.getIsDeleted()) ||
                        (ela.getIsActive() != null && !ela.getIsActive() && ela.getIsDeleted() != null && !ela.getIsDeleted()))
            .sorted((a, b) -> {
                Date dateA = a.getCreatedDate() != null ? a.getCreatedDate() : new Date(0);
                Date dateB = b.getCreatedDate() != null ? b.getCreatedDate() : new Date(0);
                return dateB.compareTo(dateA);
            })
            .map(ela -> convertToViewModel(ela))
            .collect(Collectors.toList());
    }

    public List<EmpLeaveApplicationViewModel> getAllEmpLeave(EmpLeaveApplicationViewModel model) {
        Integer empId = model.getEmpId();
        if (empId == null) {
            return empLeaveApplicationRepository.findByIsDeleted(false).stream()
                .map(ela -> convertToViewModel(ela))
                .collect(Collectors.toList());
        }
        return empLeaveApplicationRepository.findByEmpIdAndIsDeleted(empId, false).stream()
            .map(ela -> convertToViewModel(ela))
            .collect(Collectors.toList());
    }

    public List<EmpLeaveApplicationViewModel> getAllManagerLeave(EmpLeaveApplicationViewModel model) {
        try {
            Integer approvedBy = model.getApprovedBy();
            List<EmpLeaveApplication> apps;
            
            if (approvedBy == null || approvedBy == 0) {
                apps = empLeaveApplicationRepository.findByIsDeleted(false);
                apps = apps.stream().limit(100).collect(Collectors.toList());
            } else {
                apps = empLeaveApplicationRepository.findByApprovedByAndIsDeleted(approvedBy, false);
                apps = apps.stream().limit(100).collect(Collectors.toList());
            }
            
            return apps.stream()
                .map(ela -> convertToViewModel(ela))
                .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public ApproveLeaveViewModel approveLeaveByManager(ApproveLeaveViewModel model) {
        Optional<EmpLeaveApplication> elaOpt = empLeaveApplicationRepository.findById(model.getEmpLeaveId());
        if (elaOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Leave application not found\"}");
        }
        
        EmpLeaveApplication ela = elaOpt.get();
        ela.setStatus(model.getStatus());
        ela.setApprovedBy(model.getApprovedBy());
        ela.setApprovedDate(new Date());
        ela.setLastUpdatedDate(new Date());
        empLeaveApplicationRepository.save(ela);
        
        model.setMsg("Leave " + model.getStatus() + " successfully");
        return model;
    }

    public ApproveLeaveViewModel approveLeaveByHR(ApproveLeaveViewModel model) {
        return approveLeaveByManager(model);
    }

    public CompOffRequestViewModel compOffLeave(CompOffRequestViewModel model) {
        CompOffRequest cor = new CompOffRequest();
        cor.setEmpId(model.getEmpId());
        cor.setLeaveTypeId(model.getLeaveTypeId());
        cor.setFromDate(model.getFromDate());
        cor.setToDate(model.getToDate());
        cor.setNoOfDays(model.getNoOfDays());
        cor.setReason(model.getReason());
        cor.setStatus("Pending");
        cor.setIsActive(true);
        cor.setIsUpdated(false);
        cor.setIsDeleted(false);
        cor.setCreatedDate(new Date());
        
        cor = compOffRequestRepository.save(cor);
        
        model.setCompOffId(cor.getCompOffId());
        model.setStatus("Pending");
        model.setMsg("Comp off leave applied successfully");
        return model;
    }

    public CompOffRequestViewModel approveCompOff(ApproveLeaveViewModel model) {
        Optional<CompOffRequest> corOpt = compOffRequestRepository.findById(model.getEmpLeaveId());
        if (corOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Comp off request not found\"}");
        }
        
        CompOffRequest cor = corOpt.get();
        cor.setStatus(model.getStatus());
        cor.setApprovedBy(model.getApprovedBy());
        cor.setApprovedDate(new Date());
        cor.setLastUpdatedDate(new Date());
        compOffRequestRepository.save(cor);
        
        CompOffRequestViewModel result = new CompOffRequestViewModel();
        result.setMsg("Comp off " + model.getStatus());
        return result;
    }

    private EmpLeaveApplicationViewModel convertToViewModel(EmpLeaveApplication ela) {
        EmpLeaveApplicationViewModel vm = new EmpLeaveApplicationViewModel();
        vm.setLoginId(0);
        vm.setLeaveAppId(ela.getEmpLeaveId());
        vm.setEmpId(ela.getEmpId());
        vm.setEmpCode(ela.getEmpCode() != null ? ela.getEmpCode() : "");
        vm.setEmpName(ela.getEmpCode() != null ? ela.getEmpCode() : "");
        
        vm.setLeaveTypeId(ela.getLeaveTypeId());
        vm.setLeaveType(ela.getLeaveTypeId() != null ? "Leave Type " + ela.getLeaveTypeId() : "LOP");
        
        vm.setStartDate(ela.getFromDate());
        vm.setEndDate(ela.getToDate());
        vm.setDuration(ela.getNoOfDays() != null ? ela.getNoOfDays().doubleValue() : 0.0);
        vm.setReason(ela.getReason());
        vm.setStatus(ela.getStatus());
        vm.setAppliedDate(ela.getAppliedDate());
        
        vm.setApprovedBy(ela.getApprovedBy());
        vm.setApprovedDate(ela.getApprovedDate());
        vm.setCreatedby(ela.getCreatedBy());
        vm.setCreatedDate(ela.getCreatedDate());
        
        return vm;
    }

    public LeaveTypeViewModel activateLeaveType(LeaveTypeViewModel model) {
        Optional<LeaveTypeMaster> ltOpt = leaveTypeMasterRepository.findById(model.getLeaveTypeId());
        if (ltOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Leave type not found\"}");
        }
        LeaveTypeMaster lt = ltOpt.get();
        lt.setIsActive(true);
        lt.setLastUpdatedDate(new Date());
        leaveTypeMasterRepository.save(lt);
        model.setMsg("Leave type activated successfully");
        return model;
    }

    public LeaveTypeViewModel deactivateLeaveType(LeaveTypeViewModel model) {
        Optional<LeaveTypeMaster> ltOpt = leaveTypeMasterRepository.findById(model.getLeaveTypeId());
        if (ltOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Leave type not found\"}");
        }
        LeaveTypeMaster lt = ltOpt.get();
        lt.setIsActive(false);
        lt.setLastUpdatedDate(new Date());
        leaveTypeMasterRepository.save(lt);
        model.setMsg("Leave type deactivated successfully");
        return model;
    }

    public CompOffRequestViewModel rejectCompOff(ApproveLeaveViewModel model) {
        Optional<CompOffRequest> corOpt = compOffRequestRepository.findById(model.getEmpLeaveId());
        if (corOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Comp off request not found\"}");
        }
        CompOffRequest cor = corOpt.get();
        cor.setStatus("Rejected");
        cor.setApprovedBy(model.getApprovedBy());
        cor.setApprovedDate(new Date());
        cor.setLastUpdatedDate(new Date());
        compOffRequestRepository.save(cor);
        CompOffRequestViewModel result = new CompOffRequestViewModel();
        result.setMsg("Comp off rejected");
        return result;
    }

    public EmpLeaveApplicationViewModel draftApplyLeave(EmpLeaveApplicationViewModel model) {
        EmpLeaveApplication ela = new EmpLeaveApplication();
        ela.setEmpId(model.getEmpId());
        ela.setLeaveTypeId(model.getLeaveTypeId());
        ela.setFromDate(model.getFromDate());
        ela.setToDate(model.getToDate());
        ela.setNoOfDays(model.getNoOfDays());
        ela.setReason(model.getReason());
        ela.setStatus("Draft");
        ela.setIsActive(true);
        ela.setIsUpdated(false);
        ela.setIsDeleted(false);
        ela.setCreatedDate(new Date());
        ela = empLeaveApplicationRepository.save(ela);
        model.setEmpLeaveId(ela.getEmpLeaveId());
        model.setStatus("Draft");
        model.setMsg("Leave saved as draft");
        return model;
    }

    public List<Map<String, Object>> getDDApproveManager() {
        List<Map<String, Object>> result = new ArrayList<>();
        for (EmployeeMaster emp : employeeMasterRepository.findByIsActiveAndIsDeleted(true, false)) {
            if (emp.getReportId() == null || emp.getReportId() == 0) {
                Map<String, Object> m = new HashMap<>();
                m.put("id", emp.getEmpId());
                m.put("name", emp.getFirstName() + " " + emp.getLastName());
                result.add(m);
            }
        }
        return result;
    }

    public CompOffRequestViewModel getCompOffHours(CompOffRequestViewModel model) {
        model.setNoOfDays(0);
        model.setMsg("Comp off hours retrieved");
        return model;
    }

    public List<CompOffRequestViewModel> getAllEmpCompOffLeave(CompOffRequestViewModel model) {
        return compOffRequestRepository.findAll().stream()
            .filter(c -> c.getIsDeleted() == null || !c.getIsDeleted())
            .map(this::convertCompOffToViewModel)
            .collect(Collectors.toList());
    }

    public List<CompOffRequestViewModel> getAllCompOffLeave(CompOffRequestViewModel model) {
        return getAllEmpCompOffLeave(model);
    }

    private CompOffRequestViewModel convertCompOffToViewModel(CompOffRequest cor) {
        CompOffRequestViewModel vm = new CompOffRequestViewModel();
        vm.setCompOffId(cor.getCompOffId());
        vm.setEmpId(cor.getEmpId());
        vm.setLeaveTypeId(cor.getLeaveTypeId());
        vm.setFromDate(cor.getFromDate());
        vm.setToDate(cor.getToDate());
        vm.setNoOfDays(cor.getNoOfDays());
        vm.setReason(cor.getReason());
        vm.setStatus(cor.getStatus());
        return vm;
    }

    public LeaveTypeViewModel getLeaveType(LeaveTypeViewModel model) {
        Optional<LeaveTypeMaster> ltOpt = leaveTypeMasterRepository.findById(model.getLeaveTypeId());
        if (ltOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Leave type not found\"}");
        }
        LeaveTypeMaster lt = ltOpt.get();
        LeaveTypeViewModel vm = new LeaveTypeViewModel();
        vm.setLeaveTypeId(lt.getLeaveTypeId());
        vm.setLeaveType(lt.getLeaveType());
        vm.setDescription(lt.getDescription());
        vm.setLeaveCount(lt.getCredit() != null ? lt.getCredit() : 0);
        return vm;
    }

    public EmpLeaveApplicationViewModel deleteDraftLeave(EmpLeaveApplicationViewModel model) {
        Optional<EmpLeaveApplication> elaOpt = empLeaveApplicationRepository.findById(model.getEmpLeaveId());
        if (elaOpt.isEmpty()) {
            model.setMsg("Draft leave not found");
            return model;
        }
        EmpLeaveApplication ela = elaOpt.get();
        ela.setIsDeleted(true);
        ela.setIsActive(false);
        empLeaveApplicationRepository.save(ela);
        model.setStatus("Deleted");
        model.setMsg("Draft leave deleted");
        return model;
    }

    public List<EmpLeaveApplicationViewModel> getAllApplyManagerLeave(EmpLeaveApplicationViewModel model) {
        return empLeaveApplicationRepository.findAll().stream()
            .filter(e -> e.getIsDeleted() == null || !e.getIsDeleted())
            .filter(e -> "Applied".equals(e.getStatus()))
            .map(this::convertToViewModel)
            .collect(Collectors.toList());
    }

    public ApproveLeaveViewModel rejectLeaveByManager(ApproveLeaveViewModel model) {
        model.setStatus("Rejected");
        model.setMsg("Leave rejected by manager");
        return model;
    }

    public List<EmpLeaveApplicationViewModel> getAllApplyHRLeave(EmpLeaveApplicationViewModel model) {
        return empLeaveApplicationRepository.findAll().stream()
            .filter(e -> e.getIsDeleted() == null || !e.getIsDeleted())
            .filter(e -> "Approved".equals(e.getStatus()) || "Applied".equals(e.getStatus()))
            .map(this::convertToViewModel)
            .collect(Collectors.toList());
    }

    public List<EmpLeaveApplicationViewModel> getAllHRLeave(EmpLeaveApplicationViewModel model) {
        return empLeaveApplicationRepository.findAll().stream()
            .filter(e -> e.getIsDeleted() == null || !e.getIsDeleted())
            .map(this::convertToViewModel)
            .collect(Collectors.toList());
    }

    public Map<String, Object> getIndividualLeaveCount(EmpLeaveApplicationViewModel model) {
        Map<String, Object> leaveCount = new java.util.LinkedHashMap<>();
        
        Integer empId = model.getEmpId();
        String empCode = "";
        
        if (empId != null) {
            Optional<EmployeeMaster> empOpt = employeeMasterRepository.findById(empId);
            if (empOpt.isPresent()) {
                empCode = empOpt.get().getEmpCode() != null ? empOpt.get().getEmpCode() : "";
            }
        }
        
        leaveCount.put("EmpId", empId);
        
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        
        List<Map<String, Object>> casualCounts = getLeaveCountsByType(empId, empCode, "CL", currentYear, currentMonth, 1);
        leaveCount.put("CasualCounts", casualCounts);
        
        List<Map<String, Object>> reservedHolidayCounts = getLeaveCountsByType(empId, empCode, "RH", currentYear, 0, 7);
        leaveCount.put("ReservedHolidayCounts", reservedHolidayCounts);
        
        List<Map<String, Object>> earnedLeaveCounts = getLeaveCountsByType(empId, empCode, "EL", currentYear, 0, 2);
        leaveCount.put("EarnedLeaveCounts", earnedLeaveCounts);
        
        List<Map<String, Object>> compOffCounts = getLeaveCountsByType(empId, empCode, "COMP OFF", currentYear, currentMonth, 3);
        leaveCount.put("CompOffCounts", compOffCounts);
        
        leaveCount.put("MLCounts", new ArrayList<>());
        leaveCount.put("PLCounts", null);
        
        return leaveCount;
    }
    
    private List<Map<String, Object>> getLeaveCountsByType(Integer empId, String empCode, String shortName, Integer year, Integer month, Integer defaultLeaveTypeId) {
        List<Map<String, Object>> counts = new ArrayList<>();
        
        LeaveTypeMaster lt = leaveTypeMasterRepository.findByShortNameAndIsActiveAndIsDeleted(shortName, true, false);
        Integer leaveTypeId = defaultLeaveTypeId;
        if (lt != null) {
            leaveTypeId = lt.getLeaveTypeId();
        }
        
        LeaveCarryForwardMaster cf = null;
        if (empId != null && leaveTypeId != null) {
            cf = leaveCarryForwardMasterRepository.findByEmpIdAndLeaveTypeIdAndLeaveYearAndLeaveMonth(empId, leaveTypeId, year, month);
        }
        
        Map<String, Object> data = new java.util.LinkedHashMap<>();
        data.put("CFId", cf != null ? cf.getCfId() : 0);
        data.put("EmpId", empId != null ? empId : 0);
        data.put("EmpCode", empCode != null ? empCode : "");
        data.put("LeaveTypeId", leaveTypeId);
        data.put("LeaveType", shortName);
        data.put("LeaveYear", year);
        data.put("LeaveMonth", month);
        
        if (cf != null) {
            data.put("OpeningBalance", cf.getOpeningBalance() != null ? cf.getOpeningBalance().intValue() : 0);
            data.put("Availed", cf.getAvailed() != null ? cf.getAvailed().intValue() : 0);
            data.put("ClosingBalance", cf.getClosingBalance() != null ? cf.getClosingBalance().intValue() : 0);
        } else {
            data.put("OpeningBalance", 0);
            data.put("Availed", 0);
            data.put("ClosingBalance", 0);
        }
        
        counts.add(data);
        return counts;
    }

    public List<Map<String, Object>> leaveBalReport(Map<String, Object> model) {
        List<Map<String, Object>> result = new ArrayList<>();
        result.add(Map.of("EmpId", model.get("EmpId"), "LeaveType", "CL", "Balance", 10, "StatusCode", 200));
        return result;
    }

    public ApproveLeaveViewModel rejectLeaveByHR(ApproveLeaveViewModel model) {
        model.setStatus("Rejected");
        model.setMsg("Leave rejected by HR");
        return model;
    }
}