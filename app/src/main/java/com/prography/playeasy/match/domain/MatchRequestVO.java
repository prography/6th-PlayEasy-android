package com.prography.playeasy.match.domain;

import java.util.Date;

public class MatchRequestVO {
    private String title;
    private String type;
    private String description;
    private String location;
    private Integer fee;
    private Date startAt;
    private Date endAt;
    private Integer homeQuota;

    public MatchRequestVO(String title, String type, String description, String location, Integer fee, Date startAt, Date endAt, Integer homeQuota) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.location = location;
        this.fee = fee;
        this.startAt = startAt;
        this.endAt = endAt;
        this.homeQuota = homeQuota;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public Integer getHomeQuota() {
        return homeQuota;
    }

    public void setHomeQuota(Integer homeQuota) {
        this.homeQuota = homeQuota;
    }

    @Override
    public String toString() {
        return "MatchRequestVO{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", fee=" + fee +
                ", startAt=" + startAt +
                ", endAt=" + endAt +
                ", homeQuota=" + homeQuota +
                '}';
    }
}
