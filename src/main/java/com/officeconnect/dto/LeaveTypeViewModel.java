package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LeaveTypeViewModel {
    @JsonProperty("LeaveTypeId")
    @JsonAlias({"leaveTypeId", "LeaveTypeId"})
    private Integer leaveTypeId;
    @JsonProperty("LeaveType")
    @JsonAlias({"leaveType", "LeaveType"})
    private String leaveType;
    @JsonProperty("LeaveCode")
    @JsonAlias({"leaveCode", "LeaveCode"})
    private String leaveCode;
    @JsonProperty("Description")
    @JsonAlias({"description", "Description"})
    private String description;
    @JsonProperty("LeaveCount")
    @JsonAlias({"leaveCount", "LeaveCount"})
    private Integer leaveCount;
    @JsonProperty("IsActive")
    @JsonAlias({"isActive", "IsActive"})
    private Boolean isActive;
    @JsonProperty("Msg")
    @JsonAlias({"msg", "Msg"})
    private String msg;

    public Integer getLeaveTypeId() { return leaveTypeId; }
    public void setLeaveTypeId(Integer leaveTypeId) { this.leaveTypeId = leaveTypeId; }

    public String getLeaveType() { return leaveType; }
    public void setLeaveType(String leaveType) { this.leaveType = leaveType; }

    public String getLeaveCode() { return leaveCode; }
    public void setLeaveCode(String leaveCode) { this.leaveCode = leaveCode; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getLeaveCount() { return leaveCount; }
    public void setLeaveCount(Integer leaveCount) { this.leaveCount = leaveCount; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
}