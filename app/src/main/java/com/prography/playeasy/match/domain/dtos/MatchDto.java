package com.prography.playeasy.match.domain.dtos;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
//매치 작성 resquest
public class MatchDto {



    public enum Type{SOCCER,FOOTSAL5,FOOTSAL6};
    @SerializedName("type")
    Type type;
    @SerializedName("description")
    private String description;

    @SerializedName("startAt")
    private Date startAt;
    //location 변수 대신 duration 넣음
    @SerializedName("duration")
    private int duration;
    @SerializedName("fee")
    private int fee;
    @SerializedName("phone")
    String phone;
    @SerializedName("totalQuota")
    int totalQuota;

    public MatchDto(Type typ, String description, Date startAt, int duration, int fee, String phone, int totalQuota) {
        this.type=typ;
        this.description = description;
        this.startAt = startAt;
        this.duration = duration;
        this.fee = fee;
        this.phone=phone;
        this.totalQuota=totalQuota;

    }



}
