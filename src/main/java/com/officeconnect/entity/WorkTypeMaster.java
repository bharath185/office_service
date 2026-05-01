package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "WorkTypeMaster")
public class WorkTypeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WorkTypeId")
    private Integer workTypeId;

    @Column(name = "WorkType")
    private String workType;

    @Column(name = "EmpId")
    private Integer empId;

    @Column(name = "EmpCode")
    private String empCode;

    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(name = "Reason")
    private String reason;

    @Column(name = "ApproverDescription")
    private String approverDescription;

    @Column(name = "IsApproved")
    private Boolean isApproved;

    @Column(name = "IsApprovedBy")
    private Integer isApprovedBy;

    @Column(name = "IsRejected")
    private Boolean isRejected;

    @Column(name = "IsRejectedBy")
    private Integer isRejectedBy;

    @Column(name = "IsEnd")
    private Boolean isEnd;

    @Column(name = "IsActive")
    private Boolean isActive;

    @Column(name = "IsUpdated")
    private Boolean isUpdated;

    @Column(name = "IsDeleted")
    private Boolean isDeleted;

    @Column(name = "CreatedBy")
    private Integer createdBy;

    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "LastUpdatedBy")
    private Integer lastUpdatedBy;

    @Column(name = "LastupdatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastupdatedDate;

    public Integer getWorkTypeId() { return workTypeId; }
    public void setWorkTypeId(Integer workTypeId) { this.workTypeId = workTypeId; }
    public String getWorkType() { return workType; }
    public void setWorkType(String workType) { this.workType = workType; }
    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }
    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }
    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public String getApproverDescription() { return approverDescription; }
    public void setApproverDescription(String approverDescription) { this.approverDescription = approverDescription; }
    public Boolean getIsApproved() { return isApproved; }
    public void setIsApproved(Boolean isApproved) { this.isApproved = isApproved; }
    public Integer getIsApprovedBy() { return isApprovedBy; }
    public void setIsApprovedBy(Integer isApprovedBy) { this.isApprovedBy = isApprovedBy; }
    public Boolean getIsRejected() { return isRejected; }
    public void setIsRejected(Boolean isRejected) { this.isRejected = isRejected; }
    public Integer getIsRejectedBy() { return isRejectedBy; }
    public void setIsRejectedBy(Integer isRejectedBy) { this.isRejectedBy = isRejectedBy; }
    public Boolean getIsEnd() { return isEnd; }
    public void setIsEnd(Boolean isEnd) { this.isEnd = isEnd; }
    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
    public Boolean getIsUpdated() { return isUpdated; }
    public void setIsUpdated(Boolean isUpdated) { this.isUpdated = isUpdated; }
    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }
    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }
    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }
    public Integer getLastUpdatedBy() { return lastUpdatedBy; }
    public void setLastUpdatedBy(Integer lastUpdatedBy) { this.lastUpdatedBy = lastUpdatedBy; }
    public Date getLastupdatedDate() { return lastupdatedDate; }
    public void setLastupdatedDate(Date lastupdatedDate) { this.lastupdatedDate = lastupdatedDate; }
}
