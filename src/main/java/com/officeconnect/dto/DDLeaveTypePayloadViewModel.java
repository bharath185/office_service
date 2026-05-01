package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DDLeaveTypePayloadViewModel {
    @JsonProperty("CompId")
    @JsonAlias({"compId", "CompId"})
    private Integer compId;
    @JsonProperty("EmpId")
    @JsonAlias({"empId", "EmpId"})
    private Integer empId;

    public Integer getCompId() { return compId; }
    public void setCompId(Integer compId) { this.compId = compId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }
}