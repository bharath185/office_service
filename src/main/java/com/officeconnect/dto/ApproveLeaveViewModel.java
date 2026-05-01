package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApproveLeaveViewModel {
    @JsonProperty("EmpLeaveId")
    @JsonAlias({"empLeaveId", "EmpLeaveId"})
    private Integer empLeaveId;
    @JsonProperty("EmpId")
    @JsonAlias({"empId", "EmpId"})
    private Integer empId;
    @JsonProperty("Status")
    @JsonAlias({"status", "Status"})
    private String status;
    @JsonProperty("ApprovedBy")
    @JsonAlias({"approvedBy", "ApprovedBy"})
    private Integer approvedBy;
    @JsonProperty("Msg")
    @JsonAlias({"msg", "Msg"})
    private String msg;

    public Integer getEmpLeaveId() { return empLeaveId; }
    public void setEmpLeaveId(Integer empLeaveId) { this.empLeaveId = empLeaveId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getApprovedBy() { return approvedBy; }
    public void setApprovedBy(Integer approvedBy) { this.approvedBy = approvedBy; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
}