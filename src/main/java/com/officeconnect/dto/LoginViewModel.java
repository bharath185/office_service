package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginViewModel {
    @JsonProperty("UserName")
    @JsonAlias({"userName", "UserName"})
    private String userName;
    @JsonProperty("Password")
    @JsonAlias({"password", "Password"})
    private String password;
    @JsonProperty("TokenId")
    @JsonAlias({"tokenId", "TokenId"})
    private String tokenId;
    @JsonProperty("AuthKey")
    @JsonAlias({"authKey", "AuthKey"})
    private String authKey;
    @JsonProperty("RoleId")
    @JsonAlias({"roleId", "RoleId"})
    private Integer roleId;

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getTokenId() { return tokenId; }
    public void setTokenId(String tokenId) { this.tokenId = tokenId; }

    public String getAuthKey() { return authKey; }
    public void setAuthKey(String authKey) { this.authKey = authKey; }

    public Integer getRoleId() { return roleId; }
    public void setRoleId(Integer roleId) { this.roleId = roleId; }
}