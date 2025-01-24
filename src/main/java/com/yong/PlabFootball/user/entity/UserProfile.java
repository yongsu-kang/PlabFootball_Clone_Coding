package com.yong.PlabFootball.user.entity;

import com.yong.PlabFootball.user.entity.vo.Ability;
import com.yong.PlabFootball.user.entity.vo.FavoriteStyle;
import com.yong.PlabFootball.user.entity.vo.Gender;

public class UserProfile {
    private Long id;
    private String name;
    private String playerName;
    private String description;
    private Gender gender;
    private FavoriteStyle favoriteStyle;
    private Ability ability;

    public UserProfile(Long id, String name, String playerName, String description, Gender gender, FavoriteStyle favoriteStyle, Ability ability) {
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
