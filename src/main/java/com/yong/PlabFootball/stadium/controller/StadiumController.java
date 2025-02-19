package com.yong.PlabFootball.stadium.controller;

import com.yong.PlabFootball.stadium.dto.FieldDto;
import com.yong.PlabFootball.stadium.dto.StadiumDto;
import com.yong.PlabFootball.stadium.service.FieldService;
import com.yong.PlabFootball.stadium.service.StadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StadiumController {
    private final StadiumService stadiumService;
    private final FieldService fieldService;

    @PostMapping("/api/stadium")
    public StadiumDto createStadium(StadiumDto stadiumDto) {
        return stadiumService.createStadium(stadiumDto);
    }

    @PostMapping("/api/stadium/field/{stadium_id}")
    public FieldDto createField(@PathVariable(value = "stadium_id") Long id, FieldDto fieldDto) {
        StadiumDto stadiumDto = StadiumDto.builder().id(id).build();
        return fieldService.createField(fieldDto);
    }

    @GetMapping("/api/stadium")
    public List<StadiumDto> findAllStadium() {
        return stadiumService.searchAllStadium();
    }

    @GetMapping("/api/stadium/{stadium_id}")
    public StadiumDto findById(@PathVariable("stadium_id") Long id) {
        StadiumDto stadiumDto = StadiumDto.builder().id(id).build();
        return stadiumService.searchStadiumById(stadiumDto);
    }

    @PutMapping("/api/stadium")
    public StadiumDto changeStadium(StadiumDto stadiumDto) {
        return stadiumService.modifyStadium(stadiumDto);
    }

    @DeleteMapping("/api/stadium/{stadium_id}")
    public void deleteById(@PathVariable(value = "stadium_id") Long id) {
        StadiumDto stadiumDto = StadiumDto.builder().id(id).build();
        stadiumService.deleteStadiumById(stadiumDto);
    }

    @DeleteMapping("/api/field/{field_id}")
    public void deleteFieldById(@PathVariable("field_id") Long id) {
        FieldDto fieldDto = FieldDto.builder().id(id).build();
        fieldService.deleteById(fieldDto);
    }
}
