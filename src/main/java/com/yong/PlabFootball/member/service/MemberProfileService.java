package com.yong.PlabFootball.member.service;

import com.yong.PlabFootball.common.converter.MemberConverter;
import com.yong.PlabFootball.member.dto.MemberProfileDto;
import com.yong.PlabFootball.member.entity.Member;
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
    public MemberProfileDto createUserProfile(MemberProfile memberProfile) {
        return MemberConverter.toMemberProfileDto(memberProfileRepository.save(memberProfile));
    }

    public MemberProfileDto findById(MemberProfile memberProfile) {
        return MemberConverter.toMemberProfileDto(memberProfileRepository.findById(memberProfile.getId())
                .orElseThrow(IllegalArgumentException::new));
    }

    public MemberProfileDto findByMemberId(Member Member) {
        return MemberConverter.toMemberProfileDto(memberProfileRepository.findByMemberId(Member.getId())
                .orElseThrow(IllegalArgumentException::new));
    }

    @Transactional
    public void deleteById(MemberProfile memberProfile) {
        memberProfileRepository.deleteById(memberProfile.getId());
    }
}
