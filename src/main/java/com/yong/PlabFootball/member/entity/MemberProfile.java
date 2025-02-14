package com.yong.PlabFootball.member.entity;

import com.yong.PlabFootball.common.vo.BaseEntity;
import com.yong.PlabFootball.member.entity.vo.Ability;
import com.yong.PlabFootball.member.entity.vo.FavoriteStyle;
import com.yong.PlabFootball.member.entity.vo.Gender;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberProfile extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String playerName;

    @Column
    private String description;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Enumerated(value = EnumType.STRING)
    private FavoriteStyle favoriteStyle;

    @Enumerated(value = EnumType.STRING)
    private Ability ability;

    @Builder
    public MemberProfile(Long id, String name, String playerName, String description, Gender gender, FavoriteStyle favoriteStyle, Ability ability) {
        this.id = id;
        this.name = name;
        this.playerName = playerName;
        this.description = description;
        this.gender = gender;
        this.favoriteStyle = favoriteStyle;
        this.ability = ability;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changePlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void changeDescription(String description) {
        this.description = description;
    }

    public void changeGender(Gender gender) {
        this.gender = gender;
    }

    public void changeFavoriteStyle(FavoriteStyle favoriteStyle) {
        this.favoriteStyle = favoriteStyle;
    }

    public void changeAbility(Ability ability) {
        this.ability = ability;
    }
}
