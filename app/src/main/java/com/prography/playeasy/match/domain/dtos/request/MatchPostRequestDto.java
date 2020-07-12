package com.prography.playeasy.match.domain.dtos.request;

import com.google.gson.annotations.SerializedName;
import com.prography.playeasy.match.domain.dtos.LocationDto;
import com.prography.playeasy.match.domain.dtos.MatchDto;

public class MatchPostRequestDto {
    @SerializedName("matchData")
    MatchDto matchData;
    @SerializedName("locationData")
    LocationDto locationData;


    public MatchPostRequestDto( MatchDto matchDto,LocationDto locationDto) {
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
