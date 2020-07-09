package com.prography.playeasy.match.domain.MatchDetail;

import java.util.Date;

public class Match {

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
    private enum status{WAITING,CONFIRMED,CANCEL};
    private Date createdAt;
    private Date updatedAt;
   //private int homeQuota;

    private int writerId;
    private int homeTeamId;
    private int locationId;
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

  public Date getCreatedAt() {
   return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
   this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
   return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
   this.updatedAt = updatedAt;
  }

  public int getWriterId() {
   return writerId;
  }

  public void setWriterId(int writerId) {
   this.writerId = writerId;
  }

  public int getHomeTeamId() {
   return homeTeamId;
  }

  public void setHomeTeamId(int homeTeamId) {
   this.homeTeamId = homeTeamId;
  }

  public int getLocationId() {
   return locationId;
  }

  public void setLocationId(int locationId) {
   this.locationId = locationId;
  }

  public HomeTeam getHomeTeam() {
   return homeTeam;
  }

  public void setHomeTeam(HomeTeam homeTeam) {
   this.homeTeam = homeTeam;
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
