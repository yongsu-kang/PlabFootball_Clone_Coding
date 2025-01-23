package com.yong.PlabFootball.user.entity.vo;

import java.util.regex.Pattern;

public class Email {

    private final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private String email;

    public Email(String email) {
        validateEmail(email);
        this.email = email;
    }

    private void validateEmail(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailPattern);
        if (email.isBlank() || !pattern.matcher(email).matches())
            throw new IllegalArgumentException("this email is wrong");
    }

    public String getEmail() {
        return email;
    }
}
