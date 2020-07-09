package com.prography.playeasy.match.domain.MatchList;

import java.util.Date;

public class MatchEntity {


    private int id;
    // private String title;
    private String type;
    private String description;
    private Date startAt;
    //location 변수 대신 duration 넣음
    private int duration;

    private int fee;

    private int phone;

    private int totalQuota;
    private enum status{WAITING,CONFIRMED,CANCEL};
    private Date createdAt;
    private Date updatedAt;
    //private int homeQuota;

    private int writerId;
    private int homeTeamId;
    private int locationId;

}
