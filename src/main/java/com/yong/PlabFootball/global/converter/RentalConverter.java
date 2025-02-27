package com.yong.PlabFootball.global.converter;

import com.yong.PlabFootball.rental.dto.RentalDto;
import com.yong.PlabFootball.rental.dto.RentalFieldDto;
import com.yong.PlabFootball.rental.entity.Rental;
import com.yong.PlabFootball.rental.entity.RentalField;

public class RentalConverter {
    public static Rental toReservationEntity(RentalDto rentalDto) {
        Rental rental = Rental.builder()
                .id(rentalDto.getId())
                .reservationCondition(rentalDto.getReservationCondition())
                .build();

        rental.setMember(MemberConverter.toMemberEntity(rentalDto.getMemberDto()));
        rental.setRentalField(RentalConverter.toReservationFieldEntity(rentalDto.getRentalFieldDto()));
        return rental;
    }

    public static RentalDto toReservationDto(Rental rental) {
        return RentalDto.builder()
                .id(rental.getId())
                .reservationCondition(rental.getReservationCondition())
                .build();
    }

    public static RentalField toReservationFieldEntity(RentalFieldDto rentalFieldDto) {
        RentalField rentalField = RentalField.builder()
                .startTime(rentalFieldDto.getStartTime())
                .endTime(rentalFieldDto.getEndTime())
                .isPossible(rentalFieldDto.isPossible())
                .build();

//        reservationField.set
        return null;
    }


}
