package com.prography.playeasy.match.domain.dtos.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MapResponseDto {
    @SerializedName("returnData")
    List<MatchCreateMapResponseDto> returnData;
}
