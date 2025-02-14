package com.yong.PlabFootball.common.converter;

import com.yong.PlabFootball.member.dto.MemberDto;
import com.yong.PlabFootball.member.dto.MemberProfileDto;
import com.yong.PlabFootball.member.entity.Member;
import com.yong.PlabFootball.member.entity.MemberProfile;
import com.yong.PlabFootball.member.entity.vo.Email;
import com.yong.PlabFootball.member.entity.vo.Password;

public class MemberConverter {

    public static MemberDto toMemberDto(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .password(member.getPassword())
                .build();
    }

    public static Member toMemberEntity(MemberDto memberDto) {
        return Member.builder()
                .id(memberDto.getId())
                .name(memberDto.getName())
                .email(new Email(memberDto.getEmail()))
                .password(new Password(memberDto.getPassword()))
                .build();
    }

    public static MemberProfileDto toMemberProfileDto(MemberProfile memberProfile) {
        return MemberProfileDto.builder()
                .id(memberProfile.getId())
                .name(memberProfile.getName())
                .playerName(memberProfile.getPlayerName())
                .description(memberProfile.getDescription())
                .gender(memberProfile.getGender())
                .favoriteStyle(memberProfile.getFavoriteStyle())
                .ability(memberProfile.getAbility())
                .build();
    }

    public static MemberProfile toMemberProfileEntity(MemberProfileDto memberProfileDto) {
        return MemberProfile.builder()
                .id(memberProfileDto.getId())
                .name(memberProfileDto.getName())
                .playerName(memberProfileDto.getPlayerName())
                .description(memberProfileDto.getDescription())
                .gender(memberProfileDto.getGender())
                .favoriteStyle(memberProfileDto.getFavoriteStyle())
                .ability(memberProfileDto.getAbility())
                .build();
    }
}
