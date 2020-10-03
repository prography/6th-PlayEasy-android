package com.prography.playeasy.mypage.domain.models;

import com.google.gson.annotations.SerializedName;

public class MyApplyStatusApplication {


    @SerializedName("id")
    private int id;

    @SerializedName("quota")
    private int quota;

    @SerializedName("status")
    private String status;

    @SerializedName("match")
    private MyApplyStatusMatch match;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MyApplyStatusMatch getMatch() {

        return match;
    }

    public void setMatch(MyApplyStatusMatch match) {
        this.match = match;
    }
}
