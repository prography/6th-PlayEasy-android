package com.prography.playeasy.mypage.domain.dtos.register;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyMatchRegisterListDto {
    @SerializedName("matchList")
    List<MyMatchRegisterResponseDto> matchList;

}
