package com.yong.PlabFootball.stadium.dto;

import com.yong.PlabFootball.rental.dto.RentalFieldDto;
import com.yong.PlabFootball.stadium.entity.vo.GrassCondition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class FieldDto {
    private Long id;
    private String name;
    private int width;
    private int length;
    private boolean outdoor;
    private GrassCondition grassCondition;
    private int amountPerHour;
    private StadiumDto stadiumDto;
    private List<RentalFieldDto> rentalFields;
}
