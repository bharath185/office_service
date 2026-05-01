package com.officeconnect.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "GradeMaster")
public class GradeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GradeId")
    private Integer gradeId;

    @Column(name = "Grade")
    private String grade;

    @Column(name = "IsActive")
    private Boolean isActive;

    public Integer getGradeId() { return gradeId; }
    public void setGradeId(Integer gradeId) { this.gradeId = gradeId; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}