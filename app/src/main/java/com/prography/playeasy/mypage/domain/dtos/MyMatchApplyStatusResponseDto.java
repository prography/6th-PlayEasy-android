package com.prography.playeasy.mypage.domain.dtos;

import com.google.gson.annotations.SerializedName;
import com.prography.playeasy.mypage.domain.models.MyApplyStatusApplication;

import java.util.List;

public class MyMatchApplyStatusResponseDto {
    @SerializedName("applicationList")
    List<MyApplyStatusApplication> applicationList;

    public MyMatchApplyStatusResponseDto(List<MyApplyStatusApplication> applicationList) {
        this.applicationList = applicationList;
    }

    public List<MyApplyStatusApplication> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(List<MyApplyStatusApplication> applicationList) {
        this.applicationList = applicationList;
    }
}
