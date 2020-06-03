package com.prography.playeasy.match.domain;

import java.util.Date;

public class MatchResponseVO {
    private boolean success;
    private Match match;

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
