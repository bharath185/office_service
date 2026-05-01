package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DDCompanyViewModel {
    @JsonProperty("CompId")
    @JsonAlias({"compId", "CompId"})
    private Integer compId;
    @JsonProperty("Company")
    @JsonAlias({"company", "Company"})
    private String company;
    @JsonProperty("CompanyCode")
    @JsonAlias({"companyCode", "CompanyCode"})
    private String companyCode;
    @JsonProperty("EmpId")
    @JsonAlias({"empId", "EmpId"})
    private Integer empId;

    public Integer getCompId() { return compId; }
    public void setCompId(Integer compId) { this.compId = compId; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getCompanyCode() { return companyCode; }
    public void setCompanyCode(String companyCode) { this.companyCode = companyCode; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }
}