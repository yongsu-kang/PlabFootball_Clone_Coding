package com.yong.PlabFootball.stadium.entity;

import com.yong.PlabFootball.stadium.entity.vo.GrassCondition;
import lombok.Getter;

@Getter
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
}
