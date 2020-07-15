package com.prography.playeasy.mypage.domain.models;

import com.google.gson.annotations.SerializedName;

public class MyApplyStatusApplication {


    @SerializedName("id")
    private int id;
    //  static enum Type{SOCCER,FOOTSAL5,FOOTSAL6};
    @SerializedName("quota")
    private int  quota;

    @SerializedName("status")
    private String status;

    @SerializedName("match")
    private MyApplyStatusMatch match;

}
