package com.officeconnect.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AccessPolicy")
public class AccessPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccessId")
    private Integer accessId;

    @Column(name = "DeptId")
    private Integer deptId;

    @Column(name = "RoleId")
    private Integer roleId;

    @Column(name = "ModuleId")
    private Integer moduleId;

    @Column(name = "SubModuleId")
    private Integer subModuleId;

    @Column(name = "PageModuleId")
    private Integer pageModuleId;

    @Column(name = "AccessName")
    private String accessName;

    @Column(name = "ViewAccess")
    private Boolean viewAccess;

    @Column(name = "AddAccess")
    private Boolean addAccess;

    @Column(name = "UpdateAccess")
    private Boolean updateAccess;

    @Column(name = "DeleteAccess")
    private Boolean deleteAccess;

    @Column(name = "CreatedBy")
    private Integer createdBy;

    @Column(name = "CreatedDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name = "LastUpdatedBy")
    private Integer lastUpdatedBy;

    @Column(name = "LastUpdatedDate")
    @Temporal(TemporalType.DATE)
    private Date lastUpdatedDate;

    @Column(name = "IsActive")
    private Boolean isActive;

    @Column(name = "IsUpdated")
    private Boolean isUpdated;

    @Column(name = "IsDeleted")
    private Boolean isDeleted;

    public Integer getAccessId() { return accessId; }
    public void setAccessId(Integer accessId) { this.accessId = accessId; }

    public Integer getDeptId() { return deptId; }
    public void setDeptId(Integer deptId) { this.deptId = deptId; }

    public Integer getRoleId() { return roleId; }
    public void setRoleId(Integer roleId) { this.roleId = roleId; }

    public Integer getModuleId() { return moduleId; }
    public void setModuleId(Integer moduleId) { this.moduleId = moduleId; }

    public Integer getSubModuleId() { return subModuleId; }
    public void setSubModuleId(Integer subModuleId) { this.subModuleId = subModuleId; }

    public Integer getPageModuleId() { return pageModuleId; }
    public void setPageModuleId(Integer pageModuleId) { this.pageModuleId = pageModuleId; }

    public String getAccessName() { return accessName; }
    public void setAccessName(String accessName) { this.accessName = accessName; }

    public Boolean getViewAccess() { return viewAccess; }
    public void setViewAccess(Boolean viewAccess) { this.viewAccess = viewAccess; }

    public Boolean getAddAccess() { return addAccess; }
    public void setAddAccess(Boolean addAccess) { this.addAccess = addAccess; }

    public Boolean getUpdateAccess() { return updateAccess; }
    public void setUpdateAccess(Boolean updateAccess) { this.updateAccess = updateAccess; }

    public Boolean getDeleteAccess() { return deleteAccess; }
    public void setDeleteAccess(Boolean deleteAccess) { this.deleteAccess = deleteAccess; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public Boolean getIsUpdated() { return isUpdated; }
    public void setIsUpdated(Boolean isUpdated) { this.isUpdated = isUpdated; }

    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }

    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }

    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    public Integer getLastUpdatedBy() { return lastUpdatedBy; }
    public void setLastUpdatedBy(Integer lastUpdatedBy) { this.lastUpdatedBy = lastUpdatedBy; }

    public Date getLastUpdatedDate() { return lastUpdatedDate; }
    public void setLastUpdatedDate(Date lastUpdatedDate) { this.lastUpdatedDate = lastUpdatedDate; }
}