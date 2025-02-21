package com.yong.PlabFootball.rental.entity;

import com.yong.PlabFootball.global.vo.BaseEntity;
import com.yong.PlabFootball.member.entity.Member;
import com.yong.PlabFootball.rental.entity.vo.ReservationCondition;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Rental extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ReservationCondition reservationCondition;

    @ManyToOne
    private Member member;

    @OneToOne
    private RentalField rentalField;

    @Builder
    public Rental(Long id, ReservationCondition reservationCondition) {
        this.id = id;
        this.reservationCondition = reservationCondition;
    }

    public void setMember(Member member) {
        if (Objects.nonNull(this.member)) {
            member.getRentals().remove(this);
        }
        this.member = member;
        member.getRentals().add(this);
    }

    public void setRentalField(RentalField rentalField) {
        this.reservationCondition = ReservationCondition.PAUSE;
        rentalField.setRental(this);
    }

    public void chaneReservationCondition(ReservationCondition condition) {
        this.reservationCondition = condition;
    }
}
