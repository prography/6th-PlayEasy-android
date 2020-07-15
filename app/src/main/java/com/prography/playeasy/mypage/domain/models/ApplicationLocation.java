package com.prography.playeasy.mypage.domain.models;

import com.google.gson.annotations.SerializedName;

public class ApplicationLocation {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("address")
    String address;
    @SerializedName("detail")
    String detail;

}
