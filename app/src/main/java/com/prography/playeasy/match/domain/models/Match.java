package com.prography.playeasy.match.domain.models;

import java.util.Date;

public class Match {

    private int id;
   // private String title;
    static enum Type{SOCCER,FOOTSAL5,FOOTSAL6};
    private Type type;
    private String description;
    private Date startAt;
    //location 변수 대신 duration 넣음
    private int duration;

    private int fee;

    private int phone;

    private int totalQuota;
    static enum Status{WAITING,CONFIRMED,CANCEL};
    private Status matchStatus;
//   //제거
//    private Date createdAt;
//    private Date updatedAt;
   //private int homeQuota;

    private int writerId;
//
//    private int homeTeamId;
//    private int locationId;
   //사라진 필드 private int awayTeamId와 homeQuota;
    private HomeTeam homeTeam;
    private Location location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getTotalQuota() {
        return totalQuota;
    }

    public void setTotalQuota(int totalQuota) {
        this.totalQuota = totalQuota;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public HomeTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(HomeTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Match(int id, Type type, String description, Date startAt, int duration, int fee, int phone, int totalQuota, Status matchStatus, int writerId, HomeTeam homeTeam, Location location) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.startAt = startAt;
        this.duration = duration;
        this.fee = fee;
        this.phone = phone;
        this.totalQuota = totalQuota;
        this.matchStatus = matchStatus;
        this.writerId = writerId;
        this.homeTeam = homeTeam;
        this.location = location;
    }
//    @Override
//    public String toString() {
//        return "Match{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", type='" + type + '\'' +
//                ", description='" + description + '\'' +
//                ", location='" + location + '\'' +
//                ", fee=" + fee +
//                ", startAt=" + startAt +
//                ", endAt=" + endAt +
//                ", homeQuota=" + homeQuota +
//                ", writerId=" + writerId +
//                ", homeTeamId=" + homeTeamId +
//                ", awayQuota=" + awayQuota +
//                ", awayTeamId=" + awayTeamId +
//                '}';
//    }
}
