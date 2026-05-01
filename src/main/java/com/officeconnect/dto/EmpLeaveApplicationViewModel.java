package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class EmpLeaveApplicationViewModel {
    @JsonProperty("LoginId")
    @JsonAlias({"loginId", "LoginId"})
    private Integer loginId;
    @JsonProperty("LeaveAppId")
    @JsonAlias({"leaveAppId", "LeaveAppId"})
    private Integer leaveAppId;
    @JsonProperty("EmpId")
    @JsonAlias({"empId", "EmpId"})
    private Integer empId;
    @JsonProperty("EmpCode")
    @JsonAlias({"empCode", "EmpCode"})
    private String empCode;
    @JsonProperty("EmpName")
    @JsonAlias({"empName", "EmpName"})
    private String empName;
    @JsonProperty("LeaveTypeId")
    @JsonAlias({"leaveTypeId", "LeaveTypeId"})
    private Integer leaveTypeId;
    @JsonProperty("LeaveType")
    @JsonAlias({"leaveType", "LeaveType"})
    private String leaveType;
    @JsonProperty("StartDate")
    @JsonAlias({"startDate", "StartDate", "fromDate", "FromDate"})
    private Date startDate;
    @JsonProperty("EndDate")
    @JsonAlias({"endDate", "EndDate", "toDate", "ToDate"})
    private Date endDate;
    @JsonProperty("Duration")
    @JsonAlias({"duration", "Duration", "noOfDays", "NoOfDays"})
    private Double duration;
    @JsonProperty("Reason")
    @JsonAlias({"reason", "Reason"})
    private String reason;
    @JsonProperty("Status")
    @JsonAlias({"status", "Status"})
    private String status;
    @JsonProperty("AppliedDate")
    @JsonAlias({"appliedDate", "AppliedDate"})
    private Date appliedDate;
    @JsonProperty("CompOffDate")
    @JsonAlias({"compOffDate", "CompOffDate"})
    private Date compOffDate;
    @JsonProperty("CompOffReason")
    @JsonAlias({"compOffReason", "CompOffReason"})
    private String compOffReason;
    @JsonProperty("DocName")
    @JsonAlias({"docName", "DocName"})
    private String docName;
    @JsonProperty("ApprovedBy")
    @JsonAlias({"approvedBy", "ApprovedBy"})
    private Integer approvedBy;
    @JsonProperty("Approver")
    @JsonAlias({"approver", "Approver"})
    private String approver;
    @JsonProperty("IsLOP")
    @JsonAlias({"isLOP", "IsLOP"})
    private Boolean isLOP;
    @JsonProperty("ApprovedDate")
    @JsonAlias({"approvedDate", "ApprovedDate"})
    private Date approvedDate;
    @JsonProperty("HRApproved")
    @JsonAlias({"hrApproved", "HRApproved"})
    private Integer hrApproved;
    @JsonProperty("HRApprovedDate")
    @JsonAlias({"hrApprovedDate", "HRApprovedDate"})
    private Date hrApprovedDate;
    @JsonProperty("Remarks")
    @JsonAlias({"remarks", "Remarks"})
    private String remarks;
    @JsonProperty("Createdby")
    @JsonAlias({"createdby", "Createdby"})
    private Integer createdby;
    @JsonProperty("CreatedDate")
    @JsonAlias({"createdDate", "CreatedDate"})
    private Date createdDate;
    @JsonProperty("LastUpdatedBy")
    @JsonAlias({"lastUpdatedBy", "LastUpdatedBy"})
    private Integer lastUpdatedBy;
    @JsonProperty("LastUpdatedDate")
    @JsonAlias({"lastUpdatedDate", "LastUpdatedDate"})
    private Date lastUpdatedDate;
    @JsonProperty("IsActive")
    @JsonAlias({"isActive", "IsActive"})
    private Boolean isActive;
    @JsonProperty("IsUpdated")
    @JsonAlias({"isUpdated", "IsUpdated"})
    private Boolean isUpdated;
    @JsonProperty("IsDeleted")
    @JsonAlias({"isDeleted", "IsDeleted"})
    private Boolean isDeleted;
    @JsonProperty("Msg")
    @JsonAlias({"msg", "Msg"})
    private String msg;

    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }

    public Integer getLeaveAppId() { return leaveAppId; }
    public void setLeaveAppId(Integer leaveAppId) { this.leaveAppId = leaveAppId; }
    public Integer getEmpLeaveId() { return leaveAppId; }
    public void setEmpLeaveId(Integer empLeaveId) { this.leaveAppId = empLeaveId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public Integer getLeaveTypeId() { return leaveTypeId; }
    public void setLeaveTypeId(Integer leaveTypeId) { this.leaveTypeId = leaveTypeId; }

    public String getLeaveType() { return leaveType; }
    public void setLeaveType(String leaveType) { this.leaveType = leaveType; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public Date getFromDate() { return startDate; }
    public void setFromDate(Date fromDate) { this.startDate = fromDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    public Date getToDate() { return endDate; }
    public void setToDate(Date toDate) { this.endDate = toDate; }

    public Double getDuration() { return duration; }
    public void setDuration(Double duration) { this.duration = duration; }
    public Integer getNoOfDays() { return duration != null ? duration.intValue() : null; }
    public void setNoOfDays(Integer noOfDays) { this.duration = noOfDays != null ? noOfDays.doubleValue() : null; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getAppliedDate() { return appliedDate; }
    public void setAppliedDate(Date appliedDate) { this.appliedDate = appliedDate; }

    public Date getCompOffDate() { return compOffDate; }
    public void setCompOffDate(Date compOffDate) { this.compOffDate = compOffDate; }

    public String getCompOffReason() { return compOffReason; }
    public void setCompOffReason(String compOffReason) { this.compOffReason = compOffReason; }

    public String getDocName() { return docName; }
    public void setDocName(String docName) { this.docName = docName; }

    public Integer getApprovedBy() { return approvedBy; }
    public void setApprovedBy(Integer approvedBy) { this.approvedBy = approvedBy; }

    public String getApprover() { return approver; }
    public void setApprover(String approver) { this.approver = approver; }

    public Boolean getIsLOP() { return isLOP; }
    public void setIsLOP(Boolean isLOP) { this.isLOP = isLOP; }

    public Date getApprovedDate() { return approvedDate; }
    public void setApprovedDate(Date approvedDate) { this.approvedDate = approvedDate; }

    public Integer getHrApproved() { return hrApproved; }
    public void setHrApproved(Integer hrApproved) { this.hrApproved = hrApproved; }

    public Date getHrApprovedDate() { return hrApprovedDate; }
    public void setHrApprovedDate(Date hrApprovedDate) { this.hrApprovedDate = hrApprovedDate; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    public Integer getCreatedby() { return createdby; }
    public void setCreatedby(Integer createdby) { this.createdby = createdby; }

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

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
}