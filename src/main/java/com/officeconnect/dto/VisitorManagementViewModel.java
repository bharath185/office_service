package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VisitorManagementViewModel {
    @JsonProperty("VisitorId")
    private Integer visitorId;
    @JsonProperty("EmpId")
    private Integer empId;
    @JsonProperty("EmpCode")
    private String empCode;
    @JsonProperty("VisitorName")
    private String visitorName;
    @JsonProperty("Company")
    private String company;
    @JsonProperty("ContactNo")
    private String contactNo;
    @JsonProperty("EmailId")
    private String emailId;
    @JsonProperty("Purpose")
    private String purpose;
    @JsonProperty("VisitDate")
    private java.util.Date visitDate;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("Msg")
    private String msg;

    public Integer getVisitorId() { return visitorId; }
    public void setVisitorId(Integer visitorId) { this.visitorId = visitorId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }

    public String getVisitorName() { return visitorName; }
    public void setVisitorName(String visitorName) { this.visitorName = visitorName; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getContactNo() { return contactNo; }
    public void setContactNo(String contactNo) { this.contactNo = contactNo; }

    public String getEmailId() { return emailId; }
    public void setEmailId(String emailId) { this.emailId = emailId; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    public java.util.Date getVisitDate() { return visitDate; }
    public void setVisitDate(java.util.Date visitDate) { this.visitDate = visitDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
}