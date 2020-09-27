package com.prography.playeasy.mypage.domain.dtos;

import com.google.gson.annotations.SerializedName;
import com.prography.playeasy.match.domain.models.HomeTeamId;
import com.prography.playeasy.match.domain.models.LocationId;
import com.prography.playeasy.match.domain.models.Match;

public class MatchCloseResponseDto {

    @SerializedName("match")
    Match match;

    @SerializedName("homeTeam")
    HomeTeamId homeTeam;

    @SerializedName("location")
    LocationId location;
}
