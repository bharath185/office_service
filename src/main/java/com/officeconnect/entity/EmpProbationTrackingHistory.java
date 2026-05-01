package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EmpProbationTrackingHistory")
public class EmpProbationTrackingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmpProbationId")
    private Integer empProbationId;

    @Column(name = "EmpId")
    private Integer empId;

    @Column(name = "JoiningDate")
    @Temporal(TemporalType.DATE)
    private Date joiningDate;

    @Column(name = "ProbationDays")
    private Integer probationDays;

    @Column(name = "ProbationEndDate")
    @Temporal(TemporalType.DATE)
    private Date probationEndDate;

    @Column(name = "ReportId")
    private Integer reportId;

    @Column(name = "ReportCode")
    private String reportCode;

    @Column(name = "IsProbation")
    private Boolean isProbation;

    @Column(name = "IsPermanent")
    private Boolean isPermanent;

    @Column(name = "IsContract")
    private Boolean isContract;

    @Column(name = "IsConsultant")
    private Boolean isConsultant;

    @Column(name = "ConfirmDate")
    @Temporal(TemporalType.DATE)
    private Date confirmDate;

    @Column(name = "ConfirmBy")
    private Integer confirmBy;

    @Column(name = "Remarks")
    private String remarks;

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

    public Integer getEmpProbationId() { return empProbationId; }
    public void setEmpProbationId(Integer empProbationId) { this.empProbationId = empProbationId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public Date getJoiningDate() { return joiningDate; }
    public void setJoiningDate(Date joiningDate) { this.joiningDate = joiningDate; }

    public Integer getProbationDays() { return probationDays; }
    public void setProbationDays(Integer probationDays) { this.probationDays = probationDays; }

    public Date getProbationEndDate() { return probationEndDate; }
    public void setProbationEndDate(Date probationEndDate) { this.probationEndDate = probationEndDate; }

    public Integer getReportId() { return reportId; }
    public void setReportId(Integer reportId) { this.reportId = reportId; }

    public String getReportCode() { return reportCode; }
    public void setReportCode(String reportCode) { this.reportCode = reportCode; }

    public Boolean getIsProbation() { return isProbation; }
    public void setIsProbation(Boolean isProbation) { this.isProbation = isProbation; }

    public Boolean getIsPermanent() { return isPermanent; }
    public void setIsPermanent(Boolean isPermanent) { this.isPermanent = isPermanent; }

    public Boolean getIsContract() { return isContract; }
    public void setIsContract(Boolean isContract) { this.isContract = isContract; }

    public Boolean getIsConsultant() { return isConsultant; }
    public void setIsConsultant(Boolean isConsultant) { this.isConsultant = isConsultant; }

    public Date getConfirmDate() { return confirmDate; }
    public void setConfirmDate(Date confirmDate) { this.confirmDate = confirmDate; }

    public Integer getConfirmBy() { return confirmBy; }
    public void setConfirmBy(Integer confirmBy) { this.confirmBy = confirmBy; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

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
