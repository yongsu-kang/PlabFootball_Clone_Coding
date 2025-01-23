package com.yong.PlabFootball.user.entity;

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
        String email = "kang@test.com";
        String password = "aaa1234!!";

        //when
        User user = new User(username, email, password);

        //then
        assertAll(
                () -> assertThat(user.getUsername(), is(username)),
                () -> assertThat(user.getEmail(), is(email)),
                () -> assertThat(user.getPassword(), is(password))
        );
    }

    @Test
    @DisplayName("생성시에 모든 값이 존재해야한다.")
    void blankTest() {
        //given
        String username = "kang";
        String email = "kang@test.com";
        String password = "aaa1234!!";

        //when,then
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new User(username, "", password)),
                () -> assertThrows(IllegalArgumentException.class, () -> new User("", email, password)),
                () -> assertThrows(IllegalArgumentException.class, () -> new User(username, email, ""))
        );
    }

    @Test
    @DisplayName("이메일 형식이 아니면 예외처리 발생")
    void wrongEmailTest() {
        //given
        String username = "kang";
        String wrong_email = "kang123";
        String password = "aaa1234!!";

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new User(username, wrong_email, password));
    }

    @Test
    @DisplayName("패스워드는 8자리 이상의 영어 숫자 특수기호를 포함해야한다.")
    void wrongPasswordTest() {
        String username = "kang";
        String email = "kang@test.com";
        String wrongPassword1 = "a1!";
        String wrongPassword2 = "asdfertg";
        String wrongPassword3 = "fjdask123";
        String wrongPassword4 = "!@#@#@1312";
        String wrongPassword5 = "djksal!@#!@$!";

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new User(username, email, wrongPassword1)),
                () -> assertThrows(IllegalArgumentException.class, () -> new User(username, email, wrongPassword2)),
                () -> assertThrows(IllegalArgumentException.class, () -> new User(username, email, wrongPassword3)),
                () -> assertThrows(IllegalArgumentException.class, () -> new User(username, email, wrongPassword4)),
                () -> assertThrows(IllegalArgumentException.class, () -> new User(username, email, wrongPassword5))
        );


    }
}