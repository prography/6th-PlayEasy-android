package com.prography.playeasy.mypage.domain.dtos.register;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class MyMatchRegisterListDto {
    @SerializedName("matchList")
    ArrayList<MyMatchRegisterResponseDto> matchList;

    public ArrayList<MyMatchRegisterResponseDto> getMatchList() {
        return matchList;
    }
    public void setMatchList(ArrayList<MyMatchRegisterResponseDto> matchList) {
        this.matchList = matchList;
    }
}
