package com.yong.PlabFootball.user.entity;

import com.yong.PlabFootball.user.entity.vo.Email;
import com.yong.PlabFootball.user.entity.vo.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

class UserTest {

    @Test
    @DisplayName("유저 객체를 생성할 수 있어야 한다.")
    void userCreateTest() {
        //given
        String username = "kang";
        Email email = new Email("kang@test.com");
        Password password = new Password("aaa1234!!");

        //when
        User user = new User(username, email, password);

        //then
        assertAll(
                () -> assertThat(user.getUsername(), is(username)),
                () -> assertThat(user.getEmail(), is(email.getEmail())),
                () -> assertThat(user.getPassword(), is(password.getPassword()))
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
                () -> assertThrows(IllegalArgumentException.class, () -> new User(username, new Email(""), password)),
                () -> assertThrows(IllegalArgumentException.class, () -> new User("", email, password)),
                () -> assertThrows(IllegalArgumentException.class, () -> new User(username, email, new Password("")))
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
        assertThrows(IllegalArgumentException.class, () -> new User(username, new Email("kang123"), password));
    }

    @Test
    @DisplayName("패스워드는 8자리 이상의 영어 숫자 특수기호를 포함해야한다.")
    void wrongPasswordTest() {
        String username = "kang";
        Email email = new Email("kang@test.com");

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new User(username, email, new Password("a1!"))),
                () -> assertThrows(IllegalArgumentException.class, () -> new User(username, email, new Password("asdfertg"))),
                () -> assertThrows(IllegalArgumentException.class, () -> new User(username, email, new Password("fjdask123"))),
                () -> assertThrows(IllegalArgumentException.class, () -> new User(username, email, new Password("!@#@#@1312"))),
                () -> assertThrows(IllegalArgumentException.class, () -> new User(username, email, new Password("djksal!@#!@$!")))
        );
    }
}