package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EmployeeMaster")
public class EmployeeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmpId")
    private Integer empId;

    @Column(name = "OldEmp_ID")
    private Integer oldEmp_ID;

    @Column(name = "CompId")
    private Integer compId;

    @Column(name = "LEId")
    private Integer leId;

    @Column(name = "BUId")
    private Integer buId;

    @Column(name = "LocationId")
    private Integer locationId;

    @Column(name = "CategoryId")
    private Integer categoryId;

    @Column(name = "DeptName")
    private String deptName;

    @Column(name = "DesignationId")
    private Integer designationId;

    @Column(name = "DesignationName")
    private String designationName;

    @Column(name = "ReportId")
    private Integer reportId;

    @Column(name = "ReportName")
    private String reportName;

    @Column(name = "EmpCode")
    private String empCode;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "Password")
    private String password;

    @Column(name = "Photo")
    private String photo;

    @Column(name = "Salutation")
    private Integer salutation;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "MiddleName")
    private String middleName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "MobileNo")
    private String mobileNo;

    @Column(name = "EmailId")
    private String emailId;

    @Column(name = "BloodGroup")
    private String bloodGroup;

    @Column(name = "MaritalStatus")
    private String maritalStatus;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "JoiningDate")
    @Temporal(TemporalType.DATE)
    private Date joiningDate;

    @Column(name = "InterviewDate")
    @Temporal(TemporalType.DATE)
    private Date interviewDate;

    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "EmpStatus")
    private String empStatus;

    @Column(name = "Reason")
    private String reason;

    @Column(name = "EmpType")
    private Integer empType;

    @Column(name = "CEndDate")
    @Temporal(TemporalType.DATE)
    private Date cEndDate;

    @Column(name = "AuthorisedEntity")
    private String authorisedEntity;

    @Column(name = "RelievedReason")
    private String relievedReason;

    @Column(name = "RelievedDate")
    @Temporal(TemporalType.DATE)
    private Date relievedDate;

    @Column(name = "RelievedEffectiveDate")
    @Temporal(TemporalType.DATE)
    private Date relievedEffectiveDate;

    @Column(name = "IsRelieved")
    private Boolean isRelieved;

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

    // Getters and Setters
    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public Integer getOldEmp_ID() { return oldEmp_ID; }
    public void setOldEmp_ID(Integer oldEmp_ID) { this.oldEmp_ID = oldEmp_ID; }

    public Integer getCompId() { return compId; }
    public void setCompId(Integer compId) { this.compId = compId; }

    public Integer getLeId() { return leId; }
    public void setLeId(Integer leId) { this.leId = leId; }

    public Integer getBuId() { return buId; }
    public void setBuId(Integer buId) { this.buId = buId; }

    public Integer getLocationId() { return locationId; }
    public void setLocationId(Integer locationId) { this.locationId = locationId; }

    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }

    public Integer getDesignationId() { return designationId; }
    public void setDesignationId(Integer designationId) { this.designationId = designationId; }

    public String getDesignationName() { return designationName; }
    public void setDesignationName(String designationName) { this.designationName = designationName; }

    public Integer getReportId() { return reportId; }
    public void setReportId(Integer reportId) { this.reportId = reportId; }

    public String getReportName() { return reportName; }
    public void setReportName(String reportName) { this.reportName = reportName; }

    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    public Integer getSalutation() { return salutation; }
    public void setSalutation(Integer salutation) { this.salutation = salutation; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }

    public String getMobileNo() { return mobileNo; }
    public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }

    public String getEmailId() { return emailId; }
    public void setEmailId(String emailId) { this.emailId = emailId; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public String getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public Date getJoiningDate() { return joiningDate; }
    public void setJoiningDate(Date joiningDate) { this.joiningDate = joiningDate; }

    public Date getInterviewDate() { return interviewDate; }
    public void setInterviewDate(Date interviewDate) { this.interviewDate = interviewDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public String getEmpStatus() { return empStatus; }
    public void setEmpStatus(String empStatus) { this.empStatus = empStatus; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public Integer getEmpType() { return empType; }
    public void setEmpType(Integer empType) { this.empType = empType; }

    public Date getcEndDate() { return cEndDate; }
    public void setcEndDate(Date cEndDate) { this.cEndDate = cEndDate; }

    public String getAuthorisedEntity() { return authorisedEntity; }
    public void setAuthorisedEntity(String authorisedEntity) { this.authorisedEntity = authorisedEntity; }

    public String getRelievedReason() { return relievedReason; }
    public void setRelievedReason(String relievedReason) { this.relievedReason = relievedReason; }

    public Date getRelievedDate() { return relievedDate; }
    public void setRelievedDate(Date relievedDate) { this.relievedDate = relievedDate; }

    public Date getRelievedEffectiveDate() { return relievedEffectiveDate; }
    public void setRelievedEffectiveDate(Date relievedEffectiveDate) { this.relievedEffectiveDate = relievedEffectiveDate; }

    public Boolean getIsRelieved() { return isRelieved; }
    public void setIsRelieved(Boolean isRelieved) { this.isRelieved = isRelieved; }

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