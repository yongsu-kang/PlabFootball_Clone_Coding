package com.yong.PlabFootball.member.service;

import com.yong.PlabFootball.member.entity.Member;
import com.yong.PlabFootball.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createUser(Member Member) {
        return memberRepository.save(Member);
    }

    public Member findById(Member Member) {
        return memberRepository.findById(Member.getId())
                .orElseThrow(() -> new IllegalArgumentException("wrong id"));
    }

    public Member findByEmail(Member Member) {
        return memberRepository.findByEmail(Member.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("wrong email"));
    }
}
