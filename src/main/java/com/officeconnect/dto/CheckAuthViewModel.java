package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CheckAuthViewModel {
    @JsonProperty("UserName")
    private String userName;
    @JsonProperty("TokenId")
    private String tokenId;
    @JsonProperty("AuthKey")
    private String authKey;

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getTokenId() { return tokenId; }
    public void setTokenId(String tokenId) { this.tokenId = tokenId; }

    public String getAuthKey() { return authKey; }
    public void setAuthKey(String authKey) { this.authKey = authKey; }
}