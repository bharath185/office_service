package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;

public class ShiftMasterViewModel {
    @JsonProperty("ShiftId")
    private Integer shiftId;
    @JsonProperty("ShiftName")
    private String shiftName;
    @JsonProperty("ShiftCode")
    private String shiftCode;
    @JsonProperty("StartTime")
    private String startTime;
    @JsonProperty("EndTime")
    private String endTime;
    @JsonProperty("LateMarkTime")
    private String lateMarkTime;
    @JsonProperty("ClkHrs")
    private String clkHrs;
    @JsonProperty("Days")
    private String days;
    @JsonProperty("Status")
    private Boolean status;
    @JsonProperty("CreatedBy")
    private Integer createdBy;
    @JsonProperty("CreatedDate")
    private Date createdDate;
    @JsonProperty("LastUpdatedBy")
    private Integer lastUpdatedBy;
    @JsonProperty("LastUpdatedDate")
    private Date lastUpdatedDate;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("IsUpdated")
    private Boolean isUpdated;
    @JsonProperty("IsDeleted")
    private Boolean isDeleted;
    @JsonProperty("LoginId")
    private Integer loginId;
    @JsonProperty("Msg")
    private String msg;

    public Integer getShiftId() { return shiftId; }
    public void setShiftId(Integer shiftId) { this.shiftId = shiftId; }

    public String getShiftName() { return shiftName; }
    public void setShiftName(String shiftName) { this.shiftName = shiftName; }

    public String getShiftCode() { return shiftCode; }
    public void setShiftCode(String shiftCode) { this.shiftCode = shiftCode; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }

    public String getLateMarkTime() { return lateMarkTime; }
    public void setLateMarkTime(String lateMarkTime) { this.lateMarkTime = lateMarkTime; }

    public String getClkHrs() { return clkHrs; }
    public void setClkHrs(String clkHrs) { this.clkHrs = clkHrs; }

    public String getDays() { return days; }
    public void setDays(String days) { this.days = days; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }

    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }

    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    public Integer getLastUpdatedBy() { return lastUpdatedBy; }
    public void setLastUpdatedBy(Integer lastUpdatedBy) { this.lastUpdatedBy = lastUpdatedBy; }

    public Date getLastUpdatedDate() { return lastUpdatedDate; }
    public void setLastUpdatedDate(Date lastUpdatedDate) { this.lastUpdatedDate = lastUpdatedDate; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public Boolean getIsUpdated() { return isUpdated; }
    public void setIsUpdated(Boolean isUpdated) { this.isUpdated = isUpdated; }

    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }

    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
}

class ShiftGroupingViewModel {
    @JsonProperty("SgId")
    private Integer sgId;
    @JsonProperty("CompId")
    private Integer compId;
    @JsonProperty("Company")
    private String company;
    @JsonProperty("LeId")
    private Integer leId;
    @JsonProperty("LegalEntity")
    private String legalEntity;
    @JsonProperty("BuId")
    private Integer buId;
    @JsonProperty("BusinessUnit")
    private String businessUnit;
    @JsonProperty("LocationId")
    private Integer locationId;
    @JsonProperty("Location")
    private String location;
    @JsonProperty("Status")
    private Boolean status;
    @JsonProperty("CreatedBy")
    private Integer createdBy;
    @JsonProperty("CreatedDate")
    private Date createdDate;
    @JsonProperty("LastUpdatedBy")
    private Integer lastUpdatedBy;
    @JsonProperty("LastUpdatedDate")
    private Date lastUpdatedDate;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("IsUpdated")
    private Boolean isUpdated;
    @JsonProperty("IsDeleted")
    private Boolean isDeleted;
    @JsonProperty("LoginId")
    private Integer loginId;
    @JsonProperty("Msg")
    private String msg;
    @JsonProperty("LstOfShift")
    private List<ShiftMasterViewModel> lstOfShift;

    public Integer getSgId() { return sgId; }
    public void setSgId(Integer sgId) { this.sgId = sgId; }

    public Integer getCompId() { return compId; }
    public void setCompId(Integer compId) { this.compId = compId; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public Integer getLeId() { return leId; }
    public void setLeId(Integer leId) { this.leId = leId; }

    public String getLegalEntity() { return legalEntity; }
    public void setLegalEntity(String legalEntity) { this.legalEntity = legalEntity; }

    public Integer getBuId() { return buId; }
    public void setBuId(Integer buId) { this.buId = buId; }

    public String getBusinessUnit() { return businessUnit; }
    public void setBusinessUnit(String businessUnit) { this.businessUnit = businessUnit; }

    public Integer getLocationId() { return locationId; }
    public void setLocationId(Integer locationId) { this.locationId = locationId; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }

    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }

    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    public Integer getLastUpdatedBy() { return lastUpdatedBy; }
    public void setLastUpdatedBy(Integer lastUpdatedBy) { this.lastUpdatedBy = lastUpdatedBy; }

    public Date getLastUpdatedDate() { return lastUpdatedDate; }
    public void setLastUpdatedDate(Date lastUpdatedDate) { this.lastUpdatedDate = lastUpdatedDate; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public Boolean getIsUpdated() { return isUpdated; }
    public void setIsUpdated(Boolean isUpdated) { this.isUpdated = isUpdated; }

    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }

    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }

    public List<ShiftMasterViewModel> getLstOfShift() { return lstOfShift; }
    public void setLstOfShift(List<ShiftMasterViewModel> lstOfShift) { this.lstOfShift = lstOfShift; }
}