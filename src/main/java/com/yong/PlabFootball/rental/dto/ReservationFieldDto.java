package com.yong.PlabFootball.rental.dto;

import com.yong.PlabFootball.stadium.dto.FieldDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ReservationFieldDto {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isPossible;
    private FieldDto fieldDto;
    private RentalDto rentalDto;
}
