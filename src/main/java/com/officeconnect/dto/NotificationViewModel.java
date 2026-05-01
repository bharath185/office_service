package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class NotificationViewModel {
    @JsonProperty("NotificationId")
    private Integer notificationId;
    @JsonProperty("EmpId")
    private Integer empId;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("NotificationType")
    private String notificationType;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("CreatedDate")
    private Date createdDate;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("Msg")
    private String msg;

    public Integer getNotificationId() { return notificationId; }
    public void setNotificationId(Integer notificationId) { this.notificationId = notificationId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getNotificationType() { return notificationType; }
    public void setNotificationType(String notificationType) { this.notificationType = notificationType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
}