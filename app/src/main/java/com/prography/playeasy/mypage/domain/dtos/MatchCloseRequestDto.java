package com.prography.playeasy.mypage.domain.dtos;

import com.google.gson.annotations.SerializedName;

public class MatchCloseRequestDto {
    @SerializedName("matchId")

    int matchId;
    @SerializedName("status")
    String status;

    public MatchCloseRequestDto(int matchId, String status) {
        this.matchId = matchId;
        this.status = status;
    }
}
