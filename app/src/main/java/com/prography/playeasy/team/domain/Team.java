package com.prography.playeasy.team.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@ToString
@NoArgsConstructor
public class Team {
    private Integer id;
    private String name;
    private String description;
    private Integer age;
    private String level;
    private String leader;
    private String phone;

    @Builder
    public Team(String name, String description, Integer age, String level, String leader, String phone) {
        this.name = name;
        this.description = description;
        this.age = age;
        this.level = level;
        this.leader = leader;
        this.phone = phone;
    }
}
