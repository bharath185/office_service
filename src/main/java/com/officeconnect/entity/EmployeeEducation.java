package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EmployeeEducation")
public class EmployeeEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "EmpId")
    private Integer empId;

    @Column(name = "DocId")
    private Integer docId;

    @Column(name = "Others")
    private String others;

    @Column(name = "School")
    private String school;

    @Column(name = "DegreeId")
    private String degreeId;

    @Column(name = "Filed")
    private String filed;

    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "Grade")
    private String grade;

    @Column(name = "Description")
    private String description;

    @Column(name = "Path")
    private String path;

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

    public Integer getDocId() { return docId; }
    public void setDocId(Integer docId) { this.docId = docId; }

    public String getOthers() { return others; }
    public void setOthers(String others) { this.others = others; }

    public String getSchool() { return school; }
    public void setSchool(String school) { this.school = school; }

    public String getDegreeId() { return degreeId; }
    public void setDegreeId(String degreeId) { this.degreeId = degreeId; }

    public String getFiled() { return filed; }
    public void setFiled(String filed) { this.filed = filed; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }

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
