package com.yong.PlabFootball.member.service;

import com.yong.PlabFootball.global.converter.MemberConverter;
import com.yong.PlabFootball.member.dto.MemberDto;
import com.yong.PlabFootball.member.entity.Member;
import com.yong.PlabFootball.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberDto createMember(MemberDto memberDto) {
        return MemberConverter.toMemberDto(
                memberRepository.save(
                        MemberConverter.toMemberEntity(memberDto))
        );
    }

    public MemberDto searchMemberById(MemberDto memberDto) {
        return MemberConverter.toMemberDto(
                memberRepository.findById(memberDto.getId())
                        .orElseThrow(() -> new IllegalArgumentException("wrong id"))
        );
    }

    public MemberDto searchMemberByEmail(MemberDto memberDto) {
        return MemberConverter.toMemberDto(
                memberRepository.searchByEmail(memberDto.getEmail())
                        .orElseThrow(() -> new IllegalArgumentException("wrong email"))
        );
    }

    public List<MemberDto> searchAllMember() {
        return memberRepository.findAll()
                .stream()
                .map(MemberConverter::toMemberDto)
                .toList();
    }

    @Transactional
    public MemberDto modifyMemberPassword(MemberDto memberDto) {
        Member member = memberRepository.findById(memberDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("wrong id"));
        member.changePassword(memberDto.getPassword());
        return MemberConverter.toMemberDto(member);
    }

    @Transactional
    public void deleteById(MemberDto memberDto) {
        memberRepository.deleteById(memberDto.getId());
    }
}
