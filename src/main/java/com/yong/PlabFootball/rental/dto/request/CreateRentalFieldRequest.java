package com.yong.PlabFootball.rental.dto.request;

import com.yong.PlabFootball.global.converter.StadiumConverter;
import com.yong.PlabFootball.rental.entity.RentalField;
import com.yong.PlabFootball.stadium.dto.FieldDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateRentalFieldRequest {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int price;
    private boolean isPossible;
    private FieldDto fieldDto;

    @Builder
    public CreateRentalFieldRequest(LocalDateTime startTime, LocalDateTime endTime, int price, boolean isPossible, FieldDto fieldDto) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.isPossible = isPossible;
        this.fieldDto = fieldDto;
    }

    public RentalField toEntity() {
        RentalField rentalField = RentalField.builder()
                .startTime(this.startTime)
                .endTime(this.endTime)
                .price(this.price)
                .isPossible(this.isPossible)
                .build();
        rentalField.setField(StadiumConverter.toFieldEntity(this.fieldDto));

        return rentalField;
    }
}
