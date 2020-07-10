package com.prography.playeasy.match.domain.MatchDetail;

public class MatchDetailDAO {

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
