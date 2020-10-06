package com.prography.playeasy.match.domain.dtos.response;

import com.google.gson.annotations.SerializedName;
import com.prography.playeasy.match.domain.models.MatchTeamApplication;

public class MatchApplyTeamPostResponseDto {
    @SerializedName("success")
    boolean success;
    @SerializedName("matchTeamApplication")
    MatchTeamApplication matchTeamApplication;


}
