package com.prography.playeasy.match.domain.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Application {
    @SerializedName("id")
    int id;
    @SerializedName("quota")
    int quota;
    @SerializedName("status")


    String status;
    @SerializedName("createdAt")
    Date createdAt;
    @SerializedName("updatedAt")
    Date updatedAt;
    @SerializedName("matchId")
    int matchId;
    @SerializedName("userId")
    int userId;
}
