package com.yong.PlabFootball.reservation;

import com.yong.PlabFootball.common.vo.BaseEntity;
import com.yong.PlabFootball.member.entity.Member;
import com.yong.PlabFootball.reservation.vo.ReservationCondition;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ReservationCondition reservationCondition;

    @ManyToOne
    private Member member;

    @OneToOne
    private ReservationField reservationField;

    public void setMember(Member member) {
        if (Objects.nonNull(this.member)) {
            member.getReservations().remove(this);
        }
        this.member = member;
        member.getReservations().add(this);
    }

    public void setReservationField(ReservationField reservationField) {
        this.reservationCondition = ReservationCondition.PAUSE;
        reservationField.setReservation(this);
    }

    public void chaneReservationCondition(ReservationCondition condition) {
        this.reservationCondition = condition;
    }
}
