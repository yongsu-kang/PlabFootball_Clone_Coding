package com.yong.PlabFootball.stadium.entity;

import com.yong.PlabFootball.stadium.entity.vo.GrassCondition;

public class Field {
    private Long id;
    private String name;
    private int width;
    private int length;
    private boolean outdoor;
    private GrassCondition grassCondition;
    private int amountPerHour;

    public Field(Long fieldId, String name, int width, int length, boolean outdoor, GrassCondition grassCondition, int amountPerHour) {
        this.id = fieldId;
        this.name = name;
        this.width = width;
        this.length = length;
        this.outdoor = outdoor;
        this.grassCondition = grassCondition;
        this.amountPerHour = amountPerHour;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public boolean isOutdoor() {
        return outdoor;
    }

    public GrassCondition getGrassCondition() {
        return grassCondition;
    }

    public int getAmountPerHour() {
        return amountPerHour;
    }
}
