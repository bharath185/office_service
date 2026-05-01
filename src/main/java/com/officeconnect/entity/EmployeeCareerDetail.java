package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EmployeeCareerDetails")
public class EmployeeCareerDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CareerId")
    private Integer careerId;

    @Column(name = "EmpId")
    private Integer empId;

    @Column(name = "Company")
    private String company;

    @Column(name = "Designation")
    private String designation;

    @Column(name = "FromDate")
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Column(name = "ToDate")
    @Temporal(TemporalType.DATE)
    private Date toDate;

    @Column(name = "Experience")
    private String experience;

    @Column(name = "PMonth1")
    private String pMonth1;

    @Column(name = "PaySlip1")
    private String paySlip1;

    @Column(name = "PMonth2")
    private String pMonth2;

    @Column(name = "PaySlip2")
    private String paySlip2;

    @Column(name = "PMonth3")
    private String pMonth3;

    @Column(name = "PaySlip3")
    private String paySlip3;

    @Column(name = "OfferLetter")
    private String offerLetter;

    @Column(name = "SalaryLetter")
    private String salaryLetter;

    @Column(name = "ExperienceLetter")
    private String experienceLetter;

    @Column(name = "RelievingLetter")
    private String relievingLetter;

    @Column(name = "ContactName")
    private String contactName;

    @Column(name = "ContactDesignation")
    private String contactDesignation;

    @Column(name = "ContactEmail")
    private String contactEmail;

    @Column(name = "ContactMobile")
    private String contactMobile;

    @Column(name = "CTC")
    private String ctc;

    @Column(name = "Reason")
    private String reason;

    @Column(name = "CreatedBy")
    private Integer createdBy;

    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "LastUpdatedBy")
    private Integer lastUpdatedBy;

    @Column(name = "LastUpdatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDate;

    @Column(name = "IsActive")
    private Boolean isActive;

    @Column(name = "IsUpdated")
    private Boolean isUpdated;

    @Column(name = "IsDeleted")
    private Boolean isDeleted;

    public Integer getCareerId() { return careerId; }
    public void setCareerId(Integer careerId) { this.careerId = careerId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public Date getFromDate() { return fromDate; }
    public void setFromDate(Date fromDate) { this.fromDate = fromDate; }

    public Date getToDate() { return toDate; }
    public void setToDate(Date toDate) { this.toDate = toDate; }

    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }

    public String getPMonth1() { return pMonth1; }
    public void setPMonth1(String pMonth1) { this.pMonth1 = pMonth1; }

    public String getPaySlip1() { return paySlip1; }
    public void setPaySlip1(String paySlip1) { this.paySlip1 = paySlip1; }

    public String getPMonth2() { return pMonth2; }
    public void setPMonth2(String pMonth2) { this.pMonth2 = pMonth2; }

    public String getPaySlip2() { return paySlip2; }
    public void setPaySlip2(String paySlip2) { this.paySlip2 = paySlip2; }

    public String getPMonth3() { return pMonth3; }
    public void setPMonth3(String pMonth3) { this.pMonth3 = pMonth3; }

    public String getPaySlip3() { return paySlip3; }
    public void setPaySlip3(String paySlip3) { this.paySlip3 = paySlip3; }

    public String getOfferLetter() { return offerLetter; }
    public void setOfferLetter(String offerLetter) { this.offerLetter = offerLetter; }

    public String getSalaryLetter() { return salaryLetter; }
    public void setSalaryLetter(String salaryLetter) { this.salaryLetter = salaryLetter; }

    public String getExperienceLetter() { return experienceLetter; }
    public void setExperienceLetter(String experienceLetter) { this.experienceLetter = experienceLetter; }

    public String getRelievingLetter() { return relievingLetter; }
    public void setRelievingLetter(String relievingLetter) { this.relievingLetter = relievingLetter; }

    public String getContactName() { return contactName; }
    public void setContactName(String contactName) { this.contactName = contactName; }

    public String getContactDesignation() { return contactDesignation; }
    public void setContactDesignation(String contactDesignation) { this.contactDesignation = contactDesignation; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public String getContactMobile() { return contactMobile; }
    public void setContactMobile(String contactMobile) { this.contactMobile = contactMobile; }

    public String getCtc() { return ctc; }
    public void setCtc(String ctc) { this.ctc = ctc; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }

    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    public Integer getLastUpdatedBy() { return lastUpdatedBy; }
    public void setLastUpdatedBy(Integer lastUpdatedBy) { this.lastUpdatedBy = lastUpdatedBy; }

    public Date getLastUpdatedDate() { return lastUpdatedDate; }
    public void setLastUpdatedDate(Date lastUpdatedDate) { this.lastUpdatedDate = lastUpdatedDate; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public Boolean getIsUpdated() { return isUpdated; }
    public void setIsUpdated(Boolean isUpdated) { this.isUpdated = isUpdated; }

    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }
}
