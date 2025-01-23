package com.yong.PlabFootball.user.entity;

import com.yong.PlabFootball.user.entity.vo.Email;
import com.yong.PlabFootball.user.entity.vo.Password;

import java.util.regex.Pattern;

public class User {
    private long userId;
    private String username;
    private final Email email;
    private Password password;

    public User(String username, Email email, Password password) {
        validateUsername(username);
        this.username = username;
        this.email = email;
        this.password = password;
    }

    private void validateUsername(String username) {
        if (username.isBlank()) throw new IllegalArgumentException("this name is wrong");
    }

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email.getEmail();
    }

    public String getPassword() {
        return password.getPassword();
    }

    public void changePassword(String newPassword) {
        this.password = password.changePassword(newPassword);
    }
}
