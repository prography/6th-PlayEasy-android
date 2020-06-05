package com.prography.playeasy.match.domain;

import java.util.Date;
import java.util.List;

public class MatchResponseVO {
    private boolean success;
    private Match match;
    private List<Match> matchList;

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

    public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }


}
