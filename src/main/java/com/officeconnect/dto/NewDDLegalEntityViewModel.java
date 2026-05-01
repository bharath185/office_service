package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewDDLegalEntityViewModel {
    @JsonProperty("LeId")
    private Integer leId;
    @JsonProperty("CompId")
    private Integer compId;
    @JsonProperty("LegalEntity")
    private String legalEntity;
    @JsonProperty("LoginId")
    private Integer loginId;

    public Integer getLeId() { return leId; }
    public void setLeId(Integer leId) { this.leId = leId; }

    public Integer getCompId() { return compId; }
    public void setCompId(Integer compId) { this.compId = compId; }

    public String getLegalEntity() { return legalEntity; }
    public void setLegalEntity(String legalEntity) { this.legalEntity = legalEntity; }

    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }
}
