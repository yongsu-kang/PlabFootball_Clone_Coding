package com.yong.PlabFootball.member.service;

import com.yong.PlabFootball.member.dto.MemberDto;
import com.yong.PlabFootball.member.exception.EmailDuplicateException;
import com.yong.PlabFootball.member.exception.EmailNotFoundException;
import com.yong.PlabFootball.member.exception.MemberNotFoundException;
import com.yong.PlabFootball.member.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    private Long memberId;
    private String name = "kang";
    private String email = "kys7195@test.com";
    private String password = "test123!!";

    @BeforeEach
    void setup() {

        MemberDto memberDto = MemberDto.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();

        MemberDto savedMember = memberService.createMember(memberDto);

        this.memberId = savedMember.getId();

        assertAll(
                () -> assertThat(savedMember.getName(), is(name)),
                () -> assertThat(savedMember.getEmail(), is(email)),
                () -> assertThat(savedMember.getPassword(), is(password))
        );
    }

    @AfterEach
    void tearDown() {
        memberRepository.deleteAll();
    }

    @Test
    @DisplayName("중복된 이메일로 회원가입할 수 없다.")
    void duplicateEmailTest() {
        MemberDto duplicateEmailDto = MemberDto.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();

        assertThrows(EmailDuplicateException.class, () -> memberService.createMember(duplicateEmailDto));
    }

    @Test
    @DisplayName("ID 값으로 회원을 찾을 수 있다.")
    void searchMemberById() {
        MemberDto memberDto = MemberDto.builder()
                .id(memberId)
                .name(name)
                .email(email)
                .password(password)
                .build();

        MemberDto foundMember = memberService.searchMemberById(memberDto);

        assertAll(
                () -> assertThat(foundMember.getName(), is(name)),
                () -> assertThat(foundMember.getEmail(), is(email)),
                () -> assertThat(foundMember.getPassword(), is(password))
        );

    }

    @Test
    @DisplayName("ID 값이 없으면 에러를 발생시킨다.")
    void notFoundById() {
        Long isNotId = Long.MAX_VALUE;
        MemberDto memberDto = MemberDto.builder()
                .id(isNotId)
                .name(name)
                .email(email)
                .password(password)
                .build();

        assertThrows(MemberNotFoundException.class, () -> memberService.searchMemberById(memberDto));
    }

    @Test
    @DisplayName("이메일로 찾을 수 있다.")
    void searchMemberByEmail() {
        MemberDto memberDto = MemberDto.builder()
                .id(memberId)
                .name(name)
                .email(email)
                .password(password)
                .build();

        MemberDto foundMember = memberService.searchMemberByEmail(memberDto);

        assertAll(
                () -> assertThat(foundMember.getId(), is(memberDto.getId())),
                () -> assertThat(foundMember.getName(), is(memberDto.getName())),
                () -> assertThat(foundMember.getEmail(), is(memberDto.getEmail())),
                () -> assertThat(foundMember.getPassword(), is(memberDto.getPassword()))
        );
    }

    @Test
    @DisplayName("이메일을 찾을 수 없으면 에러를 낸다.")
    void notFoundByEmail() {
        String notSameEmail = "notSame12@test.com";

        MemberDto memberDto = MemberDto.builder()
                .id(memberId)
                .name(name)
                .email(notSameEmail)
                .password(password)
                .build();

        assertThrows(EmailNotFoundException.class, () -> memberService.searchMemberByEmail(memberDto));
    }

    @Test
    void modifyMemberPassword() {
        String changePassword = "otherPassword123!!";
        MemberDto memberDto = MemberDto.builder()
                .id(memberId)
                .name(name)
                .email(email)
                .password(changePassword)
                .build();

        MemberDto changedMember = memberService.modifyMemberPassword(memberDto);

        assertAll(
                () -> assertThat(changedMember.getPassword(), not(password)),
                () -> assertThat(changedMember.getPassword(), is(changePassword))
        );
    }
}