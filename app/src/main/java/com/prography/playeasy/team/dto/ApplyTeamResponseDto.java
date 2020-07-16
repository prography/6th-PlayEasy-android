package com.prography.playeasy.team.dto;

import com.prography.playeasy.team.domain.ApplyTeam;

import java.util.List;

public class ApplyTeamResponseDto {

    private ApplyTeam matchTeamApplication;
    private ApplyTeam approvedMatchTeamApplication;
    private ApplyTeam deniedMatchTeamApplication;
    private ApplyTeam canceledMatchTeamApplication;
    private List<ApplyTeam> matchTeamApplicationList;

}
