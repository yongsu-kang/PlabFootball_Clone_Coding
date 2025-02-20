package com.yong.PlabFootball.member.service;

import com.yong.PlabFootball.global.converter.MemberConverter;
import com.yong.PlabFootball.member.dto.MemberDto;
import com.yong.PlabFootball.member.exception.EmailNotFoundException;
import com.yong.PlabFootball.member.exception.MemberNotFoundException;
import com.yong.PlabFootball.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchMemberService {

    private final MemberRepository memberRepository;

    public MemberDto searchMemberById(MemberDto memberDto) {
        Long targetId = memberDto.getId();

        return MemberConverter.toMemberDto(
                memberRepository.findById(targetId)
                        .orElseThrow(() -> new MemberNotFoundException(targetId)));
    }

    public MemberDto searchMemberByEmail(MemberDto memberDto) {
        String targetEmail = memberDto.getEmail();

        return MemberConverter.toMemberDto(
                memberRepository.searchByEmail(targetEmail)
                        .orElseThrow(() -> new EmailNotFoundException(targetEmail)));
    }

    public List<MemberDto> searchAllMember() {
        return memberRepository.findAll()
                .stream()
                .map(MemberConverter::toMemberDto)
                .toList();
    }
}
