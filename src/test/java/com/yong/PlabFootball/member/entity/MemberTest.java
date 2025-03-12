package com.yong.PlabFootball.member.entity;

import com.yong.PlabFootball.member.entity.vo.Email;
import com.yong.PlabFootball.member.entity.vo.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

class MemberTest {

    @Test
    @DisplayName("유저 객체를 생성할 수 있어야 한다.")
    void userCreateTest() {
        //given
        String username = "kang";
        Email email = new Email("kang@test.com");
        Password password = new Password("aaa1234!!");

        //when
        Member member = Member.builder()
                .name(username)
                .email(email)
                .password(password)
                .build();

        //then
        assertAll(
                () -> assertThat(member.getName(), is(username)),
                () -> assertThat(member.getEmail().getEmail(), is(email.getEmail())),
                () -> assertThat(member.getPassword().getPassword(), is(password.getPassword()))
        );
    }

    @Test
    @DisplayName("생성시에 모든 값이 존재해야한다.")
    void blankTest() {
        //given
        String username = "kang";
        Email email = new Email("kang@test.com");
        Password password = new Password("aaa1234!!");

        //when,then
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> Member.builder()
                                .name(username)
                                .email(new Email(""))
                                .password(password)
                                .build()
                ),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> Member.builder()
                                .name("")
                                .email(email)
                                .password(password)
                                .build()
                ),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> Member.builder()
                                .name(username)
                                .email(email)
                                .password(new Password(""))
                                .build()
                )
        );
    }

    @Test
    @DisplayName("이메일 형식이 아니면 예외처리 발생")
    void wrongEmailTest() {
        //given
        String username = "kang";
        Password password = new Password("aaa1234!!");

        //when
        //then
        assertThrows(IllegalArgumentException.class,
                () -> Member.builder()
                        .name(username)
                        .email(new Email("kang123"))
                        .password(password)
                        .build()
        );
    }

    @Test
    @DisplayName("패스워드는 8자리 이상의 영어 숫자 특수기호를 포함해야한다.")
    void wrongPasswordTest() {
        String username = "kang";
        Email email = new Email("kang@test.com");

        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> Member.builder().name(username)
                                .email(email)
                                .password(new Password("a1!"))
                                .build()
                ),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> Member.builder().name(username)
                                .email(email)
                                .password(new Password("asdfertg"))
                                .build()
                ),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> Member.builder().name(username)
                                .email(email)
                                .password(new Password("fjdask123"))
                                .build()
                ),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> Member.builder().name(username)
                                .email(email)
                                .password(new Password("!@#@#@1312"))
                                .build()
                ),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> Member.builder().name(username)
                                .email(email)
                                .password(new Password("djksal!@#!@$!"))
                                .build()
                )
        );
    }
}