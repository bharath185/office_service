package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DDPayslipSectionViewModel {
    @JsonProperty("SectionId")
    private Integer sectionId;
    @JsonProperty("SectionName")
    private String sectionName;

    public Integer getSectionId() { return sectionId; }
    public void setSectionId(Integer sectionId) { this.sectionId = sectionId; }
    public String getSectionName() { return sectionName; }
    public void setSectionName(String sectionName) { this.sectionName = sectionName; }
}
