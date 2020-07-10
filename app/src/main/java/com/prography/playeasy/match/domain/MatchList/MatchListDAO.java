package com.prography.playeasy.match.domain.MatchList;

import com.prography.playeasy.match.domain.MatchDetail.Match;

import java.util.List;

public class MatchListDAO {
    boolean success;
    List<Match> matchList;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }
}
