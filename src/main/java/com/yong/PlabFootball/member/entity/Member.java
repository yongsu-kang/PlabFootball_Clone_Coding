package com.yong.PlabFootball.member.entity;

import com.yong.PlabFootball.member.entity.vo.Email;
import com.yong.PlabFootball.member.entity.vo.Password;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    private Email email;

    @Embedded
    private Password password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_profile_id")
    private MemberProfile memberProfile;

    @Builder
    public Member(String name, Email email, Password password) {
        validateName(name);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    private void validateName(String name) {
        if (name.isBlank()) throw new IllegalArgumentException("this name is wrong");
    }

    public void changePassword(String newPassword) {
        this.password = password.changePassword(newPassword);
    }

    public String getEmail() {
        return email.getEmail();
    }

    public String getPassword() {
        return password.getPassword();
    }
}
