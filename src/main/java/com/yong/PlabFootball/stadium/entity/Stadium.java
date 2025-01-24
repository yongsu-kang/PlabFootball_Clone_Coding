package com.yong.PlabFootball.stadium.entity;

import com.yong.PlabFootball.stadium.entity.vo.Region;

public class Stadium {
    private Long id;
    private String name;
    private String location;
    private boolean parking;
    private boolean toilet;
    private boolean vest;
    private boolean ball;
    private Region region;

    public Stadium(Long id, String name, String location, boolean parking, boolean toilet, boolean vest, boolean ball, Region region) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.parking = parking;
        this.toilet = toilet;
        this.vest = vest;
        this.ball = ball;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public boolean hasParking() {
        return parking;
    }

    public boolean hasToilet() {
        return toilet;
    }

    public boolean hasVest() {
        return vest;
    }

    public boolean hasBall() {
        return ball;
    }

    public Region getRegion() {
        return region;
    }
}
