package com.prography.playeasy.retrofit;

public class AccessTokenResult {
    private boolean success;
    private boolean isNewMember;
    private String token;

    public AccessTokenResult(boolean success, boolean isNewMember, String token) {
        this.success = success;
        this.isNewMember = isNewMember;
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isNewMember() {
        return isNewMember;
    }

    public void setNewMember(boolean newMember) {
        isNewMember = newMember;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
