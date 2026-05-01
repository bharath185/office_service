package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DDPayrollEmpListViewModel {
    @JsonProperty("EmpId")
    private Integer empId;
    @JsonProperty("EmpName")
    private String empName;
    @JsonProperty("EmpCode")
    private String empCode;

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }
    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }
    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }
}
