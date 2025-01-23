package com.yong.PlabFootball.user.entity.vo;

import java.util.regex.Pattern;

public class Password {

    private final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$])(?=\\S+$).{8,}$";
    private final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
    private String password;

    public Password(String password) {
        validatePassword(password);
        this.password = password;
    }

    private void validatePassword(String password) {
        if (password.isBlank() || password.length() < 8 || !pattern.matcher(password).matches()) throw new IllegalArgumentException("this password is wrong");
    }

    public String getPassword() {
        return password;
    }

    public Password changePassword(String newPassword) {
        return new Password(newPassword);
    }
}
