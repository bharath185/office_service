package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EmployeeAccDetails")
public class EmployeeAccDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccId")
    private Integer accId;

    @Column(name = "EmpId")
    private Integer empId;

    @Column(name = "BankName")
    private String bankName;

    @Column(name = "BranchName")
    private String branchName;

    @Column(name = "IFSCCode")
    private String ifscCode;

    @Column(name = "AccHolderName")
    private String accHolderName;

    @Column(name = "AccNo")
    private String accNo;

    @Column(name = "PFNo")
    private String pfNo;

    @Column(name = "ESIInsuranceNo")
    private String esiInsuranceNo;

    @Column(name = "HealthInsuranceNo")
    private String healthInsuranceNo;

    @Column(name = "PANNo")
    private String panNo;

    @Column(name = "UANNo")
    private String uanNo;

    @Column(name = "AadharNo")
    private String aadharNo;

    @Column(name = "MobileNo")
    private String mobileNo;

    @Column(name = "Status")
    private Boolean status;

    @Column(name = "IsPrimary")
    private Boolean isPrimary;

    @Column(name = "AccountType")
    private String accountType;

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

    public Integer getAccId() { return accId; }
    public void setAccId(Integer accId) { this.accId = accId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public String getBranch() { return branchName; }
    public void setBranch(String branch) { this.branchName = branch; }

    public String getIfscCode() { return ifscCode; }
    public void setIfscCode(String ifscCode) { this.ifscCode = ifscCode; }

    public String getAccHolderName() { return accHolderName; }
    public void setAccHolderName(String accHolderName) { this.accHolderName = accHolderName; }

    public String getAccNo() { return accNo; }
    public void setAccNo(String accNo) { this.accNo = accNo; }

    public String getAccountNo() { return accNo; }
    public void setAccountNo(String accountNo) { this.accNo = accountNo; }

    public String getPfNo() { return pfNo; }
    public void setPfNo(String pfNo) { this.pfNo = pfNo; }

    public String getEsiInsuranceNo() { return esiInsuranceNo; }
    public void setEsiInsuranceNo(String esiInsuranceNo) { this.esiInsuranceNo = esiInsuranceNo; }

    public String getHealthInsuranceNo() { return healthInsuranceNo; }
    public void setHealthInsuranceNo(String healthInsuranceNo) { this.healthInsuranceNo = healthInsuranceNo; }

    public String getPanNo() { return panNo; }
    public void setPanNo(String panNo) { this.panNo = panNo; }

    public String getUanNo() { return uanNo; }
    public void setUanNo(String uanNo) { this.uanNo = uanNo; }

    public String getAadharNo() { return aadharNo; }
    public void setAadharNo(String aadharNo) { this.aadharNo = aadharNo; }

    public String getMobileNo() { return mobileNo; }
    public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }

    public Boolean getIsPrimary() { return isPrimary; }
    public void setIsPrimary(Boolean isPrimary) { this.isPrimary = isPrimary; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

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
