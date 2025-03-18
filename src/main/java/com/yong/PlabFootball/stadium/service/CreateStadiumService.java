package com.yong.PlabFootball.stadium.service;

import com.yong.PlabFootball.global.converter.StadiumConverter;
import com.yong.PlabFootball.stadium.dto.StadiumDto;
import com.yong.PlabFootball.stadium.entity.Stadium;
import com.yong.PlabFootball.stadium.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateStadiumService {

    private final StadiumRepository stadiumRepository;

    public StadiumDto createStadium(StadiumDto stadiumDto) {
        Stadium stadium = StadiumConverter.toStadiumEntity(stadiumDto);
        return StadiumConverter.toStadiumDto(stadiumRepository.save(stadium));
    }
}
