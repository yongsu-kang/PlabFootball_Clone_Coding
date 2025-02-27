package com.yong.PlabFootball.global.converter;

import com.yong.PlabFootball.rental.dto.RentalFieldDto;
import com.yong.PlabFootball.rental.entity.RentalField;
import com.yong.PlabFootball.stadium.dto.FieldDto;
import com.yong.PlabFootball.stadium.dto.StadiumDto;
import com.yong.PlabFootball.stadium.entity.Field;
import com.yong.PlabFootball.stadium.entity.Stadium;

import java.util.List;

public class StadiumConverter {
    public static Stadium toStadiumEntity(StadiumDto stadiumDto) {
        return Stadium.builder()
                .id(stadiumDto.getId())
                .name(stadiumDto.getName())
                .location(stadiumDto.getLocation())
                .parking(stadiumDto.isParking())
                .toilet(stadiumDto.isToilet())
                .vest(stadiumDto.isVest())
                .ball(stadiumDto.isBall())
                .region(stadiumDto.getRegion())
                .build();
    }


    public static StadiumDto toStadiumDto(Stadium stadium) {
        return StadiumDto.builder()
                .id(stadium.getId())
                .name(stadium.getName())
                .location(stadium.getLocation())
                .parking(stadium.isParking())
                .toilet(stadium.isToilet())
                .vest(stadium.isVest())
                .ball(stadium.isBall())
                .region(stadium.getRegion())
                .fields(getFieldDtoList(stadium))
                .build();
    }

    public static Field toFieldEntity(FieldDto fieldDto) {
        Field field = Field.builder()
                .id(fieldDto.getId())
                .name(fieldDto.getName())
                .width(fieldDto.getWidth())
                .length(fieldDto.getLength())
                .outdoor(fieldDto.isOutdoor())
                .grassCondition(fieldDto.getGrassCondition())
                .amountPerHour(fieldDto.getAmountPerHour())
                .build();

        return field;
    }

    public static FieldDto toFieldDto(Field field) {
        return FieldDto.builder()
                .id(field.getId())
                .name(field.getName())
                .width(field.getWidth())
                .length(field.getLength())
                .outdoor(field.isOutdoor())
                .grassCondition(field.getGrassCondition())
                .amountPerHour(field.getAmountPerHour())
                .rentalFields(getRentalFieldDtoList(field))
                .build();
    }

    private static List<RentalFieldDto> getRentalFieldDtoList(Field field) {
        return field.getRentalFields().stream().map(RentalField::toDto).toList();
    }

    private static List<FieldDto> getFieldDtoList(Stadium stadium) {
        return stadium.getFields().stream().map(StadiumConverter::toFieldDto).toList();
    }
}
