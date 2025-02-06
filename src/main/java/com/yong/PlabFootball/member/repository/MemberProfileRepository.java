package com.yong.PlabFootball.member.repository;

import com.yong.PlabFootball.member.entity.MemberProfile;

import java.util.Optional;

public interface MemberProfileRepository {
    MemberProfile insert(MemberProfile memberProfile);

    Optional<MemberProfile> findById(long userProfileId);

    Optional<MemberProfile> findByMemberId(long memberId);

    MemberProfile update(MemberProfile memberProfile);

    void deleteById(Long userProfileId);
}
