package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DDApproverViewModel {
    @JsonProperty("ApproverId")
    @JsonAlias({"approverId", "ApproverId"})
    private Integer approverId;

    @JsonProperty("Approver")
    @JsonAlias({"approver", "Approver"})
    private String approver;

    @JsonProperty("CompId")
    @JsonAlias({"compId", "CompId"})
    private Integer compId;

    @JsonProperty("LEId")
    @JsonAlias({"leId", "LEId"})
    private Integer leId;

    @JsonProperty("BUId")
    @JsonAlias({"buId", "BUId"})
    private Integer buId;

    @JsonProperty("LocationId")
    @JsonAlias({"locationId", "LocationId"})
    private Integer locationId;

    @JsonProperty("EmpId")
    @JsonAlias({"empId", "EmpId"})
    private Integer empId;

    @JsonProperty("AuthorisedEntity")
    @JsonAlias({"authorisedEntity", "AuthorisedEntity"})
    private String authorisedEntity;

    public Integer getApproverId() { return approverId; }
    public void setApproverId(Integer approverId) { this.approverId = approverId; }

    public String getApprover() { return approver; }
    public void setApprover(String approver) { this.approver = approver; }

    public Integer getCompId() { return compId; }
    public void setCompId(Integer compId) { this.compId = compId; }

    @JsonIgnore
    public Integer getLEId() { return leId; }
    public void setLEId(Integer leId) { this.leId = leId; }

    @JsonIgnore
    public Integer getBUId() { return buId; }
    public void setBUId(Integer buId) { this.buId = buId; }

    public Integer getLocationId() { return locationId; }
    public void setLocationId(Integer locationId) { this.locationId = locationId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getAuthorisedEntity() { return authorisedEntity; }
    public void setAuthorisedEntity(String authorisedEntity) { this.authorisedEntity = authorisedEntity; }
}
