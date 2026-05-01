package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PayoutMappingMasterViewModel {
    @JsonProperty("LoginId")
    @JsonAlias({"loginId", "LoginId"})
    private Integer loginId;

    @JsonProperty("MapId")
    private Integer mapId;

    @JsonProperty("GradeId")
    private Integer gradeId;

    @JsonProperty("Grade")
    private String grade;

    @JsonProperty("PayoutTypeId")
    private Integer payoutTypeId;

    @JsonProperty("PayoutTypeName")
    private String payoutTypeName;

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
    public Integer getMapId() { return mapId; }
    public void setMapId(Integer mapId) { this.mapId = mapId; }
    public Integer getGradeId() { return gradeId; }
    public void setGradeId(Integer gradeId) { this.gradeId = gradeId; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public Integer getPayoutTypeId() { return payoutTypeId; }
    public void setPayoutTypeId(Integer payoutTypeId) { this.payoutTypeId = payoutTypeId; }
    public String getPayoutTypeName() { return payoutTypeName; }
    public void setPayoutTypeName(String payoutTypeName) { this.payoutTypeName = payoutTypeName; }
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
