package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SrNo")
    private Integer srNo;

    @Column(name = "LogID")
    private Integer logID;

    @Column(name = "LogDate")
    @Temporal(TemporalType.DATE)
    private Date logDate;

    @Column(name = "LogTime")
    @Temporal(TemporalType.TIME)
    private Date logTime;

    @Column(name = "Type")
    private String type;

    @Column(name = "EmpCode")
    private String empCode;

    public Integer getSrNo() { return srNo; }
    public void setSrNo(Integer srNo) { this.srNo = srNo; }

    public Integer getLogID() { return logID; }
    public void setLogID(Integer logID) { this.logID = logID; }

    public Date getLogDate() { return logDate; }
    public void setLogDate(Date logDate) { this.logDate = logDate; }

    public Date getLogTime() { return logTime; }
    public void setLogTime(Date logTime) { this.logTime = logTime; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }
}