package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DDDesignationViewModel {
    @JsonProperty("DeptId")
    @JsonAlias({"deptId", "DeptId"})
    private Integer deptId;

    @JsonProperty("DesignationId")
    @JsonAlias({"designationId", "DesignationId"})
    private Integer designationId;

    @JsonProperty("Designation")
    @JsonAlias({"designation", "Designation"})
    private String designation;

    @JsonProperty("EmpId")
    @JsonAlias({"empId", "EmpId"})
    private Integer empId;

    public Integer getDeptId() { return deptId; }
    public void setDeptId(Integer deptId) { this.deptId = deptId; }

    public Integer getDesignationId() { return designationId; }
    public void setDesignationId(Integer designationId) { this.designationId = designationId; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }
}
