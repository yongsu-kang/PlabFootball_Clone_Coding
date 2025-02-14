package com.yong.PlabFootball.member.service;

import com.yong.PlabFootball.common.converter.MemberConverter;
import com.yong.PlabFootball.member.dto.MemberProfileDto;
import com.yong.PlabFootball.member.entity.MemberProfile;
import com.yong.PlabFootball.member.repository.MemberProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberProfileService {
    private final MemberProfileRepository memberProfileRepository;

    @Transactional
    public MemberProfileDto createMemberProfile(MemberProfileDto memberProfileDto) {
        return MemberConverter.toMemberProfileDto(memberProfileRepository.save(MemberConverter.toMemberProfileEntity(memberProfileDto)));
    }

    public MemberProfileDto findById(MemberProfileDto memberProfileDto) {
        return MemberConverter.toMemberProfileDto(memberProfileRepository.findById(memberProfileDto.getId())
                .orElseThrow(IllegalArgumentException::new));
    }

    @Transactional
    public MemberProfileDto modifyMemberProfile(MemberProfileDto memberProfileDto) {
        MemberProfile memberProfile = memberProfileRepository.findById(memberProfileDto.getId())
                .orElseThrow(IllegalArgumentException::new);

        if (!memberProfile.getDescription().equals(memberProfileDto.getDescription())) {
            memberProfile.changeDescription(memberProfileDto.getDescription());
        }

        if (!memberProfile.getAbility().equals(memberProfileDto.getAbility())) {
            memberProfile.changeAbility(memberProfileDto.getAbility());
        }

        if (!memberProfile.getGender().equals(memberProfileDto.getGender())) {
            memberProfile.changeGender(memberProfileDto.getGender());
        }

        if (!memberProfile.getFavoriteStyle().equals(memberProfileDto.getFavoriteStyle())) {
            memberProfile.changeFavoriteStyle(memberProfileDto.getFavoriteStyle());
        }

        if (!memberProfile.getPlayerName().equals(memberProfileDto.getPlayerName())) {
            memberProfile.changePlayerName(memberProfileDto.getPlayerName());
        }

        return memberProfileDto;
    }

    @Transactional
    public void deleteById(MemberProfileDto memberProfileDto) {
        memberProfileRepository.deleteById(memberProfileDto.getId());
    }
}
