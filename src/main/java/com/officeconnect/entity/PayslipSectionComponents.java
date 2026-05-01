package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PayslipSectionComponents")
public class PayslipSectionComponents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SectionComponentId")
    private Integer sectionComponentId;

    @Column(name = "PayoutTypeId")
    private Integer payoutTypeId;

    @Column(name = "SectionId")
    private Integer sectionId;

    @Column(name = "ComponentId")
    private Integer componentId;

    @Column(name = "SequenceNo")
    private Integer sequenceNo;

    @Column(name = "EffectiveFrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date effectiveFrom;

    @Column(name = "EffectiveTo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date effectiveTo;

    @Column(name = "RecordStatus")
    private Boolean recordStatus;

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

    public Integer getSectionComponentId() { return sectionComponentId; }
    public void setSectionComponentId(Integer sectionComponentId) { this.sectionComponentId = sectionComponentId; }
    public Integer getPayoutTypeId() { return payoutTypeId; }
    public void setPayoutTypeId(Integer payoutTypeId) { this.payoutTypeId = payoutTypeId; }
    public Integer getSectionId() { return sectionId; }
    public void setSectionId(Integer sectionId) { this.sectionId = sectionId; }
    public Integer getComponentId() { return componentId; }
    public void setComponentId(Integer componentId) { this.componentId = componentId; }
    public Integer getSequenceNo() { return sequenceNo; }
    public void setSequenceNo(Integer sequenceNo) { this.sequenceNo = sequenceNo; }
    public Date getEffectiveFrom() { return effectiveFrom; }
    public void setEffectiveFrom(Date effectiveFrom) { this.effectiveFrom = effectiveFrom; }
    public Date getEffectiveTo() { return effectiveTo; }
    public void setEffectiveTo(Date effectiveTo) { this.effectiveTo = effectiveTo; }
    public Boolean getRecordStatus() { return recordStatus; }
    public void setRecordStatus(Boolean recordStatus) { this.recordStatus = recordStatus; }
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
