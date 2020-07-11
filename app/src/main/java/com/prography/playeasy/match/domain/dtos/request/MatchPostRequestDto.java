package com.prography.playeasy.match.domain.dtos.request;

import com.google.gson.annotations.SerializedName;
import com.prography.playeasy.match.domain.dtos.LocationDto;
import com.prography.playeasy.match.domain.dtos.MatchDto;

public class MatchPostRequestDto {
    @SerializedName("locationData")
    LocationDto locationData;
@SerializedName("matchData")
    MatchRequestDto matchData;

    public MatchPostRequestDto( MatchRequestDto matchDto,LocationDto locationDto) {
        this.locationData = locationDto;
        this.matchData = matchDto;
    }
    public String toString() {
        return "MatchPostRequestDto{" +
                ", locationData=" + locationData +
                ", matchData='" + matchData + '\'' +
                '}';
    }


}
