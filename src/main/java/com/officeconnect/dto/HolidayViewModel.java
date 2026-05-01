package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class HolidayViewModel {
    @JsonProperty("Holiday_Id")
    private Integer[] holidayId;
    
    @JsonProperty("Title")
    private String title;
    
    @JsonProperty("Day")
    private String day = null;
    
    @JsonProperty("Date")
    private String date;
    
    @JsonProperty("Description")
    private String description;
    
    @JsonProperty("Created_By")
    private Integer createdBy;
    
    @JsonProperty("Created_Date")
    private String createdDate;
    
    @JsonProperty("Modify_By")
    private Integer modifyBy;
    
    @JsonProperty("Modify_Date")
    private String modifyDate;
    
    @JsonProperty("Status")
    private String status;
    
    @JsonProperty("msg")
    private String msg = null;
    
    @JsonProperty("LoginId")
    private Integer loginId = 0;
    
    @JsonProperty("LocationId")
    private Integer[] locationId;
    
    @JsonProperty("HolidayLocationId")
    private Integer[] holidayLocationId;
    
    @JsonProperty("HolidayType")
    private String holidayType;
    
    @JsonProperty("Year")
    private Integer year;
    
    @JsonProperty("Location")
    private String[] location;
    
    @JsonProperty("HolidayLocation")
    private String[] holidayLocation;
    
    @JsonProperty("UpdatedHolidays")
    private String updatedHolidays = null;

    public Integer[] getHolidayId() { return holidayId; }
    public void setHolidayId(Integer[] holidayId) { this.holidayId = holidayId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDay() { return day; }
    public void setDay(String day) { this.day = day; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }
    public String getCreatedDate() { return createdDate; }
    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }
    public Integer getModifyBy() { return modifyBy; }
    public void setModifyBy(Integer modifyBy) { this.modifyBy = modifyBy; }
    public String getModifyDate() { return modifyDate; }
    public void setModifyDate(String modifyDate) { this.modifyDate = modifyDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }
    public Integer[] getLocationId() { return locationId; }
    public void setLocationId(Integer[] locationId) { this.locationId = locationId; }
    public Integer[] getHolidayLocationId() { return holidayLocationId; }
    public void setHolidayLocationId(Integer[] holidayLocationId) { this.holidayLocationId = holidayLocationId; }
    public String getHolidayType() { return holidayType; }
    public void setHolidayType(String holidayType) { this.holidayType = holidayType; }
    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
    public String[] getLocation() { return location; }
    public void setLocation(String[] location) { this.location = location; }
    public String[] getHolidayLocation() { return holidayLocation; }
    public void setHolidayLocation(String[] holidayLocation) { this.holidayLocation = holidayLocation; }
    public String getUpdatedHolidays() { return updatedHolidays; }
    public void setUpdatedHolidays(String updatedHolidays) { this.updatedHolidays = updatedHolidays; }

    public static String formatDate(Date date) {
        return date == null ? null : "/Date(" + date.getTime() + ")/";
    }
}
