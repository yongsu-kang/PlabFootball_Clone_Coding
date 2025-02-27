package com.yong.PlabFootball.rental.service;

import com.yong.PlabFootball.global.converter.StadiumConverter;
import com.yong.PlabFootball.rental.dto.request.CreateRentalFieldRequest;
import com.yong.PlabFootball.rental.dto.RentalFieldDto;
import com.yong.PlabFootball.rental.entity.RentalField;
import com.yong.PlabFootball.rental.repository.RentalFieldRepository;
import com.yong.PlabFootball.stadium.entity.Field;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateRentalFieldService {

    private final RentalFieldRepository rentalFieldRepository;

    public RentalFieldDto CreateRentalField(CreateRentalFieldRequest request) {
        RentalField rentalField = RentalField.builder()
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .price(request.getPrice())
                .isPossible(request.isPossible())
                .build();

        Field field = StadiumConverter.toFieldEntity(request.getFieldDto());
        rentalField.setField(field);

        RentalField savedRentalField = rentalFieldRepository.save(rentalField);

        return savedRentalField.toDto();
    }
}
