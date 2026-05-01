package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class PayslipPayloadViewModel {
    @JsonProperty("PayoutTypeId")
    private Integer payoutTypeId;

    @JsonProperty("EffectiveDateFrom")
    private String effectiveDateFrom;

    @JsonProperty("EffectiveDateTo")
    private String effectiveDateTo;

    @JsonProperty("LoginId")
    @JsonAlias({"loginId", "LoginId"})
    private Integer loginId;

    @JsonProperty("Sections")
    private List<PayslipSectionRequestViewModel> sections;

    public Integer getPayoutTypeId() { return payoutTypeId; }
    public void setPayoutTypeId(Integer payoutTypeId) { this.payoutTypeId = payoutTypeId; }
    public String getEffectiveDateFrom() { return effectiveDateFrom; }
    public void setEffectiveDateFrom(String effectiveDateFrom) { this.effectiveDateFrom = effectiveDateFrom; }
    public String getEffectiveDateTo() { return effectiveDateTo; }
    public void setEffectiveDateTo(String effectiveDateTo) { this.effectiveDateTo = effectiveDateTo; }
    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }
    public List<PayslipSectionRequestViewModel> getSections() { return sections; }
    public void setSections(List<PayslipSectionRequestViewModel> sections) { this.sections = sections; }

    public static class PayslipSectionRequestViewModel {
        @JsonProperty("SectionName")
        private String sectionName;
        @JsonProperty("Components")
        private List<PayslipComponentRequestViewModel> components;

        public String getSectionName() { return sectionName; }
        public void setSectionName(String sectionName) { this.sectionName = sectionName; }
        public List<PayslipComponentRequestViewModel> getComponents() { return components; }
        public void setComponents(List<PayslipComponentRequestViewModel> components) { this.components = components; }
    }

    public static class PayslipComponentRequestViewModel {
        @JsonProperty("SectionComponentId")
        private Integer sectionComponentId;
        @JsonProperty("ComponentId")
        private Integer componentId;
        @JsonProperty("ComponentCode")
        private String componentCode;
        @JsonProperty("ComponentName")
        private String componentName;
        @JsonProperty("SequenceNo")
        private Integer sequenceNo;
        @JsonProperty("EffectiveFrom")
        private String effectiveFrom;
        @JsonProperty("EffectiveTo")
        private String effectiveTo;
        @JsonProperty("RecordStatus")
        private Boolean recordStatus;

        public Integer getSectionComponentId() { return sectionComponentId; }
        public void setSectionComponentId(Integer sectionComponentId) { this.sectionComponentId = sectionComponentId; }
        public Integer getComponentId() { return componentId; }
        public void setComponentId(Integer componentId) { this.componentId = componentId; }
        public String getComponentCode() { return componentCode; }
        public void setComponentCode(String componentCode) { this.componentCode = componentCode; }
        public String getComponentName() { return componentName; }
        public void setComponentName(String componentName) { this.componentName = componentName; }
        public Integer getSequenceNo() { return sequenceNo; }
        public void setSequenceNo(Integer sequenceNo) { this.sequenceNo = sequenceNo; }
        public String getEffectiveFrom() { return effectiveFrom; }
        public void setEffectiveFrom(String effectiveFrom) { this.effectiveFrom = effectiveFrom; }
        public String getEffectiveTo() { return effectiveTo; }
        public void setEffectiveTo(String effectiveTo) { this.effectiveTo = effectiveTo; }
        public Boolean getRecordStatus() { return recordStatus; }
        public void setRecordStatus(Boolean recordStatus) { this.recordStatus = recordStatus; }
    }
}
