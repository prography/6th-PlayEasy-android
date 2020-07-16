package com.prography.playeasy.match.domain.dtos.request;

import com.google.gson.annotations.SerializedName;
import com.prography.playeasy.match.domain.dtos.LocationDto;
import com.prography.playeasy.match.domain.dtos.MatchIdDto;
import com.prography.playeasy.match.domain.dtos.MatchNoIdDto;

import java.util.HashMap;

public class MatchPostRequestDto extends HashMap<String,Object> {
    MatchNoIdDto matchData;
    //id없는 매치는 match
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
