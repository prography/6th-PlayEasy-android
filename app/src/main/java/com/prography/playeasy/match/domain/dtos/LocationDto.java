package com.prography.playeasy.match.domain.dtos;

import com.google.gson.annotations.SerializedName;

public class LocationDto {
    @SerializedName("latitude")
    float latitude;
    @SerializedName("longitude")
    float longitude;
    @SerializedName("name")
    String name;
    @SerializedName("address")
    String address;
    @SerializedName("detail")
    String detail;

    public LocationDto(float latitude, float longitude, String name, String address, String detail) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.address = address;
        this.detail = detail;
    }
}
