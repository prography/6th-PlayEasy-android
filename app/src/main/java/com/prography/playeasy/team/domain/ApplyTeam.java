package com.prography.playeasy.team.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@ToString
@Accessors(fluent = true)
@NoArgsConstructor
public class ApplyTeam {

    private Integer id;
    private Integer quota;
    private String status;
    private Integer matchId;
    private Integer teamId;

    private Team team;

    @Builder
    public ApplyTeam(Integer id, Integer quota, String status, Integer matchId, Integer teamId) {
        this.id = id;
        this.quota = quota;
        this.status = status;
        this.matchId = matchId;
        this.teamId = teamId;
    }
}
