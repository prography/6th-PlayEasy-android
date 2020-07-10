package com.prography.playeasy.login.domain;

public class LoginResponseVO {
    private boolean isNewMember;
    private String token;

    public LoginResponseVO(boolean isNewMember, String token) {
        this.isNewMember = isNewMember;
        this.token = token;
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
//for debug
    @Override
    public String toString() {
        return "LoginResponseVO{" +
                ", isNewMember=" + isNewMember +
                ", token='" + token + '\'' +
                '}';
    }
}
