package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class CompOffRequestViewModel {
    @JsonProperty("CompOffId")
    @JsonAlias({"compOffId", "CompOffId"})
    private Integer compOffId;
    @JsonProperty("EmpId")
    @JsonAlias({"empId", "EmpId"})
    private Integer empId;
    @JsonProperty("LeaveTypeId")
    @JsonAlias({"leaveTypeId", "LeaveTypeId"})
    private Integer leaveTypeId;
    @JsonProperty("FromDate")
    @JsonAlias({"fromDate", "FromDate"})
    private Date fromDate;
    @JsonProperty("ToDate")
    @JsonAlias({"toDate", "ToDate"})
    private Date toDate;
    @JsonProperty("NoOfDays")
    @JsonAlias({"noOfDays", "NoOfDays"})
    private Integer noOfDays;
    @JsonProperty("Reason")
    @JsonAlias({"reason", "Reason"})
    private String reason;
    @JsonProperty("Status")
    @JsonAlias({"status", "Status"})
    private String status;
    @JsonProperty("IsActive")
    @JsonAlias({"isActive", "IsActive"})
    private Boolean isActive;
    @JsonProperty("Msg")
    @JsonAlias({"msg", "Msg"})
    private String msg;

    public Integer getCompOffId() { return compOffId; }
    public void setCompOffId(Integer compOffId) { this.compOffId = compOffId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public Integer getLeaveTypeId() { return leaveTypeId; }
    public void setLeaveTypeId(Integer leaveTypeId) { this.leaveTypeId = leaveTypeId; }

    public Date getFromDate() { return fromDate; }
    public void setFromDate(Date fromDate) { this.fromDate = fromDate; }

    public Date getToDate() { return toDate; }
    public void setToDate(Date toDate) { this.toDate = toDate; }

    public Integer getNoOfDays() { return noOfDays; }
    public void setNoOfDays(Integer noOfDays) { this.noOfDays = noOfDays; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
}