package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginDetailsViewModel {
    @JsonProperty("LoginId")
    private Integer loginId;
    @JsonProperty("UserName")
    private String userName;
    @JsonProperty("EmpCode")
    private String empCode;
    @JsonProperty("Date")
    private String date;
    @JsonProperty("Time")
    private String time;
    @JsonProperty("Mode")
    private String mode;
    @JsonProperty("EmpId")
    private Integer empId;

    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }
}