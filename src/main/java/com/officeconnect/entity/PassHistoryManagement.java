package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PassHistoryManagement")
public class PassHistoryManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PassHistoryId")
    private Integer passHistoryId;

    @Column(name = "EmpId")
    private Integer empId;

    @Column(name = "EmpCode")
    private String empCode;

    @Column(name = "OldPassword")
    private String oldPassword;

    @Column(name = "NewPassword")
    private String newPassword;

    @Column(name = "FPwd")
    private Boolean fpwd;

    @Column(name = "CPwd")
    private Boolean cpwd;

    @Column(name = "Expired")
    private Boolean expired;

    @Column(name = "CreatedBy")
    private Integer createdBy;

    @Column(name = "CreatedDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name = "IsActive")
    private Boolean isActive;

    @Column(name = "IsUpdated")
    private Boolean isUpdated;

    @Column(name = "IsDeleted")
    private Boolean isDeleted;

    public Integer getPassHistoryId() { return passHistoryId; }
    public void setPassHistoryId(Integer passHistoryId) { this.passHistoryId = passHistoryId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }

    public String getOldPassword() { return oldPassword; }
    public void setOldPassword(String oldPassword) { this.oldPassword = oldPassword; }

    public String getNewPassword() { return newPassword; }
    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }

    public Boolean getFpwd() { return fpwd; }
    public void setFpwd(Boolean fpwd) { this.fpwd = fpwd; }

    public Boolean getCpwd() { return cpwd; }
    public void setCpwd(Boolean cpwd) { this.cpwd = cpwd; }

    public Boolean getExpired() { return expired; }
    public void setExpired(Boolean expired) { this.expired = expired; }

    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }

    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public Boolean getIsUpdated() { return isUpdated; }
    public void setIsUpdated(Boolean isUpdated) { this.isUpdated = isUpdated; }

    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }
}