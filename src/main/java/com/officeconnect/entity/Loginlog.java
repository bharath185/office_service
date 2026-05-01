package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Loginlog")
public class Loginlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "EmpId")
    private Integer empId;

    @Column(name = "EmpCode")
    private String empCode;

    @Column(name = "LoginTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginTime;

    @Column(name = "LogoutTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logoutTime;

    @Column(name = "IPAddress")
    private String ipAddress;

    @Column(name = "DeviceInfo")
    private String deviceInfo;

    @Column(name = "Browser")
    private String browser;

    @Column(name = "OS")
    private String os;

    @Column(name = "Location")
    private String location;

    @Column(name = "Status")
    private String status;

    @Column(name = "LoginAddress")
    private String loginAddress;

    @Column(name = "LoginCity")
    private String loginCity;

    @Column(name = "LoginLongitude")
    private String loginLongitude;

    @Column(name = "LoginLatitude")
    private String loginLatitude;

    @Column(name = "LogoutAddress")
    private String logoutAddress;

    @Column(name = "LogoutCity")
    private String logoutCity;

    @Column(name = "LogoutLongitude")
    private String logoutLongitude;

    @Column(name = "LogoutLatitude")
    private String logoutLatitude;

    @Column(name = "LoginDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginDate;

    @Column(name = "LogoutDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logoutDate;

    @Column(name = "ActionType")
    private String actionType;

    @Column(name = "LogInTime")
    @Temporal(TemporalType.TIME)
    private Date logInTime;

    @Column(name = "LogOutTime")
    @Temporal(TemporalType.TIME)
    private Date logOutTime;

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

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }

    public Date getLoginTime() { return loginTime; }
    public void setLoginTime(Date loginTime) { this.loginTime = loginTime; }

    public Date getLogoutTime() { return logoutTime; }
    public void setLogoutTime(Date logoutTime) { this.logoutTime = logoutTime; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public String getDeviceInfo() { return deviceInfo; }
    public void setDeviceInfo(String deviceInfo) { this.deviceInfo = deviceInfo; }

    public String getBrowser() { return browser; }
    public void setBrowser(String browser) { this.browser = browser; }

    public String getOs() { return os; }
    public void setOs(String os) { this.os = os; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getLoginAddress() { return loginAddress; }
    public void setLoginAddress(String loginAddress) { this.loginAddress = loginAddress; }

    public String getLoginCity() { return loginCity; }
    public void setLoginCity(String loginCity) { this.loginCity = loginCity; }

    public String getLoginLongitude() { return loginLongitude; }
    public void setLoginLongitude(String loginLongitude) { this.loginLongitude = loginLongitude; }

    public String getLoginLatitude() { return loginLatitude; }
    public void setLoginLatitude(String loginLatitude) { this.loginLatitude = loginLatitude; }

    public String getLogoutAddress() { return logoutAddress; }
    public void setLogoutAddress(String logoutAddress) { this.logoutAddress = logoutAddress; }

    public String getLogoutCity() { return logoutCity; }
    public void setLogoutCity(String logoutCity) { this.logoutCity = logoutCity; }

    public String getLogoutLongitude() { return logoutLongitude; }
    public void setLogoutLongitude(String logoutLongitude) { this.logoutLongitude = logoutLongitude; }

    public String getLogoutLatitude() { return logoutLatitude; }
    public void setLogoutLatitude(String logoutLatitude) { this.logoutLatitude = logoutLatitude; }

    public Date getLogoutDate() { return logoutDate; }
    public void setLogoutDate(Date logoutDate) { this.logoutDate = logoutDate; }

    public Date getLoginDate() { return loginDate; }
    public void setLoginDate(Date loginDate) { this.loginDate = loginDate; }

    public String getActionType() { return actionType; }
    public void setActionType(String actionType) { this.actionType = actionType; }

    public Date getLogInTime() { return logInTime; }
    public void setLogInTime(Date logInTime) { this.logInTime = logInTime; }

    public Date getLogOutTime() { return logOutTime; }
    public void setLogOutTime(Date logOutTime) { this.logOutTime = logOutTime; }

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
