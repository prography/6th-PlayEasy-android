package com.prography.playeasy.mypage.domain.models;

import com.google.gson.annotations.SerializedName;
import com.prography.playeasy.match.domain.models.HomeTeamId;
import com.prography.playeasy.match.domain.models.LocationId;
import com.prography.playeasy.match.domain.models.Match;

import java.util.Date;

public class MyApplyStatusMatch {


    @SerializedName("id")
    int id;
    @SerializedName("startAt")
    String startAt;
    @SerializedName("duration")
    int duration;
    @SerializedName("location")
    ApplicationLocation location;

    public MyApplyStatusMatch(int id, String startAt, int duration, ApplicationLocation location) {
        this.id = id;
        this.startAt = startAt;
        this.duration = duration;
        this.location = location;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {

        this.startAt = startAt;
    }

    public int getDuration() {

        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ApplicationLocation getLocation() {
        return location;
    }

    public void setLocation(ApplicationLocation location) {
        this.location = location;
    }
}
