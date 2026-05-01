package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DDBusinessUnitViewModel {
    @JsonProperty("BUId")
    @JsonAlias({"buId", "BuId", "BUId"})
    private Integer buId;
    @JsonProperty("LEId")
    @JsonAlias({"leId", "LeId", "LEId"})
    private Integer leId;
    @JsonProperty("CompId")
    @JsonAlias({"compId", "CompId"})
    private Integer compId;
    @JsonProperty("BusinessUnit")
    @JsonAlias({"businessUnit", "BusinessUnit"})
    private String businessUnit;
    @JsonProperty("EmpId")
    @JsonAlias({"empId", "EmpId"})
    private Integer empId;
    @JsonProperty("AuthorisedEntity")
    @JsonAlias({"authorisedEntity", "AuthorisedEntity"})
    private String authorisedEntity;

    public Integer getBuId() { return buId; }
    public void setBuId(Integer buId) { this.buId = buId; }

    public Integer getLeId() { return leId; }
    public void setLeId(Integer leId) { this.leId = leId; }

    public Integer getCompId() { return compId; }
    public void setCompId(Integer compId) { this.compId = compId; }

    public String getBusinessUnit() { return businessUnit; }
    public void setBusinessUnit(String businessUnit) { this.businessUnit = businessUnit; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getAuthorisedEntity() { return authorisedEntity; }
    public void setAuthorisedEntity(String authorisedEntity) { this.authorisedEntity = authorisedEntity; }
}
