package com.prography.playeasy.match.domain.dtos.request;

import com.google.gson.annotations.SerializedName;
import com.prography.playeasy.match.domain.dtos.LocationDto;
import com.prography.playeasy.match.domain.dtos.MatchIdDto;
import com.prography.playeasy.match.domain.dtos.MatchNoIdDto;

public class MatchPostRequestDto {
    @SerializedName("matchData")
    MatchNoIdDto matchData;
    //id없는 매치는 match
    @SerializedName("locationData")
    LocationDto locationData;


    public MatchPostRequestDto( MatchNoIdDto matchDto,LocationDto locationDto) {
        this.locationData = locationDto;
        this.matchData = matchDto;
    }
    public String toString() {
        return "MatchPostRequestDto{" +

                ", matchData=" + matchData +
                ", locationData='" + locationData + '\'' +
                '}';

    }


}
