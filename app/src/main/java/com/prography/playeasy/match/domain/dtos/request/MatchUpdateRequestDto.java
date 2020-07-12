package com.prography.playeasy.match.domain.dtos.request;

import com.google.gson.annotations.SerializedName;
import com.prography.playeasy.match.domain.models.Location;
import com.prography.playeasy.match.domain.models.Match;

public class MatchUpdateRequestDto {
@SerializedName("matchData")
    Match matchData;
@SerializedName("locationData")
    Location locationData;

    public MatchUpdateRequestDto(Match matchData, Location locationData) {
        this.matchData = matchData;
        this.locationData = locationData;
    }

    public Match getMatchData() {
        return matchData;
    }

    public void setMatchData(Match matchData) {
        this.matchData = matchData;
    }

    public Location getLocationData() {
        return locationData;
    }

    public void setLocationData(Location locationData) {
        this.locationData = locationData;
    }
}
