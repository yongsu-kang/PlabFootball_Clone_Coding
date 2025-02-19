package com.yong.PlabFootball.stadium.entity;

import com.yong.PlabFootball.global.vo.BaseEntity;
import com.yong.PlabFootball.stadium.entity.vo.GrassCondition;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "field")
public class Field extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int width;

    @Column(nullable = false)
    private int length;

    @Column(nullable = false)
    private boolean outdoor;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private GrassCondition grassCondition;

    @Column(nullable = false)
    private int amountPerHour;

    @ManyToOne
    private Stadium stadium;

    @Builder
    public Field(Long id, String name, int width, int length, boolean outdoor, GrassCondition grassCondition, int amountPerHour) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.length = length;
        this.outdoor = outdoor;
        this.grassCondition = grassCondition;
        this.amountPerHour = amountPerHour;
    }

    public void setStadium(Stadium stadium) {
        if (Objects.nonNull(this.stadium)) {
            stadium.getFields().remove(this);
        }
        this.stadium = stadium;
        stadium.getFields().add(this);
    }
}
