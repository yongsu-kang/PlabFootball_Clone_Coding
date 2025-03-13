package com.yong.PlabFootball.member.dto;

import com.yong.PlabFootball.member.entity.Member;
import com.yong.PlabFootball.member.entity.vo.Email;
import com.yong.PlabFootball.member.entity.vo.Password;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MemberDto {
    private Long id;
    private String name;
    private String email;
    private String password;

    public Member toEntity() {
        return Member.builder()
                .id(this.id)
                .name(this.name)
                .email(new Email(this.email))
                .password(new Password(this.password))
                .build();
    }
}
