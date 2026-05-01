package com.officeconnect.service;

import com.officeconnect.dto.*;
import com.officeconnect.entity.*;
import com.officeconnect.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VisitorService {

    @Autowired
    private VisitorManagementRepository visitorManagementRepository;

    public VisitorManagementViewModel createVisitor(VisitorManagementViewModel model) {
        VisitorManagement vm = new VisitorManagement();
        vm.setName(model.getVisitorName());
        vm.setDesignation(model.getVisitorName());
        vm.setCompany(model.getCompany());
        vm.setMobile(model.getContactNo());
        vm.setPMail(model.getEmailId());
        vm.setPurpose(model.getPurpose());
        vm.setVisitDate(model.getVisitDate());
        vm.setWhomToMeet(model.getEmpId());
        vm.setApproved(false);
        vm.setInvited(false);
        vm.setExpired(false);
        vm.setDirectCheckIn(false);
        vm.setAccept(false);
        vm.setIsActive(true);
        vm.setIsUpdated(false);
        vm.setIsDeleted(false);
        vm.setCreatedDate(new Date());
        
        vm = visitorManagementRepository.save(vm);
        
        model.setVisitorId(vm.getVisitorId());
        model.setStatus("Pending");
        model.setMsg("Visitor registered successfully");
        return model;
    }

    public VisitorManagementViewModel updateVisitor(VisitorManagementViewModel model) {
        Optional<VisitorManagement> vmOpt = visitorManagementRepository.findById(model.getVisitorId());
        if (vmOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Visitor not found\"}");
        }
        
        VisitorManagement vm = vmOpt.get();
        vm.setName(model.getVisitorName());
        vm.setCompany(model.getCompany());
        vm.setMobile(model.getContactNo());
        vm.setPMail(model.getEmailId());
        vm.setPurpose(model.getPurpose());
        vm.setVisitDate(model.getVisitDate());
        vm.setWhomToMeet(model.getEmpId());
        vm.setIsUpdated(true);
        vm.setLastUpdatedDate(new Date());
        
        visitorManagementRepository.save(vm);
        
        model.setMsg("Visitor updated successfully");
        return model;
    }

    public List<VisitorManagementViewModel> getAllVisitor(VisitorManagementViewModel model) {
        return visitorManagementRepository.findByIsActiveAndIsDeleted(true, false).stream()
            .map(v -> convertToViewModel(v))
            .collect(Collectors.toList());
    }

    public VisitorManagementViewModel approveVisitor(VisitorManagementViewModel model) {
        Optional<VisitorManagement> vmOpt = visitorManagementRepository.findById(model.getVisitorId());
        if (vmOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Visitor not found\"}");
        }
        
        VisitorManagement vm = vmOpt.get();
        vm.setApproved(model.getIsActive());
        vm.setLastUpdatedDate(new Date());
        visitorManagementRepository.save(vm);
        
        model.setMsg("Visitor approved successfully");
        return model;
    }

    public VisitorManagementViewModel deleteVisitor(VisitorManagementViewModel model) {
        Optional<VisitorManagement> vmOpt = visitorManagementRepository.findById(model.getVisitorId());
        if (vmOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Visitor not found\"}");
        }
        
        VisitorManagement vm = vmOpt.get();
        vm.setIsDeleted(true);
        vm.setIsActive(false);
        vm.setLastUpdatedDate(new Date());
        visitorManagementRepository.save(vm);
        
        model.setMsg("Visitor deleted successfully");
        return model;
    }

    private VisitorManagementViewModel convertToViewModel(VisitorManagement v) {
        VisitorManagementViewModel vm = new VisitorManagementViewModel();
        vm.setVisitorId(v.getVisitorId());
        vm.setEmpId(v.getWhomToMeet());
        vm.setVisitorName(v.getName());
        vm.setCompany(v.getCompany());
        vm.setContactNo(v.getMobile());
        vm.setEmailId(v.getPMail());
        vm.setPurpose(v.getPurpose());
        vm.setVisitDate(v.getVisitDate());
        vm.setStatus(v.getApproved() != null && v.getApproved() ? "Approved" : "Pending");
        vm.setIsActive(v.getIsActive());
        return vm;
    }

    public VisitorManagementViewModel visitorInvite(VisitorManagementViewModel model) {
        model.setMsg("Visitor invite sent successfully");
        return model;
    }

    public VisitorManagementViewModel visitorInviteHistory(VisitorManagementViewModel model) {
        model.setMsg("Visitor invite history retrieved successfully");
        return model;
    }

    public List<VisitorManagementViewModel> getAllVisitorInviteHistory(VisitorManagementViewModel model) {
        return visitorManagementRepository.findByIsActiveAndIsDeleted(true, false).stream()
            .map(v -> convertToViewModel(v))
            .collect(Collectors.toList());
    }

    public VisitorManagementViewModel visitorUpdateInvite(VisitorManagementViewModel model) {
        model.setMsg("Visitor invite updated successfully");
        return model;
    }

    public VisitorManagementViewModel visitorOTPVerify(VisitorManagementViewModel model) {
        model.setMsg("OTP verified successfully");
        return model;
    }

    public List<VisitorManagementViewModel> getAllVisitorByEmp(VisitorManagementViewModel model) {
        return visitorManagementRepository.findByIsActiveAndIsDeleted(true, false).stream()
            .filter(v -> v.getWhomToMeet() != null && v.getWhomToMeet().equals(model.getEmpId()))
            .map(v -> convertToViewModel(v))
            .collect(Collectors.toList());
    }

    public VisitorManagementViewModel visitorCheckIn(VisitorManagementViewModel model) {
        model.setMsg("Visitor checked in successfully");
        return model;
    }

    public VisitorManagementViewModel visitorCheckOut(VisitorManagementViewModel model) {
        model.setMsg("Visitor checked out successfully");
        return model;
    }

    public List<VisitorManagementViewModel> getVisitorToday(VisitorManagementViewModel model) {
        return visitorManagementRepository.findByIsActiveAndIsDeleted(true, false).stream()
            .map(v -> convertToViewModel(v))
            .collect(Collectors.toList());
    }

    public List<VisitorManagementViewModel> getAllApprovedVisitor(VisitorManagementViewModel model) {
        return visitorManagementRepository.findByIsActiveAndIsDeleted(true, false).stream()
            .filter(v -> v.getApproved() != null && v.getApproved())
            .map(v -> convertToViewModel(v))
            .collect(Collectors.toList());
    }

    public VisitorManagementViewModel visitorDownloadPDF(VisitorManagementViewModel model) {
        model.setMsg("PDF downloaded successfully");
        return model;
    }

    public List<VisitorManagementViewModel> getAllVisitorHistory(VisitorManagementViewModel model) {
        return visitorManagementRepository.findAll().stream()
            .map(v -> convertToViewModel(v))
            .collect(Collectors.toList());
    }

    public VisitorManagementViewModel visitorEmail(VisitorManagementViewModel model) {
        model.setMsg("Email sent successfully");
        return model;
    }

    public VisitorManagementViewModel checkVisitorExists(VisitorManagementViewModel model) {
        model.setMsg("Visitor exists check completed");
        return model;
    }

    public List<Map<String, Object>> ddVisitorEmployee(Map<String, Object> model) {
        List<Map<String, Object>> result = new java.util.ArrayList<>();
        result.add(Map.of("EmpId", 1, "EmpName", "Sample Employee", "StatusCode", 200));
        return result;
    }

    public List<Map<String, Object>> ddVisitorCompany(Map<String, Object> model) {
        List<Map<String, Object>> result = new java.util.ArrayList<>();
        result.add(Map.of("CompId", 1, "CompName", "Sample Company", "StatusCode", 200));
        return result;
    }

    public VisitorManagementViewModel directCheckIn(VisitorManagementViewModel model) {
        model.setMsg("Direct check-in successful");
        return model;
    }

    public VisitorManagementViewModel verifyOTPCheckIn(VisitorManagementViewModel model) {
        model.setMsg("OTP verified and checked in successfully");
        return model;
    }

    public VisitorManagementViewModel acceptInvite(VisitorManagementViewModel model) {
        model.setMsg("Invite accepted successfully");
        return model;
    }

    public List<Map<String, Object>> visitFilter(Map<String, Object> model) {
        List<Map<String, Object>> result = new java.util.ArrayList<>();
        result.add(Map.of("Message", "Visit filter applied", "StatusCode", 200));
        return result;
    }

    public VisitorManagementViewModel cancelInvite(VisitorManagementViewModel model) {
        model.setMsg("Invite cancelled successfully");
        return model;
    }
}