package com.prography.playeasy.match.domain.dtos;

import java.util.Date;
//for request Put
public class MatchUpdateDto {

    private int id;
    // private String title;
    private enum type{SOCCER,FOOTSAL5,FOOTSAL6};
    private String description;
    private Date startAt;
    //location 변수 대신 duration 넣음
    private int duration;

    private int fee;

    private int phone;

    private int totalQuota;

    public MatchUpdateDto(int id, String description, Date startAt, int duration, int fee, int phone, int totalQuota) {
        this.id = id;
        this.description = description;
        this.startAt = startAt;
        this.duration = duration;
        this.fee = fee;
        this.phone = phone;
        this.totalQuota = totalQuota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getTotalQuota() {
        return totalQuota;
    }

    public void setTotalQuota(int totalQuota) {
        this.totalQuota = totalQuota;
    }

    @Override
    public String toString() {
        return "MatchUpdateDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", startAt=" + startAt +
                ", duration=" + duration +
                ", fee=" + fee +
                ", phone=" + phone +
                ", totalQuota=" + totalQuota +
                '}';
    }
}
