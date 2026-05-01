package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class EmployeeSelectViewModel {
    @JsonProperty("LoginId")
    private Integer loginId;
    @JsonProperty("EmpId")
    private Integer empId;
    @JsonProperty("CompId")
    private Integer compId;
    @JsonProperty("Company")
    private String company;
    @JsonProperty("DeptName")
    private String deptName;
    @JsonProperty("ReportId")
    private Integer reportId;
    @JsonProperty("EmpCode")
    private String empCode;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("EmpName")
    private String empName;
    @JsonProperty("MiddleName")
    private String middleName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("IsUpdated")
    private Boolean isUpdated;
    @JsonProperty("IsDeleted")
    private Boolean isDeleted;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("StartDate")
    private String startDate;
    @JsonProperty("TotalEmployeeCount")
    private Integer totalEmployeeCount;

    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public Integer getCompId() { return compId; }
    public void setCompId(Integer compId) { this.compId = compId; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }

    public Integer getReportId() { return reportId; }
    public void setReportId(Integer reportId) { this.reportId = reportId; }

    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public Boolean getIsUpdated() { return isUpdated; }
    public void setIsUpdated(Boolean isUpdated) { this.isUpdated = isUpdated; }

    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public Integer getTotalEmployeeCount() { return totalEmployeeCount; }
    public void setTotalEmployeeCount(Integer totalEmployeeCount) { this.totalEmployeeCount = totalEmployeeCount; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }
}
