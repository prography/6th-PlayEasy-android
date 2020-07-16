package com.prography.playeasy.team.dto;
import com.prography.playeasy.team.domain.Team;
import com.prography.playeasy.mypage.domain.User;

import java.util.List;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@ToString
public class TeamResponseDto {
    private Team createTeam;
    private Team updateTeam;
    private List<User> userList;
    private List<Team> teamList;
}
