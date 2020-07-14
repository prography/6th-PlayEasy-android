package com.prography.playeasy.team.domain;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@ToString
@Accessors(fluent = true)
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
}

