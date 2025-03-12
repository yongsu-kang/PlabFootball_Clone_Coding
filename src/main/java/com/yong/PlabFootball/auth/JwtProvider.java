package com.yong.PlabFootball.auth;

public interface JwtProvider {
    String createToken(String email);

    String getMemberEmail(String token);

    boolean validateToken(String token);
}
