package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DDPayrollSegmentViewModel {
    @JsonProperty("SegmentId")
    private Integer segmentId;
    @JsonProperty("SegmentName")
    private String segmentName;

    public Integer getSegmentId() { return segmentId; }
    public void setSegmentId(Integer segmentId) { this.segmentId = segmentId; }
    public String getSegmentName() { return segmentName; }
    public void setSegmentName(String segmentName) { this.segmentName = segmentName; }
}
