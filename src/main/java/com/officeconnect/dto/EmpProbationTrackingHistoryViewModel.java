package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;

public class EmpProbationTrackingHistoryViewModel {
    
    @JsonProperty("LoginId")
    @JsonAlias({"loginId", "LoginId"})
    private Integer loginId;
    
    @JsonProperty("LEId")
    @JsonAlias({"leId", "LEId"})
    private Integer leId;
    
    @JsonProperty("BuId")
    @JsonAlias({"buId", "BuId"})
    private Integer buId;
    
    @JsonProperty("LocId")
    @JsonAlias({"locId", "LocId"})
    private Integer locId;
    
    @JsonProperty("DeptId")
    @JsonAlias({"deptId", "DeptId"})
    private Integer deptId;
    
    @JsonProperty("DesignationId")
    @JsonAlias({"designationId", "DesignationId"})
    private Integer designationId;
    
    @JsonProperty("ReporterId")
    @JsonAlias({"reporterId", "ReporterId"})
    private Integer reporterId;
    
    @JsonProperty("EmpId")
    @JsonAlias({"empId", "EmpId"})
    private Integer empId;
    
    @JsonProperty("EmpProbationId")
    private Integer empProbationId;
    
    @JsonProperty("EmpName")
    private String empName;
    
    @JsonProperty("EmpCode")
    private String empCode;
    
    @JsonProperty("JoiningDate")
    private Object joiningDate;
    
    @JsonProperty("ProbationDays")
    private Integer probationDays;
    
    @JsonProperty("ProbationEndDate")
    private Object probationEndDate;
    
    @JsonProperty("ReportId")
    private Integer reportId;
    
    @JsonProperty("ReportCode")
    private String reportCode;
    
    @JsonProperty("IsProbation")
    private Boolean isProbation;
    
    @JsonProperty("IsPermanent")
    private Boolean isPermanent;
    
    @JsonProperty("IsContract")
    private Boolean isContract;
    
    @JsonProperty("IsConsultant")
    private Boolean isConsultant;
    
    @JsonProperty("ConfirmDate")
    private Object confirmDate;
    
    @JsonProperty("ConfirmBy")
    private Integer confirmBy;
    
    @JsonProperty("Remarks")
    private String remarks;
    
    @JsonProperty("CreatedBy")
    private Integer createdBy;
    
    @JsonProperty("CreatedDate")
    private Object createdDate;
    
    @JsonProperty("LastUpdatedBy")
    private Integer lastUpdatedBy;
    
    @JsonProperty("LastUpdatedDate")
    private Object lastUpdatedDate;
    
    @JsonProperty("IsActive")
    private Boolean isActive;
    
    @JsonProperty("IsUpdated")
    private Boolean isUpdated;
    
    @JsonProperty("IsDeleted")
    private Boolean isDeleted;

    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }

    public Integer getLeId() { return leId; }
    public void setLeId(Integer leId) { this.leId = leId; }

    public Integer getBuId() { return buId; }
    public void setBuId(Integer buId) { this.buId = buId; }

    public Integer getLocId() { return locId; }
    public void setLocId(Integer locId) { this.locId = locId; }

    public Integer getDeptId() { return deptId; }
    public void setDeptId(Integer deptId) { this.deptId = deptId; }

    public Integer getDesignationId() { return designationId; }
    public void setDesignationId(Integer designationId) { this.designationId = designationId; }

    public Integer getReporterId() { return reporterId; }
    public void setReporterId(Integer reporterId) { this.reporterId = reporterId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public Integer getEmpProbationId() { return empProbationId; }
    public void setEmpProbationId(Integer empProbationId) { this.empProbationId = empProbationId; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }

    public Object getJoiningDate() { return joiningDate; }
    public void setJoiningDate(Object joiningDate) { this.joiningDate = joiningDate; }

    public Integer getProbationDays() { return probationDays; }
    public void setProbationDays(Integer probationDays) { this.probationDays = probationDays; }

    public Object getProbationEndDate() { return probationEndDate; }
    public void setProbationEndDate(Object probationEndDate) { this.probationEndDate = probationEndDate; }

    public Integer getReportId() { return reportId; }
    public void setReportId(Integer reportId) { this.reportId = reportId; }

    public String getReportCode() { return reportCode; }
    public void setReportCode(String reportCode) { this.reportCode = reportCode; }

    public Boolean getIsProbation() { return isProbation; }
    public void setIsProbation(Boolean isProbation) { this.isProbation = isProbation; }

    public Boolean getIsPermanent() { return isPermanent; }
    public void setIsPermanent(Boolean isPermanent) { this.isPermanent = isPermanent; }

    public Boolean getIsContract() { return isContract; }
    public void setIsContract(Boolean isContract) { this.isContract = isContract; }

    public Boolean getIsConsultant() { return isConsultant; }
    public void setIsConsultant(Boolean isConsultant) { this.isConsultant = isConsultant; }

    public Object getConfirmDate() { return confirmDate; }
    public void setConfirmDate(Object confirmDate) { this.confirmDate = confirmDate; }

    public Integer getConfirmBy() { return confirmBy; }
    public void setConfirmBy(Integer confirmBy) { this.confirmBy = confirmBy; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }

    public Object getCreatedDate() { return createdDate; }
    public void setCreatedDate(Object createdDate) { this.createdDate = createdDate; }

    public Integer getLastUpdatedBy() { return lastUpdatedBy; }
    public void setLastUpdatedBy(Integer lastUpdatedBy) { this.lastUpdatedBy = lastUpdatedBy; }

    public Object getLastUpdatedDate() { return lastUpdatedDate; }
    public void setLastUpdatedDate(Object lastUpdatedDate) { this.lastUpdatedDate = lastUpdatedDate; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public Boolean getIsUpdated() { return isUpdated; }
    public void setIsUpdated(Boolean isUpdated) { this.isUpdated = isUpdated; }

    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }
}
