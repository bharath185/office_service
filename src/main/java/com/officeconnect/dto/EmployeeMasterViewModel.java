package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class EmployeeMasterViewModel {
    @JsonProperty("LoginId")
    @JsonAlias({"loginId", "LoginId"})
    private Integer loginId;
    @JsonProperty("EmpId")
    @JsonAlias({"empId", "EmpId"})
    private Integer empId;
    @JsonProperty("OldEmp_ID")
    @JsonAlias({"oldEmp_ID", "OldEmp_ID"})
    private Integer oldEmp_ID;
    @JsonProperty("CompId")
    @JsonAlias({"compId", "CompId"})
    private Integer compId;
    @JsonProperty("Company")
    @JsonAlias({"company", "Company"})
    private String company;
    @JsonProperty("LEId")
    @JsonAlias({"leId", "LEId"})
    private Integer leId;
    @JsonProperty("LegalEntity")
    @JsonAlias({"legalEntity", "LegalEntity"})
    private String legalEntity;
    @JsonProperty("BUId")
    @JsonAlias({"buId", "BUId"})
    private Integer buId;
    @JsonProperty("BusinessUnit")
    @JsonAlias({"businessUnit", "BusinessUnit"})
    private String businessUnit;
    @JsonProperty("LocationId")
    @JsonAlias({"locationId", "LocationId"})
    private Integer locationId;
    @JsonProperty("Location")
    @JsonAlias({"location", "Location"})
    private String location;
    @JsonProperty("CategoryId")
    @JsonAlias({"categoryId", "CategoryId"})
    private Integer categoryId;
    @JsonProperty("DeptId")
    @JsonAlias({"deptId", "DeptId"})
    private Integer deptId;
    @JsonProperty("DeptName")
    @JsonAlias({"deptName", "DeptName"})
    private String deptName;
    @JsonProperty("DesignationId")
    @JsonAlias({"designationId", "DesignationId"})
    private Integer designationId;
    @JsonProperty("Designation")
    @JsonAlias({"designation", "Designation"})
    private String designation;
    @JsonProperty("ReportId")
    @JsonAlias({"reportId", "ReportId"})
    private Integer reportId;
    @JsonProperty("ApproverId")
    @JsonAlias({"approverId", "ApproverId"})
    private Integer approverId;
    @JsonProperty("Approver")
    @JsonAlias({"approver", "Approver"})
    private String approver;
    @JsonProperty("ReportEmpCode")
    @JsonAlias({"reportEmpCode", "ReportEmpCode"})
    private String reportEmpCode;
    @JsonProperty("ReportEmpName")
    @JsonAlias({"reportEmpName", "ReportEmpName"})
    private String reportEmpName;
    @JsonProperty("Authorised")
    @JsonAlias({"authorised", "Authorised"})
    private Boolean authorised;
    @JsonProperty("EmpCode")
    @JsonAlias({"empCode", "EmpCode"})
    private String empCode;
    @JsonProperty("TokenId")
    @JsonAlias({"tokenId", "TokenId"})
    private String tokenId;
    @JsonProperty("UserAuth")
    @JsonAlias({"userAuth", "UserAuth"})
    private String userAuth;
    @JsonProperty("UserName")
    @JsonAlias({"userName", "UserName"})
    private String userName;
    @JsonProperty("Password")
    @JsonAlias({"password", "Password"})
    private String password;
    @JsonProperty("Photo")
    @JsonAlias({"photo", "Photo"})
    private String photo;
    @JsonProperty("SalutationId")
    @JsonAlias({"salutationId", "SalutationId"})
    private Integer salutationId;
    @JsonProperty("Salutation")
    @JsonAlias({"salutation", "Salutation"})
    private String salutation;
    @JsonProperty("FirstName")
    @JsonAlias({"firstName", "FirstName"})
    private String firstName;
    @JsonProperty("MiddleName")
    @JsonAlias({"middleName", "MiddleName"})
    private String middleName;
    @JsonProperty("LastName")
    @JsonAlias({"lastName", "LastName"})
    private String lastName;
    @JsonProperty("DOB")
    @JsonAlias({"dob", "DOB"})
    private Object dob;
    @JsonProperty("MobileNo")
    @JsonAlias({"mobileNo", "MobileNo"})
    private String mobileNo;
    @JsonProperty("EmailId")
    @JsonAlias({"emailId", "EmailId"})
    private String emailId;
    @JsonProperty("BloodGroup")
    @JsonAlias({"bloodGroup", "BloodGroup"})
    private String bloodGroup;
    @JsonProperty("MaritalStatus")
    @JsonAlias({"maritalStatus", "MaritalStatus"})
    private String maritalStatus;
    @JsonProperty("Gender")
    @JsonAlias({"gender", "Gender"})
    private String gender;
    @JsonProperty("InterviewDate")
    @JsonAlias({"interviewDate", "InterviewDate"})
    private Object interviewDate;
    @JsonProperty("JoiningDate")
    @JsonAlias({"joiningDate", "JoiningDate"})
    private Object joiningDate;
    @JsonProperty("EndDate")
    @JsonAlias({"endDate", "EndDate"})
    private Object endDate;
    @JsonProperty("EmpStatus")
    @JsonAlias({"empStatus", "EmpStatus"})
    private String empStatus;
    @JsonProperty("Reason")
    @JsonAlias({"reason", "Reason"})
    private String reason;
    @JsonProperty("EmpType")
    @JsonAlias({"empType", "EmpType"})
    private String empType;
    @JsonProperty("EmpTypeId")
    @JsonAlias({"empTypeId", "EmpTypeId"})
    private Integer empTypeId;
    @JsonProperty("CEndDate")
    @JsonAlias({"cEndDate", "CEndDate"})
    private Object cEndDate;
    @JsonProperty("CPwd")
    @JsonAlias({"cPwd", "CPwd"})
    private Boolean cPwd;
    @JsonProperty("OnSiteLogInId")
    @JsonAlias({"onSiteLogInId", "OnSiteLogInId"})
    private Integer onSiteLogInId;
    @JsonProperty("OnSiteLogInDate")
    @JsonAlias({"onSiteLogInDate", "OnSiteLogInDate"})
    private Object onSiteLogInDate;
    @JsonProperty("OnSiteLogOutDate")
    @JsonAlias({"onSiteLogOutDate", "OnSiteLogOutDate"})
    private Object onSiteLogOutDate;
    @JsonProperty("OnSiteLogInTime")
    @JsonAlias({"onSiteLogInTime", "OnSiteLogInTime"})
    private String onSiteLogInTime;
    @JsonProperty("OnSiteLogOutTime")
    @JsonAlias({"onSiteLogOutTime", "OnSiteLogOutTime"})
    private String onSiteLogOutTime;
    @JsonProperty("OnSiteStatus")
    @JsonAlias({"onSiteStatus", "OnSiteStatus"})
    private String onSiteStatus;
    @JsonProperty("AuthorisedEntity")
    @JsonAlias({"authorisedEntity", "AuthorisedEntity"})
    private String authorisedEntity;
    @JsonProperty("RelievedReason")
    @JsonAlias({"relievedReason", "RelievedReason"})
    private String relievedReason;
    @JsonProperty("RelievedDate")
    @JsonAlias({"relievedDate", "RelievedDate"})
    private Object relievedDate;
    @JsonProperty("RelievedEffectiveDate")
    @JsonAlias({"relievedEffectiveDate", "RelievedEffectiveDate"})
    private Object relievedEffectiveDate;
    @JsonProperty("IsRelieved")
    @JsonAlias({"isRelieved", "IsRelieved"})
    private Boolean isRelieved;
    @JsonProperty("FromDate")
    @JsonAlias({"fromDate", "FromDate"})
    private Object fromDate;
    @JsonProperty("ToDate")
    @JsonAlias({"toDate", "ToDate"})
    private Object toDate;
    @JsonProperty("Status")
    @JsonAlias({"status", "Status"})
    private String status;
    @JsonProperty("CreatedBy")
    @JsonAlias({"createdBy", "CreatedBy"})
    private Integer createdBy;
    @JsonProperty("CreatedDate")
    @JsonAlias({"createdDate", "CreatedDate"})
    private Object createdDate;
    @JsonProperty("LastUpdatedBy")
    @JsonAlias({"lastUpdatedBy", "LastUpdatedBy"})
    private Integer lastUpdatedBy;
    @JsonProperty("LastUpdatedDate")
    @JsonAlias({"lastUpdatedDate", "LastUpdatedDate"})
    private Object lastUpdatedDate;
    @JsonProperty("IsActive")
    @JsonAlias({"isActive", "IsActive"})
    private Boolean isActive;
    @JsonProperty("IsUpdated")
    @JsonAlias({"isUpdated", "IsUpdated"})
    private Boolean isUpdated;
    @JsonProperty("IsDeleted")
    @JsonAlias({"isDeleted", "IsDeleted"})
    private Boolean isDeleted;
    @JsonProperty("IsProbation")
    @JsonAlias({"isProbation", "IsProbation"})
    private Boolean isProbation;
    @JsonProperty("IsProbationConfirm")
    @JsonAlias({"isProbationConfirm", "IsProbationConfirm"})
    private Boolean isProbationConfirm;
    @JsonProperty("ProbationConfirmationEffectiveDate")
    @JsonAlias({"probationConfirmationEffectiveDate", "ProbationConfirmationEffectiveDate"})
    private Object probationConfirmationEffectiveDate;
    @JsonProperty("ProbationConfirmationDate")
    @JsonAlias({"probationConfirmationDate", "ProbationConfirmationDate"})
    private Object probationConfirmationDate;
    @JsonProperty("ProbationRemarks")
    @JsonAlias({"probationRemarks", "ProbationRemarks"})
    private String probationRemarks;
    @JsonProperty("ProbationConfirmationStatus")
    @JsonAlias({"probationConfirmationStatus", "ProbationConfirmationStatus"})
    private String probationConfirmationStatus;
    @JsonProperty("msg")
    @JsonAlias({"msg", "Msg"})
    private String msg;
    @JsonProperty("StartDate")
    @JsonAlias({"startDate", "StartDate"})
    private Object startDate;
    @JsonProperty("TotalEmployeeCount")
    @JsonAlias({"totalEmployeeCount", "TotalEmployeeCount"})
    private Integer totalEmployeeCount;
    @JsonProperty("EmpName")
    @JsonAlias({"empName", "EmpName"})
    private String empName;

    // Getters and Setters
    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public Integer getOldEmp_ID() { return oldEmp_ID; }
    public void setOldEmp_ID(Integer oldEmp_ID) { this.oldEmp_ID = oldEmp_ID; }

    public Integer getCompId() { return compId; }
    public void setCompId(Integer compId) { this.compId = compId; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public Integer getLeId() { return leId; }
    public void setLeId(Integer leId) { this.leId = leId; }

    public String getLegalEntity() { return legalEntity; }
    public void setLegalEntity(String legalEntity) { this.legalEntity = legalEntity; }

    public Integer getBuId() { return buId; }
    public void setBuId(Integer buId) { this.buId = buId; }

    public String getBusinessUnit() { return businessUnit; }
    public void setBusinessUnit(String businessUnit) { this.businessUnit = businessUnit; }

    public Integer getLocationId() { return locationId; }
    public void setLocationId(Integer locationId) { this.locationId = locationId; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }

    public Integer getDeptId() { return deptId; }
    public void setDeptId(Integer deptId) { this.deptId = deptId; }

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }

    public Integer getDesignationId() { return designationId; }
    public void setDesignationId(Integer designationId) { this.designationId = designationId; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public Integer getReportId() { return reportId; }
    public void setReportId(Integer reportId) { this.reportId = reportId; }

    public Integer getApproverId() { return approverId; }
    public void setApproverId(Integer approverId) { this.approverId = approverId; }

    public String getApprover() { return approver; }
    public void setApprover(String approver) { this.approver = approver; }

    public String getReportEmpCode() { return reportEmpCode; }
    public void setReportEmpCode(String reportEmpCode) { this.reportEmpCode = reportEmpCode; }

    public String getReportEmpName() { return reportEmpName; }
    public void setReportEmpName(String reportEmpName) { this.reportEmpName = reportEmpName; }

    public Boolean getAuthorised() { return authorised; }
    public void setAuthorised(Boolean authorised) { this.authorised = authorised; }

    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }

    public String getTokenId() { return tokenId; }
    public void setTokenId(String tokenId) { this.tokenId = tokenId; }

    public String getUserAuth() { return userAuth; }
    public void setUserAuth(String userAuth) { this.userAuth = userAuth; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    public Integer getSalutationId() { return salutationId; }
    public void setSalutationId(Integer salutationId) { this.salutationId = salutationId; }

    public String getSalutation() { return salutation; }
    public void setSalutation(String salutation) { this.salutation = salutation; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Object getDob() { return dob; }
    public void setDob(Object dob) { this.dob = dob; }

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

    public Object getInterviewDate() { return interviewDate; }
    public void setInterviewDate(Object interviewDate) { this.interviewDate = interviewDate; }

    public Object getJoiningDate() { return joiningDate; }
    public void setJoiningDate(Object joiningDate) { this.joiningDate = joiningDate; }

    public Object getEndDate() { return endDate; }
    public void setEndDate(Object endDate) { this.endDate = endDate; }

    public String getEmpStatus() { return empStatus; }
    public void setEmpStatus(String empStatus) { this.empStatus = empStatus; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getEmpType() { return empType; }
    public void setEmpType(String empType) { this.empType = empType; }

    public Integer getEmpTypeId() { return empTypeId; }
    public void setEmpTypeId(Integer empTypeId) { this.empTypeId = empTypeId; }

    public Object getcEndDate() { return cEndDate; }
    public void setcEndDate(Object cEndDate) { this.cEndDate = cEndDate; }

    public Boolean getcPwd() { return cPwd; }
    public void setcPwd(Boolean cPwd) { this.cPwd = cPwd; }

    public Integer getOnSiteLogInId() { return onSiteLogInId; }
    public void setOnSiteLogInId(Integer onSiteLogInId) { this.onSiteLogInId = onSiteLogInId; }

    public Object getOnSiteLogInDate() { return onSiteLogInDate; }
    public void setOnSiteLogInDate(Object onSiteLogInDate) { this.onSiteLogInDate = onSiteLogInDate; }

    public Object getOnSiteLogOutDate() { return onSiteLogOutDate; }
    public void setOnSiteLogOutDate(Object onSiteLogOutDate) { this.onSiteLogOutDate = onSiteLogOutDate; }

    public String getOnSiteLogInTime() { return onSiteLogInTime; }
    public void setOnSiteLogInTime(String onSiteLogInTime) { this.onSiteLogInTime = onSiteLogInTime; }

    public String getOnSiteLogOutTime() { return onSiteLogOutTime; }
    public void setOnSiteLogOutTime(String onSiteLogOutTime) { this.onSiteLogOutTime = onSiteLogOutTime; }

    public String getOnSiteStatus() { return onSiteStatus; }
    public void setOnSiteStatus(String onSiteStatus) { this.onSiteStatus = onSiteStatus; }

    public String getAuthorisedEntity() { return authorisedEntity; }
    public void setAuthorisedEntity(String authorisedEntity) { this.authorisedEntity = authorisedEntity; }

    public String getRelievedReason() { return relievedReason; }
    public void setRelievedReason(String relievedReason) { this.relievedReason = relievedReason; }

    public Object getRelievedDate() { return relievedDate; }
    public void setRelievedDate(Object relievedDate) { this.relievedDate = relievedDate; }

    public Object getRelievedEffectiveDate() { return relievedEffectiveDate; }
    public void setRelievedEffectiveDate(Object relievedEffectiveDate) { this.relievedEffectiveDate = relievedEffectiveDate; }

    public Boolean getIsRelieved() { return isRelieved; }
    public void setIsRelieved(Boolean isRelieved) { this.isRelieved = isRelieved; }

    public Object getFromDate() { return fromDate; }
    public void setFromDate(Object fromDate) { this.fromDate = fromDate; }

    public Object getToDate() { return toDate; }
    public void setToDate(Object toDate) { this.toDate = toDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }

    public Object getCreatedDate() { return createdDate; }
    public void setCreatedDate(Object createdDate) { this.createdDate = createdDate; }

    public Integer getLastUpdatedBy() { return lastUpdatedBy; }
    public void setLastUpdatedBy(Integer lastUpdatedBy) { this.lastUpdatedBy = lastUpdatedBy; }

    public Object getLastUpdatedDate() { return lastUpdatedDate; }
    public void setLastUpdatedDate(Object lastUpdatedDate) { this.lastUpdatedDate = lastUpdatedDate; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public Boolean getIsUpdated() { return isUpdated; }
    public void setIsUpdated(Boolean isUpdated) { this.isUpdated = isUpdated; }

    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }

    public Boolean getIsProbation() { return isProbation; }
    public void setIsProbation(Boolean isProbation) { this.isProbation = isProbation; }

    public Boolean getIsProbationConfirm() { return isProbationConfirm; }
    public void setIsProbationConfirm(Boolean isProbationConfirm) { this.isProbationConfirm = isProbationConfirm; }

    public Object getProbationConfirmationEffectiveDate() { return probationConfirmationEffectiveDate; }
    public void setProbationConfirmationEffectiveDate(Object probationConfirmationEffectiveDate) { this.probationConfirmationEffectiveDate = probationConfirmationEffectiveDate; }

    public Object getProbationConfirmationDate() { return probationConfirmationDate; }
    public void setProbationConfirmationDate(Object probationConfirmationDate) { this.probationConfirmationDate = probationConfirmationDate; }

    public String getProbationRemarks() { return probationRemarks; }
    public void setProbationRemarks(String probationRemarks) { this.probationRemarks = probationRemarks; }

    public String getProbationConfirmationStatus() { return probationConfirmationStatus; }
    public void setProbationConfirmationStatus(String probationConfirmationStatus) { this.probationConfirmationStatus = probationConfirmationStatus; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }

    public Object getStartDate() { return startDate; }
    public void setStartDate(Object startDate) { this.startDate = startDate; }

    public Integer getTotalEmployeeCount() { return totalEmployeeCount; }
    public void setTotalEmployeeCount(Integer totalEmployeeCount) { this.totalEmployeeCount = totalEmployeeCount; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }
}
