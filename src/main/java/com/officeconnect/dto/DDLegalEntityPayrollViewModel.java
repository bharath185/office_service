package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DDLegalEntityPayrollViewModel {
    @JsonProperty("LEId")
    private Integer leId;
    @JsonProperty("LegalEntity")
    private String legalEntity;
    @JsonProperty("LoginId")
    private Integer loginId;

    public Integer getLEId() { return leId; }
    public void setLEId(Integer leId) { this.leId = leId; }
    public String getLegalEntity() { return legalEntity; }
    public void setLegalEntity(String legalEntity) { this.legalEntity = legalEntity; }
    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }
}
