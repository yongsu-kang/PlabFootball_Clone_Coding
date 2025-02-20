package com.yong.PlabFootball.stadium.controller;

import com.yong.PlabFootball.stadium.dto.StadiumDto;
import com.yong.PlabFootball.stadium.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StadiumController {

    private final CreateStadiumService createStadiumService;
    private final SearchStadiumService searchStadiumService;
    private final ModifyStadiumService modifyStadiumService;

    @PostMapping("/api/stadium")
    public StadiumDto createStadium(StadiumDto stadiumDto) {
        return createStadiumService.createStadium(stadiumDto);
    }

    @GetMapping("/api/stadium")
    public List<StadiumDto> searchAllStadium() {
        return searchStadiumService.searchAllStadium();
    }

    @GetMapping("/api/stadium/{stadium_id}")
    public StadiumDto searchStadiumFindById(@PathVariable("stadium_id") Long id) {
        StadiumDto stadiumDto = StadiumDto.builder().id(id).build();
        return searchStadiumService.searchStadiumById(stadiumDto);
    }

    @PutMapping("/api/stadium")
    public StadiumDto modifyStadium(StadiumDto stadiumDto) {
        return modifyStadiumService.modifyStadium(stadiumDto);
    }

    @DeleteMapping("/api/stadium/{stadium_id}")
    public void deleteById(@PathVariable(value = "stadium_id") Long id) {
        StadiumDto stadiumDto = StadiumDto.builder().id(id).build();
        modifyStadiumService.deleteStadiumById(stadiumDto);
    }
}
