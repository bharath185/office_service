package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DDGenderViewModel {
    @JsonProperty("GenderId")
    @JsonAlias({"genderId", "GenderId"})
    private Integer genderId;

    @JsonProperty("Gender")
    @JsonAlias({"gender", "Gender"})
    private String gender;

    @JsonProperty("EmpId")
    @JsonAlias({"empId", "EmpId"})
    private Integer empId;

    public Integer getGenderId() { return genderId; }
    public void setGenderId(Integer genderId) { this.genderId = genderId; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }
}
