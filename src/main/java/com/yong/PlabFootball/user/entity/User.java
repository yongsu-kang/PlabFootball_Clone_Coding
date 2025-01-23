package com.yong.PlabFootball.user.entity;

import java.util.regex.Pattern;

public class User {
    private long userId;
    private String username;
    private final String email;
    private String password;

    public User(String username, String email, String password) {
        validateUsername(username);
        validateEmail(email);
        validatePassword(password);

        this.username = username;
        this.email = email;
        this.password = password;
    }

    private void validateUsername(String username) {
        if (username.isBlank()) throw new IllegalArgumentException("this name is wrong");
    }

    private void validateEmail(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailPattern);
        if (email.isBlank() || !pattern.matcher(email).matches())
            throw new IllegalArgumentException("this email is wrong");
    }

    private void validatePassword(String password) {
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(passwordPattern);
        if (password.isBlank() || password.length() < 8 || !pattern.matcher(password).matches()) throw new IllegalArgumentException("this password is wrong");
    }

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
}
