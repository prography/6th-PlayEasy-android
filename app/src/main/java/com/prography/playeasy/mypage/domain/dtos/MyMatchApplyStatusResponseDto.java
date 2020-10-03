package com.prography.playeasy.mypage.domain.dtos;

import com.google.gson.annotations.SerializedName;
import com.prography.playeasy.mypage.domain.models.MyApplyStatusApplication;

import java.util.ArrayList;
import java.util.List;

public class MyMatchApplyStatusResponseDto {
    @SerializedName("applicationList")
    ArrayList<MyApplyStatusApplication> applicationList;

    public MyMatchApplyStatusResponseDto(ArrayList<MyApplyStatusApplication> applicationList) {
        this.applicationList = applicationList;
    }

    public ArrayList<MyApplyStatusApplication> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(ArrayList<MyApplyStatusApplication> applicationList) {
        this.applicationList = applicationList;
    }
}
