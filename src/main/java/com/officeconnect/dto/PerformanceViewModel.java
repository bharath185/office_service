package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class PerformanceViewModel {
    @JsonProperty("GoalId")
    private Integer goalId;
    @JsonProperty("EmpId")
    private Integer empId;
    @JsonProperty("GoalTitle")
    private String goalTitle;
    @JsonProperty("GoalDescription")
    private String goalDescription;
    @JsonProperty("TargetDate")
    private Date targetDate;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Rating")
    private String rating;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("Msg")
    private String msg;

    public Integer getGoalId() { return goalId; }
    public void setGoalId(Integer goalId) { this.goalId = goalId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getGoalTitle() { return goalTitle; }
    public void setGoalTitle(String goalTitle) { this.goalTitle = goalTitle; }

    public String getGoalDescription() { return goalDescription; }
    public void setGoalDescription(String goalDescription) { this.goalDescription = goalDescription; }

    public Date getTargetDate() { return targetDate; }
    public void setTargetDate(Date targetDate) { this.targetDate = targetDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
}

class PerformanceReviewViewModel {
    @JsonProperty("ReviewId")
    private Integer reviewId;
    @JsonProperty("EmpId")
    private Integer empId;
    @JsonProperty("ReviewerId")
    private Integer reviewerId;
    @JsonProperty("ReviewPeriod")
    private String reviewPeriod;
    @JsonProperty("OverallRating")
    private String overallRating;
    @JsonProperty("Strengths")
    private String strengths;
    @JsonProperty("Improvements")
    private String improvements;
    @JsonProperty("Comments")
    private String comments;
    @JsonProperty("ReviewDate")
    private Date reviewDate;

    public Integer getReviewId() { return reviewId; }
    public void setReviewId(Integer reviewId) { this.reviewId = reviewId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public Integer getReviewerId() { return reviewerId; }
    public void setReviewerId(Integer reviewerId) { this.reviewerId = reviewerId; }

    public String getReviewPeriod() { return reviewPeriod; }
    public void setReviewPeriod(String reviewPeriod) { this.reviewPeriod = reviewPeriod; }

    public String getOverallRating() { return overallRating; }
    public void setOverallRating(String overallRating) { this.overallRating = overallRating; }

    public String getStrengths() { return strengths; }
    public void setStrengths(String strengths) { this.strengths = strengths; }

    public String getImprovements() { return improvements; }
    public void setImprovements(String improvements) { this.improvements = improvements; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }

    public Date getReviewDate() { return reviewDate; }
    public void setReviewDate(Date reviewDate) { this.reviewDate = reviewDate; }
}