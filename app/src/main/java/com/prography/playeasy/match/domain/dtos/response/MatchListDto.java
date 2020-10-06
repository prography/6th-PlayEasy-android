package com.prography.playeasy.match.domain.dtos.response;

import com.google.gson.annotations.SerializedName;
import com.prography.playeasy.match.domain.models.Match;

import java.util.ArrayList;
import java.util.List;

public class MatchListDto {
    @SerializedName("matchList")
    ArrayList<Match> matchList;

    public ArrayList<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(ArrayList<Match> matchList) {
        this.matchList = matchList;
    }


}
