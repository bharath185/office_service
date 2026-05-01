package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DDSalutationViewModel {
    @JsonProperty("SalutationId")
    @JsonAlias({"salutationId", "SalutationId"})
    private Integer salutationId;

    @JsonProperty("Salutation")
    @JsonAlias({"salutation", "Salutation"})
    private String salutation;

    @JsonProperty("EmpId")
    @JsonAlias({"empId", "EmpId"})
    private Integer empId;

    public Integer getSalutationId() { return salutationId; }
    public void setSalutationId(Integer salutationId) { this.salutationId = salutationId; }

    public String getSalutation() { return salutation; }
    public void setSalutation(String salutation) { this.salutation = salutation; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }
}
