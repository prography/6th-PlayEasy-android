package com.prography.playeasy.mypage.domain;

import com.prography.playeasy.team.domain.Team;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@ToString
@Accessors(fluent = true)
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private String socialType;
    private String phone;
    private String pushToken;
    private String level;
    private String description;
    private String picture;
    private Integer teamId;

    private Team team;

    @Builder
    public User(Integer id, String name, Integer age, String email, String socialType, String phone, String pushToken, String level, String description, String picture) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.socialType = socialType;
        this.phone = phone;
        this.pushToken = pushToken;
        this.level = level;
        this.description = description;
        this.picture = picture;
    }
}

