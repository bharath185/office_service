package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EmailConfigMaster")
public class EmailConfigMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmailConfigId")
    private Integer emailConfigId;

    @Column(name = "ConfigName")
    private String configName;

    @Column(name = "SMTPServer")
    private String smtpServer;

    @Column(name = "SMTPPort")
    private Integer smtpPort;

    @Column(name = "SMTPMailId")
    private String smtpMailId;

    @Column(name = "SMTPPassword")
    private String smtpPassword;

    @Column(name = "FromEmail")
    private String fromEmail;

    @Column(name = "FromName")
    private String fromName;

    @Column(name = "IsSSL")
    private Boolean isSSL;

    @Column(name = "IsTLS")
    private Boolean isTLS;

    @Column(name = "IsHtml")
    private Boolean isHtml;

    @Column(name = "CompId")
    private Integer compId;

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

    public Integer getEmailConfigId() { return emailConfigId; }
    public void setEmailConfigId(Integer emailConfigId) { this.emailConfigId = emailConfigId; }

    public String getConfigName() { return configName; }
    public void setConfigName(String configName) { this.configName = configName; }

    public String getSmtpServer() { return smtpServer; }
    public void setSmtpServer(String smtpServer) { this.smtpServer = smtpServer; }

    public Integer getSmtpPort() { return smtpPort; }
    public void setSmtpPort(Integer smtpPort) { this.smtpPort = smtpPort; }

    public String getSmtpMailId() { return smtpMailId; }
    public void setSmtpMailId(String smtpMailId) { this.smtpMailId = smtpMailId; }

    public String getSmtpPassword() { return smtpPassword; }
    public void setSmtpPassword(String smtpPassword) { this.smtpPassword = smtpPassword; }

    public String getFromEmail() { return fromEmail; }
    public void setFromEmail(String fromEmail) { this.fromEmail = fromEmail; }

    public String getFromName() { return fromName; }
    public void setFromName(String fromName) { this.fromName = fromName; }

    public Boolean getIsSSL() { return isSSL; }
    public void setIsSSL(Boolean isSSL) { this.isSSL = isSSL; }

    public Boolean getIsTLS() { return isTLS; }
    public void setIsTLS(Boolean isTLS) { this.isTLS = isTLS; }

    public Boolean getIsHtml() { return isHtml; }
    public void setIsHtml(Boolean isHtml) { this.isHtml = isHtml; }

    public Integer getCompId() { return compId; }
    public void setCompId(Integer compId) { this.compId = compId; }

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