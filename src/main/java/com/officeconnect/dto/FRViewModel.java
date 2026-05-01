package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FRViewModel {
    @JsonProperty("UserName")
    private String userName;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Otp")
    private String otp;
    @JsonProperty("AuthKey")
    private String authKey;
    @JsonProperty("RoleId")
    private Integer roleId;
    @JsonProperty("EmpId")
    private Integer empId;
    @JsonProperty("EmpCode")
    private String empCode;
    @JsonProperty("Msg")
    private String msg;

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getOtp() { return otp; }
    public void setOtp(String otp) { this.otp = otp; }

    public String getAuthKey() { return authKey; }
    public void setAuthKey(String authKey) { this.authKey = authKey; }

    public Integer getRoleId() { return roleId; }
    public void setRoleId(Integer roleId) { this.roleId = roleId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
}