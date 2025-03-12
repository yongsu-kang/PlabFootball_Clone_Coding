package com.yong.PlabFootball.stadium.service;

import com.yong.PlabFootball.global.converter.StadiumConverter;
import com.yong.PlabFootball.stadium.dto.StadiumDto;
import com.yong.PlabFootball.stadium.entity.Stadium;
import com.yong.PlabFootball.stadium.entity.vo.Region;
import com.yong.PlabFootball.stadium.repository.StadiumRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class StadiumServiceTest {

    @Autowired
    StadiumService stadiumService;

    @Autowired
    StadiumRepository stadiumRepository;

    private Long id;
    private String name = "abc";
    private String location = "vndjnjd";
    private boolean parking = true;
    private boolean toilet = true;
    private boolean vest = true;
    private boolean ball = true;
    private Region region = Region.BUSAN;

    Stadium stadium = Stadium.builder()
            .name(name)
            .location(location)
            .parking(parking)
            .toilet(toilet)
            .vest(vest)
            .ball(ball)
            .region(region)
            .build();

    @BeforeEach
    void setup() {
        StadiumDto dto = StadiumConverter.toStadiumDto(stadium);

        StadiumDto createdStadium = stadiumService.createStadium(dto);

        this.stadium = StadiumConverter.toStadiumEntity(createdStadium);
        this.id = stadium.getId();
    }

    @AfterEach
    void tearDown() {
        stadiumRepository.deleteAll();
    }

    @Test
    void modifyStadium() {
        StadiumDto changeStadiumDto = StadiumDto.builder()
                .id(id)
                .name("change name")
                .location("change Location")
                .parking(false)
                .toilet(false)
                .vest(false)
                .ball(false)
                .region(Region.CHUNGBUK)
                .build();

        StadiumDto changedStadium = stadiumService.modifyStadium(changeStadiumDto);
    }
}