package com.yong.PlabFootball.member.service;

import com.yong.PlabFootball.global.converter.MemberConverter;
import com.yong.PlabFootball.member.dto.MemberDto;
import com.yong.PlabFootball.member.entity.Member;
import com.yong.PlabFootball.member.exception.EmailDuplicateException;
import com.yong.PlabFootball.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SignUpMemberService {

    private final MemberRepository memberRepository;

    public MemberDto signUpMember(MemberDto memberDto) {
        Member member = MemberConverter.toMemberEntity(memberDto);

        if (memberRepository.existsByEmail(member.getEmail())){
            throw new EmailDuplicateException(member.getEmail());
        }

        return MemberConverter.toMemberDto(memberRepository.save(member));
    }
}
