package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Holidays")
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Holiday_Id")
    @JsonProperty("HolidayId")
    private Integer holidayId;

    @Column(name = "Title")
    @JsonProperty("Title")
    private String title;

    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    @JsonProperty("Date")
    private Date date;

    @Column(name = "Description")
    @JsonProperty("Description")
    private String description;

    @Column(name = "Created_By")
    @JsonProperty("CreatedBy")
    private Integer createdBy;

    @Column(name = "Created_Date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("CreatedDate")
    private Date createdDate;

    @Column(name = "Modify_By")
    @JsonProperty("ModifyBy")
    private Integer modifyBy;

    @Column(name = "Modify_Date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("ModifyDate")
    private Date modifyDate;

    @Column(name = "Status")
    @JsonProperty("Status")
    private String status;

    @Column(name = "Year")
    @JsonProperty("Year")
    private Integer year;

    @Column(name = "LocationId")
    @JsonProperty("LocationId")
    private Integer locationId;

    @Column(name = "HolidayType")
    @JsonProperty("HolidayType")
    private String holidayType;

    @Column(name = "Location")
    @JsonProperty("Location")
    private String location;

    public Integer getId() { return holidayId; }
    public void setId(Integer id) { this.holidayId = id; }

    public Integer getHolidayId() { return holidayId; }
    public void setHolidayId(Integer holidayId) { this.holidayId = holidayId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }

    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    public Integer getModifyBy() { return modifyBy; }
    public void setModifyBy(Integer modifyBy) { this.modifyBy = modifyBy; }

    public Date getModifyDate() { return modifyDate; }
    public void setModifyDate(Date modifyDate) { this.modifyDate = modifyDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public Integer getLocationId() { return locationId; }
    public void setLocationId(Integer locationId) { this.locationId = locationId; }

    public String getHolidayType() { return holidayType; }
    public void setHolidayType(String holidayType) { this.holidayType = holidayType; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
