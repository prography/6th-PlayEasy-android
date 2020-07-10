package com.prography.playeasy.match.domain.dtos.response;

import com.prography.playeasy.match.domain.models.Match;

public class MatchDetailDto {

    boolean success;

    Match match;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
