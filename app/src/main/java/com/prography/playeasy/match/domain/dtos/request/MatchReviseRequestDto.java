package com.prography.playeasy.match.domain.dtos.request;

import com.prography.playeasy.match.domain.dtos.LocationDto;
import com.prography.playeasy.match.domain.dtos.MatchDto;
import com.prography.playeasy.match.domain.dtos.MatchUpdateDto;
import com.prography.playeasy.match.domain.models.Location;

public class MatchReviseRequestDto {
    MatchDto matchData;
    Location locationData;
}
