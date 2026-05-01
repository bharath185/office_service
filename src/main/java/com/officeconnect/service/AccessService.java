package com.officeconnect.service;

import com.officeconnect.dto.*;
import com.officeconnect.entity.*;
import com.officeconnect.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccessService {

    @Autowired
    private AccessPolicyRepository accessPolicyRepository;

    @Autowired
    private EmployeeMasterRepository employeeMasterRepository;

    @Autowired
    private DeptMasterRepository deptMasterRepository;

    @Autowired
    private RoleMasterRepository roleMasterRepository;

    @Autowired
    private ModuleMasterRepository moduleMasterRepository;

    @Autowired
    private SubModuleMasterRepository subModuleMasterRepository;

    @Autowired
    private PageModuleMasterRepository pageModuleMasterRepository;

    @Autowired
    private DesignationMasterRepository designationMasterRepository;

    private Integer getIntegerValue(Object obj) {
        if (obj == null) return 0;
        try {
            return Integer.parseInt(obj.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public AccessViewModel createPolicy(AccessViewModel model) {
        AccessPolicy policy = new AccessPolicy();
        policy.setDeptId(model.getDeptId());
        policy.setRoleId(model.getRoleId());
        policy.setModuleId(model.getModuleId());
        policy.setAccessName(model.getAccessName());
        policy.setViewAccess(model.getCanView());
        policy.setAddAccess(model.getCanAdd());
        policy.setUpdateAccess(model.getCanEdit());
        policy.setDeleteAccess(model.getCanDelete());
        policy.setIsActive(true);
        policy.setIsUpdated(false);
        policy.setIsDeleted(false);
        policy.setCreatedDate(new Date());
        
        policy = accessPolicyRepository.save(policy);
        
        model.setPolicyId(policy.getAccessId());
        model.setMsg("Access policy created successfully");
        return model;
    }

    public List<AccessViewModel> getAllPolicies(AccessViewModel model) {
        if (model.getRoleId() != null) {
            return accessPolicyRepository.findByRoleIdAndIsDeleted(model.getRoleId(), false).stream()
                .map(p -> convertToViewModel(p))
                .collect(Collectors.toList());
        }
        return accessPolicyRepository.findAll().stream()
            .filter(p -> p.getIsDeleted() != null && !p.getIsDeleted())
            .map(p -> convertToViewModel(p))
            .collect(Collectors.toList());
    }

    public AccessViewModel updatePolicy(AccessViewModel model) {
        Optional<AccessPolicy> policyOpt = accessPolicyRepository.findById(model.getPolicyId());
        if (policyOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Policy not found\"}");
        }
        
        AccessPolicy policy = policyOpt.get();
        policy.setViewAccess(model.getCanView());
        policy.setAddAccess(model.getCanAdd());
        policy.setUpdateAccess(model.getCanEdit());
        policy.setDeleteAccess(model.getCanDelete());
        policy.setIsUpdated(true);
        policy.setLastUpdatedDate(new Date());
        accessPolicyRepository.save(policy);
        
        model.setMsg("Access policy updated successfully");
        return model;
    }

    public AccessViewModel deletePolicy(AccessViewModel model) {
        Optional<AccessPolicy> policyOpt = accessPolicyRepository.findById(model.getPolicyId());
        if (policyOpt.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Policy not found\"}");
        }
        
        AccessPolicy policy = policyOpt.get();
        policy.setIsDeleted(true);
        policy.setIsActive(false);
        accessPolicyRepository.save(policy);
        
        model.setMsg("Access policy deleted successfully");
        return model;
    }

    private AccessViewModel convertToViewModel(AccessPolicy p) {
        AccessViewModel vm = new AccessViewModel();
        vm.setPolicyId(p.getAccessId());
        vm.setDeptId(p.getDeptId());
        vm.setRoleId(p.getRoleId());
        vm.setModuleId(p.getModuleId());
        vm.setAccessName(p.getAccessName());
        vm.setCanView(p.getViewAccess());
        vm.setCanAdd(p.getAddAccess());
        vm.setCanEdit(p.getUpdateAccess());
        vm.setCanDelete(p.getDeleteAccess());
        vm.setIsActive(p.getIsActive());
        return vm;
    }

    public Map<String, Object> addRole(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer empId = getIntegerValue(model.get("EmpId"));
        String roleName = model.get("RoleName") != null ? model.get("RoleName").toString() : "";
        Integer deptId = getIntegerValue(model.get("DeptId"));
        Integer gradeId = getIntegerValue(model.get("GradeId"));
        String grade = model.get("Grade") != null ? model.get("Grade").toString() : "";

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        List<DesignationMaster> existing = designationMasterRepository.findAll().stream()
            .filter(d -> d.getDeptId() != null && d.getDeptId().equals(deptId))
            .filter(d -> d.getDesignation() != null && d.getDesignation().equals(roleName))
            .filter(d -> Boolean.TRUE.equals(d.getIsActive()) && (d.getIsDeleted() == null || !d.getIsDeleted()))
            .collect(Collectors.toList());

        if (!existing.isEmpty()) {
            throw new RuntimeException("Role Details Already Exists");
        }

        DesignationMaster dm = new DesignationMaster();
        dm.setDeptId(deptId);
        dm.setDesignation(roleName);
        dm.setGradeId(gradeId);
        dm.setGrade(grade);
        dm.setIsActive(true);
        dm.setIsUpdated(false);
        dm.setIsDeleted(false);
        dm.setCreatedBy(empId);
        dm.setCreatedDate(new Date());
        dm.setLastUpdatedBy(empId);
        dm.setLastUpdatedDate(new Date());
        designationMasterRepository.save(dm);

        result.put("msg", "Added");
        result.put("RoleName", roleName);
        return result;
    }

    public Map<String, Object> updateRole(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer empId = getIntegerValue(model.get("EmpId"));
        Integer roleId = getIntegerValue(model.get("RoleId"));
        String roleName = model.get("RoleName") != null ? model.get("RoleName").toString() : "";
        Integer deptId = getIntegerValue(model.get("DeptId"));
        Integer gradeId = getIntegerValue(model.get("GradeId"));
        String grade = model.get("Grade") != null ? model.get("Grade").toString() : "";

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        Optional<DesignationMaster> roleOpt = designationMasterRepository.findById(roleId);
        if (roleOpt.isEmpty()) {
            throw new RuntimeException("Role Details Not Found");
        }

        DesignationMaster dm = roleOpt.get();
        dm.setDesignation(roleName);
        dm.setDeptId(deptId);
        dm.setGradeId(gradeId);
        dm.setGrade(grade);
        dm.setIsActive(true);
        dm.setIsUpdated(true);
        dm.setIsDeleted(false);
        dm.setLastUpdatedBy(empId);
        dm.setLastUpdatedDate(new Date());
        designationMasterRepository.save(dm);

        result.put("msg", "Updated");
        result.put("RoleName", roleName);
        return result;
    }

    public Map<String, Object> deleteRole(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer empId = getIntegerValue(model.get("EmpId"));
        Integer roleId = getIntegerValue(model.get("RoleId"));
        String roleName = model.get("RoleName") != null ? model.get("RoleName").toString() : "";

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        Optional<DesignationMaster> roleOpt = designationMasterRepository.findById(roleId);
        if (roleOpt.isEmpty()) {
            throw new RuntimeException("Role Details Not Found");
        }

        DesignationMaster dm = roleOpt.get();
        dm.setIsDeleted(true);
        dm.setLastUpdatedBy(empId);
        dm.setLastUpdatedDate(new Date());
        designationMasterRepository.save(dm);

        result.put("msg", "Deleted");
        result.put("RoleName", roleName);
        return result;
    }

    public Map<String, Object> getRole(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer roleId = getIntegerValue(model.get("RoleId"));
        Integer empId = getIntegerValue(model.get("EmpId"));

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        Optional<DesignationMaster> roleOpt = designationMasterRepository.findById(roleId);
        if (roleOpt.isEmpty()) {
            throw new RuntimeException("Role Details Not Found");
        }

        DesignationMaster dm = roleOpt.get();
        String deptName = null;
        if (dm.getDeptId() != null) {
            Optional<DeptMaster> deptOpt = deptMasterRepository.findById(dm.getDeptId());
            if (deptOpt.isPresent()) {
                deptName = deptOpt.get().getDeptName();
            }
        }

        result.put("RoleId", dm.getDesignationId());
        result.put("DeptId", dm.getDeptId());
        result.put("DeptName", deptName);
        result.put("RoleName", dm.getDesignation());
        result.put("GradeId", dm.getGradeId());
        result.put("Grade", dm.getGrade());
        result.put("IsActive", dm.getIsActive());
        result.put("IsUpdated", dm.getIsUpdated());
        result.put("IsDeleted", dm.getIsDeleted());
        return result;
    }

    public List<Map<String, Object>> getAllRole(Map<String, Object> model) {
        Integer empId = getIntegerValue(model.get("EmpId"));
        Integer deptId = model.get("DeptId") != null ? Integer.parseInt(model.get("DeptId").toString()) : null;

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        return designationMasterRepository.findAll().stream()
            .filter(d -> d.getIsDeleted() == null || !d.getIsDeleted())
            .filter(d -> d.getIsActive() == null || d.getIsActive())
            .filter(d -> deptId == null || d.getDeptId() == null || d.getDeptId().equals(deptId))
            .map(d -> {
                Map<String, Object> m = new LinkedHashMap<>();

                String deptName = null;
                if (d.getDeptId() != null) {
                    Optional<DeptMaster> deptOpt = deptMasterRepository.findById(d.getDeptId());
                    if (deptOpt.isPresent()) {
                        deptName = deptOpt.get().getDeptName();
                    }
                }

                m.put("RoleId", d.getDesignationId());
                m.put("DeptId", d.getDeptId());
                m.put("DeptName", deptName);
                m.put("RoleName", d.getDesignation());
                m.put("GradeId", d.getGradeId() != null ? d.getGradeId() : 5);
                m.put("Grade", d.getGrade() != null ? d.getGrade() : "Grade-5");
                m.put("msg", null);
                m.put("CreatedBy", d.getCreatedBy());
                m.put("CreatedDate", d.getCreatedDate() != null ? "\\/Date(" + d.getCreatedDate().getTime() + ")\\/" : null);
                m.put("LastUpdatedBy", d.getLastUpdatedBy());
                m.put("LastUpdatedDate", d.getLastUpdatedDate() != null ? "\\/Date(" + d.getLastUpdatedDate().getTime() + ")\\/" : null);
                m.put("IsActive", d.getIsActive());
                m.put("IsUpdated", d.getIsUpdated());
                m.put("IsDeleted", d.getIsDeleted());
                m.put("EmpId", 0);
                return m;
            })
            .collect(Collectors.toList());
    }

    public List<Map<String, Object>> getDDRole(Map<String, Object> model) {
        return getAllRole(model);
    }

    public Map<String, Object> addModule(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer empId = getIntegerValue(model.get("EmpId"));
        String moduleName = model.get("ModuleName") != null ? model.get("ModuleName").toString() : "";

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        List<ModuleMaster> existing = moduleMasterRepository.findAll().stream()
            .filter(m -> m.getModuleName() != null && m.getModuleName().equals(moduleName))
            .filter(m -> Boolean.TRUE.equals(m.getIsActive()) && (m.getIsDeleted() == null || !m.getIsDeleted()))
            .collect(Collectors.toList());

        if (!existing.isEmpty()) {
            throw new RuntimeException("Module Details Already Exists");
        }

        ModuleMaster mm = new ModuleMaster();
        mm.setModuleName(moduleName);
        mm.setIsActive(true);
        mm.setIsUpdated(false);
        mm.setIsDeleted(false);
        mm.setCreatedBy(empId);
        mm.setCreatedDate(new Date());
        mm.setLastUpdatedBy(empId);
        mm.setLastUpdatedDate(new Date());
        moduleMasterRepository.save(mm);

        result.put("msg", "Added");
        result.put("ModuleName", moduleName);
        return result;
    }

    public Map<String, Object> updateModule(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer empId = getIntegerValue(model.get("EmpId"));
        Integer moduleId = getIntegerValue(model.get("ModuleId"));
        String moduleName = model.get("ModuleName") != null ? model.get("ModuleName").toString() : "";

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        Optional<ModuleMaster> moduleOpt = moduleMasterRepository.findById(moduleId);
        if (moduleOpt.isEmpty()) {
            throw new RuntimeException("Module Details Not Found");
        }

        ModuleMaster mm = moduleOpt.get();
        mm.setModuleName(moduleName);
        mm.setIsActive(true);
        mm.setIsUpdated(true);
        mm.setIsDeleted(false);
        mm.setLastUpdatedBy(empId);
        mm.setLastUpdatedDate(new Date());
        moduleMasterRepository.save(mm);

        result.put("msg", "Updated");
        result.put("ModuleName", moduleName);
        return result;
    }

    public Map<String, Object> deleteModule(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer empId = getIntegerValue(model.get("EmpId"));
        Integer moduleId = getIntegerValue(model.get("ModuleId"));
        String moduleName = model.get("ModuleName") != null ? model.get("ModuleName").toString() : "";

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        Optional<ModuleMaster> moduleOpt = moduleMasterRepository.findById(moduleId);
        if (moduleOpt.isEmpty()) {
            throw new RuntimeException("Module Details Not Found");
        }

        ModuleMaster mm = moduleOpt.get();
        mm.setIsDeleted(true);
        mm.setLastUpdatedBy(empId);
        mm.setLastUpdatedDate(new Date());
        moduleMasterRepository.save(mm);

        result.put("msg", "Deleted");
        result.put("ModuleName", moduleName);
        return result;
    }

    public Map<String, Object> getModule(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer moduleId = getIntegerValue(model.get("ModuleId"));
        Integer empId = getIntegerValue(model.get("EmpId"));

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        Optional<ModuleMaster> moduleOpt = moduleMasterRepository.findById(moduleId);
        if (moduleOpt.isEmpty()) {
            throw new RuntimeException("Module Details Not Found");
        }

        ModuleMaster mm = moduleOpt.get();
        result.put("ModuleId", mm.getModuleId());
        result.put("ModuleName", mm.getModuleName());
        result.put("IsActive", mm.getIsActive());
        result.put("IsUpdated", mm.getIsUpdated());
        result.put("IsDeleted", mm.getIsDeleted());
        return result;
    }

    public List<Map<String, Object>> getAllModule(Map<String, Object> model) {
        Integer empId = getIntegerValue(model.get("EmpId"));

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        return moduleMasterRepository.findAll().stream()
            .filter(m -> m.getIsDeleted() == null || !m.getIsDeleted())
            .filter(m -> m.getIsActive() == null || m.getIsActive())
            .map(m -> {
                Map<String, Object> result = new LinkedHashMap<>();
                result.put("ModuleId", m.getModuleId());
                result.put("ModuleName", m.getModuleName());
                result.put("msg", null);
                result.put("CreatedBy", m.getCreatedBy());
                result.put("CreatedDate", m.getCreatedDate() != null ? "\\/Date(" + m.getCreatedDate().getTime() + ")\\/" : null);
                result.put("LastUpdatedBy", m.getLastUpdatedBy());
                result.put("LastUpdatedDate", m.getLastUpdatedDate() != null ? "\\/Date(" + m.getLastUpdatedDate().getTime() + ")\\/" : null);
                result.put("IsActive", m.getIsActive());
                result.put("IsUpdated", m.getIsUpdated());
                result.put("IsDeleted", m.getIsDeleted());
                result.put("EmpId", 0);
                return result;
            })
            .collect(Collectors.toList());
    }

    public List<Map<String, Object>> getDDModule() {
        return getAllModule(new HashMap<>());
    }

    public Map<String, Object> addSubModule(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer empId = getIntegerValue(model.get("EmpId"));
        String subModuleName = model.get("SubModuleName") != null ? model.get("SubModuleName").toString() : "";
        Integer moduleId = getIntegerValue(model.get("ModuleId"));

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        List<SubModuleMaster> existing = subModuleMasterRepository.findAll().stream()
            .filter(s -> s.getSubModuleName() != null && s.getSubModuleName().equals(subModuleName))
            .filter(s -> Boolean.TRUE.equals(s.getIsActive()) && (s.getIsDeleted() == null || !s.getIsDeleted()))
            .collect(Collectors.toList());

        if (!existing.isEmpty()) {
            throw new RuntimeException("SubModule Details Already Exists");
        }

        SubModuleMaster smm = new SubModuleMaster();
        smm.setModuleId(moduleId);
        smm.setSubModuleName(subModuleName);
        smm.setIsActive(true);
        smm.setIsUpdated(false);
        smm.setIsDeleted(false);
        smm.setCreatedBy(empId);
        smm.setCreatedDate(new Date());
        smm.setLastUpdatedBy(empId);
        smm.setLastUpdatedDate(new Date());
        subModuleMasterRepository.save(smm);

        result.put("msg", "Added");
        result.put("SubModuleName", subModuleName);
        return result;
    }

    public Map<String, Object> updateSubModule(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer empId = getIntegerValue(model.get("EmpId"));
        Integer subModuleId = getIntegerValue(model.get("SubModuleId"));
        String subModuleName = model.get("SubModuleName") != null ? model.get("SubModuleName").toString() : "";
        Integer moduleId = getIntegerValue(model.get("ModuleId"));

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        Optional<SubModuleMaster> subModuleOpt = subModuleMasterRepository.findById(subModuleId);
        if (subModuleOpt.isEmpty()) {
            throw new RuntimeException("SubModule Details Not Found");
        }

        SubModuleMaster smm = subModuleOpt.get();
        smm.setModuleId(moduleId);
        smm.setSubModuleName(subModuleName);
        smm.setIsActive(true);
        smm.setIsUpdated(true);
        smm.setIsDeleted(false);
        smm.setLastUpdatedBy(empId);
        smm.setLastUpdatedDate(new Date());
        subModuleMasterRepository.save(smm);

        result.put("msg", "Updated");
        result.put("SubModuleName", subModuleName);
        return result;
    }

    public Map<String, Object> deleteSubModule(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer empId = getIntegerValue(model.get("EmpId"));
        Integer subModuleId = getIntegerValue(model.get("SubModuleId"));
        String subModuleName = model.get("SubModuleName") != null ? model.get("SubModuleName").toString() : "";

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        Optional<SubModuleMaster> subModuleOpt = subModuleMasterRepository.findById(subModuleId);
        if (subModuleOpt.isEmpty()) {
            throw new RuntimeException("SubModule Details Not Found");
        }

        SubModuleMaster smm = subModuleOpt.get();
        smm.setIsDeleted(true);
        smm.setLastUpdatedBy(empId);
        smm.setLastUpdatedDate(new Date());
        subModuleMasterRepository.save(smm);

        result.put("msg", "Deleted");
        result.put("SubModuleName", subModuleName);
        return result;
    }

    public Map<String, Object> getSubModule(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer subModuleId = getIntegerValue(model.get("SubModuleId"));
        Integer empId = getIntegerValue(model.get("EmpId"));

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        Optional<SubModuleMaster> subModuleOpt = subModuleMasterRepository.findById(subModuleId);
        if (subModuleOpt.isEmpty()) {
            throw new RuntimeException("SubModule Details Not Found");
        }

        SubModuleMaster smm = subModuleOpt.get();
        result.put("SubModuleId", smm.getSubModuleId());
        result.put("SubModuleName", smm.getSubModuleName());
        result.put("ModuleId", smm.getModuleId());
        result.put("IsActive", smm.getIsActive());
        result.put("IsUpdated", smm.getIsUpdated());
        result.put("IsDeleted", smm.getIsDeleted());
        return result;
    }

    public List<Map<String, Object>> getAllSubModule(Map<String, Object> model) {
        Integer empId = getIntegerValue(model.get("EmpId"));
        Integer moduleId = model.get("ModuleId") != null ? Integer.parseInt(model.get("ModuleId").toString()) : null;

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        return subModuleMasterRepository.findAll().stream()
            .filter(s -> s.getIsDeleted() == null || !s.getIsDeleted())
            .filter(s -> s.getIsActive() == null || s.getIsActive())
            .filter(s -> moduleId == null || s.getModuleId() == null || s.getModuleId().equals(moduleId))
            .map(s -> {
                Map<String, Object> m = new LinkedHashMap<>();
                m.put("SubModuleId", s.getSubModuleId());
                m.put("SubModuleName", s.getSubModuleName());
                m.put("ModuleId", s.getModuleId());
                m.put("msg", null);
                m.put("CreatedBy", s.getCreatedBy());
                m.put("CreatedDate", s.getCreatedDate() != null ? "\\/Date(" + s.getCreatedDate().getTime() + ")\\/" : null);
                m.put("LastUpdatedBy", s.getLastUpdatedBy());
                m.put("LastUpdatedDate", s.getLastUpdatedDate() != null ? "\\/Date(" + s.getLastUpdatedDate().getTime() + ")\\/" : null);
                m.put("IsActive", s.getIsActive());
                m.put("IsUpdated", s.getIsUpdated());
                m.put("IsDeleted", s.getIsDeleted());
                m.put("EmpId", 0);
                return m;
            })
            .collect(Collectors.toList());
    }

    public List<Map<String, Object>> getDDSubModule() {
        return getAllSubModule(new HashMap<>());
    }

    public Map<String, Object> addPageModule(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer empId = getIntegerValue(model.get("EmpId"));
        String pageName = model.get("PageName") != null ? model.get("PageName").toString() : "";
        Integer moduleId = getIntegerValue(model.get("ModuleId"));
        Integer subModuleId = getIntegerValue(model.get("SubModuleId"));

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        List<PageModuleMaster> existing = pageModuleMasterRepository.findAll().stream()
            .filter(p -> p.getPageName() != null && p.getPageName().equals(pageName))
            .filter(p -> Boolean.TRUE.equals(p.getIsActive()) && (p.getIsDeleted() == null || !p.getIsDeleted()))
            .collect(Collectors.toList());

        if (!existing.isEmpty()) {
            throw new RuntimeException("Page Module Details Already Exists");
        }

        PageModuleMaster pmm = new PageModuleMaster();
        pmm.setModuleId(moduleId);
        pmm.setSubModuleId(subModuleId);
        pmm.setPageName(pageName);
        pmm.setIsActive(true);
        pmm.setIsUpdated(false);
        pmm.setIsDeleted(false);
        pmm.setCreatedBy(empId);
        pmm.setCreatedDate(new Date());
        pmm.setLastUpdatedBy(empId);
        pmm.setLastUpdatedDate(new Date());
        pageModuleMasterRepository.save(pmm);

        result.put("msg", "Added");
        result.put("PageName", pageName);
        return result;
    }

    public Map<String, Object> updatePageModule(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer empId = getIntegerValue(model.get("EmpId"));
        Integer pageModuleId = getIntegerValue(model.get("PageModuleId"));
        String pageName = model.get("PageName") != null ? model.get("PageName").toString() : "";
        Integer moduleId = getIntegerValue(model.get("ModuleId"));
        Integer subModuleId = getIntegerValue(model.get("SubModuleId"));

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        Optional<PageModuleMaster> pageModuleOpt = pageModuleMasterRepository.findById(pageModuleId);
        if (pageModuleOpt.isEmpty()) {
            throw new RuntimeException("Page Module Details Not Found");
        }

        PageModuleMaster pmm = pageModuleOpt.get();
        pmm.setModuleId(moduleId);
        pmm.setSubModuleId(subModuleId);
        pmm.setPageName(pageName);
        pmm.setIsActive(true);
        pmm.setIsUpdated(true);
        pmm.setIsDeleted(false);
        pmm.setLastUpdatedBy(empId);
        pmm.setLastUpdatedDate(new Date());
        pageModuleMasterRepository.save(pmm);

        result.put("msg", "Updated");
        result.put("PageName", pageName);
        return result;
    }

    public Map<String, Object> deletePageModule(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer empId = getIntegerValue(model.get("EmpId"));
        Integer pageModuleId = getIntegerValue(model.get("PageModuleId"));
        String pageName = model.get("PageName") != null ? model.get("PageName").toString() : "";

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        Optional<PageModuleMaster> pageModuleOpt = pageModuleMasterRepository.findById(pageModuleId);
        if (pageModuleOpt.isEmpty()) {
            throw new RuntimeException("Page Module Details Not Found");
        }

        PageModuleMaster pmm = pageModuleOpt.get();
        pmm.setIsDeleted(true);
        pmm.setLastUpdatedBy(empId);
        pmm.setLastUpdatedDate(new Date());
        pageModuleMasterRepository.save(pmm);

        result.put("msg", "Deleted");
        result.put("PageName", pageName);
        return result;
    }

    public Map<String, Object> getPageModule(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer pageModuleId = getIntegerValue(model.get("PageModuleId"));
        Integer empId = getIntegerValue(model.get("EmpId"));

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        Optional<PageModuleMaster> pageModuleOpt = pageModuleMasterRepository.findById(pageModuleId);
        if (pageModuleOpt.isEmpty()) {
            throw new RuntimeException("Page Module Details Not Found");
        }

        PageModuleMaster pmm = pageModuleOpt.get();
        result.put("PageModuleId", pmm.getPageModuleId());
        result.put("PageName", pmm.getPageName());
        result.put("ModuleId", pmm.getModuleId());
        result.put("SubModuleId", pmm.getSubModuleId());
        result.put("IsActive", pmm.getIsActive());
        result.put("IsUpdated", pmm.getIsUpdated());
        result.put("IsDeleted", pmm.getIsDeleted());
        return result;
    }

    public List<Map<String, Object>> getAllPageModule(Map<String, Object> model) {
        Integer empId = getIntegerValue(model.get("EmpId"));
        Integer subModuleId = model.get("SubModuleId") != null ? Integer.parseInt(model.get("SubModuleId").toString()) : null;

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        return pageModuleMasterRepository.findAll().stream()
            .filter(p -> p.getIsDeleted() == null || !p.getIsDeleted())
            .filter(p -> p.getIsActive() == null || p.getIsActive())
            .filter(p -> subModuleId == null || p.getSubModuleId() == null || p.getSubModuleId().equals(subModuleId))
            .map(p -> {
                Map<String, Object> m = new LinkedHashMap<>();
                m.put("PageModuleId", p.getPageModuleId());
                m.put("PageName", p.getPageName());
                m.put("ModuleId", p.getModuleId());
                m.put("SubModuleId", p.getSubModuleId());
                m.put("msg", null);
                m.put("CreatedBy", p.getCreatedBy());
                m.put("CreatedDate", p.getCreatedDate() != null ? "\\/Date(" + p.getCreatedDate().getTime() + ")\\/" : null);
                m.put("LastUpdatedBy", p.getLastUpdatedBy());
                m.put("LastUpdatedDate", p.getLastUpdatedDate() != null ? "\\/Date(" + p.getLastUpdatedDate().getTime() + ")\\/" : null);
                m.put("IsActive", p.getIsActive());
                m.put("IsUpdated", p.getIsUpdated());
                m.put("IsDeleted", p.getIsDeleted());
                m.put("EmpId", 0);
                return m;
            })
            .collect(Collectors.toList());
    }

    public List<Map<String, Object>> getDDPageModule() {
        return getAllPageModule(new HashMap<>());
    }

    public Map<String, Object> addDept(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer empId = getIntegerValue(model.get("EmpId"));
        String deptName = model.get("DeptName") != null ? model.get("DeptName").toString() : "";
        String deptShortName = model.get("DeptShortName") != null ? model.get("DeptShortName").toString() : null;

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        List<DeptMaster> existing = deptMasterRepository.findAll().stream()
            .filter(d -> d.getDeptName() != null && d.getDeptName().equals(deptName))
            .filter(d -> Boolean.TRUE.equals(d.getIsActive()) && (d.getIsDeleted() == null || !d.getIsDeleted()))
            .collect(Collectors.toList());

        if (!existing.isEmpty()) {
            throw new RuntimeException("Department Details Already Exists");
        }

        DeptMaster dm = new DeptMaster();
        dm.setDeptName(deptName);
        dm.setDeptShortName(deptShortName);
        dm.setIsActive(true);
        dm.setIsUpdated(false);
        dm.setIsDeleted(false);
        dm.setCreatedBy(empId);
        dm.setCreatedDate(new Date());
        dm.setLastUpdatedBy(empId);
        dm.setLastUpdatedDate(new Date());
        deptMasterRepository.save(dm);

        result.put("msg", "Added");
        result.put("DeptName", deptName);
        return result;
    }

    public Map<String, Object> deleteDept(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer empId = getIntegerValue(model.get("EmpId"));
        Integer deptId = getIntegerValue(model.get("DeptId"));
        String deptName = model.get("DeptName") != null ? model.get("DeptName").toString() : "";

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        Optional<DeptMaster> deptOpt = deptMasterRepository.findById(deptId);
        if (deptOpt.isEmpty()) {
            throw new RuntimeException("Department Details Not Found");
        }

        DeptMaster dm = deptOpt.get();
        dm.setIsDeleted(true);
        dm.setLastUpdatedBy(empId);
        dm.setLastUpdatedDate(new Date());
        deptMasterRepository.save(dm);

        result.put("msg", "Deleted");
        result.put("DeptName", deptName);
        return result;
    }

    public Map<String, Object> getDept(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer deptId = getIntegerValue(model.get("DeptId"));
        Integer empId = getIntegerValue(model.get("EmpId"));

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        Optional<DeptMaster> deptOpt = deptMasterRepository.findById(deptId);
        if (deptOpt.isEmpty()) {
            throw new RuntimeException("Department Details Not Found");
        }

        DeptMaster dm = deptOpt.get();
        result.put("DeptId", dm.getDeptId());
        result.put("DeptName", dm.getDeptName());
        result.put("DeptShortName", dm.getDeptShortName());
        result.put("IsActive", dm.getIsActive());
        result.put("IsUpdated", dm.getIsUpdated());
        result.put("IsDeleted", dm.getIsDeleted());
        return result;
    }

    public Map<String, Object> updateDept(Map<String, Object> model) {
        Map<String, Object> result = new HashMap<>();
        
        Object deptIdObj = model.get("DeptId");
        Object deptNameObj = model.get("DeptName");
        Object deptShortNameObj = model.get("DeptShortName");
        
        if (deptIdObj == null) {
            result.put("msg", "Department ID is required");
            return result;
        }
        
        Integer deptId;
        try {
            deptId = Integer.parseInt(deptIdObj.toString());
        } catch (NumberFormatException e) {
            result.put("msg", "Invalid Department ID");
            return result;
        }
        
        Optional<DeptMaster> deptOpt = deptMasterRepository.findById(deptId);
        if (deptOpt.isEmpty()) {
            result.put("msg", "Department not found");
            result.put("DeptId", 0);
            return result;
        }
        
        DeptMaster dept = deptOpt.get();
        if (deptNameObj != null) {
            dept.setDeptName(deptNameObj.toString());
        }
        if (deptShortNameObj != null) {
            dept.setDeptShortName(deptShortNameObj.toString());
        }
        dept.setIsUpdated(true);
        dept.setLastUpdatedDate(new Date());
        
        deptMasterRepository.save(dept);
        
        result.put("DeptId", 0);
        result.put("DeptName", dept.getDeptName());
        result.put("DeptShortName", null);
        result.put("msg", "Updated");
        result.put("CreatedBy", null);
        result.put("CreatedDate", null);
        result.put("LastUpdatedBy", null);
        result.put("LastUpdatedDate", null);
        result.put("IsActive", null);
        result.put("IsUpdated", null);
        result.put("IsDeleted", null);
        result.put("EmpId", 0);
        return result;
    }

    public List<Map<String, Object>> getAllDept(Map<String, Object> model) {
        Integer empId = getIntegerValue(model.get("EmpId"));

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        return deptMasterRepository.findAll().stream()
            .filter(d -> d.getIsDeleted() == null || !d.getIsDeleted())
            .filter(d -> d.getIsActive() == null || d.getIsActive())
            .map(d -> {
                Map<String, Object> m = new LinkedHashMap<>();
                m.put("DeptId", d.getDeptId());
                m.put("DeptName", d.getDeptName());
                m.put("DeptShortName", d.getDeptShortName());
                m.put("msg", null);
                m.put("CreatedBy", d.getCreatedBy());
                m.put("CreatedDate", d.getCreatedDate() != null ? "\\/Date(" + d.getCreatedDate().getTime() + ")\\/" : null);
                m.put("LastUpdatedBy", d.getLastUpdatedBy());
                m.put("LastUpdatedDate", d.getLastUpdatedDate() != null ? "\\/Date(" + d.getLastUpdatedDate().getTime() + ")\\/" : null);
                m.put("IsActive", d.getIsActive());
                m.put("IsUpdated", d.getIsUpdated());
                m.put("IsDeleted", d.getIsDeleted());
                m.put("EmpId", 0);
                return m;
            })
            .collect(Collectors.toList());
    }

    public List<Map<String, Object>> getDDDept() {
        return deptMasterRepository.findAll().stream()
            .filter(d -> d.getIsDeleted() == null || !d.getIsDeleted())
            .filter(d -> d.getIsActive() == null || d.getIsActive())
            .map(d -> {
                Map<String, Object> m = new LinkedHashMap<>();
                m.put("DeptId", d.getDeptId());
                m.put("DeptName", d.getDeptName());
                m.put("DeptShortName", d.getDeptShortName());
                m.put("EmpId", 0);
                return m;
            })
            .collect(Collectors.toList());
    }

    public List<Map<String, Object>> getDDAccess() {
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> m = new HashMap<>();
        m.put("id", 1);
        m.put("name", "View");
        result.add(m);
        m = new HashMap<>();
        m.put("id", 2);
        m.put("name", "Add");
        result.add(m);
        m = new HashMap<>();
        m.put("id", 3);
        m.put("name", "Update");
        result.add(m);
        m = new HashMap<>();
        m.put("id", 4);
        m.put("name", "Delete");
        result.add(m);
        return result;
    }

    public Map<String, Object> addAccess(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer empId = getIntegerValue(model.get("EmpId"));
        String accessName = model.get("AccessName") != null ? model.get("AccessName").toString() : "";
        Integer deptId = getIntegerValue(model.get("DeptId"));
        Integer roleId = getIntegerValue(model.get("RoleId"));
        Integer moduleId = getIntegerValue(model.get("ModuleId"));
        Integer subModuleId = getIntegerValue(model.get("SubModuleId"));
        Integer pageModuleId = getIntegerValue(model.get("PageModuleId"));
        Boolean addAccess = model.get("AddAccess") != null ? Boolean.parseBoolean(model.get("AddAccess").toString()) : false;
        Boolean updateAccess = model.get("UpdateAccess") != null ? Boolean.parseBoolean(model.get("UpdateAccess").toString()) : false;
        Boolean deleteAccess = model.get("DeleteAccess") != null ? Boolean.parseBoolean(model.get("DeleteAccess").toString()) : false;
        Boolean viewAccess = model.get("ViewAccess") != null ? Boolean.parseBoolean(model.get("ViewAccess").toString()) : false;

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        List<AccessPolicy> existing = accessPolicyRepository.findAll().stream()
            .filter(a -> a.getAccessName() != null && a.getAccessName().equals(accessName))
            .filter(a -> Boolean.TRUE.equals(a.getIsActive()) && (a.getIsDeleted() == null || !a.getIsDeleted()))
            .collect(Collectors.toList());

        if (!existing.isEmpty()) {
            throw new RuntimeException("Access Details Already Exists");
        }

        AccessPolicy ap = new AccessPolicy();
        ap.setAccessName(accessName);
        ap.setDeptId(deptId != 0 ? deptId : null);
        ap.setRoleId(roleId != 0 ? roleId : null);
        ap.setModuleId(moduleId != 0 ? moduleId : null);
        ap.setSubModuleId(subModuleId != 0 ? subModuleId : null);
        ap.setPageModuleId(pageModuleId != 0 ? pageModuleId : null);
        ap.setAddAccess(addAccess);
        ap.setUpdateAccess(updateAccess);
        ap.setDeleteAccess(deleteAccess);
        ap.setViewAccess(viewAccess);
        ap.setIsActive(true);
        ap.setIsUpdated(false);
        ap.setIsDeleted(false);
        ap.setCreatedBy(empId);
        ap.setCreatedDate(new Date());
        ap.setLastUpdatedBy(empId);
        ap.setLastUpdatedDate(new Date());
        accessPolicyRepository.save(ap);

        result.put("msg", "Added");
        result.put("AccessName", accessName);
        return result;
    }

    public Map<String, Object> updateAccess(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer empId = getIntegerValue(model.get("EmpId"));
        Integer accessId = getIntegerValue(model.get("AccessId"));
        String accessName = model.get("AccessName") != null ? model.get("AccessName").toString() : "";
        Integer deptId = getIntegerValue(model.get("DeptId"));
        Integer roleId = getIntegerValue(model.get("RoleId"));
        Integer moduleId = getIntegerValue(model.get("ModuleId"));
        Integer subModuleId = getIntegerValue(model.get("SubModuleId"));
        Integer pageModuleId = getIntegerValue(model.get("PageModuleId"));
        Boolean addAccess = model.get("AddAccess") != null ? Boolean.parseBoolean(model.get("AddAccess").toString()) : false;
        Boolean updateAccess = model.get("UpdateAccess") != null ? Boolean.parseBoolean(model.get("UpdateAccess").toString()) : false;
        Boolean deleteAccess = model.get("DeleteAccess") != null ? Boolean.parseBoolean(model.get("DeleteAccess").toString()) : false;
        Boolean viewAccess = model.get("ViewAccess") != null ? Boolean.parseBoolean(model.get("ViewAccess").toString()) : false;

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        Optional<AccessPolicy> accessOpt = accessPolicyRepository.findById(accessId);
        if (accessOpt.isEmpty()) {
            throw new RuntimeException("Access Details Not Found");
        }

        AccessPolicy ap = accessOpt.get();
        ap.setAccessName(accessName);
        ap.setDeptId(deptId != 0 ? deptId : null);
        ap.setRoleId(roleId != 0 ? roleId : null);
        ap.setModuleId(moduleId != 0 ? moduleId : null);
        ap.setSubModuleId(subModuleId != 0 ? subModuleId : null);
        ap.setPageModuleId(pageModuleId != 0 ? pageModuleId : null);
        ap.setAddAccess(addAccess);
        ap.setUpdateAccess(updateAccess);
        ap.setDeleteAccess(deleteAccess);
        ap.setViewAccess(viewAccess);
        ap.setIsActive(true);
        ap.setIsUpdated(true);
        ap.setIsDeleted(false);
        ap.setLastUpdatedBy(empId);
        ap.setLastUpdatedDate(new Date());
        accessPolicyRepository.save(ap);

        result.put("msg", "Updated");
        result.put("AccessName", accessName);
        return result;
    }

    public Map<String, Object> deleteAccess(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer empId = getIntegerValue(model.get("EmpId"));
        Integer accessId = getIntegerValue(model.get("AccessId"));
        String accessName = model.get("AccessName") != null ? model.get("AccessName").toString() : "";

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        Optional<AccessPolicy> accessOpt = accessPolicyRepository.findById(accessId);
        if (accessOpt.isEmpty()) {
            throw new RuntimeException("Access Details Not Found");
        }

        AccessPolicy ap = accessOpt.get();
        ap.setIsDeleted(true);
        ap.setLastUpdatedBy(empId);
        ap.setLastUpdatedDate(new Date());
        accessPolicyRepository.save(ap);

        result.put("msg", "Deleted");
        result.put("AccessName", accessName);
        return result;
    }

    public Map<String, Object> getAccess(Map<String, Object> model) {
        Map<String, Object> result = new LinkedHashMap<>();
        Integer accessId = getIntegerValue(model.get("AccessId"));
        Integer empId = getIntegerValue(model.get("EmpId"));

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        Optional<AccessPolicy> accessOpt = accessPolicyRepository.findById(accessId);
        if (accessOpt.isEmpty()) {
            throw new RuntimeException("Access Details Not Found");
        }

        AccessPolicy ap = accessOpt.get();
        result.put("AccessId", ap.getAccessId());
        result.put("AccessName", ap.getAccessName());
        result.put("DeptId", ap.getDeptId());
        result.put("RoleId", ap.getRoleId());
        result.put("ModuleId", ap.getModuleId());
        result.put("SubModuleId", ap.getSubModuleId());
        result.put("PageModuleId", ap.getPageModuleId());
        result.put("AddAccess", ap.getAddAccess());
        result.put("UpdateAccess", ap.getUpdateAccess());
        result.put("DeleteAccess", ap.getDeleteAccess());
        result.put("ViewAccess", ap.getViewAccess());
        result.put("IsActive", ap.getIsActive());
        result.put("IsUpdated", ap.getIsUpdated());
        result.put("IsDeleted", ap.getIsDeleted());
        return result;
    }

    public List<Map<String, Object>> getAllAccess(Map<String, Object> model) {
        Integer empId = getIntegerValue(model.get("EmpId"));

        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        List<AccessPolicy> policies = accessPolicyRepository.findAll().stream()
            .filter(a -> a.getIsDeleted() == null || !a.getIsDeleted())
            .filter(a -> a.getIsActive() == null || a.getIsActive())
            .collect(Collectors.toList());

        List<Integer> deptIds = policies.stream().map(AccessPolicy::getDeptId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
        List<Integer> roleIds = policies.stream().map(AccessPolicy::getRoleId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
        List<Integer> moduleIds = policies.stream().map(AccessPolicy::getModuleId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
        List<Integer> subModuleIds = policies.stream().map(AccessPolicy::getSubModuleId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
        List<Integer> pageModuleIds = policies.stream().map(AccessPolicy::getPageModuleId).filter(Objects::nonNull).distinct().collect(Collectors.toList());

        Map<Integer, DeptMaster> depts = deptIds.isEmpty() ? new HashMap<>() :
            deptMasterRepository.findAllById(deptIds).stream().collect(Collectors.toMap(DeptMaster::getDeptId, d -> d));
        Map<Integer, DesignationMaster> roles = roleIds.isEmpty() ? new HashMap<>() :
            designationMasterRepository.findAllById(roleIds).stream().collect(Collectors.toMap(DesignationMaster::getDesignationId, r -> r));
        Map<Integer, ModuleMaster> modules = moduleIds.isEmpty() ? new HashMap<>() :
            moduleMasterRepository.findAllById(moduleIds).stream().collect(Collectors.toMap(ModuleMaster::getModuleId, m -> m));
        Map<Integer, SubModuleMaster> subModules = subModuleIds.isEmpty() ? new HashMap<>() :
            subModuleMasterRepository.findAllById(subModuleIds).stream().collect(Collectors.toMap(SubModuleMaster::getSubModuleId, s -> s));
        Map<Integer, PageModuleMaster> pageModules = pageModuleIds.isEmpty() ? new HashMap<>() :
            pageModuleMasterRepository.findAllById(pageModuleIds).stream().collect(Collectors.toMap(PageModuleMaster::getPageModuleId, p -> p));

        return policies.stream().map(a -> {
            Map<String, Object> r = new LinkedHashMap<>();
            r.put("AccessId", a.getAccessId());
            r.put("AccessName", a.getAccessName());
            r.put("DeptId", a.getDeptId());
            DeptMaster dept = depts.get(a.getDeptId());
            r.put("DeptName", dept != null ? dept.getDeptName() : null);
            r.put("RoleId", a.getRoleId());
            DesignationMaster role = roles.get(a.getRoleId());
            r.put("RoleName", role != null ? role.getDesignation() : null);
            r.put("ModuleId", a.getModuleId());
            ModuleMaster module = modules.get(a.getModuleId());
            r.put("ModuleName", module != null ? module.getModuleName() : null);
            r.put("SubModuleId", a.getSubModuleId());
            SubModuleMaster subModule = subModules.get(a.getSubModuleId());
            r.put("SubModuleName", subModule != null ? subModule.getSubModuleName() : null);
            r.put("PageModuleId", a.getPageModuleId());
            PageModuleMaster pageModule = pageModules.get(a.getPageModuleId());
            r.put("PageName", pageModule != null ? pageModule.getPageName() : null);
            r.put("AddAccess", Boolean.TRUE.equals(a.getAddAccess()));
            r.put("UpdateAccess", Boolean.TRUE.equals(a.getUpdateAccess()));
            r.put("DeleteAccess", Boolean.TRUE.equals(a.getDeleteAccess()));
            r.put("ViewAccess", Boolean.TRUE.equals(a.getViewAccess()));
            r.put("msg", null);
            r.put("CreatedBy", a.getCreatedBy());
            r.put("CreatedDate", a.getCreatedDate() != null ? "\\/Date(" + a.getCreatedDate().getTime() + ")\\/" : null);
            r.put("LastUpdatedBy", a.getLastUpdatedBy());
            r.put("LastUpdatedDate", a.getLastUpdatedDate() != null ? "\\/Date(" + a.getLastUpdatedDate().getTime() + ")\\/" : null);
            r.put("IsActive", a.getIsActive());
            r.put("IsUpdated", a.getIsUpdated());
            r.put("IsDeleted", a.getIsDeleted());
            r.put("EmpId", 0);
            return r;
        }).collect(Collectors.toList());
    }

    public List<Map<String, Object>> getAccessPolicy(Map<String, Object> model) {
        List<Map<String, Object>> result = new ArrayList<>();

        Object empIdObj = model.get("EmpId");
        Integer empId = 0;
        if (empIdObj != null) {
            try {
                empId = Integer.parseInt(empIdObj.toString());
            } catch (NumberFormatException e) {
                empId = 0;
            }
        }

        if (empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        Optional<EmployeeMaster> empOpt = employeeMasterRepository.findById(empId);
        if (empOpt.isEmpty()) {
            throw new RuntimeException("Employee not found");
        }

        EmployeeMaster emp = empOpt.get();
        Integer categoryId = emp.getCategoryId();
        Integer designationId = emp.getDesignationId();

        List<AccessPolicy> policies = accessPolicyRepository.findAll().stream()
            .filter(p -> Boolean.TRUE.equals(p.getIsActive()) && (p.getIsDeleted() == null || !p.getIsDeleted()))
            .filter(p -> p.getDeptId() != null && p.getDeptId().equals(categoryId))
            .filter(p -> p.getRoleId() != null && p.getRoleId().equals(designationId))
            .collect(Collectors.toList());

        if (policies.isEmpty()) {
            throw new RuntimeException("Access Policies Details Not Found");
        }

        List<Integer> deptIds = policies.stream().map(AccessPolicy::getDeptId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
        List<Integer> roleIds = policies.stream().map(AccessPolicy::getRoleId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
        List<Integer> moduleIds = policies.stream().map(AccessPolicy::getModuleId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
        List<Integer> subModuleIds = policies.stream().map(AccessPolicy::getSubModuleId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
        List<Integer> pageModuleIds = policies.stream().map(AccessPolicy::getPageModuleId).filter(Objects::nonNull).distinct().collect(Collectors.toList());

        Map<Integer, DeptMaster> depts = deptIds.isEmpty() ? new HashMap<>() :
            deptMasterRepository.findAllById(deptIds).stream().collect(Collectors.toMap(DeptMaster::getDeptId, d -> d));
        Map<Integer, DesignationMaster> roles = roleIds.isEmpty() ? new HashMap<>() :
            designationMasterRepository.findAllById(roleIds).stream().collect(Collectors.toMap(DesignationMaster::getDesignationId, r -> r));
        Map<Integer, ModuleMaster> modules = moduleIds.isEmpty() ? new HashMap<>() :
            moduleMasterRepository.findAllById(moduleIds).stream().collect(Collectors.toMap(ModuleMaster::getModuleId, m -> m));
        Map<Integer, SubModuleMaster> subModules = subModuleIds.isEmpty() ? new HashMap<>() :
            subModuleMasterRepository.findAllById(subModuleIds).stream().collect(Collectors.toMap(SubModuleMaster::getSubModuleId, s -> s));
        Map<Integer, PageModuleMaster> pageModules = pageModuleIds.isEmpty() ? new HashMap<>() :
            pageModuleMasterRepository.findAllById(pageModuleIds).stream().collect(Collectors.toMap(PageModuleMaster::getPageModuleId, p -> p));

        for (AccessPolicy policy : policies) {
            Map<String, Object> m = new HashMap<>();
            m.put("AccessId", policy.getAccessId());
            m.put("AccessName", policy.getAccessName());
            m.put("DeptId", policy.getDeptId());
            DeptMaster dept = depts.get(policy.getDeptId());
            m.put("DeptName", dept != null ? dept.getDeptName() : "");
            m.put("DeptShortName", dept != null ? dept.getDeptShortName() : "");
            m.put("RoleId", policy.getRoleId());
            DesignationMaster role = roles.get(policy.getRoleId());
            m.put("RoleName", role != null ? role.getDesignation() : "");
            m.put("ModuleId", policy.getModuleId());
            ModuleMaster module = modules.get(policy.getModuleId());
            m.put("ModuleName", module != null ? module.getModuleName() : "");
            m.put("SubModuleId", policy.getSubModuleId());
            SubModuleMaster subModule = subModules.get(policy.getSubModuleId());
            m.put("SubModuleName", subModule != null ? subModule.getSubModuleName() : "");
            m.put("PageModuleId", policy.getPageModuleId());
            PageModuleMaster pageModule = pageModules.get(policy.getPageModuleId());
            m.put("PageName", pageModule != null ? pageModule.getPageName() : "");
            m.put("AddAccess", Boolean.TRUE.equals(policy.getAddAccess()));
            m.put("UpdateAccess", Boolean.TRUE.equals(policy.getUpdateAccess()));
            m.put("DeleteAccess", Boolean.TRUE.equals(policy.getDeleteAccess()));
            m.put("ViewAccess", Boolean.TRUE.equals(policy.getViewAccess()));
            m.put("EmpId", 0);

            result.add(m);
        }

        return result;
    }

    public List<Map<String, Object>> getDDCompany() {
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> m = new HashMap<>();
        m.put("id", 1);
        m.put("name", "Company");
        result.add(m);
        return result;
    }

    public List<Map<String, Object>> getDDEmployee() {
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> m = new HashMap<>();
        m.put("id", 1);
        m.put("name", "Employee");
        result.add(m);
        return result;
    }

    public List<Map<String, Object>> getDDDeptEmployee() {
        return getDDEmployee();
    }

    public List<DDDesignationViewModel> getDDDesignation(Integer empId, Integer deptId) {
        if (empId == null || empId == 0) {
            throw new RuntimeException("EmpId is Missing");
        }

        List<DesignationMaster> designations;
        if (deptId != null && deptId != 0) {
            designations = designationMasterRepository.findAll().stream()
                .filter(d -> d.getDeptId() != null && d.getDeptId() == deptId)
                .filter(d -> d.getIsActive() != null && d.getIsActive())
                .filter(d -> d.getIsDeleted() == null || !d.getIsDeleted())
                .collect(Collectors.toList());
        } else {
            designations = designationMasterRepository.findAll().stream()
                .filter(d -> d.getIsActive() != null && d.getIsActive())
                .filter(d -> d.getIsDeleted() == null || !d.getIsDeleted())
                .collect(Collectors.toList());
        }

        if (designations.isEmpty()) {
            throw new RuntimeException("Role Details Not Found");
        }

        return designations.stream()
            .map(d -> {
                DDDesignationViewModel vm = new DDDesignationViewModel();
                vm.setDeptId(d.getDeptId() != null ? d.getDeptId() : 0);
                vm.setDesignationId(d.getDesignationId());
                vm.setDesignation(d.getDesignation());
                vm.setEmpId(0);
                return vm;
            })
            .collect(Collectors.toList());
    }

    public List<Map<String, Object>> getDDGrade() {
        List<Map<String, Object>> result = new ArrayList<>();
        for (int gradeId = 1; gradeId <= 25; gradeId++) {
            Map<String, Object> m = new HashMap<>();
            m.put("GradeId", gradeId);
            m.put("Grade", "Grade-" + gradeId);
            m.put("EmpId", 0);
            result.add(m);
        }
        return result;
    }
}