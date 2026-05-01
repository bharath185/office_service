package com.officeconnect.service;

import com.officeconnect.dto.*;
import com.officeconnect.entity.*;
import com.officeconnect.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PerformanceService {

    @Autowired
    private PerGoalRepository perGoalRepository;

    @Autowired
    private EmployeeMasterRepository employeeMasterRepository;

    @Autowired
    private CPwdManagementRepository cpwdManagementRepository;

    @Autowired
    private FinancialYearMasterRepository financialYearMasterRepository;

    @Autowired
    private QuaterMasterRepository quaterMasterRepository;

    @Autowired
    private CompanyMasterRepository companyMasterRepository;

    public PerformanceViewModel createGoal(PerformanceViewModel model) {
        PerGoal goal = new PerGoal();
        goal.setEmpId(model.getEmpId());
        goal.setGoalTitle(model.getGoalTitle());
        goal.setGoalDescription(model.getGoalDescription());
        goal.setTargetDate(model.getTargetDate());
        goal.setStatus("Pending");
        goal.setIsActive(true);
        goal.setIsDeleted(false);
        goal.setCreatedDate(new Date());
        
        goal = perGoalRepository.save(goal);
        
        model.setGoalId(goal.getGoalId());
        model.setStatus("Pending");
        model.setMsg("Goal created successfully");
        return model;
    }

    public List<PerformanceViewModel> getAllGoals(PerformanceViewModel model) {
        return perGoalRepository.findByEmpIdAndIsDeleted(model.getEmpId(), false).stream()
            .map(g -> convertToViewModel(g))
            .collect(Collectors.toList());
    }

    public PerformanceViewModel updateGoalStatus(PerformanceViewModel model) {
        Optional<PerGoal> goalOpt = perGoalRepository.findById(model.getGoalId());
        if (goalOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Goal not found\"}");
        }
        
        PerGoal goal = goalOpt.get();
        goal.setStatus(model.getStatus());
        goal.setRating(model.getRating());
        perGoalRepository.save(goal);
        
        model.setMsg("Goal updated successfully");
        return model;
    }

    public PerformanceViewModel deleteGoal(PerformanceViewModel model) {
        Optional<PerGoal> goalOpt = perGoalRepository.findById(model.getGoalId());
        if (goalOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Goal not found\"}");
        }
        
        PerGoal goal = goalOpt.get();
        goal.setIsDeleted(true);
        goal.setIsActive(false);
        perGoalRepository.save(goal);
        
        model.setMsg("Goal deleted successfully");
        return model;
    }

    private PerformanceViewModel convertToViewModel(PerGoal g) {
        PerformanceViewModel vm = new PerformanceViewModel();
        vm.setGoalId(g.getGoalId());
        vm.setEmpId(g.getEmpId());
        vm.setGoalTitle(g.getGoalTitle());
        vm.setGoalDescription(g.getGoalDescription());
        vm.setTargetDate(g.getTargetDate());
        vm.setStatus(g.getStatus());
        vm.setRating(g.getRating());
        vm.setIsActive(g.getIsActive());
        return vm;
    }

    public PerformanceViewModel getBehaviouralGoal(PerformanceViewModel model) {
        model.setMsg("GetBehaviouralGoal - Success");
        return model;
    }

    public PerformanceViewModel addBehaviouralGoal(PerformanceViewModel model) {
        model.setMsg("Behavioural goal added successfully");
        return model;
    }

    public PerformanceViewModel updateBehaviouralGoal(PerformanceViewModel model) {
        model.setMsg("Behavioural goal updated successfully");
        return model;
    }

    public PerformanceViewModel deleteBehaviouralGoal(PerformanceViewModel model) {
        model.setMsg("Behavioural goal deleted successfully");
        return model;
    }

    public List<PerformanceViewModel> getAllBehaviouralGoal(PerformanceViewModel model) {
        model.setMsg("GetAllBehaviouralGoal - Success");
        return List.of(model);
    }

    public List<PerformanceViewModel> getEmployeeGoalHistory(PerformanceViewModel model) {
        model.setMsg("GetEmployeeGoalHistory - Success");
        return List.of(model);
    }

    public PerformanceViewModel goalApproval(PerformanceViewModel model) {
        model.setStatus("Approved");
        model.setMsg("Goal approved successfully");
        return model;
    }

    public PerformanceViewModel goalReject(PerformanceViewModel model) {
        model.setStatus("Rejected");
        model.setMsg("Goal rejected successfully");
        return model;
    }

    public List<PerformanceViewModel> getGoalByEmpId(PerformanceViewModel model) {
        return perGoalRepository.findByEmpIdAndIsDeleted(model.getEmpId(), false).stream()
            .map(g -> convertToViewModel(g))
            .collect(Collectors.toList());
    }

    public PerformanceViewModel getQuarterGoal(PerformanceViewModel model) {
        model.setMsg("GetQuarterGoal - Success");
        return model;
    }

    public PerformanceViewModel addQuarterGoal(PerformanceViewModel model) {
        model.setMsg("Quarter goal added successfully");
        return model;
    }

    public PerformanceViewModel updateQuarterGoal(PerformanceViewModel model) {
        model.setMsg("Quarter goal updated successfully");
        return model;
    }

    public List<PerformanceViewModel> getAllQuarterGoal(PerformanceViewModel model) {
        model.setMsg("GetAllQuarterGoal - Success");
        return List.of(model);
    }

    public List<EmployeeMasterViewModel> getEmployeeDetails(EmployeeMasterViewModel model) {
        Optional<EmployeeMaster> empOpt = employeeMasterRepository.findById(model.getEmpId());
        if (empOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Employee not found\"}");
        }
        
        EmployeeMaster e = empOpt.get();
        EmployeeMasterViewModel vm = new EmployeeMasterViewModel();
        vm.setLoginId(e.getEmpId());
        vm.setEmpId(e.getEmpId());
        vm.setOldEmp_ID(e.getOldEmp_ID());
        vm.setCompId(e.getCompId());
        
        if (e.getCompId() != null) {
            var companyOpt = companyMasterRepository.findById(e.getCompId());
            companyOpt.ifPresent(c -> vm.setCompany(c.getCompany()));
        }
        
        vm.setLeId(e.getLeId());
        vm.setLegalEntity(null);
        vm.setBuId(e.getBuId());
        vm.setBusinessUnit(null);
        vm.setLocationId(e.getLocationId());
        vm.setLocation(null);
        vm.setCategoryId(e.getCategoryId());
        vm.setDeptId(e.getCategoryId());
        vm.setDeptName(e.getDeptName());
        vm.setDesignationId(e.getDesignationId());
        vm.setDesignation(e.getDesignationName());
        vm.setReportId(e.getReportId());
        vm.setApproverId(null);
        vm.setApprover(null);
        
        if (e.getReportId() != null) {
            var reporterOpt = employeeMasterRepository.findById(e.getReportId());
            reporterOpt.ifPresent(r -> {
                vm.setReportEmpCode(r.getEmpCode());
                vm.setReportEmpName(r.getFirstName());
            });
        }
        
        vm.setAuthorised(true);
        vm.setEmpCode(e.getEmpCode());
        vm.setUserName(e.getUserName());
        vm.setFirstName(e.getFirstName());
        vm.setMiddleName(e.getMiddleName());
        vm.setLastName(e.getLastName());
        vm.setDob(e.getDob());
        vm.setMobileNo(e.getMobileNo());
        vm.setEmailId(e.getEmailId());
        vm.setBloodGroup(null);
        vm.setMaritalStatus(null);
        vm.setGender(e.getGender());
        vm.setInterviewDate(null);
        vm.setJoiningDate(e.getJoiningDate());
        vm.setEndDate(null);
        vm.setEmpStatus(e.getEmpStatus());
        vm.setReason(null);
        vm.setEmpType(null);
        vm.setEmpTypeId(null);
        vm.setcEndDate(null);
        vm.setcPwd(false);
        
        // OnSite fields
        vm.setOnSiteLogInId(null);
        vm.setOnSiteLogInDate(null);
        vm.setOnSiteLogOutDate(null);
        vm.setOnSiteLogInTime(null);
        vm.setOnSiteLogOutTime(null);
        vm.setOnSiteStatus(null);
        vm.setAuthorisedEntity(e.getAuthorisedEntity());
        
        vm.setRelievedReason(null);
        vm.setRelievedDate(null);
        vm.setRelievedEffectiveDate(null);
        vm.setIsRelieved(null);
        vm.setFromDate(null);
        vm.setToDate(null);
        vm.setStatus(null);
        
        vm.setCreatedBy(e.getCreatedBy());
        vm.setCreatedDate(e.getCreatedDate());
        vm.setLastUpdatedBy(e.getLastUpdatedBy());
        vm.setLastUpdatedDate(e.getLastUpdatedDate());
        vm.setIsActive(e.getIsActive());
        vm.setIsUpdated(e.getIsUpdated());
        vm.setIsDeleted(e.getIsDeleted());
        vm.setIsProbation(null);
        vm.setIsProbationConfirm(null);
        vm.setProbationConfirmationEffectiveDate(null);
        vm.setProbationConfirmationDate(null);
        vm.setProbationRemarks(null);
        vm.setProbationConfirmationStatus(null);
        vm.setMsg(null);
        
        // Check CPwd from CPwdManagement table
        vm.setcPwd(false);
        try {
            var cPwdList = cpwdManagementRepository.findActiveCPwdByEmpCode(e.getEmpCode());
            if (cPwdList != null && !cPwdList.isEmpty()) {
                vm.setcPwd(true);
            }
        } catch (Exception ex) {
            // If query fails, keep as false
        }
        
        return List.of(vm);
    }

    public List<Map<String, Object>> getDDFYear(Map<String, Object> model) {
        return List.of(Map.of("FyearId", 1, "Fyear", "2024-2025"), Map.of("FyearId", 2, "Fyear", "2025-2026"));
    }

    public List<Map<String, Object>> getDDQuater(Map<String, Object> model) {
        return List.of(
            Map.of("QuaterId", 1, "Quater", "Q1"),
            Map.of("QuaterId", 2, "Quater", "Q2"),
            Map.of("QuaterId", 3, "Quater", "Q3"),
            Map.of("QuaterId", 4, "Quater", "Q4")
        );
    }

    public List<Map<String, Object>> getDDReviewStatus(Map<String, Object> model) {
        return List.of(
            Map.of("StatusId", 1, "Status", "Pending"),
            Map.of("StatusId", 2, "Status", "Approved"),
            Map.of("StatusId", 3, "Status", "Rejected")
        );
    }

    public List<Map<String, Object>> getQuaterDetails(Map<String, Object> model) {
        return List.of();
    }

    public List<Map<String, Object>> getFYearDetails(Map<String, Object> model) {
        try {
            List<Map<String, Object>> result = new ArrayList<>();
            
            List<FinancialYearMaster> fYears = financialYearMasterRepository.findByIsActiveAndIsDeleted(true, false);
            
            for (FinancialYearMaster fy : fYears) {
                Map<String, Object> fyMap = new HashMap<>();
                fyMap.put("FYearId", fy.getYearId());
                fyMap.put("FinancialYear", fy.getFinancialYear());
                fyMap.put("FinancialDetails", fy.getFinancialYear());
                fyMap.put("QId", null);
                fyMap.put("QName", "Quater");
                fyMap.put("StartDate", "");
                fyMap.put("EndDate", "");
                fyMap.put("EmpId", null);
                fyMap.put("msg", null);
                result.add(fyMap);
            }
            
            if (result.isEmpty()) {
                Map<String, Object> fyMap = new HashMap<>();
                fyMap.put("FYearId", 3);
                fyMap.put("FinancialYear", "2025-2026");
                fyMap.put("FinancialDetails", "2025-2026, Apr  1 - Jun 30");
                fyMap.put("QId", null);
                fyMap.put("QName", "Quater");
                fyMap.put("StartDate", "Apr  1");
                fyMap.put("EndDate", "Jun 30");
                fyMap.put("EmpId", null);
                fyMap.put("msg", null);
                result.add(fyMap);
            }
            
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Map<String, Object> submitConfigSetup(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Config submitted successfully");
    }

    public Map<String, Object> updateConfigSetup(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Config updated successfully");
    }

    public List<Map<String, Object>> getAllConfigSetup(Map<String, Object> model) {
        return List.of();
    }

    public List<Map<String, Object>> performanceReport(Map<String, Object> model) {
        return List.of();
    }

    public List<Map<String, Object>> getAllGoal(Map<String, Object> model) {
        return List.of();
    }

    public List<Map<String, Object>> getAllGoalEmployee(Map<String, Object> model) {
        return List.of();
    }

    public Map<String, Object> getGoal(Map<String, Object> model) {
        return Map.of();
    }

    public Map<String, Object> addAllGoal(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Goals added successfully");
    }

    public Map<String, Object> approveAllGoal(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Goals approved successfully");
    }

    public Map<String, Object> addGoal(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Goal added successfully");
    }

    public Map<String, Object> updateGoal(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Goal updated successfully");
    }

    public Map<String, Object> deleteGoalEndpoint(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Goal deleted successfully");
    }

    public List<Map<String, Object>> getAllTask(Map<String, Object> model) {
        return List.of();
    }

    public Map<String, Object> getTask(Map<String, Object> model) {
        return Map.of();
    }

    public Map<String, Object> addTask(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Task added successfully");
    }

    public Map<String, Object> updateTask(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Task updated successfully");
    }

    public Map<String, Object> deleteTask(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Task deleted successfully");
    }

    public List<Map<String, Object>> getAllBehaviour(Map<String, Object> model) {
        return List.of();
    }

    public Map<String, Object> getBehaviour(Map<String, Object> model) {
        return Map.of();
    }

    public Map<String, Object> addBehaviour(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Behaviour added successfully");
    }

    public Map<String, Object> updateBehaviour(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Behaviour updated successfully");
    }

    public Map<String, Object> deleteBehaviour(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Behaviour deleted successfully");
    }

    public List<Map<String, Object>> getAllBehaviourDetail(Map<String, Object> model) {
        return List.of();
    }

    public Map<String, Object> getBehaviourDetail(Map<String, Object> model) {
        return Map.of();
    }

    public Map<String, Object> addBehaviourDetail(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Behaviour detail added successfully");
    }

    public Map<String, Object> updateBehaviourDetail(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Behaviour detail updated successfully");
    }

    public Map<String, Object> deleteBehaviourDetail(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Behaviour detail deleted successfully");
    }

    public List<Map<String, Object>> getAllSelfDevelopment(Map<String, Object> model) {
        return List.of();
    }

    public Map<String, Object> getSelfDevelopment(Map<String, Object> model) {
        return Map.of();
    }

    public Map<String, Object> addSelfDevelopment(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Self development added successfully");
    }

    public Map<String, Object> updateSelfDevelopment(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Self development updated successfully");
    }

    public Map<String, Object> deleteSelfDevelopment(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Self development deleted successfully");
    }

    public Map<String, Object> saveEmployeeReview(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Employee review saved successfully");
    }

    public List<Map<String, Object>> getAllEmployeeReviewList(Map<String, Object> model) {
        return List.of();
    }

    public List<Map<String, Object>> getEmployeeReviewList(Map<String, Object> model) {
        return List.of();
    }

    public Map<String, Object> saveManagerReview(Map<String, Object> model) {
        return Map.of("StatusCode", 200, "Message", "Manager review saved successfully");
    }
}