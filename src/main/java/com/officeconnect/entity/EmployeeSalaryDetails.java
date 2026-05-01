package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name = "EmployeeSalaryDetails")
public class EmployeeSalaryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SalaryId")
    private Integer salaryId;

    @Column(name = "EmpId")
    private Integer empId;

    @Column(name = "EmpCode")
    private String empCode;

    @Column(name = "CTC")
    private BigDecimal ctc;

    @Column(name = "MCTC")
    private BigDecimal mCTC;

    @Column(name = "PerviousCTC")
    private BigDecimal perviousCTC;

    @Column(name = "IncrementPercent")
    private BigDecimal incrementPercent;

    @Column(name = "EffectiveFromDate")
    @Temporal(TemporalType.DATE)
    private Date effectiveFromDate;

    @Column(name = "EffectiveToDate")
    @Temporal(TemporalType.DATE)
    private Date effectiveToDate;

    @Column(name = "IsAppraised")
    private Boolean isAppraised;

    @Column(name = "RecordStatus")
    private Boolean recordStatus;

    @Column(name = "CreatedBy")
    private Integer createdBy;

    @Column(name = "CreatedDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name = "LastUpdatedBy")
    private Integer lastUpdatedBy;

    @Column(name = "LastUpdatedDate")
    @Temporal(TemporalType.DATE)
    private Date lastUpdatedDate;

    @Column(name = "IsActive")
    private Boolean isActive;

    @Column(name = "IsUpdated")
    private Boolean isUpdated;

    @Column(name = "IsDeleted")
    private Boolean isDeleted;

    public Integer getSalaryId() { return salaryId; }
    public void setSalaryId(Integer salaryId) { this.salaryId = salaryId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }

    public BigDecimal getCtc() { return ctc; }
    public void setCtc(BigDecimal ctc) { this.ctc = ctc; }

    public BigDecimal getMCTC() { return mCTC; }
    public void setMCTC(BigDecimal mCTC) { this.mCTC = mCTC; }

    public BigDecimal getPerviousCTC() { return perviousCTC; }
    public void setPerviousCTC(BigDecimal perviousCTC) { this.perviousCTC = perviousCTC; }

    public BigDecimal getIncrementPercent() { return incrementPercent; }
    public void setIncrementPercent(BigDecimal incrementPercent) { this.incrementPercent = incrementPercent; }

    public Date getEffectiveFromDate() { return effectiveFromDate; }
    public void setEffectiveFromDate(Date effectiveFromDate) { this.effectiveFromDate = effectiveFromDate; }

    public Date getEffectiveToDate() { return effectiveToDate; }
    public void setEffectiveToDate(Date effectiveToDate) { this.effectiveToDate = effectiveToDate; }

    public Boolean getIsAppraised() { return isAppraised; }
    public void setIsAppraised(Boolean isAppraised) { this.isAppraised = isAppraised; }

    public Boolean getRecordStatus() { return recordStatus; }
    public void setRecordStatus(Boolean recordStatus) { this.recordStatus = recordStatus; }

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