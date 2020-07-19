package com.prography.playeasy.match.domain.models;

import android.widget.TextView;

public class Place
{

    private String address_name;
    private String road_address_name;

    public Place(String address_name, String road_address_name) {
        this.address_name = address_name;
        this.road_address_name = road_address_name;
    }

    public String getAddress_name() {
        return address_name;
    }

    public void setAddress_name(String address_name) {
        this.address_name = address_name;
    }

    public String getRoad_address_name() {
        return road_address_name;
    }

    public void setRoad_address_name(String road_address_name) {
        this.road_address_name = road_address_name;
    }
}
