package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VisitorManagement")
public class VisitorManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VisitId")
    private Integer visitorId;

    @Column(name = "RegNo")
    private String regNo;

    @Column(name = "QR")
    private String qr;

    @Column(name = "Name")
    private String visitorName;

    @Column(name = "Designation")
    private String designation;

    @Column(name = "Company")
    private String company;

    @Column(name = "Purpose")
    private String purpose;

    @Column(name = "PMail")
    private String pMail;

    @Column(name = "OMail")
    private String oMail;

    @Column(name = "Mobile")
    private String mobile;

    @Column(name = "AMobile")
    private String aMobile;

    @Column(name = "Photo")
    private String photo;

    @Column(name = "CompId")
    private String compId;

    @Column(name = "WhomtoMeet")
    private Integer whomToMeet;

    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date visitDate;

    @Column(name = "Time")
    private String time;

    @Column(name = "Invited")
    private Boolean invited;

    @Column(name = "Accept")
    private Boolean accept;

    @Column(name = "Approved")
    private Boolean approved;

    @Column(name = "Expired")
    private Boolean expired;

    @Column(name = "Accessories")
    private String accessories;

    @Column(name = "DirectCheckIn")
    private Boolean directCheckIn;

    @Column(name = "CheckIn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkIn;

    @Column(name = "CheckOut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOut;

    @Column(name = "IdCard")
    private String idCard;

    @Column(name = "CreatedBy")
    private Integer createdBy;

    @Column(name = "CreatedDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name = "LastUpdatedBy")
    private Integer lastUpdatedBy;

    @Column(name = "LastUpdatedDate")
    @Temporal(TemporalType.DATE)
    private Date lastUpdatedDate;

    @Column(name = "IsActive")
    private Boolean isActive;

    @Column(name = "IsUpdated")
    private Boolean isUpdated;

    @Column(name = "IsDeleted")
    private Boolean isDeleted;

    public Integer getVisitorId() { return visitorId; }
    public void setVisitorId(Integer visitorId) { this.visitorId = visitorId; }

    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }

    public String getVisitorName() { return visitorName; }
    public void setVisitorName(String visitorName) { this.visitorName = visitorName; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public Date getVisitDate() { return visitDate; }
    public void setVisitDate(Date visitDate) { this.visitDate = visitDate; }

    public Boolean getApproved() { return approved; }
    public void setApproved(Boolean approved) { this.approved = approved; }

    public Date getCheckIn() { return checkIn; }
    public void setCheckIn(Date checkIn) { this.checkIn = checkIn; }

    public Date getCheckOut() { return checkOut; }
    public void setCheckOut(Date checkOut) { this.checkOut = checkOut; }

    public String getName() { return visitorName; }
    public void setName(String name) { this.visitorName = name; }

    public String getPMail() { return pMail; }
    public void setPMail(String pMail) { this.pMail = pMail; }

    public Integer getWhomToMeet() { return whomToMeet; }
    public void setWhomToMeet(Integer whomToMeet) { this.whomToMeet = whomToMeet; }

    public Boolean getInvited() { return invited; }
    public void setInvited(Boolean invited) { this.invited = invited; }

    public Boolean getExpired() { return expired; }
    public void setExpired(Boolean expired) { this.expired = expired; }

    public Boolean getDirectCheckIn() { return directCheckIn; }
    public void setDirectCheckIn(Boolean directCheckIn) { this.directCheckIn = directCheckIn; }

    public Boolean getAccept() { return accept; }
    public void setAccept(Boolean accept) { this.accept = accept; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public Boolean getIsUpdated() { return isUpdated; }
    public void setIsUpdated(Boolean isUpdated) { this.isUpdated = isUpdated; }

    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }

    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }

    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    public Integer getLastUpdatedBy() { return lastUpdatedBy; }
    public void setLastUpdatedBy(Integer lastUpdatedBy) { this.lastUpdatedBy = lastUpdatedBy; }

    public Date getLastUpdatedDate() { return lastUpdatedDate; }
    public void setLastUpdatedDate(Date lastUpdatedDate) { this.lastUpdatedDate = lastUpdatedDate; }
}