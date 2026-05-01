package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkTypeMasterViewModel {
    @JsonProperty("LoginId")
    @JsonAlias({"loginId", "LoginId"})
    private Integer loginId;
    
    @JsonProperty("WorkTypeId")
    @JsonAlias({"workTypeId", "WorkTypeId"})
    private Integer workTypeId;
    
    @JsonProperty("WorkType")
    private String workType;
    
    @JsonProperty("EmpId")
    @JsonAlias({"empId", "EmpId"})
    private Integer empId;
    
    @JsonProperty("EmpCode")
    private String empCode;
    
    @JsonProperty("EmpName")
    private String empName;
    
    @JsonProperty("StartDate")
    private String startDate;
    
    @JsonProperty("EndDate")
    private String endDate;
    
    @JsonProperty("Reason")
    private String reason;
    
    @JsonProperty("ApproverDescription")
    private String approverDescription;
    
    @JsonProperty("IsApproved")
    private Boolean isApproved;
    
    @JsonProperty("IsApprovedBy")
    private Integer isApprovedBy;
    
    @JsonProperty("Approver")
    private String approver;
    
    @JsonProperty("IsRejected")
    private Boolean isRejected;
    
    @JsonProperty("IsRejectedBy")
    private Integer isRejectedBy;
    
    @JsonProperty("RApprover")
    private String rApprover;
    
    @JsonProperty("IsEnd")
    private Boolean isEnd;
    
    @JsonProperty("IsActive")
    private Boolean isActive;
    
    @JsonProperty("IsUpdated")
    private Boolean isUpdated;
    
    @JsonProperty("IsDeleted")
    private Boolean isDeleted;
    
    @JsonProperty("CreatedBy")
    private Integer createdBy;
    
    @JsonProperty("CreatedDate")
    private String createdDate;
    
    @JsonProperty("LastUpdatedBy")
    private Integer lastUpdatedBy;
    
    @JsonProperty("LastupdatedDate")
    private String lastupdatedDate;
    
    @JsonProperty("msg")
    private String msg;
    
    @JsonProperty("Status")
    private String status;

    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }
    public Integer getWorkTypeId() { return workTypeId; }
    public void setWorkTypeId(Integer workTypeId) { this.workTypeId = workTypeId; }
    public String getWorkType() { return workType; }
    public void setWorkType(String workType) { this.workType = workType; }
    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }
    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }
    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }
    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public String getApproverDescription() { return approverDescription; }
    public void setApproverDescription(String approverDescription) { this.approverDescription = approverDescription; }
    public Boolean getIsApproved() { return isApproved; }
    public void setIsApproved(Boolean isApproved) { this.isApproved = isApproved; }
    public Integer getIsApprovedBy() { return isApprovedBy; }
    public void setIsApprovedBy(Integer isApprovedBy) { this.isApprovedBy = isApprovedBy; }
    public String getApprover() { return approver; }
    public void setApprover(String approver) { this.approver = approver; }
    public Boolean getIsRejected() { return isRejected; }
    public void setIsRejected(Boolean isRejected) { this.isRejected = isRejected; }
    public Integer getIsRejectedBy() { return isRejectedBy; }
    public void setIsRejectedBy(Integer isRejectedBy) { this.isRejectedBy = isRejectedBy; }
    public String getRApprover() { return rApprover; }
    public void setRApprover(String rApprover) { this.rApprover = rApprover; }
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
    public String getCreatedDate() { return createdDate; }
    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }
    public Integer getLastUpdatedBy() { return lastUpdatedBy; }
    public void setLastUpdatedBy(Integer lastUpdatedBy) { this.lastUpdatedBy = lastUpdatedBy; }
    public String getLastupdatedDate() { return lastupdatedDate; }
    public void setLastupdatedDate(String lastupdatedDate) { this.lastupdatedDate = lastupdatedDate; }
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
