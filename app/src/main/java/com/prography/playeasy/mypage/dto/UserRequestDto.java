package com.prography.playeasy.mypage.dto;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class UserRequestDto extends HashMap<Object,Object>{

    @SerializedName("name")
    String name;
    @SerializedName("age")
    int age;
    @SerializedName("phone")
    String phone;
    @SerializedName("level")
    String level;
    @SerializedName("description")
    String description;
    @SerializedName("team")
    String team;
    
}
