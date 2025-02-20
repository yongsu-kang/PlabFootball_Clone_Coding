package com.yong.PlabFootball.member.service;

import com.yong.PlabFootball.global.converter.MemberConverter;
import com.yong.PlabFootball.member.dto.MemberDto;
import com.yong.PlabFootball.member.entity.Member;
import com.yong.PlabFootball.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ModifyMemberService {

    private final MemberRepository memberRepository;

    public MemberDto modifyMemberPassword(MemberDto memberDto) {
        Member member = memberRepository.findById(memberDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("wrong id"));
        member.changePassword(memberDto.getPassword());
        return MemberConverter.toMemberDto(member);
    }

    public void deleteById(MemberDto memberDto) {
        memberRepository.deleteById(memberDto.getId());
    }
}
