package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DDLegalEntityViewModel {
    @JsonProperty("LEId")
    @JsonAlias({"leId", "LeId", "LEId"})
    private Integer leId;
    @JsonProperty("CompId")
    @JsonAlias({"compId", "CompId"})
    private Integer compId;
    @JsonProperty("LegalEntity")
    @JsonAlias({"legalEntity", "LegalEntity"})
    private String legalEntity;
    @JsonProperty("EmpId")
    @JsonAlias({"empId", "EmpId"})
    private Integer empId;
    @JsonProperty("AuthorisedEntity")
    @JsonAlias({"authorisedEntity", "AuthorisedEntity"})
    private String authorisedEntity;

    public Integer getLeId() { return leId; }
    public void setLeId(Integer leId) { this.leId = leId; }

    public Integer getCompId() { return compId; }
    public void setCompId(Integer compId) { this.compId = compId; }

    public String getLegalEntity() { return legalEntity; }
    public void setLegalEntity(String legalEntity) { this.legalEntity = legalEntity; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getAuthorisedEntity() { return authorisedEntity; }
    public void setAuthorisedEntity(String authorisedEntity) { this.authorisedEntity = authorisedEntity; }
}