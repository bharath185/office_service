package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EmployeeDetails")
public class EmployeeDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "EmpId")
    private Integer empId;

    @Column(name = "AMobileNo")
    private String aMobileNo;

    @Column(name = "PMailId")
    private String pMailId;

    @Column(name = "FatherName")
    private String fatherName;

    @Column(name = "MotherName")
    private String motherName;

    @Column(name = "HusbandName")
    private String husbandName;

    @Column(name = "FContactNo")
    private String fContactNo;

    @Column(name = "MContactNo")
    private String mContactNo;

    @Column(name = "HContactNo")
    private String hContactNo;

    @Column(name = "EContactNo")
    private String eContactNo;

    @Column(name = "EContactName")
    private String eContactName;

    @Column(name = "EContactRelationship")
    private String eContactRelationship;

    @Column(name = "Height")
    private String height;

    @Column(name = "Weight")
    private String weight;

    @Column(name = "DateOfAnniversary")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfAnniversary;

    @Column(name = "Disability")
    private String disability;

    @Column(name = "TotalExperience")
    private String totalExperience;

    @Column(name = "RelevantExperience")
    private String relevantExperience;

    @Column(name = "ECActivities")
    private String ecActivities;

    @Column(name = "Sports")
    private String sports;

    @Column(name = "PermanentDoorNumber")
    private String permanentDoorNumber;

    @Column(name = "PermanentBuildingName")
    private String permanentBuildingName;

    @Column(name = "PermanentStreet")
    private String permanentStreet;

    @Column(name = "PermanentLocation")
    private String permanentLocation;

    @Column(name = "PermanentCity")
    private String permanentCity;

    @Column(name = "PermanentState")
    private String permanentState;

    @Column(name = "PermanentCountry")
    private String permanentCountry;

    @Column(name = "PermanentPinCode")
    private String permanentPinCode;

    @Column(name = "CurrentDoorNumber")
    private String currentDoorNumber;

    @Column(name = "CurrentBuildingName")
    private String currentBuildingName;

    @Column(name = "CurrentStreet")
    private String currentStreet;

    @Column(name = "CurrentLocation")
    private String currentLocation;

    @Column(name = "CurrentCity")
    private String currentCity;

    @Column(name = "CurrentState")
    private String currentState;

    @Column(name = "CurrentCountry")
    private String currentCountry;

    @Column(name = "CurrentPinCode")
    private String currentPinCode;

    @Column(name = "Caste")
    private String caste;

    @Column(name = "Region")
    private String region;

    @Column(name = "Country")
    private String country;

    @Column(name = "Nationality")
    private String nationality;

    @Column(name = "EContactNo1")
    private String eContactNo1;

    @Column(name = "EContactName1")
    private String eContactName1;

    @Column(name = "EContactRelationship1")
    private String eContactRelationship1;

    @Column(name = "EContactNo2")
    private String eContactNo2;

    @Column(name = "EContactName2")
    private String eContactName2;

    @Column(name = "EContactRelationship2")
    private String eContactRelationship2;

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

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getAMobileNo() { return aMobileNo; }
    public void setAMobileNo(String aMobileNo) { this.aMobileNo = aMobileNo; }

    public String getPMailId() { return pMailId; }
    public void setPMailId(String pMailId) { this.pMailId = pMailId; }

    public String getFatherName() { return fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }

    public String getMotherName() { return motherName; }
    public void setMotherName(String motherName) { this.motherName = motherName; }

    public String getHusbandName() { return husbandName; }
    public void setHusbandName(String husbandName) { this.husbandName = husbandName; }

    public String getFContactNo() { return fContactNo; }
    public void setFContactNo(String fContactNo) { this.fContactNo = fContactNo; }

    public String getMContactNo() { return mContactNo; }
    public void setMContactNo(String mContactNo) { this.mContactNo = mContactNo; }

    public String getHContactNo() { return hContactNo; }
    public void setHContactNo(String hContactNo) { this.hContactNo = hContactNo; }

    public String getEContactNo() { return eContactNo; }
    public void setEContactNo(String eContactNo) { this.eContactNo = eContactNo; }

    public String getEContactName() { return eContactName; }
    public void setEContactName(String eContactName) { this.eContactName = eContactName; }

    public String getEContactRelationship() { return eContactRelationship; }
    public void setEContactRelationship(String eContactRelationship) { this.eContactRelationship = eContactRelationship; }

    public String getHeight() { return height; }
    public void setHeight(String height) { this.height = height; }

    public String getWeight() { return weight; }
    public void setWeight(String weight) { this.weight = weight; }

    public Date getDateOfAnniversary() { return dateOfAnniversary; }
    public void setDateOfAnniversary(Date dateOfAnniversary) { this.dateOfAnniversary = dateOfAnniversary; }

    public String getDisability() { return disability; }
    public void setDisability(String disability) { this.disability = disability; }

    public String getTotalExperience() { return totalExperience; }
    public void setTotalExperience(String totalExperience) { this.totalExperience = totalExperience; }

    public String getRelevantExperience() { return relevantExperience; }
    public void setRelevantExperience(String relevantExperience) { this.relevantExperience = relevantExperience; }

    public String getEcActivities() { return ecActivities; }
    public void setEcActivities(String ecActivities) { this.ecActivities = ecActivities; }

    public String getSports() { return sports; }
    public void setSports(String sports) { this.sports = sports; }

    public String getPermanentDoorNumber() { return permanentDoorNumber; }
    public void setPermanentDoorNumber(String permanentDoorNumber) { this.permanentDoorNumber = permanentDoorNumber; }

    public String getPermanentBuildingName() { return permanentBuildingName; }
    public void setPermanentBuildingName(String permanentBuildingName) { this.permanentBuildingName = permanentBuildingName; }

    public String getPermanentStreet() { return permanentStreet; }
    public void setPermanentStreet(String permanentStreet) { this.permanentStreet = permanentStreet; }

    public String getPermanentLocation() { return permanentLocation; }
    public void setPermanentLocation(String permanentLocation) { this.permanentLocation = permanentLocation; }

    public String getPermanentCity() { return permanentCity; }
    public void setPermanentCity(String permanentCity) { this.permanentCity = permanentCity; }

    public String getPermanentState() { return permanentState; }
    public void setPermanentState(String permanentState) { this.permanentState = permanentState; }

    public String getPermanentCountry() { return permanentCountry; }
    public void setPermanentCountry(String permanentCountry) { this.permanentCountry = permanentCountry; }

    public String getPermanentPinCode() { return permanentPinCode; }
    public void setPermanentPinCode(String permanentPinCode) { this.permanentPinCode = permanentPinCode; }

    public String getCurrentDoorNumber() { return currentDoorNumber; }
    public void setCurrentDoorNumber(String currentDoorNumber) { this.currentDoorNumber = currentDoorNumber; }

    public String getCurrentBuildingName() { return currentBuildingName; }
    public void setCurrentBuildingName(String currentBuildingName) { this.currentBuildingName = currentBuildingName; }

    public String getCurrentStreet() { return currentStreet; }
    public void setCurrentStreet(String currentStreet) { this.currentStreet = currentStreet; }

    public String getCurrentLocation() { return currentLocation; }
    public void setCurrentLocation(String currentLocation) { this.currentLocation = currentLocation; }

    public String getCurrentCity() { return currentCity; }
    public void setCurrentCity(String currentCity) { this.currentCity = currentCity; }

    public String getCurrentState() { return currentState; }
    public void setCurrentState(String currentState) { this.currentState = currentState; }

    public String getCurrentCountry() { return currentCountry; }
    public void setCurrentCountry(String currentCountry) { this.currentCountry = currentCountry; }

    public String getCurrentPinCode() { return currentPinCode; }
    public void setCurrentPinCode(String currentPinCode) { this.currentPinCode = currentPinCode; }

    public String getCaste() { return caste; }
    public void setCaste(String caste) { this.caste = caste; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public String getEContactNo1() { return eContactNo1; }
    public void setEContactNo1(String eContactNo1) { this.eContactNo1 = eContactNo1; }

    public String getEContactName1() { return eContactName1; }
    public void setEContactName1(String eContactName1) { this.eContactName1 = eContactName1; }

    public String getEContactRelationship1() { return eContactRelationship1; }
    public void setEContactRelationship1(String eContactRelationship1) { this.eContactRelationship1 = eContactRelationship1; }

    public String getEContactNo2() { return eContactNo2; }
    public void setEContactNo2(String eContactNo2) { this.eContactNo2 = eContactNo2; }

    public String getEContactName2() { return eContactName2; }
    public void setEContactName2(String eContactName2) { this.eContactName2 = eContactName2; }

    public String getEContactRelationship2() { return eContactRelationship2; }
    public void setEContactRelationship2(String eContactRelationship2) { this.eContactRelationship2 = eContactRelationship2; }

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
