package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PayrollComponentLogic")
public class PayrollComponentLogic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LogicId")
    private Integer logicId;

    @Column(name = "ComponentId")
    private Integer componentId;

    @Column(name = "SNo")
    private Integer sno;

    @Column(name = "Percentage")
    private Double percentage;

    @Column(name = "Value")
    private Double value;

    @Column(name = "ComponentId1")
    private Integer componentId1;

    @Column(name = "ComponentName1")
    private String componentName1;

    @Column(name = "EffectiveFrom")
    @Temporal(TemporalType.DATE)
    private Date effectiveFrom;

    @Column(name = "EffectiveTo")
    @Temporal(TemporalType.DATE)
    private Date effectiveTo;

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

    public Integer getLogicId() { return logicId; }
    public void setLogicId(Integer logicId) { this.logicId = logicId; }

    public Integer getComponentId() { return componentId; }
    public void setComponentId(Integer componentId) { this.componentId = componentId; }

    public Integer getSno() { return sno; }
    public void setSno(Integer sno) { this.sno = sno; }

    public Double getPercentage() { return percentage; }
    public void setPercentage(Double percentage) { this.percentage = percentage; }

    public Double getValue() { return value; }
    public void setValue(Double value) { this.value = value; }

    public Integer getComponentId1() { return componentId1; }
    public void setComponentId1(Integer componentId1) { this.componentId1 = componentId1; }

    public String getComponentName1() { return componentName1; }
    public void setComponentName1(String componentName1) { this.componentName1 = componentName1; }

    public Date getEffectiveFrom() { return effectiveFrom; }
    public void setEffectiveFrom(Date effectiveFrom) { this.effectiveFrom = effectiveFrom; }

    public Date getEffectiveTo() { return effectiveTo; }
    public void setEffectiveTo(Date effectiveTo) { this.effectiveTo = effectiveTo; }

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
