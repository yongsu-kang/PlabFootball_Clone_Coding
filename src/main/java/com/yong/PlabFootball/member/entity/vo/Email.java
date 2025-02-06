package com.yong.PlabFootball.member.entity.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Email {

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    @Column(name = "email", nullable = false, unique = true)
    private String value;

    public Email(String email) {
        validateEmail(email);
        this.value = email;
    }

    private void validateEmail(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailPattern);
        if (email.isBlank() || !pattern.matcher(email).matches())
            throw new IllegalArgumentException("this email is wrong");
    }

    public String getEmail() {
        return value;
    }
}
