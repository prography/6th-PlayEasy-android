package com.prography.playeasy.match.domain.dtos;

import java.util.Date;

public class MatchDto {
    private enum type{SOCCER,FOOTSAL5,FOOTSAL6};
    private String description;
    private Date startAt;
    //location 변수 대신 duration 넣음
    private int duration;

    private int fee;

}
