package com.prography.playeasy.login.domain;

import com.google.gson.annotations.SerializedName;

public class LoginRequestVO {
    @SerializedName(value = "access_token")
    private String accessToken;

    public LoginRequestVO(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getaccessToken() {
        return accessToken;
    }

    public void setaccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
