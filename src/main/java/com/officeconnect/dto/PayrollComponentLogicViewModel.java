package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PayrollComponentLogicViewModel {
    @JsonProperty("EmpId")
    @JsonAlias({"empId", "EmpId"})
    private Integer empId;

    @JsonProperty("LoginId")
    @JsonAlias({"loginId", "LoginId"})
    private Integer loginId;

    @JsonProperty("LogicId")
    private Integer logicId;

    @JsonProperty("ComponentId")
    private Integer componentId;

    @JsonProperty("Percentage")
    private java.math.BigDecimal percentage;

    @JsonProperty("Value")
    private java.math.BigDecimal value;

    @JsonProperty("ComponentId1")
    private Integer componentId1;

    @JsonProperty("ComponentName1")
    private String componentName1;

    @JsonProperty("EffectiveFrom")
    private String effectiveFrom;

    @JsonProperty("EffectiveTo")
    private String effectiveTo;

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

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }
    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }
    public Integer getLogicId() { return logicId; }
    public void setLogicId(Integer logicId) { this.logicId = logicId; }
    public Integer getComponentId() { return componentId; }
    public void setComponentId(Integer componentId) { this.componentId = componentId; }
    public java.math.BigDecimal getPercentage() { return percentage; }
    public void setPercentage(java.math.BigDecimal percentage) { this.percentage = percentage; }
    public java.math.BigDecimal getValue() { return value; }
    public void setValue(java.math.BigDecimal value) { this.value = value; }
    public Integer getComponentId1() { return componentId1; }
    public void setComponentId1(Integer componentId1) { this.componentId1 = componentId1; }
    public String getComponentName1() { return componentName1; }
    public void setComponentName1(String componentName1) { this.componentName1 = componentName1; }
    public String getEffectiveFrom() { return effectiveFrom; }
    public void setEffectiveFrom(String effectiveFrom) { this.effectiveFrom = effectiveFrom; }
    public String getEffectiveTo() { return effectiveTo; }
    public void setEffectiveTo(String effectiveTo) { this.effectiveTo = effectiveTo; }
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
