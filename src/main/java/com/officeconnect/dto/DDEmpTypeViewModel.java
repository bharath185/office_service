package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DDEmpTypeViewModel {
    @JsonProperty("EmpTypeId")
    private Integer empTypeId;
    
    @JsonProperty("EmpType")
    private String empType;
    
    @JsonProperty("Description")
    private String description;
    
    @JsonProperty("EmpId")
    private Integer empId;

    public Integer getEmpTypeId() { return empTypeId; }
    public void setEmpTypeId(Integer empTypeId) { this.empTypeId = empTypeId; }

    public String getEmpType() { return empType; }
    public void setEmpType(String empType) { this.empType = empType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }
}
