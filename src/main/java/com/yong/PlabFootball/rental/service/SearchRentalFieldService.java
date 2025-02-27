package com.yong.PlabFootball.rental.service;

import com.yong.PlabFootball.global.converter.StadiumConverter;
import com.yong.PlabFootball.rental.repository.RentalFieldQueryRepository;
import com.yong.PlabFootball.rental.repository.RentalFieldRepository;
import com.yong.PlabFootball.stadium.dto.StadiumDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchRentalFieldService {

    private final RentalFieldRepository rentalFieldRepository;
    private final RentalFieldQueryRepository queryRepository;

    public List<StadiumDto> searchAllRentalFieldsInStadium() {
        return queryRepository.searchAllRentalFields()
                .stream()
                .map(StadiumConverter::toStadiumDto)
                .toList();
    }
}
