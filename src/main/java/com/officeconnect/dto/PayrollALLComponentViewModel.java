package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class PayrollALLComponentViewModel {
    @JsonProperty("EmpId")
    @JsonAlias({"empId", "EmpId"})
    private Integer empId;

    @JsonProperty("LoginId")
    @JsonAlias({"loginId", "LoginId"})
    private Integer loginId;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Month")
    private String month;

    @JsonProperty("MonthNo")
    private Integer monthNo;

    @JsonProperty("ComponentId")
    private Integer componentId;

    @JsonProperty("ComponentName")
    private String componentName;

    @JsonProperty("ComponentCode")
    private String componentCode;

    @JsonProperty("ComponentValue")
    private String componentValue;

    @JsonProperty("PayoutTypeId")
    private Integer payoutTypeId;

    @JsonProperty("PayoutTypeName")
    private String payoutTypeName;

    @JsonProperty("FrequencyId")
    private Integer frequencyId;

    @JsonProperty("Frequency")
    private String frequency;

    @JsonProperty("SegmentId")
    private Integer segmentId;

    @JsonProperty("SegmentName")
    private String segmentName;

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

    @JsonProperty("lstofLC")
    private List<PayrollALLComponentLogicConditionViewModel> lstofLC;

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }
    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }
    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }
    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }
    public Integer getMonthNo() { return monthNo; }
    public void setMonthNo(Integer monthNo) { this.monthNo = monthNo; }
    public Integer getComponentId() { return componentId; }
    public void setComponentId(Integer componentId) { this.componentId = componentId; }
    public String getComponentName() { return componentName; }
    public void setComponentName(String componentName) { this.componentName = componentName; }
    public String getComponentCode() { return componentCode; }
    public void setComponentCode(String componentCode) { this.componentCode = componentCode; }
    public String getComponentValue() { return componentValue; }
    public void setComponentValue(String componentValue) { this.componentValue = componentValue; }
    public Integer getPayoutTypeId() { return payoutTypeId; }
    public void setPayoutTypeId(Integer payoutTypeId) { this.payoutTypeId = payoutTypeId; }
    public String getPayoutTypeName() { return payoutTypeName; }
    public void setPayoutTypeName(String payoutTypeName) { this.payoutTypeName = payoutTypeName; }
    public Integer getFrequencyId() { return frequencyId; }
    public void setFrequencyId(Integer frequencyId) { this.frequencyId = frequencyId; }
    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }
    public Integer getSegmentId() { return segmentId; }
    public void setSegmentId(Integer segmentId) { this.segmentId = segmentId; }
    public String getSegmentName() { return segmentName; }
    public void setSegmentName(String segmentName) { this.segmentName = segmentName; }
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
    public List<PayrollALLComponentLogicConditionViewModel> getLstofLC() { return lstofLC; }
    public void setLstofLC(List<PayrollALLComponentLogicConditionViewModel> lstofLC) { this.lstofLC = lstofLC; }
}
