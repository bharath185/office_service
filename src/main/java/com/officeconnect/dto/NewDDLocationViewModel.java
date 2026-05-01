package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewDDLocationViewModel {
    @JsonProperty("LocationId")
    @JsonAlias({"locationId", "LocationId"})
    private Integer locationId;
    @JsonProperty("LeId")
    @JsonAlias({"leId", "LeId"})
    private Integer leId;
    @JsonProperty("CompId")
    @JsonAlias({"compId", "CompId"})
    private Integer compId;
    @JsonProperty("Location")
    @JsonAlias({"location", "Location"})
    private String location;
    @JsonProperty("LoginId")
    @JsonAlias({"loginId", "LoginId"})
    private Integer loginId;

    public Integer getLocationId() { return locationId; }
    public void setLocationId(Integer locationId) { this.locationId = locationId; }

    public Integer getLeId() { return leId; }
    public void setLeId(Integer leId) { this.leId = leId; }

    public Integer getCompId() { return compId; }
    public void setCompId(Integer compId) { this.compId = compId; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }
}
