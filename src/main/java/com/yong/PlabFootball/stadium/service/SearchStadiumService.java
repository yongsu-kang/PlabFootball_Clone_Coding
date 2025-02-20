package com.yong.PlabFootball.stadium.service;

import com.yong.PlabFootball.global.converter.StadiumConverter;
import com.yong.PlabFootball.stadium.dto.StadiumDto;
import com.yong.PlabFootball.stadium.exception.StadiumNotFoundException;
import com.yong.PlabFootball.stadium.repository.StadiumQueryRepository;
import com.yong.PlabFootball.stadium.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchStadiumService {

    private final StadiumRepository stadiumRepository;
    private final StadiumQueryRepository queryRepository;

    public StadiumDto searchStadiumById(StadiumDto stadiumDto) {
        Long targetId = stadiumDto.getId();

        return StadiumConverter.toStadiumDto(stadiumRepository.findById(targetId)
                .orElseThrow(() -> new StadiumNotFoundException(targetId)));
    }

    public List<StadiumDto> searchAllStadium() {
        return queryRepository.searchAllStadiumWithField()
                .stream()
                .map(StadiumConverter::toStadiumDto)
                .toList();
    }
}
