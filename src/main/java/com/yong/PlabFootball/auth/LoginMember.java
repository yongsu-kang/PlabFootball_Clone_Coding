package com.yong.PlabFootball.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginMember {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
