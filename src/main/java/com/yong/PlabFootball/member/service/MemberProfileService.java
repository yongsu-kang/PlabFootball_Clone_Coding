package com.yong.PlabFootball.member.service;

import com.yong.PlabFootball.member.entity.Member;
import com.yong.PlabFootball.member.entity.MemberProfile;
import com.yong.PlabFootball.member.repository.MemberProfileRepository;

public class MemberProfileService {
    private final MemberProfileRepository memberProfileRepository;

    public MemberProfileService(MemberProfileRepository memberProfileRepository) {
        this.memberProfileRepository = memberProfileRepository;
    }

    public MemberProfile createUserProfile(MemberProfile memberProfile) {
        return memberProfileRepository.insert(memberProfile);
    }

    public MemberProfile findById(MemberProfile memberProfile) {
        return memberProfileRepository.findById(memberProfile.getId())
                .orElseThrow(IllegalArgumentException::new);
    }

    public MemberProfile findByUserId(Member Member) {
        return memberProfileRepository.findByMemberId(Member.getId())
                .orElseThrow(IllegalArgumentException::new);
    }

    public void deleteById(MemberProfile memberProfile) {
        memberProfileRepository.deleteById(memberProfile.getId());
    }
}
