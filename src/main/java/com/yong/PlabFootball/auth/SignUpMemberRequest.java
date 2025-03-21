package com.yong.PlabFootball.auth;

import com.yong.PlabFootball.member.dto.MemberDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpMemberRequest {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public MemberDto toMemberDto() {
        return MemberDto.builder()
                .name(this.name)
                .email(this.email)
                .password(this.password)
                .build();
    }
}
