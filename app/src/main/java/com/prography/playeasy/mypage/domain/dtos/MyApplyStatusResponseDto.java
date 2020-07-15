package com.prography.playeasy.mypage.domain.dtos;

import com.google.gson.annotations.SerializedName;
import com.prography.playeasy.mypage.domain.models.MyApplyStatusApplication;

import java.util.List;

public class MyApplyStatusResponseDto {
    @SerializedName("applicationList")
    List<MyApplyStatusApplication> applicationList;
}
