package com.yong.PlabFootball.member.repository;

import com.yong.PlabFootball.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

    @Query("select m from Member m where m.email.value = :email")
    public Optional<Member> searchByEmail(@Param("email") String email);
}
