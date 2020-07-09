package com.prography.playeasy.match.domain.MatchRevise;

import java.util.Date;
//for request Put
public class MatchUpdateDto {

    private int id;
    // private String title;
    private enum type{SOCCER,FOOTSAL5,FOOTSAL6};
    private String description;
    private Date startAt;
    //location 변수 대신 duration 넣음
    private int duration;

    private int fee;

    private int phone;

    private int totalQuota;


}
