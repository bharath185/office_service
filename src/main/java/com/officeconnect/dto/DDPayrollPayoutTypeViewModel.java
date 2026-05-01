package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DDPayrollPayoutTypeViewModel {
    @JsonProperty("PayoutTypeId")
    private Integer payoutTypeId;
    @JsonProperty("PayoutTypeName")
    private String payoutTypeName;
    @JsonProperty("Frequency")
    private String frequency;

    public Integer getPayoutTypeId() { return payoutTypeId; }
    public void setPayoutTypeId(Integer payoutTypeId) { this.payoutTypeId = payoutTypeId; }
    public String getPayoutTypeName() { return payoutTypeName; }
    public void setPayoutTypeName(String payoutTypeName) { this.payoutTypeName = payoutTypeName; }
    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }
}
