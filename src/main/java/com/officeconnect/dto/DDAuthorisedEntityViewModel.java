package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DDAuthorisedEntityViewModel {
    @JsonProperty("EmpId")
    @JsonAlias({"empId", "EmpId"})
    private Integer empId;
    @JsonProperty("LoginId")
    @JsonAlias({"loginId", "LoginId"})
    private Integer loginId;
    @JsonProperty("AuthorisedEntity")
    @JsonAlias({"authorisedEntity", "AuthorisedEntity"})
    private String authorisedEntity;
    @JsonProperty("LeId")
    @JsonAlias({"leId", "LeId"})
    private Integer leId;
    @JsonProperty("LegalEntity")
    @JsonAlias({"legalEntity", "LegalEntity"})
    private String legalEntity;

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }

    public String getAuthorisedEntity() { return authorisedEntity; }
    public void setAuthorisedEntity(String authorisedEntity) { this.authorisedEntity = authorisedEntity; }

    public Integer getLeId() { return leId; }
    public void setLeId(Integer leId) { this.leId = leId; }

    public String getLegalEntity() { return legalEntity; }
    public void setLegalEntity(String legalEntity) { this.legalEntity = legalEntity; }
}