package com.yong.PlabFootball.member.repository;

import com.yong.PlabFootball.member.entity.MemberProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberProfileRepository extends JpaRepository<MemberProfile, Long> {
}
