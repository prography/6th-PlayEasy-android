package com.prography.playeasy.mypage.dto;

import com.prography.playeasy.mypage.domain.User;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@ToString
public class UserResponseDto {
    private User user;

}
