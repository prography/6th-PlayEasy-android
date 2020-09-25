package com.prography.playeasy.match.domain.dtos.request;

import com.google.gson.annotations.SerializedName;

public class MatchApplyTeamPostRequestDto {
    @SerializedName("matchId")
    int matchId;
    @SerializedName("quota")
    int quota;

    public MatchApplyTeamPostRequestDto(int matchId, int quota) {
        this.matchId = matchId;
        this.quota = quota;
    }
}
