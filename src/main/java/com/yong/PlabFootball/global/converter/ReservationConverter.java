package com.yong.PlabFootball.global.converter;

import com.yong.PlabFootball.reservation.dto.ReservationDto;
import com.yong.PlabFootball.reservation.dto.ReservationFieldDto;
import com.yong.PlabFootball.reservation.entity.Reservation;
import com.yong.PlabFootball.reservation.entity.ReservationField;

public class ReservationConverter {
    public static Reservation toReservationEntity(ReservationDto reservationDto) {
        Reservation reservation = Reservation.builder()
                .id(reservationDto.getId())
                .reservationCondition(reservationDto.getReservationCondition())
                .build();

        reservation.setMember(MemberConverter.toMemberEntity(reservationDto.getMemberDto()));
        reservation.setReservationField(ReservationConverter.toReservationFieldEntity(reservationDto.getReservationFieldDto()));
        return reservation;
    }

    public static ReservationDto toReservationDto(Reservation reservation) {
        return ReservationDto.builder()
                .id(reservation.getId())
                .reservationCondition(reservation.getReservationCondition())
                .build();
    }

    public static ReservationField toReservationFieldEntity(ReservationFieldDto reservationFieldDto) {
        ReservationField reservationField = ReservationField.builder()
                .startTime(reservationFieldDto.getStartTime())
                .endTime(reservationFieldDto.getEndTime())
                .isPossible(reservationFieldDto.isPossible())
                .build();

//        reservationField.set
        return null;
    }


}
