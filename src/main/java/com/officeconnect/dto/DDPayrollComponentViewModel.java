package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DDPayrollComponentViewModel {
    @JsonProperty("ComponentId")
    private Integer componentId;
    @JsonProperty("ComponentName")
    private String componentName;

    public Integer getComponentId() { return componentId; }
    public void setComponentId(Integer componentId) { this.componentId = componentId; }
    public String getComponentName() { return componentName; }
    public void setComponentName(String componentName) { this.componentName = componentName; }
}
