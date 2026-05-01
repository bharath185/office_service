package com.officeconnect.service;

import com.officeconnect.dto.*;
import com.officeconnect.entity.*;
import com.officeconnect.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PayrollService {

    @Autowired
    private PayrollComponentRepository payrollComponentRepository;

    @Autowired
    private PayrollPayoutTypeRepository payrollPayoutTypeRepository;

    @Autowired
    private PayrollSegmentRepository payrollSegmentRepository;

    @Autowired
    private PayrollFrequencyMasterRepository payrollFrequencyMasterRepository;

    @Autowired
    private PayrollComponentLogicRepository payrollComponentLogicRepository;

    @Autowired
    private PayslipSectionRepository payslipSectionRepository;

    @Autowired
    private PayslipSectionComponentsRepository payslipSectionComponentsRepository;

    @Autowired
    private EmployeeSalaryDetailsRepository employeeSalaryDetailsRepository;

    @Autowired
    private EmployeeMasterRepository employeeMasterRepository;

    @Autowired
    private LocationMasterRepository locationMasterRepository;

    @Autowired
    private LegalEntityMasterRepository legalEntityMasterRepository;

    @Autowired
    private PayoutMappingMasterRepository payoutMappingMasterRepository;

    @Autowired
    private CompanyMasterRepository companyMasterRepository;

    private String formatDate(Date d) {
        if (d == null) return null;
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(d);
    }

    private Date parseDate(String s) {
        if (s == null) return null;
        try {
            if (s.contains("T")) return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(s);
            return new SimpleDateFormat("yyyy-MM-dd").parse(s);
        } catch (Exception e) { return new Date(); }
    }

    private Integer parseSafeInt(Object value) {
        if (value == null) return 0;
        if (value instanceof Integer) return (Integer) value;
        if (value instanceof String) {
            try { return Integer.valueOf((String) value); } catch (NumberFormatException e) { return 0; }
        }
        if (value instanceof Number) return ((Number) value).intValue();
        return 0;
    }

    // ===== Payout Type =====

    public List<DDPayrollPayoutTypeViewModel> ddPayrollPayoutType(PayrollPayoutTypeViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        List<PayrollPayoutType> details = payrollPayoutTypeRepository.findAll().stream()
            .filter(p -> Boolean.TRUE.equals(p.getIsActive()) && Boolean.FALSE.equals(p.getIsDeleted()))
            .sorted((a, b) -> Integer.compare(b.getPayoutTypeId(), a.getPayoutTypeId()))
            .collect(Collectors.toList());

        if (details.isEmpty()) throw new RuntimeException("Payout Type Details Not Found");

        return details.stream().map(p -> {
            DDPayrollPayoutTypeViewModel vm = new DDPayrollPayoutTypeViewModel();
            vm.setPayoutTypeId(p.getPayoutTypeId());
            vm.setPayoutTypeName(p.getPayoutTypeName());
            vm.setFrequency(p.getFrequency());
            return vm;
        }).collect(Collectors.toList());
    }

    public List<PayrollPayoutTypeViewModel> getAllPayrollPayoutType(PayrollPayoutTypeViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        List<PayrollPayoutType> details = payrollPayoutTypeRepository.findAll().stream()
            .filter(p -> Boolean.FALSE.equals(p.getIsDeleted()))
            .sorted((a, b) -> Integer.compare(b.getPayoutTypeId(), a.getPayoutTypeId()))
            .collect(Collectors.toList());

        if (details.isEmpty()) throw new RuntimeException("Payout Type Details Not Found");

        return details.stream().map(p -> {
            PayrollPayoutTypeViewModel vm = new PayrollPayoutTypeViewModel();
            vm.setPayoutTypeId(p.getPayoutTypeId());
            vm.setPayoutTypeName(p.getPayoutTypeName());
            vm.setFrequency(p.getFrequency());
            vm.setCreatedBy(p.getCreatedBy());
            vm.setCreatedDate(formatDate(p.getCreatedDate()));
            vm.setLastUpdatedBy(p.getLastUpdatedBy());
            vm.setLastUpdatedDate(formatDate(p.getLastUpdatedDate()));
            vm.setIsActive(p.getIsActive());
            vm.setIsUpdated(p.getIsUpdated());
            vm.setIsDeleted(p.getIsDeleted());
            return vm;
        }).collect(Collectors.toList());
    }

    public PayrollPayoutTypeViewModel getPayrollPayoutType(PayrollPayoutTypeViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        PayrollPayoutType p = payrollPayoutTypeRepository.findById(model.getPayoutTypeId()).orElse(null);
        if (p == null || Boolean.TRUE.equals(p.getIsDeleted())) throw new RuntimeException("Payout Type Details Not Found");

        PayrollPayoutTypeViewModel vm = new PayrollPayoutTypeViewModel();
        vm.setPayoutTypeId(p.getPayoutTypeId());
        vm.setPayoutTypeName(p.getPayoutTypeName());
        vm.setFrequency(p.getFrequency());
        vm.setCreatedBy(p.getCreatedBy());
        vm.setCreatedDate(formatDate(p.getCreatedDate()));
        vm.setLastUpdatedBy(p.getLastUpdatedBy());
        vm.setLastUpdatedDate(formatDate(p.getLastUpdatedDate()));
        vm.setIsActive(p.getIsActive());
        vm.setIsUpdated(p.getIsUpdated());
        vm.setIsDeleted(p.getIsDeleted());
        return vm;
    }

    public PayrollResponseViewModel addPayrollPayoutType(PayrollPayoutTypeViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Mismatching");

        boolean exists = payrollPayoutTypeRepository.findAll().stream()
            .anyMatch(p -> p.getPayoutTypeName() != null && p.getPayoutTypeName().equals(model.getPayoutTypeName())
                && Boolean.TRUE.equals(p.getIsActive()) && Boolean.FALSE.equals(p.getIsDeleted()));
        if (exists) throw new RuntimeException("Payout Type Details Already Exists");

        PayrollPayoutType p = new PayrollPayoutType();
        p.setPayoutTypeName(model.getPayoutTypeName());
        p.setFrequency(model.getFrequency());
        p.setIsActive(true);
        p.setIsUpdated(false);
        p.setIsDeleted(false);
        p.setCreatedBy(loginId);
        p.setCreatedDate(new Date());
        p.setLastUpdatedBy(loginId);
        p.setLastUpdatedDate(new Date());
        payrollPayoutTypeRepository.save(p);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Added");
        return vm;
    }

    public PayrollResponseViewModel updatePayrollPayoutType(PayrollPayoutTypeViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        Integer id = (model.getPayoutTypeId() != null && model.getPayoutTypeId() != 0) ? model.getPayoutTypeId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Mismatching");
        if (id == 0) throw new RuntimeException("Payout Type Id is Mismatching");

        PayrollPayoutType p = payrollPayoutTypeRepository.findById(id).orElse(null);
        if (p == null || !Boolean.TRUE.equals(p.getIsActive()) || Boolean.TRUE.equals(p.getIsDeleted()))
            throw new RuntimeException("Payout Type Details Not Found");

        p.setPayoutTypeName(model.getPayoutTypeName());
        p.setFrequency(model.getFrequency());
        p.setIsActive(true);
        p.setIsUpdated(true);
        p.setIsDeleted(false);
        p.setLastUpdatedBy(loginId);
        p.setLastUpdatedDate(new Date());
        payrollPayoutTypeRepository.save(p);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Updated");
        return vm;
    }

    public PayrollResponseViewModel deletePayrollPayoutType(PayrollPayoutTypeViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        Integer id = (model.getPayoutTypeId() != null && model.getPayoutTypeId() != 0) ? model.getPayoutTypeId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        PayrollPayoutType p = payrollPayoutTypeRepository.findById(id).orElse(null);
        if (p == null || !Boolean.TRUE.equals(p.getIsActive()) || Boolean.TRUE.equals(p.getIsDeleted()))
            throw new RuntimeException("Payout Type Details Not Found");

        p.setIsActive(true);
        p.setIsUpdated(true);
        p.setIsDeleted(true);
        p.setLastUpdatedBy(loginId);
        p.setLastUpdatedDate(new Date());
        payrollPayoutTypeRepository.save(p);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Deleted");
        return vm;
    }

    // ===== Segment =====

    public List<DDPayrollSegmentViewModel> ddPayrollSegment(PayrollSegmentViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        Integer payoutTypeId = (model.getPayoutTypeId() != null && model.getPayoutTypeId() != 0) ? model.getPayoutTypeId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        List<PayrollSegment> details = payrollSegmentRepository.findAll().stream()
            .filter(s -> {
                boolean active = Boolean.TRUE.equals(s.getIsActive()) && Boolean.FALSE.equals(s.getIsDeleted());
                if (payoutTypeId == 0) return active;
                return active && s.getPayoutTypeId() != null && s.getPayoutTypeId().equals(payoutTypeId);
            })
            .sorted((a, b) -> Integer.compare(b.getSegmentId(), a.getSegmentId()))
            .collect(Collectors.toList());

        if (details.isEmpty()) throw new RuntimeException("Segment Details Not Found");

        return details.stream().map(s -> {
            DDPayrollSegmentViewModel vm = new DDPayrollSegmentViewModel();
            vm.setSegmentId(s.getSegmentId());
            vm.setSegmentName(s.getSegmentName());
            return vm;
        }).collect(Collectors.toList());
    }

    public List<PayrollSegmentViewModel> getAllPayrollSegment(PayrollSegmentViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        List<PayrollSegment> details = payrollSegmentRepository.findAll().stream()
            .filter(s -> Boolean.TRUE.equals(s.getIsActive()) && Boolean.FALSE.equals(s.getIsDeleted()))
            .sorted((a, b) -> Integer.compare(b.getSegmentId(), a.getSegmentId()))
            .collect(Collectors.toList());

        if (details.isEmpty()) throw new RuntimeException("Segment Details Not Found");

        return details.stream().map(s -> {
            PayrollSegmentViewModel vm = new PayrollSegmentViewModel();
            vm.setPayoutTypeId(s.getPayoutTypeId());
            vm.setSegmentId(s.getSegmentId());
            vm.setSegmentName(s.getSegmentName());
            vm.setCreatedBy(s.getCreatedBy());
            vm.setCreatedDate(formatDate(s.getCreatedDate()));
            vm.setLastUpdatedBy(s.getLastUpdatedBy());
            vm.setLastUpdatedDate(formatDate(s.getLastUpdatedDate()));
            vm.setIsActive(s.getIsActive());
            vm.setIsUpdated(s.getIsUpdated());
            vm.setIsDeleted(s.getIsDeleted());
            if (s.getPayoutTypeId() != null) {
                PayrollPayoutType pt = payrollPayoutTypeRepository.findById(s.getPayoutTypeId()).orElse(null);
                vm.setPayoutTypeName(pt != null ? pt.getPayoutTypeName() : "");
            }
            return vm;
        }).collect(Collectors.toList());
    }

    public PayrollSegmentViewModel getPayrollSegment(PayrollSegmentViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        PayrollSegment s = payrollSegmentRepository.findById(model.getSegmentId()).orElse(null);
        if (s == null || !Boolean.TRUE.equals(s.getIsActive()) || Boolean.TRUE.equals(s.getIsDeleted()))
            throw new RuntimeException("Segment Details Not Found");

        PayrollSegmentViewModel vm = new PayrollSegmentViewModel();
        vm.setPayoutTypeId(s.getPayoutTypeId());
        vm.setSegmentId(s.getSegmentId());
        vm.setSegmentName(s.getSegmentName());
        vm.setCreatedBy(s.getCreatedBy());
        vm.setCreatedDate(formatDate(s.getCreatedDate()));
        vm.setLastUpdatedBy(s.getLastUpdatedBy());
        vm.setLastUpdatedDate(formatDate(s.getLastUpdatedDate()));
        vm.setIsActive(s.getIsActive());
        vm.setIsUpdated(s.getIsUpdated());
        vm.setIsDeleted(s.getIsDeleted());
        if (s.getPayoutTypeId() != null) {
            PayrollPayoutType pt = payrollPayoutTypeRepository.findById(s.getPayoutTypeId()).orElse(null);
            vm.setPayoutTypeName(pt != null ? pt.getPayoutTypeName() : "");
        }
        return vm;
    }

    public PayrollResponseViewModel addPayrollSegment(PayrollSegmentViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Mismatching");

        boolean exists = payrollSegmentRepository.findAll().stream()
            .anyMatch(s -> s.getPayoutTypeId() != null && s.getPayoutTypeId().equals(model.getPayoutTypeId())
                && s.getSegmentName() != null && s.getSegmentName().equals(model.getSegmentName())
                && Boolean.TRUE.equals(s.getIsActive()) && Boolean.FALSE.equals(s.getIsDeleted()));
        if (exists) throw new RuntimeException("Segment Details Already Exists");

        PayrollSegment s = new PayrollSegment();
        s.setSegmentName(model.getSegmentName());
        s.setPayoutTypeId(model.getPayoutTypeId());
        s.setIsActive(true);
        s.setIsUpdated(false);
        s.setIsDeleted(false);
        s.setCreatedBy(loginId);
        s.setCreatedDate(new Date());
        s.setLastUpdatedBy(loginId);
        s.setLastUpdatedDate(new Date());
        payrollSegmentRepository.save(s);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Added");
        return vm;
    }

    public PayrollResponseViewModel updatePayrollSegment(PayrollSegmentViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        Integer id = (model.getSegmentId() != null && model.getSegmentId() != 0) ? model.getSegmentId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Mismatching");
        if (id == 0) throw new RuntimeException("Segment Id is Mismatching");

        PayrollSegment s = payrollSegmentRepository.findById(id).orElse(null);
        if (s == null || !Boolean.TRUE.equals(s.getIsActive()) || Boolean.TRUE.equals(s.getIsDeleted()))
            throw new RuntimeException("Segment Details Not Found");

        s.setSegmentName(model.getSegmentName());
        s.setPayoutTypeId(model.getPayoutTypeId());
        s.setIsActive(true);
        s.setIsUpdated(true);
        s.setIsDeleted(false);
        s.setLastUpdatedBy(loginId);
        s.setLastUpdatedDate(new Date());
        payrollSegmentRepository.save(s);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Updated");
        return vm;
    }

    public PayrollResponseViewModel deletePayrollSegment(PayrollSegmentViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        Integer id = (model.getSegmentId() != null && model.getSegmentId() != 0) ? model.getSegmentId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        PayrollSegment s = payrollSegmentRepository.findById(id).orElse(null);
        if (s == null || !Boolean.TRUE.equals(s.getIsActive()) || Boolean.TRUE.equals(s.getIsDeleted()))
            throw new RuntimeException("Segment Details Not Found");

        s.setIsActive(true);
        s.setIsUpdated(true);
        s.setIsDeleted(true);
        s.setLastUpdatedBy(loginId);
        s.setLastUpdatedDate(new Date());
        payrollSegmentRepository.save(s);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Deleted");
        return vm;
    }

    // ===== Component =====

    public PayrollComponentViewModel addComponent(PayrollComponentViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Mismatching");

        boolean exists = payrollComponentRepository.findAll().stream()
            .anyMatch(c -> c.getComponentName() != null && c.getComponentName().equals(model.getComponentName())
                && Boolean.TRUE.equals(c.getIsActive()) && Boolean.FALSE.equals(c.getIsDeleted()));
        if (exists) throw new RuntimeException("Component Details Already Exists");

        PayrollComponent c = new PayrollComponent();
        c.setComponentName(model.getComponentName());
        c.setComponentCode(model.getComponentCode());
        c.setPayoutTypeId(model.getPayoutTypeId());
        c.setSegmentId(model.getSegmentId());
        c.setIsActive(true);
        c.setIsDeleted(false);
        c.setCreatedBy(loginId);
        c.setCreatedDate(new Date());
        payrollComponentRepository.save(c);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Added");
        return model;
    }

    public PayrollComponentViewModel updateComponent(PayrollComponentViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        Integer id = (model.getComponentId() != null && model.getComponentId() != 0) ? model.getComponentId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Mismatching");

        PayrollComponent c = payrollComponentRepository.findById(id).orElse(null);
        if (c == null || !Boolean.TRUE.equals(c.getIsActive()) || Boolean.TRUE.equals(c.getIsDeleted()))
            throw new RuntimeException("Component Details Not Found");

        c.setComponentName(model.getComponentName());
        c.setComponentCode(model.getComponentCode());
        c.setPayoutTypeId(model.getPayoutTypeId());
        c.setSegmentId(model.getSegmentId());
        payrollComponentRepository.save(c);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Updated");
        return model;
    }

    public PayrollComponentViewModel deleteComponent(PayrollComponentViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        Integer id = (model.getComponentId() != null && model.getComponentId() != 0) ? model.getComponentId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        PayrollComponent c = payrollComponentRepository.findById(id).orElse(null);
        if (c == null || !Boolean.TRUE.equals(c.getIsActive()) || Boolean.TRUE.equals(c.getIsDeleted()))
            throw new RuntimeException("Component Details Not Found");

        c.setIsActive(false);
        c.setIsDeleted(true);
        payrollComponentRepository.save(c);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Deleted");
        return model;
    }

    public List<PayrollComponentViewModel> getAllComponents(PayrollComponentViewModel model) {
        return payrollComponentRepository.findAll().stream()
            .filter(c -> Boolean.TRUE.equals(c.getIsActive()) && Boolean.FALSE.equals(c.getIsDeleted()))
            .map(c -> {
                PayrollComponentViewModel vm = new PayrollComponentViewModel();
                vm.setComponentId(c.getComponentId());
                vm.setComponentName(c.getComponentName());
                vm.setComponentCode(c.getComponentCode());
                vm.setPayoutTypeId(c.getPayoutTypeId());
                vm.setSegmentId(c.getSegmentId());
                vm.setIsActive(c.getIsActive());
                return vm;
            }).collect(Collectors.toList());
    }

    public List<DDPayrollComponentViewModel> ddPayrollComponent(PayrollComponentViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        List<PayrollComponent> details = payrollComponentRepository.findAll().stream()
            .filter(c -> Boolean.TRUE.equals(c.getIsActive()) && Boolean.FALSE.equals(c.getIsDeleted()))
            .collect(Collectors.toList());

        if (details.isEmpty()) throw new RuntimeException("Component Details Not Found");

        return details.stream().map(c -> {
            DDPayrollComponentViewModel vm = new DDPayrollComponentViewModel();
            vm.setComponentId(c.getComponentId());
            vm.setComponentName(c.getComponentName());
            return vm;
        }).collect(Collectors.toList());
    }

    public List<PayrollALLComponentViewModel> getAllComponentDetails(PayrollALLComponentViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        List<PayrollComponent> components = payrollComponentRepository.findAll().stream()
            .filter(c -> Boolean.TRUE.equals(c.getIsActive()) && Boolean.FALSE.equals(c.getIsDeleted()))
            .collect(Collectors.toList());

        if (components.isEmpty()) throw new RuntimeException("Component Details Not Found");

        return components.stream().map(c -> {
            PayrollALLComponentViewModel vm = new PayrollALLComponentViewModel();
            vm.setComponentId(c.getComponentId());
            vm.setComponentName(c.getComponentName());
            vm.setComponentCode(c.getComponentCode());
            vm.setPayoutTypeId(c.getPayoutTypeId());
            vm.setSegmentId(c.getSegmentId());
            if (c.getPayoutTypeId() != null) {
                PayrollPayoutType pt = payrollPayoutTypeRepository.findById(c.getPayoutTypeId()).orElse(null);
                vm.setPayoutTypeName(pt != null ? pt.getPayoutTypeName() : "");
            }
            if (c.getSegmentId() != null) {
                PayrollSegment seg = payrollSegmentRepository.findById(c.getSegmentId()).orElse(null);
                vm.setSegmentName(seg != null ? seg.getSegmentName() : "");
            }
            List<PayrollComponentLogic> logics = payrollComponentLogicRepository.findByComponentIdAndIsActiveTrueAndIsDeletedFalseOrderBySno(c.getComponentId());
            List<PayrollALLComponentLogicConditionViewModel> lstLC = logics.stream().map(l -> {
                PayrollALLComponentLogicConditionViewModel lvm = new PayrollALLComponentLogicConditionViewModel();
                lvm.setComponentId(l.getComponentId());
                lvm.setLogicId(l.getLogicId());
                lvm.setEffectiveFrom(formatDate(l.getCreatedDate()));
                return lvm;
            }).collect(Collectors.toList());
            vm.setLstofLC(lstLC);
            return vm;
        }).collect(Collectors.toList());
    }

    // ===== Payslip Section =====

    public List<DDPayslipSectionViewModel> ddPayslipSection(PayslipSectionViewModel model) {
        Integer loginId = (model != null && model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        List<PayslipSection> details = payslipSectionRepository.findAll().stream()
            .filter(s -> Boolean.TRUE.equals(s.getIsActive()) && Boolean.FALSE.equals(s.getIsDeleted()))
            .collect(Collectors.toList());

        if (details.isEmpty()) throw new RuntimeException("Section Details Not Found");

        return details.stream().map(s -> {
            DDPayslipSectionViewModel vm = new DDPayslipSectionViewModel();
            vm.setSectionId(s.getSectionId());
            vm.setSectionName(s.getSectionName());
            return vm;
        }).collect(Collectors.toList());
    }

    public List<PayslipSectionViewModel> getAllPayslipSection(PayslipSectionViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        List<PayslipSection> details = payslipSectionRepository.findAll().stream()
            .filter(s -> Boolean.FALSE.equals(s.getIsDeleted()))
            .collect(Collectors.toList());

        if (details.isEmpty()) throw new RuntimeException("Section Details Not Found");

        return details.stream().map(s -> {
            PayslipSectionViewModel vm = new PayslipSectionViewModel();
            vm.setSectionId(s.getSectionId());
            vm.setSectionName(s.getSectionName());
            vm.setSequenceNo(s.getSequenceNo());
            vm.setCreatedBy(s.getCreatedBy());
            vm.setCreatedDate(formatDate(s.getCreatedDate()));
            vm.setLastUpdatedBy(s.getLastUpdatedBy());
            vm.setLastUpdatedDate(formatDate(s.getLastUpdatedDate()));
            vm.setIsActive(s.getIsActive());
            vm.setIsUpdated(s.getIsUpdated());
            vm.setIsDeleted(s.getIsDeleted());
            return vm;
        }).collect(Collectors.toList());
    }

    public PayslipSectionViewModel getPayslipSection(PayslipSectionViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        PayslipSection s = payslipSectionRepository.findById(model.getSectionId()).orElse(null);
        if (s == null || Boolean.TRUE.equals(s.getIsDeleted())) throw new RuntimeException("Section Details Not Found");

        PayslipSectionViewModel vm = new PayslipSectionViewModel();
        vm.setSectionId(s.getSectionId());
        vm.setSectionName(s.getSectionName());
        vm.setSequenceNo(s.getSequenceNo());
        vm.setCreatedBy(s.getCreatedBy());
        vm.setCreatedDate(formatDate(s.getCreatedDate()));
        vm.setLastUpdatedBy(s.getLastUpdatedBy());
        vm.setLastUpdatedDate(formatDate(s.getLastUpdatedDate()));
        vm.setIsActive(s.getIsActive());
        vm.setIsUpdated(s.getIsUpdated());
        vm.setIsDeleted(s.getIsDeleted());
        return vm;
    }

    public PayrollResponseViewModel addPayslipSection(PayslipSectionViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Mismatching");

        PayslipSection s = new PayslipSection();
        s.setSectionName(model.getSectionName());
        s.setSequenceNo(model.getSequenceNo());
        s.setIsActive(true);
        s.setIsUpdated(false);
        s.setIsDeleted(false);
        s.setCreatedBy(loginId);
        s.setCreatedDate(new Date());
        s.setLastUpdatedBy(loginId);
        s.setLastUpdatedDate(new Date());
        payslipSectionRepository.save(s);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Added");
        return vm;
    }

    public PayrollResponseViewModel updatePayslipSection(PayslipSectionViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        Integer id = (model.getSectionId() != null && model.getSectionId() != 0) ? model.getSectionId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Mismatching");
        if (id == 0) throw new RuntimeException("Section Id is Mismatching");

        PayslipSection s = payslipSectionRepository.findById(id).orElse(null);
        if (s == null || Boolean.TRUE.equals(s.getIsDeleted())) throw new RuntimeException("Section Details Not Found");

        s.setSectionName(model.getSectionName());
        s.setSequenceNo(model.getSequenceNo());
        s.setIsUpdated(true);
        s.setLastUpdatedBy(loginId);
        s.setLastUpdatedDate(new Date());
        payslipSectionRepository.save(s);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Updated");
        return vm;
    }

    public PayrollResponseViewModel deletePayslipSection(PayslipSectionViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        Integer id = (model.getSectionId() != null && model.getSectionId() != 0) ? model.getSectionId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        PayslipSection s = payslipSectionRepository.findById(id).orElse(null);
        if (s == null || Boolean.TRUE.equals(s.getIsDeleted())) throw new RuntimeException("Section Details Not Found");

        s.setIsUpdated(true);
        s.setIsDeleted(true);
        s.setLastUpdatedBy(loginId);
        s.setLastUpdatedDate(new Date());
        payslipSectionRepository.save(s);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Deleted");
        return vm;
    }

    // ===== Payslip Section Components =====

    public List<PayslipSectionComponentViewModel> getAllPayslipSectionComponent(PayslipSectionComponentViewModel model) {
        Integer loginId = (model != null && model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        List<PayslipSectionComponents> details = payslipSectionComponentsRepository.findAll().stream()
            .filter(s -> Boolean.TRUE.equals(s.getIsActive()) && Boolean.FALSE.equals(s.getIsDeleted()))
            .collect(Collectors.toList());

        if (details.isEmpty()) throw new RuntimeException("Section Component Details Not Found");

        return details.stream().map(s -> {
            PayslipSectionComponentViewModel vm = new PayslipSectionComponentViewModel();
            vm.setSectionComponentId(s.getSectionComponentId());
            vm.setPayoutTypeId(s.getPayoutTypeId());
            vm.setSectionId(s.getSectionId());
            vm.setComponentId(s.getComponentId());
            vm.setSequenceNo(s.getSequenceNo());
            vm.setEffectiveFrom(formatDate(s.getEffectiveFrom()));
            vm.setEffectiveTo(formatDate(s.getEffectiveTo()));
            vm.setRecordStatus(s.getRecordStatus());
            vm.setCreatedBy(s.getCreatedBy());
            vm.setCreatedDate(formatDate(s.getCreatedDate()));
            vm.setLastUpdatedBy(s.getLastUpdatedBy());
            vm.setLastUpdatedDate(formatDate(s.getLastUpdatedDate()));
            vm.setIsActive(s.getIsActive());
            vm.setIsUpdated(s.getIsUpdated());
            vm.setIsDeleted(s.getIsDeleted());
            if (s.getPayoutTypeId() != null) {
                PayrollPayoutType pt = payrollPayoutTypeRepository.findById(s.getPayoutTypeId()).orElse(null);
                vm.setPayoutTypeName(pt != null ? pt.getPayoutTypeName() : "");
            }
            if (s.getSectionId() != null) {
                PayslipSection sec = payslipSectionRepository.findById(s.getSectionId()).orElse(null);
                vm.setSectionName(sec != null ? sec.getSectionName() : "");
            }
            if (s.getComponentId() != null) {
                PayrollComponent comp = payrollComponentRepository.findById(s.getComponentId()).orElse(null);
                vm.setComponentName(comp != null ? comp.getComponentName() : "");
                vm.setComponentCode(comp != null ? comp.getComponentCode() : "");
            }
            return vm;
        }).collect(Collectors.toList());
    }

    public PayslipSectionComponentViewModel getPayslipSectionComponent(PayslipSectionComponentViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        PayslipSectionComponents s = payslipSectionComponentsRepository.findById(model.getSectionComponentId()).orElse(null);
        if (s == null || Boolean.TRUE.equals(s.getIsDeleted())) throw new RuntimeException("Section Component Details Not Found");

        PayslipSectionComponentViewModel vm = new PayslipSectionComponentViewModel();
        vm.setSectionComponentId(s.getSectionComponentId());
        vm.setPayoutTypeId(s.getPayoutTypeId());
        vm.setSectionId(s.getSectionId());
        vm.setComponentId(s.getComponentId());
        vm.setSequenceNo(s.getSequenceNo());
        vm.setEffectiveFrom(formatDate(s.getEffectiveFrom()));
        vm.setEffectiveTo(formatDate(s.getEffectiveTo()));
        vm.setRecordStatus(s.getRecordStatus());
        vm.setCreatedBy(s.getCreatedBy());
        vm.setCreatedDate(formatDate(s.getCreatedDate()));
        vm.setLastUpdatedBy(s.getLastUpdatedBy());
        vm.setLastUpdatedDate(formatDate(s.getLastUpdatedDate()));
        vm.setIsActive(s.getIsActive());
        vm.setIsUpdated(s.getIsUpdated());
        vm.setIsDeleted(s.getIsDeleted());
        if (s.getPayoutTypeId() != null) {
            PayrollPayoutType pt = payrollPayoutTypeRepository.findById(s.getPayoutTypeId()).orElse(null);
            vm.setPayoutTypeName(pt != null ? pt.getPayoutTypeName() : "");
        }
        if (s.getSectionId() != null) {
            PayslipSection sec = payslipSectionRepository.findById(s.getSectionId()).orElse(null);
            vm.setSectionName(sec != null ? sec.getSectionName() : "");
        }
        if (s.getComponentId() != null) {
            PayrollComponent comp = payrollComponentRepository.findById(s.getComponentId()).orElse(null);
            vm.setComponentName(comp != null ? comp.getComponentName() : "");
            vm.setComponentCode(comp != null ? comp.getComponentCode() : "");
        }
        return vm;
    }

    public PayrollResponseViewModel addPayslipSectionComponent(PayslipSectionComponentViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Mismatching");

        PayslipSectionComponents s = new PayslipSectionComponents();
        s.setPayoutTypeId(model.getPayoutTypeId());
        s.setSectionId(model.getSectionId());
        s.setComponentId(model.getComponentId());
        s.setSequenceNo(model.getSequenceNo());
        s.setEffectiveFrom(parseDate(model.getEffectiveFrom()));
        s.setEffectiveTo(parseDate(model.getEffectiveTo()));
        s.setRecordStatus(model.getRecordStatus());
        s.setIsActive(true);
        s.setIsUpdated(false);
        s.setIsDeleted(false);
        s.setCreatedBy(loginId);
        s.setCreatedDate(new Date());
        s.setLastUpdatedBy(loginId);
        s.setLastUpdatedDate(new Date());
        payslipSectionComponentsRepository.save(s);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Added");
        return vm;
    }

    public PayrollResponseViewModel updatePayslipSectionComponent(PayslipSectionComponentViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        Integer id = (model.getSectionComponentId() != null && model.getSectionComponentId() != 0) ? model.getSectionComponentId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Mismatching");
        if (id == 0) throw new RuntimeException("Section Component Id is Mismatching");

        PayslipSectionComponents s = payslipSectionComponentsRepository.findById(id).orElse(null);
        if (s == null || Boolean.TRUE.equals(s.getIsDeleted())) throw new RuntimeException("Section Component Details Not Found");

        s.setPayoutTypeId(model.getPayoutTypeId());
        s.setSectionId(model.getSectionId());
        s.setComponentId(model.getComponentId());
        s.setSequenceNo(model.getSequenceNo());
        s.setEffectiveFrom(parseDate(model.getEffectiveFrom()));
        s.setEffectiveTo(parseDate(model.getEffectiveTo()));
        s.setRecordStatus(model.getRecordStatus());
        s.setIsUpdated(true);
        s.setLastUpdatedBy(loginId);
        s.setLastUpdatedDate(new Date());
        payslipSectionComponentsRepository.save(s);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Updated");
        return vm;
    }

    public PayrollResponseViewModel deletePayslipSectionComponent(PayslipSectionComponentViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        Integer id = (model.getSectionComponentId() != null && model.getSectionComponentId() != 0) ? model.getSectionComponentId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        PayslipSectionComponents s = payslipSectionComponentsRepository.findById(id).orElse(null);
        if (s == null || Boolean.TRUE.equals(s.getIsDeleted())) throw new RuntimeException("Section Component Details Not Found");

        s.setIsUpdated(true);
        s.setIsDeleted(true);
        s.setLastUpdatedBy(loginId);
        s.setLastUpdatedDate(new Date());
        payslipSectionComponentsRepository.save(s);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Deleted");
        return vm;
    }

    // ===== Employee Salary Details =====

    public List<EmployeeSalaryDetailsViewModel> getAllEmployeeSalaryDetails(EmployeeSalaryDetailsViewModel model) {
        Integer loginId = (model != null && model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        List<EmployeeSalaryDetails> details = employeeSalaryDetailsRepository.findAll().stream()
            .filter(s -> Boolean.TRUE.equals(s.getIsActive()) && Boolean.FALSE.equals(s.getIsDeleted()))
            .collect(Collectors.toList());

        if (details.isEmpty()) return new ArrayList<>();

        return details.stream().map(s -> mapSalaryDetail(s)).collect(Collectors.toList());
    }

    public EmployeeSalaryDetailsViewModel getEmployeeSalaryDetails(EmployeeSalaryDetailsViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        EmployeeSalaryDetails s = employeeSalaryDetailsRepository.findById(model.getSalaryId()).orElse(null);
        if (s == null || Boolean.TRUE.equals(s.getIsDeleted())) throw new RuntimeException("Salary Details Not Found");

        return mapSalaryDetail(s);
    }

    public PayrollResponseViewModel addEmployeeSalaryDetails(EmployeeSalaryDetailsViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Mismatching");

        EmployeeSalaryDetails s = new EmployeeSalaryDetails();
        s.setEmpId(model.getEmpId());
        s.setEmpCode(model.getEmpCode());
        s.setCtc(model.getCtc());
        s.setMCTC(model.getMctc());
        s.setEffectiveFromDate(parseDate(model.getEffectiveFromDate()));
        s.setEffectiveToDate(parseDate(model.getEffectiveToDate()));
        s.setIsAppraised(model.getIsAppraised());
        s.setRecordStatus(model.getRecordStatus());
        s.setIsActive(true);
        s.setIsUpdated(false);
        s.setIsDeleted(false);
        s.setCreatedBy(loginId);
        s.setCreatedDate(new Date());
        s.setLastUpdatedBy(loginId);
        s.setLastUpdatedDate(new Date());
        employeeSalaryDetailsRepository.save(s);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Added");
        return vm;
    }

    public PayrollResponseViewModel updateEmployeeSalaryDetails(EmployeeSalaryDetailsViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        Integer id = (model.getSalaryId() != null && model.getSalaryId() != 0) ? model.getSalaryId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Mismatching");
        if (id == 0) throw new RuntimeException("Salary Id is Mismatching");

        EmployeeSalaryDetails s = employeeSalaryDetailsRepository.findById(id).orElse(null);
        if (s == null || Boolean.TRUE.equals(s.getIsDeleted())) throw new RuntimeException("Salary Details Not Found");

        s.setEmpId(model.getEmpId());
        s.setEmpCode(model.getEmpCode());
        s.setCtc(model.getCtc());
        s.setMCTC(model.getMctc());
        s.setEffectiveFromDate(parseDate(model.getEffectiveFromDate()));
        s.setEffectiveToDate(parseDate(model.getEffectiveToDate()));
        s.setIsAppraised(model.getIsAppraised());
        s.setRecordStatus(model.getRecordStatus());
        s.setIsUpdated(true);
        s.setLastUpdatedBy(loginId);
        s.setLastUpdatedDate(new Date());
        employeeSalaryDetailsRepository.save(s);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Updated");
        return vm;
    }

    public PayrollResponseViewModel deleteEmployeeSalaryDetails(EmployeeSalaryDetailsViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        Integer id = (model.getSalaryId() != null && model.getSalaryId() != 0) ? model.getSalaryId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        EmployeeSalaryDetails s = employeeSalaryDetailsRepository.findById(id).orElse(null);
        if (s == null || Boolean.TRUE.equals(s.getIsDeleted())) throw new RuntimeException("Salary Details Not Found");

        s.setIsUpdated(true);
        s.setIsDeleted(true);
        s.setLastUpdatedBy(loginId);
        s.setLastUpdatedDate(new Date());
        employeeSalaryDetailsRepository.save(s);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Deleted");
        return vm;
    }

    private EmployeeSalaryDetailsViewModel mapSalaryDetail(EmployeeSalaryDetails s) {
        EmployeeSalaryDetailsViewModel vm = new EmployeeSalaryDetailsViewModel();
        vm.setSalaryId(s.getSalaryId());
        vm.setEmpId(s.getEmpId());
        vm.setEmpCode(s.getEmpCode());
        vm.setCtc(s.getCtc());
        vm.setMctc(s.getMCTC());
        vm.setEffectiveFromDate(formatDate(s.getEffectiveFromDate()));
        vm.setEffectiveToDate(formatDate(s.getEffectiveToDate()));
        vm.setIsAppraised(s.getIsAppraised());
        vm.setRecordStatus(s.getRecordStatus());
        vm.setIsActive(s.getIsActive());
        vm.setIsUpdated(s.getIsUpdated());
        vm.setIsDeleted(s.getIsDeleted());
        vm.setCreatedBy(s.getCreatedBy());
        vm.setCreatedDate(formatDate(s.getCreatedDate()));
        vm.setLastUpdatedBy(s.getLastUpdatedBy());
        vm.setLastUpdatedDate(formatDate(s.getLastUpdatedDate()));
        if (s.getEmpId() != null) {
            EmployeeMaster emp = employeeMasterRepository.findByEmpIdAndActive(s.getEmpId());
            if (emp != null) {
                vm.setFirstName(emp.getFirstName());
                vm.setMiddleName(emp.getMiddleName());
                vm.setLastName(emp.getLastName());
            }
        }
        return vm;
    }

    // ===== Payout Mapping Master =====

    public List<PayoutMappingMasterViewModel> getAllPayoutMappingMaster(PayoutMappingMasterViewModel model) {
        Integer loginId = (model != null && model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        List<PayoutMappingMaster> details = payoutMappingMasterRepository.findAll().stream()
            .filter(m -> Boolean.TRUE.equals(m.getIsActive()) && Boolean.FALSE.equals(m.getIsDeleted()))
            .collect(Collectors.toList());

        if (details.isEmpty()) return new ArrayList<>();

        return details.stream().map(m -> {
            PayoutMappingMasterViewModel vm = new PayoutMappingMasterViewModel();
            vm.setMapId(m.getMapId());
            vm.setGradeId(m.getGradeId());
            vm.setGrade(m.getGrade());
            vm.setPayoutTypeId(m.getPayoutTypeId());
            vm.setCreatedBy(m.getCreatedBy());
            vm.setCreatedDate(formatDate(m.getCreatedDate()));
            vm.setLastUpdatedBy(m.getLastUpdatedBy());
            vm.setLastUpdatedDate(formatDate(m.getLastUpdatedDate()));
            vm.setIsActive(m.getIsActive());
            vm.setIsUpdated(m.getIsUpdated());
            vm.setIsDeleted(m.getIsDeleted());
            if (m.getPayoutTypeId() != null) {
                PayrollPayoutType pt = payrollPayoutTypeRepository.findById(m.getPayoutTypeId()).orElse(null);
                vm.setPayoutTypeName(pt != null ? pt.getPayoutTypeName() : "");
            }
            return vm;
        }).collect(Collectors.toList());
    }

    public PayoutMappingMasterViewModel getPayoutMappingMaster(PayoutMappingMasterViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        PayoutMappingMaster m = payoutMappingMasterRepository.findById(model.getMapId()).orElse(null);
        if (m == null || Boolean.TRUE.equals(m.getIsDeleted())) throw new RuntimeException("Payout Mapping Details Not Found");

        PayoutMappingMasterViewModel vm = new PayoutMappingMasterViewModel();
        vm.setMapId(m.getMapId());
        vm.setGradeId(m.getGradeId());
        vm.setGrade(m.getGrade());
        vm.setPayoutTypeId(m.getPayoutTypeId());
        vm.setCreatedBy(m.getCreatedBy());
        vm.setCreatedDate(formatDate(m.getCreatedDate()));
        vm.setLastUpdatedBy(m.getLastUpdatedBy());
        vm.setLastUpdatedDate(formatDate(m.getLastUpdatedDate()));
        vm.setIsActive(m.getIsActive());
        vm.setIsUpdated(m.getIsUpdated());
        vm.setIsDeleted(m.getIsDeleted());
        if (m.getPayoutTypeId() != null) {
            PayrollPayoutType pt = payrollPayoutTypeRepository.findById(m.getPayoutTypeId()).orElse(null);
            vm.setPayoutTypeName(pt != null ? pt.getPayoutTypeName() : "");
        }
        return vm;
    }

    public PayrollResponseViewModel addPayoutMappingMaster(PayoutMappingMasterViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Mismatching");

        PayoutMappingMaster m = new PayoutMappingMaster();
        m.setGradeId(model.getGradeId());
        m.setGrade(model.getGrade());
        m.setPayoutTypeId(model.getPayoutTypeId());
        m.setIsActive(true);
        m.setIsUpdated(false);
        m.setIsDeleted(false);
        m.setCreatedBy(loginId);
        m.setCreatedDate(new Date());
        m.setLastUpdatedBy(loginId);
        m.setLastUpdatedDate(new Date());
        payoutMappingMasterRepository.save(m);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Added");
        return vm;
    }

    public PayrollResponseViewModel updatePayoutMappingMaster(PayoutMappingMasterViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        Integer id = (model.getMapId() != null && model.getMapId() != 0) ? model.getMapId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Mismatching");
        if (id == 0) throw new RuntimeException("Mapping Id is Mismatching");

        PayoutMappingMaster m = payoutMappingMasterRepository.findById(id).orElse(null);
        if (m == null || Boolean.TRUE.equals(m.getIsDeleted())) throw new RuntimeException("Payout Mapping Details Not Found");

        m.setGradeId(model.getGradeId());
        m.setGrade(model.getGrade());
        m.setPayoutTypeId(model.getPayoutTypeId());
        m.setIsUpdated(true);
        m.setLastUpdatedBy(loginId);
        m.setLastUpdatedDate(new Date());
        payoutMappingMasterRepository.save(m);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Updated");
        return vm;
    }

    public PayrollResponseViewModel deletePayoutMappingMaster(PayoutMappingMasterViewModel model) {
        Integer loginId = (model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        Integer id = (model.getMapId() != null && model.getMapId() != 0) ? model.getMapId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        PayoutMappingMaster m = payoutMappingMasterRepository.findById(id).orElse(null);
        if (m == null || Boolean.TRUE.equals(m.getIsDeleted())) throw new RuntimeException("Payout Mapping Details Not Found");

        m.setIsUpdated(true);
        m.setIsDeleted(true);
        m.setLastUpdatedBy(loginId);
        m.setLastUpdatedDate(new Date());
        payoutMappingMasterRepository.save(m);

        PayrollResponseViewModel vm = new PayrollResponseViewModel();
        vm.setStatus(200);
        vm.setMsg("Deleted");
        return vm;
    }

    // ===== Dropdowns =====

    public List<Map<String, Object>> getDDPayrollFrequency() {
        Integer loginId = 1;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        List<PayrollFrequencyMaster> details = payrollFrequencyMasterRepository.findByIsActiveTrue();
        if (details.isEmpty()) throw new RuntimeException("Frequency Details Not Found");

        return details.stream()
            .map(f -> {
                Map<String, Object> m = new HashMap<>();
                m.put("FrequencyId", f.getFrequencyId());
                m.put("Frequency", f.getFrequency());
                return m;
            }).collect(Collectors.toList());
    }

    public List<Map<String, Object>> getDDPayrollSymbols(PayrolAccessViewModel model) {
        Integer loginId = (model != null && model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> m = new HashMap<>(); m.put("SymbolId", 1); m.put("Symbol", "+"); result.add(m);
        m = new HashMap<>(); m.put("SymbolId", 2); m.put("Symbol", "-"); result.add(m);
        m = new HashMap<>(); m.put("SymbolId", 3); m.put("Symbol", "*"); result.add(m);
        m = new HashMap<>(); m.put("SymbolId", 4); m.put("Symbol", "/"); result.add(m);
        return result;
    }

    public List<DDLegalEntityPayrollViewModel> ddLegalEntity(PayrollPayoutTypeViewModel model) {
        Integer loginId = (model != null && model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        List<LegalEntityMaster> details = legalEntityMasterRepository.findAll().stream()
            .filter(l -> Boolean.TRUE.equals(l.getIsActive()) && Boolean.FALSE.equals(l.getIsDeleted()))
            .collect(Collectors.toList());

        return details.stream().map(l -> {
            DDLegalEntityPayrollViewModel vm = new DDLegalEntityPayrollViewModel();
            vm.setLEId(l.getLeId());
            vm.setLegalEntity(l.getLegalEntity());
            vm.setLoginId(loginId);
            return vm;
        }).collect(Collectors.toList());
    }

    public List<DDLocationViewModel> getDDLocation() {
        return locationMasterRepository.findByIsActiveAndIsDeleted(true, false).stream()
            .map(loc -> {
                DDLocationViewModel vm = new DDLocationViewModel();
                vm.setLocationId(loc.getLocationId());
                vm.setLocation(loc.getLocation());
                return vm;
            }).collect(Collectors.toList());
    }

    public List<DDPayrollEmpListViewModel> ddPayrollEmpList(PayrollComponentViewModel model) {
        Integer loginId = (model != null && model.getLoginId() != null && model.getLoginId() != 0) ? model.getLoginId() : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        List<EmployeeMaster> employees = employeeMasterRepository.findByIsActiveAndIsDeleted(true, false);

        return employees.stream().map(e -> {
            DDPayrollEmpListViewModel vm = new DDPayrollEmpListViewModel();
            vm.setEmpId(e.getEmpId());
            vm.setEmpName(e.getFirstName() + " " + e.getMiddleName() + " " + e.getLastName());
            vm.setEmpCode(e.getUserName());
            return vm;
        }).collect(Collectors.toList());
    }

    // ===== Stubs for complex calculations =====

    public Map<String, Object> empCTCCalculation(Map<String, Object> model) {
        Map<String, Object> result = new HashMap<>();
        result.put("CTC", 0);
        result.put("msg", "CTC calculated");
        return result;
    }

    public Map<String, Object> empPayslipGeneration(Map<String, Object> model) {
        return model;
    }

    public Map<String, Object> calculatePayroll(Map<String, Object> model) {
        Map<String, Object> result = new HashMap<>();
        result.put("msg", "Payroll calculated");
        return result;
    }

    public Map<String, Object> generatePayslip(Map<String, Object> model) {
        return model;
    }

    public List<Map<String, Object>> getPayslipByEmployee(Map<String, Object> model) {
        return new ArrayList<>();
    }

    public Map<String, Object> processPayroll(Map<String, Object> model) {
        Map<String, Object> result = new HashMap<>();
        result.put("Status", 200);
        result.put("msg", "Payroll processed successfully");
        return result;
    }

    public Map<String, Object> payrollReportforALL(Map<String, Object> model) {
        Map<String, Object> result = new HashMap<>();
        result.put("msg", "Payroll report generated");
        return result;
    }

    public List<Map<String, Object>> getDDPayrollSymbols() {
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> m = new HashMap<>(); m.put("id", 1); m.put("name", "+"); result.add(m);
        m = new HashMap<>(); m.put("id", 2); m.put("name", "-"); result.add(m);
        return result;
    }

    public List<Map<String, Object>> getPayrollComponents() {
        PayrollComponentViewModel model = new PayrollComponentViewModel();
        model.setLoginId(1);
        return ddPayrollComponent(model).stream()
            .map(c -> { Map<String, Object> m = new HashMap<>(); m.put("id", c.getComponentId()); m.put("name", c.getComponentName()); return m; })
            .collect(Collectors.toList());
    }

    public Map<String, Object> activatePayrollPayoutType(Map<String, Object> model) {
        return Map.of("msg", "Activated", "StatusCode", 200);
    }

    public Map<String, Object> deactivatePayrollPayoutType(Map<String, Object> model) {
        return Map.of("msg", "Deactivated", "StatusCode", 200);
    }

    public Map<String, Object> addPayrollVariable(Map<String, Object> model) {
        return Map.of("msg", "Added", "StatusCode", 200);
    }

    public Map<String, Object> updatePayrollVariable(Map<String, Object> model) {
        return Map.of("msg", "Updated", "StatusCode", 200);
    }

    public Map<String, Object> deletePayrollVariable(Map<String, Object> model) {
        return Map.of("msg", "Deleted", "StatusCode", 200);
    }

    public Map<String, Object> getPayrollVariable(Map<String, Object> model) {
        Map<String, Object> result = new HashMap<>();
        result.put("VariableId", model.get("VariableId"));
        result.put("VariableName", "Sample Variable");
        result.put("StatusCode", 200);
        return result;
    }

    public List<Map<String, Object>> getAllPayrollVariable(Map<String, Object> model) {
        List<Map<String, Object>> result = new ArrayList<>();
        result.add(Map.of("VariableId", 1, "VariableName", "Sample Variable", "StatusCode", 200));
        return result;
    }

    public List<Map<String, Object>> ddPayrollVariable(Map<String, Object> model) {
        List<Map<String, Object>> result = new ArrayList<>();
        result.add(Map.of("VariableId", 1, "VariableName", "Sample Variable", "StatusCode", 200));
        return result;
    }

    public Map<String, Object> addPayrollVariableHistory(Map<String, Object> model) {
        return Map.of("msg", "Added", "StatusCode", 200);
    }

    public Map<String, Object> updatePayrollVariableHistory(Map<String, Object> model) {
        return Map.of("msg", "Updated", "StatusCode", 200);
    }

    public Map<String, Object> deletePayrollVariableHistory(Map<String, Object> model) {
        return Map.of("msg", "Deleted", "StatusCode", 200);
    }

    public List<Map<String, Object>> payrollVariableHistory(Map<String, Object> model) {
        List<Map<String, Object>> result = new ArrayList<>();
        result.add(Map.of("HistoryId", 1, "VariableId", 1, "OldValue", "100", "NewValue", "150", "StatusCode", 200));
        return result;
    }

    public List<Map<String, Object>> getAllPayrollPayoutTypeSegment(Map<String, Object> model) {
        Integer loginId = model.containsKey("LoginId") ? parseSafeInt(model.get("LoginId")) : 0;
        Integer payoutTypeId = model.containsKey("PayoutTypeId") ? parseSafeInt(model.get("PayoutTypeId")) : 0;
        if (loginId == 0) throw new RuntimeException("LoginId is Missing");

        // Preload all payout types for efficient lookup
        Map<Integer, String> payoutTypeNames = new HashMap<>();
        for (PayrollPayoutType pt : payrollPayoutTypeRepository.findAll()) {
            payoutTypeNames.put(pt.getPayoutTypeId(), pt.getPayoutTypeName());
        }

        List<PayrollSegment> segments = payrollSegmentRepository.findAll().stream()
            .filter(s -> Boolean.TRUE.equals(s.getIsActive()) && Boolean.FALSE.equals(s.getIsDeleted()))
            .filter(s -> payoutTypeId == 0 || (s.getPayoutTypeId() != null && s.getPayoutTypeId().equals(payoutTypeId)))
            .collect(Collectors.toList());

        if (segments.isEmpty()) throw new RuntimeException("Segment Details Not Found");

        return segments.stream().map(s -> {
            Map<String, Object> m = new HashMap<>();
            m.put("SegmentId", s.getSegmentId());
            m.put("SegmentName", s.getSegmentName());
            m.put("PayoutTypeId", s.getPayoutTypeId());
            m.put("PayoutTypeName", s.getPayoutTypeId() != null ? payoutTypeNames.getOrDefault(s.getPayoutTypeId(), "") : "");
            m.put("CreatedBy", s.getCreatedBy());
            m.put("CreatedDate", formatDate(s.getCreatedDate()));
            m.put("LastUpdatedBy", s.getLastUpdatedBy());
            m.put("LastUpdatedDate", formatDate(s.getLastUpdatedDate()));
            m.put("IsActive", s.getIsActive());
            m.put("IsUpdated", s.getIsUpdated());
            m.put("IsDeleted", s.getIsDeleted());
            return m;
        }).collect(Collectors.toList());
    }
}
