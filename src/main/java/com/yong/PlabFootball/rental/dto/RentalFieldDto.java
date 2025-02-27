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
public class RentalFieldDto {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isPossible;
    private int price;
    private FieldDto fieldDto;
}
