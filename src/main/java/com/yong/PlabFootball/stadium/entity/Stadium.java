package com.yong.PlabFootball.stadium.entity;

import com.yong.PlabFootball.global.vo.BaseEntity;
import com.yong.PlabFootball.stadium.entity.vo.Region;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "stadium")
public class Stadium extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private boolean parking;

    @Column(nullable = false)
    private boolean toilet;

    @Column(nullable = false)
    private boolean vest;

    @Column(nullable = false)
    private boolean ball;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Region region;

    @OneToMany(mappedBy = "stadium", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Field> fields = new ArrayList<>();

    @Builder
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

    public void addField(Field field) {
        field.setStadium(this);
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changeParking(boolean parking) {
        this.parking = parking;
    }

    public void changeToilet(boolean toilet) {
        this.toilet = toilet;
    }

    public void changeVest(boolean vest) {
        this.vest = vest;
    }

    public void changeBall(boolean ball) {
        this.ball = ball;
    }

    public void changeRegion(Region region) {
        this.region = region;
    }

    public void changeLocation(String location) {
        this.location = location;
    }
}
