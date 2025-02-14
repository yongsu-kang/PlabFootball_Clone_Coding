package com.yong.PlabFootball.member.dto;

import com.yong.PlabFootball.member.entity.vo.Ability;
import com.yong.PlabFootball.member.entity.vo.FavoriteStyle;
import com.yong.PlabFootball.member.entity.vo.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MemberProfileDto {
    private Long id;
    private String name;
    private String playerName;
    private String description;
    private Gender gender;
    private FavoriteStyle favoriteStyle;
    private Ability ability;
}
