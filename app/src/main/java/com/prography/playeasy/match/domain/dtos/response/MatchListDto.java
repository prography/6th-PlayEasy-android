package com.prography.playeasy.match.domain.dtos.response;

import com.prography.playeasy.match.domain.models.Match;

import java.util.List;

public class MatchListDto {

    List<Match> matchList;

    public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }
}
