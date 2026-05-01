package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessViewModel {
    @JsonProperty("PolicyId")
    @JsonAlias({"policyId", "PolicyId"})
    private Integer policyId;
    @JsonProperty("DeptId")
    @JsonAlias({"deptId", "DeptId"})
    private Integer deptId;
    @JsonProperty("RoleId")
    @JsonAlias({"roleId", "RoleId"})
    private Integer roleId;
    @JsonProperty("ModuleId")
    @JsonAlias({"moduleId", "ModuleId"})
    private Integer moduleId;
    @JsonProperty("AccessName")
    @JsonAlias({"accessName", "AccessName"})
    private String accessName;
    @JsonProperty("CanView")
    @JsonAlias({"canView", "CanView"})
    private Boolean canView;
    @JsonProperty("CanAdd")
    @JsonAlias({"canAdd", "CanAdd"})
    private Boolean canAdd;
    @JsonProperty("CanEdit")
    @JsonAlias({"canEdit", "CanEdit"})
    private Boolean canEdit;
    @JsonProperty("CanDelete")
    @JsonAlias({"canDelete", "CanDelete"})
    private Boolean canDelete;
    @JsonProperty("IsActive")
    @JsonAlias({"isActive", "IsActive"})
    private Boolean isActive;
    @JsonProperty("Msg")
    @JsonAlias({"msg", "Msg"})
    private String msg;

    public Integer getPolicyId() { return policyId; }
    public void setPolicyId(Integer policyId) { this.policyId = policyId; }

    public Integer getDeptId() { return deptId; }
    public void setDeptId(Integer deptId) { this.deptId = deptId; }

    public Integer getRoleId() { return roleId; }
    public void setRoleId(Integer roleId) { this.roleId = roleId; }

    public Integer getModuleId() { return moduleId; }
    public void setModuleId(Integer moduleId) { this.moduleId = moduleId; }

    public String getAccessName() { return accessName; }
    public void setAccessName(String accessName) { this.accessName = accessName; }

    public Boolean getCanView() { return canView; }
    public void setCanView(Boolean canView) { this.canView = canView; }

    public Boolean getCanAdd() { return canAdd; }
    public void setCanAdd(Boolean canAdd) { this.canAdd = canAdd; }

    public Boolean getCanEdit() { return canEdit; }
    public void setCanEdit(Boolean canEdit) { this.canEdit = canEdit; }

    public Boolean getCanDelete() { return canDelete; }
    public void setCanDelete(Boolean canDelete) { this.canDelete = canDelete; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
}