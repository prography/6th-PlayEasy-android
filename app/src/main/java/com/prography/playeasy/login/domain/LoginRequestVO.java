package com.prography.playeasy.login.domain;

import com.google.gson.annotations.SerializedName;

public class LoginRequestVO {
    @SerializedName(value = "access_token")
    private String accessToken;

    public LoginRequestVO(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
