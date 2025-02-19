package com.yong.PlabFootball.stadium.service;

import com.yong.PlabFootball.global.converter.StadiumConverter;
import com.yong.PlabFootball.stadium.dto.StadiumDto;
import com.yong.PlabFootball.stadium.entity.Stadium;
import com.yong.PlabFootball.stadium.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StadiumService {
    private final StadiumRepository stadiumRepository;

    @Transactional
    public StadiumDto createStadium(StadiumDto stadiumDto) {
        Stadium stadium = StadiumConverter.toStadiumEntity(stadiumDto);
        return StadiumConverter.toStadiumDto(stadiumRepository.save(stadium));
    }

    public StadiumDto searchStadiumById(StadiumDto stadiumDto) {
        return StadiumConverter.toStadiumDto(stadiumRepository.findById(stadiumDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("wrong stadium id")));
    }

    public List<StadiumDto> searchAllStadium() {
        return stadiumRepository.findAll()
                .stream()
                .map(StadiumConverter::toStadiumDto)
                .toList();
    }

    @Transactional
    public StadiumDto modifyStadium(StadiumDto stadiumDto) {
        Stadium stadium = stadiumRepository.findById(stadiumDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("wrong stadium id"));

        stadium.changeName(stadiumDto.getName());
        stadium.changeLocation(stadiumDto.getLocation());
        stadium.changeParking(stadiumDto.isParking());
        stadium.changeToilet(stadiumDto.isToilet());
        stadium.changeVest(stadiumDto.isVest());
        stadium.changeBall(stadiumDto.isBall());
        stadium.changeRegion(stadiumDto.getRegion());

        return StadiumConverter.toStadiumDto(stadium);
    }

    @Transactional
    public void deleteStadiumById(StadiumDto stadiumDto) {
        stadiumRepository.deleteById(stadiumDto.getId());
    }
}
