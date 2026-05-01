package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShiftGroupingMasterViewModel {
    @JsonProperty("ShiftGroupingId")
    private Integer shiftGroupingId;
    @JsonProperty("ShiftGroupingName")
    private String shiftGroupingName;
    @JsonProperty("LocationId")
    private Integer locationId;
    @JsonProperty("CompanyId")
    private Integer companyId;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("ShiftId")
    private Integer shiftId;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("CreatedBy")
    private Integer createdBy;
    @JsonProperty("LastUpdatedBy")
    private Integer lastUpdatedBy;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("IsUpdated")
    private Boolean isUpdated;
    @JsonProperty("IsDeleted")
    private Boolean isDeleted;
    @JsonProperty("Msg")
    private String msg;

    public Integer getShiftGroupingId() { return shiftGroupingId; }
    public void setShiftGroupingId(Integer shiftGroupingId) { this.shiftGroupingId = shiftGroupingId; }

    public String getShiftGroupingName() { return shiftGroupingName; }
    public void setShiftGroupingName(String shiftGroupingName) { this.shiftGroupingName = shiftGroupingName; }

    public Integer getLocationId() { return locationId; }
    public void setLocationId(Integer locationId) { this.locationId = locationId; }

    public Integer getCompanyId() { return companyId; }
    public void setCompanyId(Integer companyId) { this.companyId = companyId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getShiftId() { return shiftId; }
    public void setShiftId(Integer shiftId) { this.shiftId = shiftId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }

    public Integer getLastUpdatedBy() { return lastUpdatedBy; }
    public void setLastUpdatedBy(Integer lastUpdatedBy) { this.lastUpdatedBy = lastUpdatedBy; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public Boolean getIsUpdated() { return isUpdated; }
    public void setIsUpdated(Boolean isUpdated) { this.isUpdated = isUpdated; }

    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
}
