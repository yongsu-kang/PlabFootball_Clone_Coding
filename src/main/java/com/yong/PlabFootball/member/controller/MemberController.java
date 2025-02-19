package com.yong.PlabFootball.member.controller;

import com.yong.PlabFootball.member.dto.MemberDto;
import com.yong.PlabFootball.member.dto.MemberProfileDto;
import com.yong.PlabFootball.member.service.MemberProfileService;
import com.yong.PlabFootball.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberProfileService memberProfileService;

    @PostMapping("/api/members")
    public MemberDto createMember(MemberDto memberDto) {
        return memberService.createMember(memberDto);
    }

    @GetMapping("/api/members/{member_id}")
    public MemberDto getMemberById(@PathVariable(value = "member_id") Long id) {
        MemberDto memberDto = MemberDto.builder().id(id).build();
        return memberService.findById(memberDto);
    }

    @GetMapping("/api/members")
    public List<MemberDto> getMembers() {
        return memberService.findAllMember();
    }

    @PutMapping("/api/members")
    public MemberDto changePassword(MemberDto memberDto) {
        return memberService.changePassword(memberDto);
    }

    @DeleteMapping("/api/members")
    public ResponseEntity<Void> deleteMemberById(MemberDto memberDto) {
        memberService.deleteById(memberDto);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/api/members/info")
    public MemberProfileDto createMemberProfile(MemberProfileDto memberProfileDto) {
        return memberProfileService.createMemberProfile(memberProfileDto);
    }

    @GetMapping("/api/members/info")
    public MemberProfileDto getMemberProfileById(MemberProfileDto memberProfileDto) {
        return memberProfileService.findById(memberProfileDto);
    }

    @PutMapping("/api/members/info")
    public MemberProfileDto changeMemberProfile(MemberProfileDto memberProfileDto) {
        return memberProfileService.modifyMemberProfile(memberProfileDto);
    }
}
