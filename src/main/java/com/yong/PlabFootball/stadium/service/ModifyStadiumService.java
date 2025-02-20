package com.yong.PlabFootball.stadium.service;

import com.yong.PlabFootball.global.converter.StadiumConverter;
import com.yong.PlabFootball.stadium.dto.StadiumDto;
import com.yong.PlabFootball.stadium.entity.Stadium;
import com.yong.PlabFootball.stadium.exception.StadiumNotFoundException;
import com.yong.PlabFootball.stadium.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ModifyStadiumService {

    private final StadiumRepository stadiumRepository;

    public StadiumDto modifyStadium(StadiumDto stadiumDto) {
        Long targetId = stadiumDto.getId();

        Stadium stadium = stadiumRepository.findById(stadiumDto.getId())
                .orElseThrow(() -> new StadiumNotFoundException(targetId));

        stadium.changeName(stadiumDto.getName());
        stadium.changeLocation(stadiumDto.getLocation());
        stadium.changeParking(stadiumDto.isParking());
        stadium.changeToilet(stadiumDto.isToilet());
        stadium.changeVest(stadiumDto.isVest());
        stadium.changeBall(stadiumDto.isBall());
        stadium.changeRegion(stadiumDto.getRegion());

        return StadiumConverter.toStadiumDto(stadium);
    }

    public void deleteStadiumById(StadiumDto stadiumDto) {
        stadiumRepository.deleteById(stadiumDto.getId());
    }
}
