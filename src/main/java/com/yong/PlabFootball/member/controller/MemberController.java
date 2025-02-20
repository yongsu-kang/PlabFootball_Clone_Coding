package com.yong.PlabFootball.member.controller;

import com.yong.PlabFootball.member.dto.MemberDto;
import com.yong.PlabFootball.member.dto.MemberProfileDto;
import com.yong.PlabFootball.member.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberProfileService memberProfileService;
    private final SignUpMemberService signUpMemberService;
    private final SearchMemberService searchMemberService;
    private final ModifyMemberService modifyMemberService;

    @PostMapping
    public MemberDto signUpMember(MemberDto memberDto) {
        return signUpMemberService.signUpMember(memberDto);
    }

    @GetMapping("/{member_id}")
    public MemberDto searchMemberById(@PathVariable(value = "member_id") Long id) {
        MemberDto memberDto = MemberDto.builder().id(id).build();
        return searchMemberService.searchMemberById(memberDto);
    }

    @GetMapping
    public List<MemberDto> searchAllMembers() {
        return searchMemberService.searchAllMember();
    }

    @PutMapping
    public MemberDto changePassword(MemberDto memberDto) {
        return modifyMemberService.modifyMemberPassword(memberDto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMemberById(MemberDto memberDto) {
        modifyMemberService.deleteById(memberDto);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/info")
    public MemberProfileDto createMemberProfile(MemberProfileDto memberProfileDto) {
        return memberProfileService.createMemberProfile(memberProfileDto);
    }

    @GetMapping("/info")
    public MemberProfileDto getMemberProfileById(MemberProfileDto memberProfileDto) {
        return memberProfileService.searchProfileById(memberProfileDto);
    }

    @PutMapping("/info")
    public MemberProfileDto changeMemberProfile(MemberProfileDto memberProfileDto) {
        return memberProfileService.modifyMemberProfile(memberProfileDto);
    }
}
