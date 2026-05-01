package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HolidayMaster")
public class HolidayMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Holiday_Type_Id")
    private Integer holidayTypeId;

    @Column(name = "Holiday_Type_Name")
    private String holidayTypeName;

    public Integer getHolidayTypeId() { return holidayTypeId; }
    public void setHolidayTypeId(Integer holidayTypeId) { this.holidayTypeId = holidayTypeId; }

    public String getHolidayTypeName() { return holidayTypeName; }
    public void setHolidayTypeName(String holidayTypeName) { this.holidayTypeName = holidayTypeName; }
}