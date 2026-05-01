package com.officeconnect.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ServiceMaster")
public class ServiceMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ServiceId")
    private Integer serviceId;

    @Column(name = "ServiceName")
    private String serviceName;

    @Column(name = "ServiceLink")
    private String serviceLink;

    @Column(name = "IsActive")
    private Boolean isActive;

    public Integer getServiceId() { return serviceId; }
    public void setServiceId(Integer serviceId) { this.serviceId = serviceId; }

    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }

    public String getServiceLink() { return serviceLink; }
    public void setServiceLink(String serviceLink) { this.serviceLink = serviceLink; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}