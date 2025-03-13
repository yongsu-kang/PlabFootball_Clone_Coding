package com.yong.PlabFootball.member.entity;

import com.yong.PlabFootball.global.vo.BaseEntity;
import com.yong.PlabFootball.member.dto.MemberDto;
import com.yong.PlabFootball.member.entity.vo.Email;
import com.yong.PlabFootball.member.entity.vo.Password;
import com.yong.PlabFootball.rental.entity.Rental;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member extends BaseEntity {

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
    private MemberProfile memberProfile;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Rental> rentals = new ArrayList<>();

    @Builder
    public Member(Long id, String name, Email email, Password password) {
        validateName(name);
        this.id = id;
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

    public void addReservation(Rental rental) {
        rental.setMember(this);
    }

    public void saveMemberProfile(MemberProfile memberProfile) {
        this.memberProfile = memberProfile;
    }

    public MemberDto toDto() {
        return MemberDto.builder()
                .id(this.id)
                .name(this.name)
                .email(this.email.getEmail())
                .password(this.password.getPassword())
                .build();
    }
}
