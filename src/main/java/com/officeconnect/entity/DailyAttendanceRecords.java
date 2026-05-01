package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name = "DailyAttendanceRecords")
public class DailyAttendanceRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "RecordDate")
    @Temporal(TemporalType.DATE)
    private Date recordDate;

    @Column(name = "EmpId")
    private Integer empId;

    @Column(name = "EmpCode")
    private String empCode;

    @Column(name = "EmpName")
    private String empName;

    @Column(name = "LogDate")
    @Temporal(TemporalType.DATE)
    private Date logDate;

    @Column(name = "DayName")
    private String dayName;

    @Column(name = "IsWeekend")
    private Boolean isWeekend;

    @Column(name = "IsHoliday")
    private Boolean isHoliday;

    @Column(name = "LogInTime")
    private String logInTime;

    @Column(name = "LogOutTime")
    private String logOutTime;

    @Column(name = "ESSLLogInTime")
    private String esslLogInTime;

    @Column(name = "ESSLLogOutTime")
    private String esslLogOutTime;

    @Column(name = "WFHLogInTime")
    private String wfhLogInTime;

    @Column(name = "WFHLogOutTime")
    private String wfhLogOutTime;

    @Column(name = "ONSITELogInTime")
    private String onsitelogInTime;

    @Column(name = "ONSITELogOutTime")
    private String onsitelogOutTime;

    @Column(name = "WorkingHours")
    private String workingHours;

    @Column(name = "WorkingHoursDecimal")
    private BigDecimal workingHoursDecimal;

    @Column(name = "CompId")
    private Integer compId;

    @Column(name = "CompName")
    private String compName;

    @Column(name = "Designation")
    private String designation;

    @Column(name = "DeptName")
    private String deptName;

    @Column(name = "DeptId")
    private Integer deptId;

    @Column(name = "DesignationId")
    private Integer designationId;

    @Column(name = "DailyPay")
    private BigDecimal dailyPay;

    @Column(name = "LeaveType")
    private String leaveType;

    @Column(name = "WorkType")
    private String workType;

    @Column(name = "DaysPresent")
    private Boolean daysPresent;

    @Column(name = "PayDays")
    private BigDecimal payDays;

    @Column(name = "ActiveHours")
    private String activeHours;

    @Column(name = "ESSLActiveHours")
    private String esslActiveHours;

    @Column(name = "WFHActiveHours")
    private String wfhActiveHours;

    @Column(name = "ONSITEActiveHours")
    private String onsitelActiveHours;

    @Column(name = "MANUALActiveHours")
    private String manualActiveHours;

    @Column(name = "ShiftName")
    private String shiftName;

    @Column(name = "BreakTime")
    private String breakTime;

    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "LastUpdatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDate;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Date getRecordDate() { return recordDate; }
    public void setRecordDate(Date recordDate) { this.recordDate = recordDate; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public Date getLogDate() { return logDate; }
    public void setLogDate(Date logDate) { this.logDate = logDate; }

    public String getDayName() { return dayName; }
    public void setDayName(String dayName) { this.dayName = dayName; }

    public Boolean getIsWeekend() { return isWeekend; }
    public void setIsWeekend(Boolean isWeekend) { this.isWeekend = isWeekend; }

    public Boolean getIsHoliday() { return isHoliday; }
    public void setIsHoliday(Boolean isHoliday) { this.isHoliday = isHoliday; }

    public String getLogInTime() { return logInTime; }
    public void setLogInTime(String logInTime) { this.logInTime = logInTime; }

    public String getLogOutTime() { return logOutTime; }
    public void setLogOutTime(String logOutTime) { this.logOutTime = logOutTime; }

    public String getesslLogInTime() { return esslLogInTime; }
    public void setesslLogInTime(String esslLogInTime) { this.esslLogInTime = esslLogInTime; }

    public String getesslLogOutTime() { return esslLogOutTime; }
    public void setesslLogOutTime(String esslLogOutTime) { this.esslLogOutTime = esslLogOutTime; }

    public String getwfhLogInTime() { return wfhLogInTime; }
    public void setwfhLogInTime(String wfhLogInTime) { this.wfhLogInTime = wfhLogInTime; }

    public String getwfhLogOutTime() { return wfhLogOutTime; }
    public void setwfhLogOutTime(String wfhLogOutTime) { this.wfhLogOutTime = wfhLogOutTime; }

    public String getonsitelogInTime() { return onsitelogInTime; }
    public void setonsitelogInTime(String onsitelogInTime) { this.onsitelogInTime = onsitelogInTime; }

    public String getonsitelogOutTime() { return onsitelogOutTime; }
    public void setonsitelogOutTime(String onsitelogOutTime) { this.onsitelogOutTime = onsitelogOutTime; }

    public String getWorkingHours() { return workingHours; }
    public void setWorkingHours(String workingHours) { this.workingHours = workingHours; }

    public BigDecimal getWorkingHoursDecimal() { return workingHoursDecimal; }
    public void setWorkingHoursDecimal(BigDecimal workingHoursDecimal) { this.workingHoursDecimal = workingHoursDecimal; }

    public Integer getCompId() { return compId; }
    public void setCompId(Integer compId) { this.compId = compId; }

    public String getCompName() { return compName; }
    public void setCompName(String compName) { this.compName = compName; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }

    public Integer getDeptId() { return deptId; }
    public void setDeptId(Integer deptId) { this.deptId = deptId; }

    public Integer getDesignationId() { return designationId; }
    public void setDesignationId(Integer designationId) { this.designationId = designationId; }

    public BigDecimal getDailyPay() { return dailyPay; }
    public void setDailyPay(BigDecimal dailyPay) { this.dailyPay = dailyPay; }

    public String getLeaveType() { return leaveType; }
    public void setLeaveType(String leaveType) { this.leaveType = leaveType; }

    public String getWorkType() { return workType; }
    public void setWorkType(String workType) { this.workType = workType; }

    public Boolean getDaysPresent() { return daysPresent; }
    public void setDaysPresent(Boolean daysPresent) { this.daysPresent = daysPresent; }

    public BigDecimal getPayDays() { return payDays; }
    public void setPayDays(BigDecimal payDays) { this.payDays = payDays; }

    public String getActiveHours() { return activeHours; }
    public void setActiveHours(String activeHours) { this.activeHours = activeHours; }

    public String getesslActiveHours() { return esslActiveHours; }
    public void setesslActiveHours(String esslActiveHours) { this.esslActiveHours = esslActiveHours; }

    public String getwfhActiveHours() { return wfhActiveHours; }
    public void setwfhActiveHours(String wfhActiveHours) { this.wfhActiveHours = wfhActiveHours; }

    public String getonsitelActiveHours() { return onsitelActiveHours; }
    public void setonsitelActiveHours(String onsitelActiveHours) { this.onsitelActiveHours = onsitelActiveHours; }

    public String getmanualActiveHours() { return manualActiveHours; }
    public void setmanualActiveHours(String manualActiveHours) { this.manualActiveHours = manualActiveHours; }

    public String getShiftName() { return shiftName; }
    public void setShiftName(String shiftName) { this.shiftName = shiftName; }

    public String getBreakTime() { return breakTime; }
    public void setBreakTime(String breakTime) { this.breakTime = breakTime; }

    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    public Date getLastUpdatedDate() { return lastUpdatedDate; }
    public void setLastUpdatedDate(Date lastUpdatedDate) { this.lastUpdatedDate = lastUpdatedDate; }
}