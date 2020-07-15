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
    Date startAt;
    @SerializedName("duration")
    int duration;
    @SerializedName("location")
    ApplicationLocation location;
}
