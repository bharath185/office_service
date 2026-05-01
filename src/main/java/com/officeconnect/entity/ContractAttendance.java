package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ContractAttendance")
public class ContractAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CId")
    private Integer cId;

    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "Mobile")
    private String mobile;

    @Column(name = "Mail")
    private String mail;

    @Column(name = "EmpCode")
    private String empCode;

    @Column(name = "EmpName")
    private String empName;

    @Column(name = "Skill")
    private String skill;

    @Column(name = "VendorId")
    private Integer vendorId;

    @Column(name = "VendorCode")
    private String vendorCode;

    @Column(name = "Vendor")
    private String vendor;

    @Column(name = "ProjectId")
    private Integer projectId;

    @Column(name = "ProjectCode")
    private String projectCode;

    @Column(name = "Project")
    private String project;

    @Column(name = "SiteId")
    private Integer siteId;

    @Column(name = "Site")
    private String site;

    @Column(name = "SiteDetails")
    private String siteDetails;

    @Column(name = "ManagerId")
    private Integer managerId;

    @Column(name = "ManagerEmpCode")
    private String managerEmpCode;

    @Column(name = "ManagerName")
    private String managerName;

    @Column(name = "Status")
    private Boolean status;

    @Column(name = "IsLogin")
    private Boolean isLogin;

    @Column(name = "IsLogout")
    private Boolean isLogout;

    @Column(name = "LoginTime")
    private String loginTime;

    @Column(name = "LogoutTime")
    private String logoutTime;

    @Column(name = "Activehrs")
    private String activehrs;

    @Column(name = "Approvedhrs")
    private String approvedhrs;

    @Column(name = "LoginAddress")
    private String loginAddress;

    @Column(name = "LoginLonqitude")
    private String loginLonqitude;

    @Column(name = "LoginLatitude")
    private String loginLatitude;

    @Column(name = "LogoutAddress")
    private String logoutAddress;

    @Column(name = "LogoutLonqitude")
    private String logoutLonqitude;

    @Column(name = "LogoutLatitude")
    private String logoutLatitude;

    @Column(name = "IsLogoutManager")
    private Boolean isLogoutManager;

    @Column(name = "IsApproved")
    private Boolean isApproved;

    @Column(name = "Description")
    private String description;

    @Column(name = "ManPowerApproval")
    private String manPowerApproval;

    @Column(name = "CreatedBy")
    private Integer createdBy;

    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "LastUpdatedBy")
    private Integer lastUpdatedBy;

    @Column(name = "LastUpdatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDate;

    @Column(name = "IsActive")
    private Boolean isActive;

    @Column(name = "IsUpdated")
    private Boolean isUpdated;

    @Column(name = "IsDeleted")
    private Boolean isDeleted;

    public Integer getcId() { return cId; }
    public void setcId(Integer cId) { this.cId = cId; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public String getSkill() { return skill; }
    public void setSkill(String skill) { this.skill = skill; }

    public Integer getVendorId() { return vendorId; }
    public void setVendorId(Integer vendorId) { this.vendorId = vendorId; }

    public String getVendorCode() { return vendorCode; }
    public void setVendorCode(String vendorCode) { this.vendorCode = vendorCode; }

    public String getVendor() { return vendor; }
    public void setVendor(String vendor) { this.vendor = vendor; }

    public Integer getProjectId() { return projectId; }
    public void setProjectId(Integer projectId) { this.projectId = projectId; }

    public String getProjectCode() { return projectCode; }
    public void setProjectCode(String projectCode) { this.projectCode = projectCode; }

    public String getProject() { return project; }
    public void setProject(String project) { this.project = project; }

    public Integer getSiteId() { return siteId; }
    public void setSiteId(Integer siteId) { this.siteId = siteId; }

    public String getSite() { return site; }
    public void setSite(String site) { this.site = site; }

    public String getSiteDetails() { return siteDetails; }
    public void setSiteDetails(String siteDetails) { this.siteDetails = siteDetails; }

    public Integer getManagerId() { return managerId; }
    public void setManagerId(Integer managerId) { this.managerId = managerId; }

    public String getManagerEmpCode() { return managerEmpCode; }
    public void setManagerEmpCode(String managerEmpCode) { this.managerEmpCode = managerEmpCode; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }

    public Boolean getIsLogin() { return isLogin; }
    public void setIsLogin(Boolean isLogin) { this.isLogin = isLogin; }

    public Boolean getIsLogout() { return isLogout; }
    public void setIsLogout(Boolean isLogout) { this.isLogout = isLogout; }

    public String getLoginTime() { return loginTime; }
    public void setLoginTime(String loginTime) { this.loginTime = loginTime; }

    public String getLogoutTime() { return logoutTime; }
    public void setLogoutTime(String logoutTime) { this.logoutTime = logoutTime; }

    public String getActivehrs() { return activehrs; }
    public void setActivehrs(String activehrs) { this.activehrs = activehrs; }

    public String getApprovedhrs() { return approvedhrs; }
    public void setApprovedhrs(String approvedhrs) { this.approvedhrs = approvedhrs; }

    public String getLoginAddress() { return loginAddress; }
    public void setLoginAddress(String loginAddress) { this.loginAddress = loginAddress; }

    public String getLoginLonqitude() { return loginLonqitude; }
    public void setLoginLonqitude(String loginLonqitude) { this.loginLonqitude = loginLonqitude; }

    public String getLoginLatitude() { return loginLatitude; }
    public void setLoginLatitude(String loginLatitude) { this.loginLatitude = loginLatitude; }

    public String getLogoutAddress() { return logoutAddress; }
    public void setLogoutAddress(String logoutAddress) { this.logoutAddress = logoutAddress; }

    public String getLogoutLonqitude() { return logoutLonqitude; }
    public void setLogoutLonqitude(String logoutLonqitude) { this.logoutLonqitude = logoutLonqitude; }

    public String getLogoutLatitude() { return logoutLatitude; }
    public void setLogoutLatitude(String logoutLatitude) { this.logoutLatitude = logoutLatitude; }

    public Boolean getIsLogoutManager() { return isLogoutManager; }
    public void setIsLogoutManager(Boolean isLogoutManager) { this.isLogoutManager = isLogoutManager; }

    public Boolean getIsApproved() { return isApproved; }
    public void setIsApproved(Boolean isApproved) { this.isApproved = isApproved; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getManPowerApproval() { return manPowerApproval; }
    public void setManPowerApproval(String manPowerApproval) { this.manPowerApproval = manPowerApproval; }

    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }

    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    public Integer getLastUpdatedBy() { return lastUpdatedBy; }
    public void setLastUpdatedBy(Integer lastUpdatedBy) { this.lastUpdatedBy = lastUpdatedBy; }

    public Date getLastUpdatedDate() { return lastUpdatedDate; }
    public void setLastUpdatedDate(Date lastUpdatedDate) { this.lastUpdatedDate = lastUpdatedDate; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public Boolean getIsUpdated() { return isUpdated; }
    public void setIsUpdated(Boolean isUpdated) { this.isUpdated = isUpdated; }

    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }
}