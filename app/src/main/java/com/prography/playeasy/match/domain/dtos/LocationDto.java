package com.prography.playeasy.match.domain.dtos;

public class LocationDto {

    float latitude;
    float longitude;
    String name;
    String address;
    String detail;

    public LocationDto(float latitude, float longitude, String name, String address, String detail) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.address = address;
        this.detail = detail;
    }
}
