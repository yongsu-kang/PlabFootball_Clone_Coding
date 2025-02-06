package com.yong.PlabFootball.member.entity.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Password {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$])(?=\\S+$).{8,}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    @Column(name = "password", nullable = false)
    private String value;

    public Password(String password) {
        validatePassword(password);
        this.value = password;
    }

    private void validatePassword(String password) {
        if (password.isBlank() || password.length() < 8 || !pattern.matcher(password).matches())
            throw new IllegalArgumentException("this password is wrong");
    }

    public Password changePassword(String newPassword) {
        return new Password(newPassword);
    }

    public String getPassword() {
        return value;
    }
}
