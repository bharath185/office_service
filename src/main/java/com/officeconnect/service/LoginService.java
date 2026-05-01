package com.officeconnect.service;

import com.officeconnect.config.JwtAuthenticationFilter;
import com.officeconnect.dto.CheckAuthViewModel;
import com.officeconnect.dto.EmployeeMasterViewModel;
import com.officeconnect.dto.FRViewModel;
import com.officeconnect.dto.LoginDetailsViewModel;
import com.officeconnect.dto.LoginViewModel;
import com.officeconnect.entity.*;
import com.officeconnect.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginService {

    // Helper method to format date as /Date(timestamp)/
    private Object formatDate(Date date) {
        if (date == null) {
            return null;
        }
        return "/Date(" + date.getTime() + ")/";
    }

    // Helper method to capitalize first letter
    private String capitalizeFirst(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    @Autowired
    private EmployeeMasterRepository employeeMasterRepository;

    @Autowired
    private SessionMasterRepository sessionMasterRepository;

    @Autowired
    private CompanyMasterRepository companyMasterRepository;

    @Autowired
    private CPwdManagementRepository cpwdManagementRepository;

    @Autowired
    private FPwdManagementRepository fpwdManagementRepository;

    @Autowired
    private PassHistoryManagementRepository passHistoryManagementRepository;

    @Autowired
    private EmailSetUpRepository emailSetUpRepository;

    public EmployeeMasterViewModel checkLogin(LoginViewModel loginUser) {
        if (loginUser == null || loginUser.getUserName() == null || loginUser.getPassword() == null ||
            loginUser.getUserName().isEmpty() || loginUser.getPassword().isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Invalid Input Parameters\"}");
        }

        String username = loginUser.getUserName();
        String password = loginUser.getPassword();

        List<EmployeeMaster> empDetails = employeeMasterRepository.findActiveUserByUserName(username);

        if (empDetails == null || empDetails.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"UserName is Mismatching\"}");
        }

        EmployeeMaster emp = empDetails.get(0);
        int empId = emp.getEmpId();
        Integer oldEmpId = emp.getOldEmp_ID();
        Integer leId = emp.getLeId();

        // Find authorized employees
        List<EmployeeMaster> authorizedEmp = null;
        if (leId != null && leId == 1) {
            authorizedEmp = employeeMasterRepository.findByReportIdAndEmpCodeStartingWith(oldEmpId, "3DCAD-");
            if (authorizedEmp == null || authorizedEmp.isEmpty()) {
                authorizedEmp = employeeMasterRepository.findByReportIdAndEmpCodeStartingWith(oldEmpId, "3DCADVS-");
            }
            if (authorizedEmp == null || authorizedEmp.isEmpty()) {
                authorizedEmp = employeeMasterRepository.findByReportIdAndEmpCodeStartingWith(oldEmpId, "3DCADPU-");
            }
            if (authorizedEmp == null || authorizedEmp.isEmpty()) {
                authorizedEmp = employeeMasterRepository.findByReportId(oldEmpId);
            }
        } else {
            authorizedEmp = employeeMasterRepository.findByReportIdAndEmpCodeStartingWith(empId, "RIM-");
        }

EmployeeMasterViewModel userDetails = new EmployeeMasterViewModel();
        userDetails.setCompId(emp.getCompId());
        if (emp.getCompId() != null) {
            Optional<CompanyMaster> company = companyMasterRepository.findById(emp.getCompId());
            company.ifPresent(c -> userDetails.setCompany(c.getCompany()));
        }
        userDetails.setOldEmp_ID(null);
        userDetails.setLeId(null);
        userDetails.setLegalEntity(null);
        userDetails.setBuId(null);
        userDetails.setBusinessUnit(null);
        userDetails.setLocationId(null);
        userDetails.setLocation(null);
        userDetails.setCategoryId(null);
        userDetails.setDeptId(emp.getCategoryId());
        userDetails.setDeptName(emp.getDeptName());
        userDetails.setDesignationId(emp.getDesignationId());
        userDetails.setDesignation(emp.getDesignationName());
        userDetails.setEmpId(emp.getEmpId());
        userDetails.setLoginId(emp.getEmpId());
        userDetails.setEmpCode(emp.getEmpCode());
        userDetails.setUserName(emp.getUserName());
        String plainPassword = emp.getPassword();
        if (plainPassword != null) {
            String encoded = Base64.getEncoder().encodeToString(plainPassword.getBytes(StandardCharsets.UTF_16LE));
            userDetails.setPassword(encoded);
        } else {
            userDetails.setPassword(null);
        }
        userDetails.setPhoto(null);
        userDetails.setSalutationId(null);
        userDetails.setSalutation(null);
        userDetails.setFirstName(emp.getFirstName());
        userDetails.setMiddleName(emp.getMiddleName());
        userDetails.setLastName(emp.getLastName());
        userDetails.setDob(formatDate(emp.getDob()));
        userDetails.setMobileNo(emp.getMobileNo());
        userDetails.setEmailId(emp.getEmailId());
        userDetails.setBloodGroup(null);
        userDetails.setMaritalStatus(null);
        userDetails.setGender(capitalizeFirst(emp.getGender()));
        userDetails.setInterviewDate(null);
        userDetails.setJoiningDate(formatDate(emp.getJoiningDate()));
        userDetails.setEndDate(null);
        userDetails.setEmpStatus(emp.getEmpStatus());
        userDetails.setReason(null);
        userDetails.setEmpType(null);
        userDetails.setEmpTypeId(null);
        userDetails.setcEndDate(null);
        userDetails.setcPwd(false);
        userDetails.setOnSiteLogInId(null);
        userDetails.setOnSiteLogInDate(null);
        userDetails.setOnSiteLogOutDate(null);
        userDetails.setOnSiteLogInTime(null);
        userDetails.setOnSiteLogOutTime(null);
        userDetails.setOnSiteStatus(null);
        userDetails.setAuthorisedEntity(null);
        userDetails.setRelievedReason(null);
        userDetails.setRelievedDate(null);
        userDetails.setRelievedEffectiveDate(null);
        userDetails.setIsRelieved(null);
        userDetails.setFromDate(null);
        userDetails.setToDate(null);
        userDetails.setStatus(null);
        userDetails.setReportId(emp.getReportId());
        userDetails.setApproverId(null);
        userDetails.setApprover(null);
        userDetails.setReportEmpCode(null);
        userDetails.setReportEmpName(null);

        if (emp.getReportId() != null) {
            Optional<EmployeeMaster> reporter = employeeMasterRepository.findById(emp.getReportId());
            reporter.ifPresent(r -> userDetails.setReportEmpCode(r.getEmpCode()));
        }

        if (authorizedEmp != null && !authorizedEmp.isEmpty()) {
            userDetails.setAuthorised(true);
        } else {
            userDetails.setAuthorised(false);
        }

        userDetails.setIsActive(emp.getIsActive());
        userDetails.setIsUpdated(emp.getIsUpdated());
        userDetails.setIsDeleted(emp.getIsDeleted());
        userDetails.setIsProbation(null);
        userDetails.setIsProbationConfirm(null);
        userDetails.setProbationConfirmationEffectiveDate(null);
        userDetails.setProbationConfirmationDate(null);
        userDetails.setProbationRemarks(null);
        userDetails.setProbationConfirmationStatus(null);
        userDetails.setMsg(null);
        userDetails.setCreatedBy(emp.getCreatedBy());
        userDetails.setCreatedDate(formatDate(emp.getCreatedDate()));
        userDetails.setLastUpdatedBy(emp.getLastUpdatedBy());
        userDetails.setLastUpdatedDate(formatDate(emp.getLastUpdatedDate()));
        userDetails.setcPwd(false);

        // Check if has compulsory password changed
        try {
            List<CPwdManagement> cpwdList = cpwdManagementRepository.findActiveCPwdByEmpCode(username);
            if (cpwdList != null && !cpwdList.isEmpty()) {
                userDetails.setcPwd(true);
            }
        } catch (Exception e) {
            // Skip if table doesn't exist
        }

        // Generate tokens - handle null designationId
        String userName = userDetails.getUserName();
        Integer roleId = userDetails.getDesignationId();
        String roleIdStr = (roleId != null) ? String.valueOf(roleId) : "1";
        
        String tokenId = JwtAuthenticationFilter.encodeAuthToken(userName);
        String userAuth = JwtAuthenticationFilter.encodeToken(userName, roleIdStr);
        
        userDetails.setTokenId(tokenId);
        userDetails.setUserAuth(userAuth);
        
        System.out.println("=== TOKEN GENERATED ===");
        System.out.println("TokenId: " + tokenId);
        System.out.println("UserAuth: " + userAuth);

        // Verify password
        try {
            String storedPassword = emp.getPassword();
            boolean passwordMatch = false;
            
            if (storedPassword != null) {
                try {
                    byte[] decrypted = Base64.getDecoder().decode(storedPassword);
                    String decryptedPassword = new String(decrypted, StandardCharsets.UTF_16);
                    if (decryptedPassword.trim().equals(password.trim())) {
                        passwordMatch = true;
                    }
                } catch (Exception e) {
                    // Not base64, try plain match
                }
                
                if (!passwordMatch && storedPassword.equals(password)) {
                    passwordMatch = true;
                }
            }
            
            if (!passwordMatch) {
                throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Password is Mismatching\"}");
            }
            
            SessionMaster session = new SessionMaster();
            session.setUsername(username);
            session.setTockenId(userDetails.getTokenId());
            session.setAuthKey(userDetails.getUserAuth());
            session.setRoleId(userDetails.getDesignationId());
            session.setStatus(true);
            session.setExpired(false);
            session.setWfh(false);
            session.setIsActive(true);
            session.setIsDeleted(false);
            session.setCreatedDate(new Date());
            session.setLastUpdatedDate(new Date());
            sessionMasterRepository.save(session);

            return userDetails;
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Password is Mismatching\"}");
        }
    }

    public List<Map<String, Object>> getAllWFHDays(Map<String, Object> model) {
        List<Map<String, Object>> list = new java.util.ArrayList<>();
        Map<String, Object> day = new java.util.HashMap<>();
        day.put("day", "2026-01-01");
        day.put("status", "Planned");
        list.add(day);
        return list;
    }

    public EmployeeMasterViewModel checkLogOut(LoginViewModel loginUser) {
        if (loginUser == null || loginUser.getUserName() == null || loginUser.getUserName().isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"Not Found\"}");
        }

        String username = loginUser.getUserName();
        String token = loginUser.getTokenId();
        String authKey = loginUser.getAuthKey();
        Integer roleId = loginUser.getRoleId();

        List<EmployeeMaster> empDetails = employeeMasterRepository.findActiveUserByUserName(username);
        if (empDetails == null || empDetails.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"User is Not Found\"}");
        }

        EmployeeMaster emp = empDetails.get(0);
        EmployeeMasterViewModel userDetails = new EmployeeMasterViewModel();
        userDetails.setEmpId(emp.getEmpId());
        userDetails.setCompId(0);
        userDetails.setCategoryId(0);
        userDetails.setDesignationId(0);
        userDetails.setEmpCode(emp.getEmpCode());
        userDetails.setUserName(emp.getUserName());
        userDetails.setEmpStatus(emp.getEmpStatus());
        userDetails.setTokenId("Expired");

        // Find and update session
        Optional<SessionMaster> sessionOpt = sessionMasterRepository.findActiveSessionByUsernameAndToken(username, token);
        if (sessionOpt.isPresent()) {
            SessionMaster session = sessionOpt.get();
            Optional<SessionMaster> sessionWithAuth = sessionMasterRepository.findActiveSessionByUsernameTokenAuthKeyAndRole(username, token, authKey, roleId);
            if (sessionWithAuth.isPresent()) {
                SessionMaster s = sessionWithAuth.get();
                s.setExpired(true);
                s.setLastUpdatedDate(new Date());
                sessionMasterRepository.save(s);
            } else {
                throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"User Authorization is Failed\"}");
            }
        } else {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"User Token is Expired\"}");
        }

        return userDetails;
    }

    public CheckAuthViewModel checkAuth(LoginViewModel loginUser) {
        String username = loginUser.getUserName();

        List<EmployeeMaster> empDetails = employeeMasterRepository.findActiveUserByUserName(username);
        if (empDetails == null || empDetails.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"UserName is Mismatching\"}");
        }

        CheckAuthViewModel checkAuth = new CheckAuthViewModel();
        checkAuth.setUserName(username);
        checkAuth.setTokenId("Success");
        checkAuth.setAuthKey("Success");

        return checkAuth;
    }

    public FRViewModel forgetPassword(FRViewModel model) {
        if (model.getUserName() == null || model.getUserName().isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"UserName is Mismatching\"}");
        }

        String username = model.getUserName();
        String email = model.getEmail();

        List<EmployeeMaster> empDetails = employeeMasterRepository.findActiveUserByUserName(username);
        if (empDetails == null || empDetails.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"User is not found\"}");
        }

        EmployeeMaster emp = empDetails.get(0);
        if (!email.equals(emp.getEmailId())) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"EmailId is Mismatching\"}");
        }

        String otp = generateSecureOTP();

        // Save OTP
        FPwdManagement fpm = new FPwdManagement();
        fpm.setEmpId(emp.getEmpId());
        fpm.setEmpCode(username);
        fpm.setOtp(otp);
        fpm.setExpired(false);
        fpm.setCreatedBy(emp.getEmpId());
        fpm.setCreatedDate(new Date());
        fpm.setLastUpdatedBy(emp.getEmpId());
        fpm.setLastUpdatedDate(new Date());
        fpm.setIsActive(true);
        fpm.setIsUpdated(false);
        fpm.setIsDeleted(false);
        fpwdManagementRepository.save(fpm);

        FRViewModel frvm = new FRViewModel();
        frvm.setMsg("OTP Send successfully");
        frvm.setOtp(otp);
        frvm.setUserName(username);

        return frvm;
    }

    public FRViewModel fpwdVerify(FRViewModel model) {
        String username = model.getUserName();
        String otp = model.getOtp();

        Optional<FPwdManagement> fpwdDetails = fpwdManagementRepository.findActiveByEmpCodeAndOtp(username, otp);
        if (fpwdDetails.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"OTP is Invalid\"}");
        }

        // Expire all OTPs for this user
        List<FPwdManagement> fpwdList = fpwdManagementRepository.findActiveByEmpCode(username);
        for (FPwdManagement f : fpwdList) {
            f.setExpired(true);
            f.setIsUpdated(true);
            f.setLastUpdatedDate(new Date());
            fpwdManagementRepository.save(f);
        }

        EmployeeMaster emp = employeeMasterRepository.findActiveUserByUserName(username).get(0);

        FRViewModel frvm = new FRViewModel();
        frvm.setMsg("OTP Verified");
        frvm.setUserName(username);
        frvm.setEmpId(emp.getEmpId());
        frvm.setEmpCode(emp.getEmpCode());

        return frvm;
    }

    public FRViewModel changePassword(FRViewModel model) {
        String empCode = model.getUserName();
        String newPassword = model.getOtp(); // Using OTP field for new password
        Boolean fpwd = model.getMsg() != null && model.getMsg().equals("FPwd");

        List<EmployeeMaster> empDetails = employeeMasterRepository.findActiveUserByUserName(empCode);
        if (empDetails == null || empDetails.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"User details is Mismatching\"}");
        }

        EmployeeMaster emp = empDetails.get(0);

        // Update password
        String encodedPassword = Base64.getEncoder().encodeToString(newPassword.getBytes(StandardCharsets.UTF_16));
        emp.setPassword(encodedPassword);
        emp.setIsUpdated(true);
        emp.setLastUpdatedBy(emp.getEmpId());
        emp.setLastUpdatedDate(new Date());
        employeeMasterRepository.save(emp);

        // Create history
        PassHistoryManagement phm = new PassHistoryManagement();
        phm.setEmpId(emp.getEmpId());
        phm.setEmpCode(empCode);
        phm.setOldPassword(emp.getPassword());
        phm.setNewPassword(newPassword);
        phm.setFpwd(fpwd);
        phm.setCpwd(!fpwd);
        phm.setExpired(false);
        phm.setCreatedBy(emp.getEmpId());
        phm.setCreatedDate(new Date());
        phm.setIsActive(true);
        phm.setIsUpdated(false);
        phm.setIsDeleted(false);
        passHistoryManagementRepository.save(phm);

        FRViewModel frvm = new FRViewModel();
        frvm.setMsg("Password Changed");
        frvm.setEmpCode(empCode);

        return frvm;
    }

    private String generateSecureOTP() {
        int randomNumber = (int) (Math.random() * 900000) + 100000;
        return String.valueOf(randomNumber);
    }

    public LoginDetailsViewModel getLoginDetails(LoginDetailsViewModel model) {
        String username = model.getUserName();
        if (username == null || username.isEmpty()) {
            throw new RuntimeException("{\"StatusCode\":404,\"Message\":\"UserName is Mismatching\"}");
        }

        LoginDetailsViewModel ldvm = new LoginDetailsViewModel();
        ldvm.setUserName(username);
        ldvm.setEmpCode(username);
        ldvm.setMode("");
        ldvm.setDate("");
        ldvm.setTime("");

        return ldvm;
    }

    public Map<String, Object> getAllWFHDetails(Map<String, Object> model) {
        Map<String, Object> result = new java.util.HashMap<>();
        result.put("msg", "WFH details retrieved");
        return result;
    }

    public Map<String, Object> getAllWFHAnalysis(Map<String, Object> model) {
        Map<String, Object> result = new java.util.HashMap<>();
        result.put("msg", "WFH analysis retrieved");
        return result;
    }

    public Map<String, Object> getAllWFHFilterDetails(Map<String, Object> model) {
        Map<String, Object> result = new java.util.HashMap<>();
        result.put("msg", "WFH filter details retrieved");
        return result;
    }

    public Map<String, Object> saveWFHAnalysis(Map<String, Object> model) {
        Map<String, Object> result = new java.util.HashMap<>();
        result.put("msg", "WFH analysis saved");
        return result;
    }

    public Map<String, Object> wfhEmpList(Map<String, Object> model) {
        Map<String, Object> result = new java.util.HashMap<>();
        result.put("msg", "WFH employee list retrieved");
        return result;
    }

    public Map<String, Object> viewScreenShots(Map<String, Object> model) {
        Map<String, Object> result = new java.util.HashMap<>();
        result.put("msg", "Screen shots retrieved");
        return result;
    }
}
