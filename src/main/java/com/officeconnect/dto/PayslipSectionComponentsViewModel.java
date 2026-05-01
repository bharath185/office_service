package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PayslipSectionComponentsViewModel {
    @JsonProperty("SectionComponentId")
    private Integer sectionComponentId;
    @JsonProperty("SectionId")
    private Integer sectionId;
    @JsonProperty("ComponentId")
    private Integer componentId;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("Msg")
    private String msg;

    public Integer getSectionComponentId() { return sectionComponentId; }
    public void setSectionComponentId(Integer sectionComponentId) { this.sectionComponentId = sectionComponentId; }

    public Integer getSectionId() { return sectionId; }
    public void setSectionId(Integer sectionId) { this.sectionId = sectionId; }

    public Integer getComponentId() { return componentId; }
    public void setComponentId(Integer componentId) { this.componentId = componentId; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
}
