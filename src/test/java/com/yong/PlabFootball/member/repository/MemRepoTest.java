package com.yong.PlabFootball.member.repository;

import com.yong.PlabFootball.member.entity.Member;
import com.yong.PlabFootball.member.entity.vo.Email;
import com.yong.PlabFootball.member.entity.vo.Password;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

@SpringBootTest
@ActiveProfiles("test")
class MemRepoTest {

    @Autowired
    MemberRepository memberRepository;

    private final String email = "test123@test.com";
    private final String password = "fajdsk!@321";

    Member mem = Member.builder()
            .name("kang")
            .email(new Email(email))
            .password(new Password(password))
            .build();


    @BeforeEach
    void setUp() {
        memberRepository.save(mem);
    }

    @AfterEach
    void tearDown() {
        memberRepository.deleteAll();
    }

    @Test
    void findByEmail() {
        Member member = memberRepository.searchByEmail(mem.getEmail().getEmail()).get();

        assertAll(
                () -> assertThat(member.getEmail().getEmail(), is(mem.getEmail().getEmail()))
        );
    }
}