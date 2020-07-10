package com.prography.playeasy.match.domain.dtos.request;

import com.prography.playeasy.match.domain.dtos.LocationDto;
import com.prography.playeasy.match.domain.dtos.MatchDto;

public class MatchPostRequestDto {
    LocationDto locationDto;

    MatchRequestDto matchDto;

    public MatchPostRequestDto( MatchRequestDto matchDto,LocationDto locationDto) {
        this.locationDto = locationDto;
        this.matchDto = matchDto;
    }
}
