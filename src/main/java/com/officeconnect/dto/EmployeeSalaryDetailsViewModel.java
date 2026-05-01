package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeSalaryDetailsViewModel {
    @JsonProperty("LoginId")
    @JsonAlias({"loginId", "LoginId"})
    private Integer loginId;

    @JsonProperty("EmpId")
    private Integer empId;

    @JsonProperty("CompId")
    private Integer compId;

    @JsonProperty("LEId")
    private Integer leId;

    @JsonProperty("BUId")
    private Integer buId;

    @JsonProperty("LocId")
    private Integer locId;

    @JsonProperty("DeptId")
    private Integer deptId;

    @JsonProperty("DesignationId")
    private Integer designationId;

    @JsonProperty("ReportId")
    private Integer reportId;

    @JsonProperty("SalaryId")
    private Integer salaryId;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("MiddleName")
    private String middleName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("EmpCode")
    private String empCode;

    @JsonProperty("CTC")
    private java.math.BigDecimal ctc;

    @JsonProperty("MCTC")
    private java.math.BigDecimal mctc;

    @JsonProperty("PerviousCTC")
    private java.math.BigDecimal perviousCtc;

    @JsonProperty("IncrementPercent")
    private java.math.BigDecimal incrementPercent;

    @JsonProperty("EffectiveFromDate")
    private String effectiveFromDate;

    @JsonProperty("EffectiveToDate")
    private String effectiveToDate;

    @JsonProperty("IsAppraised")
    private Boolean isAppraised;

    @JsonProperty("RecordStatus")
    private Boolean recordStatus;

    @JsonProperty("IsFixed")
    private Boolean isFixed;

    @JsonProperty("IsVariable")
    private Boolean isVariable;

    @JsonProperty("Period")
    private Integer period;

    @JsonProperty("VariableId")
    private Integer variableId;

    @JsonProperty("VariableName")
    private String variableName;

    @JsonProperty("VariableCode")
    private String variableCode;

    @JsonProperty("VariableAmt")
    private String variableAmt;

    @JsonProperty("IsArrear")
    private Boolean isArrear;

    @JsonProperty("ArrearAmt")
    private String arrearAmt;

    @JsonProperty("IsClearArrear")
    private Boolean isClearArrear;

    @JsonProperty("PendingMonth")
    private Integer pendingMonth;

    @JsonProperty("ArrearYear")
    private Integer arrearYear;

    @JsonProperty("ArrearMonth")
    private Integer arrearMonth;

    @JsonProperty("DescriptionforArrear")
    private String descriptionforArrear;

    @JsonProperty("CreatedBy")
    private Integer createdBy;

    @JsonProperty("CreatedDate")
    private String createdDate;

    @JsonProperty("LastUpdatedBy")
    private Integer lastUpdatedBy;

    @JsonProperty("LastUpdatedDate")
    private String lastUpdatedDate;

    @JsonProperty("IsActive")
    private Boolean isActive;

    @JsonProperty("IsUpdated")
    private Boolean isUpdated;

    @JsonProperty("IsDeleted")
    private Boolean isDeleted;

    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }
    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }
    public Integer getCompId() { return compId; }
    public void setCompId(Integer compId) { this.compId = compId; }
    public Integer getLEId() { return leId; }
    public void setLEId(Integer leId) { this.leId = leId; }
    public Integer getBUId() { return buId; }
    public void setBUId(Integer buId) { this.buId = buId; }
    public Integer getLocId() { return locId; }
    public void setLocId(Integer locId) { this.locId = locId; }
    public Integer getDeptId() { return deptId; }
    public void setDeptId(Integer deptId) { this.deptId = deptId; }
    public Integer getDesignationId() { return designationId; }
    public void setDesignationId(Integer designationId) { this.designationId = designationId; }
    public Integer getReportId() { return reportId; }
    public void setReportId(Integer reportId) { this.reportId = reportId; }
    public Integer getSalaryId() { return salaryId; }
    public void setSalaryId(Integer salaryId) { this.salaryId = salaryId; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }
    public java.math.BigDecimal getCtc() { return ctc; }
    public void setCtc(java.math.BigDecimal ctc) { this.ctc = ctc; }
    public java.math.BigDecimal getMctc() { return mctc; }
    public void setMctc(java.math.BigDecimal mctc) { this.mctc = mctc; }
    public java.math.BigDecimal getPerviousCtc() { return perviousCtc; }
    public void setPerviousCtc(java.math.BigDecimal perviousCtc) { this.perviousCtc = perviousCtc; }
    public java.math.BigDecimal getIncrementPercent() { return incrementPercent; }
    public void setIncrementPercent(java.math.BigDecimal incrementPercent) { this.incrementPercent = incrementPercent; }
    public String getEffectiveFromDate() { return effectiveFromDate; }
    public void setEffectiveFromDate(String effectiveFromDate) { this.effectiveFromDate = effectiveFromDate; }
    public String getEffectiveToDate() { return effectiveToDate; }
    public void setEffectiveToDate(String effectiveToDate) { this.effectiveToDate = effectiveToDate; }
    public Boolean getIsAppraised() { return isAppraised; }
    public void setIsAppraised(Boolean isAppraised) { this.isAppraised = isAppraised; }
    public Boolean getRecordStatus() { return recordStatus; }
    public void setRecordStatus(Boolean recordStatus) { this.recordStatus = recordStatus; }
    public Boolean getIsFixed() { return isFixed; }
    public void setIsFixed(Boolean isFixed) { this.isFixed = isFixed; }
    public Boolean getIsVariable() { return isVariable; }
    public void setIsVariable(Boolean isVariable) { this.isVariable = isVariable; }
    public Integer getPeriod() { return period; }
    public void setPeriod(Integer period) { this.period = period; }
    public Integer getVariableId() { return variableId; }
    public void setVariableId(Integer variableId) { this.variableId = variableId; }
    public String getVariableName() { return variableName; }
    public void setVariableName(String variableName) { this.variableName = variableName; }
    public String getVariableCode() { return variableCode; }
    public void setVariableCode(String variableCode) { this.variableCode = variableCode; }
    public String getVariableAmt() { return variableAmt; }
    public void setVariableAmt(String variableAmt) { this.variableAmt = variableAmt; }
    public Boolean getIsArrear() { return isArrear; }
    public void setIsArrear(Boolean isArrear) { this.isArrear = isArrear; }
    public String getArrearAmt() { return arrearAmt; }
    public void setArrearAmt(String arrearAmt) { this.arrearAmt = arrearAmt; }
    public Boolean getIsClearArrear() { return isClearArrear; }
    public void setIsClearArrear(Boolean isClearArrear) { this.isClearArrear = isClearArrear; }
    public Integer getPendingMonth() { return pendingMonth; }
    public void setPendingMonth(Integer pendingMonth) { this.pendingMonth = pendingMonth; }
    public Integer getArrearYear() { return arrearYear; }
    public void setArrearYear(Integer arrearYear) { this.arrearYear = arrearYear; }
    public Integer getArrearMonth() { return arrearMonth; }
    public void setArrearMonth(Integer arrearMonth) { this.arrearMonth = arrearMonth; }
    public String getDescriptionforArrear() { return descriptionforArrear; }
    public void setDescriptionforArrear(String descriptionforArrear) { this.descriptionforArrear = descriptionforArrear; }
    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }
    public String getCreatedDate() { return createdDate; }
    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }
    public Integer getLastUpdatedBy() { return lastUpdatedBy; }
    public void setLastUpdatedBy(Integer lastUpdatedBy) { this.lastUpdatedBy = lastUpdatedBy; }
    public String getLastUpdatedDate() { return lastUpdatedDate; }
    public void setLastUpdatedDate(String lastUpdatedDate) { this.lastUpdatedDate = lastUpdatedDate; }
    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
    public Boolean getIsUpdated() { return isUpdated; }
    public void setIsUpdated(Boolean isUpdated) { this.isUpdated = isUpdated; }
    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }
}
