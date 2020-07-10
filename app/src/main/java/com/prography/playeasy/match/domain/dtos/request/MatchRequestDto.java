package com.prography.playeasy.match.domain.dtos.request;

import java.util.Date;

public class MatchRequestDto {

    private String type;
    private String description;
    private int fee;
    private Date startAt;
    private int duration;
    String phone;
    private int totalQuota;

    public MatchRequestDto( String type, String description,  Date startAt, int duration,int fee, String phone,int totalQuota) {

        this.type = type;
        this.description = description;
        this.fee = fee;
        this.startAt = startAt;
        this.duration = duration;
        this.phone=phone;
        this.totalQuota = totalQuota;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }




    public int getHomeQuota() {
        return totalQuota;
    }

    public void setHomeQuota(int homeQuota) {
        this.totalQuota = homeQuota;
    }

    @Override
    public String toString() {
        return "{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", startAt=" + startAt +
                ", durationi=" +duration+
                ", fee=" + fee +
                ", totalQuota=" + totalQuota +
                '}';
    }
}
