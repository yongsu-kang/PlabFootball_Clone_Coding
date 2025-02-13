package com.yong.PlabFootball.member.entity;

import com.yong.PlabFootball.common.vo.BaseEntity;
import com.yong.PlabFootball.member.entity.vo.Email;
import com.yong.PlabFootball.member.entity.vo.Password;
import com.yong.PlabFootball.reservation.Reservation;
import com.yong.PlabFootball.stadium.entity.Stadium;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    private List<Reservation> reservations = new ArrayList<>();

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

    public void addReservation(Reservation reservation) {
        reservation.setMember(this);
    }

    public void setMemberProfile(MemberProfile memberProfile) {
        this.memberProfile = memberProfile;
    }
}
