package com.officeconnect.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PayrollFrequencyMaster")
public class PayrollFrequencyMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FrequencyId")
    private Integer frequencyId;

    @Column(name = "Frequency")
    private String frequency;

    @Column(name = "IsActive")
    private Boolean isActive;

    public Integer getFrequencyId() { return frequencyId; }
    public void setFrequencyId(Integer frequencyId) { this.frequencyId = frequencyId; }

    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}
