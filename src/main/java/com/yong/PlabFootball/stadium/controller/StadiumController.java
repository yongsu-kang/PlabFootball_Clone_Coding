package com.yong.PlabFootball.stadium.controller;

import com.yong.PlabFootball.stadium.dto.CreateStadiumRequest;
import com.yong.PlabFootball.stadium.dto.StadiumDto;
import com.yong.PlabFootball.stadium.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/stadiums")
public class StadiumController {

    private final CreateStadiumService createStadiumService;
    private final SearchStadiumService searchStadiumService;
    private final ModifyStadiumService modifyStadiumService;

    @PostMapping
    public StadiumDto createStadium(@RequestBody CreateStadiumRequest createStadiumRequest) {
        StadiumDto stadiumDto = createStadiumRequest.toStadiumDto();
        System.out.println(createStadiumRequest);

        return createStadiumService.createStadium(stadiumDto);
    }

    @GetMapping
    public List<StadiumDto> searchAllStadium() {
        return searchStadiumService.searchAllStadium();
    }

    @GetMapping("/{stadium_id}")
    public StadiumDto searchStadiumFindById(@PathVariable("stadium_id") Long id) {
        StadiumDto stadiumDto = StadiumDto.builder().id(id).build();
        return searchStadiumService.searchStadiumById(stadiumDto);
    }

    @PutMapping
    public StadiumDto modifyStadium(@RequestBody StadiumDto stadiumDto) {
        return modifyStadiumService.modifyStadium(stadiumDto);
    }

    @DeleteMapping("{stadium_id}")
    public void deleteById(@PathVariable(value = "stadium_id") Long id) {
        StadiumDto stadiumDto = StadiumDto.builder().id(id).build();
        modifyStadiumService.deleteStadiumById(stadiumDto);
    }
}
