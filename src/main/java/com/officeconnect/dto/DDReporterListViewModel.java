package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DDReporterListViewModel {
    @JsonProperty("ReporterId")
    @JsonAlias({"reporterId", "ReporterId"})
    private Integer reporterId;
    
    @JsonProperty("CompId")
    @JsonAlias({"compId", "CompId"})
    private Integer compId;
    
    @JsonProperty("LEId")
    @JsonAlias({"leId", "LEId"})
    private Integer leId;
    
    @JsonProperty("BUId")
    @JsonAlias({"buId", "BUId"})
    private Integer buId;
    
    @JsonProperty("LocationId")
    @JsonAlias({"locationId", "LocationId"})
    private Integer locationId;
    
    @JsonProperty("DeptId")
    @JsonAlias({"deptId", "DeptId"})
    private Integer deptId;
    
    @JsonProperty("DesignationId")
    @JsonAlias({"designationId", "DesignationId"})
    private Integer designationId;
    
    @JsonProperty("EmpId")
    @JsonAlias({"empId", "EmpId"})
    private Integer empId;
    
    @JsonProperty("ReporterName")
    private String reporterName;
    
    @JsonProperty("ReporterCode")
    private String reporterCode;
    
    @JsonProperty("LoginId")
    @JsonAlias({"loginId", "LoginId"})
    private Integer loginId;

    public Integer getReporterId() { return reporterId; }
    public void setReporterId(Integer reporterId) { this.reporterId = reporterId; }
    public Integer getCompId() { return compId; }
    public void setCompId(Integer compId) { this.compId = compId; }
    public Integer getLEId() { return leId; }
    public void setLEId(Integer leId) { this.leId = leId; }
    public Integer getBUId() { return buId; }
    public void setBUId(Integer buId) { this.buId = buId; }
    public Integer getLocationId() { return locationId; }
    public void setLocationId(Integer locationId) { this.locationId = locationId; }
    public Integer getDeptId() { return deptId; }
    public void setDeptId(Integer deptId) { this.deptId = deptId; }
    public Integer getDesignationId() { return designationId; }
    public void setDesignationId(Integer designationId) { this.designationId = designationId; }
    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }
    public String getReporterName() { return reporterName; }
    public void setReporterName(String reporterName) { this.reporterName = reporterName; }
    public String getReporterCode() { return reporterCode; }
    public void setReporterCode(String reporterCode) { this.reporterCode = reporterCode; }
    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }
}
