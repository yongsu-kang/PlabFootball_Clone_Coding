package com.yong.PlabFootball.stadium.service;

import com.yong.PlabFootball.global.converter.StadiumConverter;
import com.yong.PlabFootball.stadium.dto.FieldDto;
import com.yong.PlabFootball.stadium.entity.Stadium;
import com.yong.PlabFootball.stadium.entity.vo.GrassCondition;
import com.yong.PlabFootball.stadium.entity.vo.Region;
import com.yong.PlabFootball.stadium.repository.StadiumRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

@SpringBootTest
@ActiveProfiles("test")
class FieldServiceTest {

    @Autowired
    private StadiumRepository stadiumRepository;

    @Autowired
    private FieldService fieldService;

    Stadium stadium;

    @BeforeEach
    void setUp() {
        String name = "abc";
        String location = "vndjnjd";
        boolean parking = true;
        boolean toilet = true;
        boolean vest = true;
        boolean ball = true;
        Region region = Region.BUSAN;

        Stadium forSaveStadium = Stadium.builder()
                .name(name)
                .location(location)
                .parking(parking)
                .toilet(toilet)
                .vest(vest)
                .ball(ball)
                .region(region)
                .build();

        this.stadium = stadiumRepository.save(forSaveStadium);

        FieldDto fieldDto = FieldDto.builder()
                .name("asd")
                .width(12)
                .length(12)
                .outdoor(true)
                .grassCondition(GrassCondition.ARTIFICIAL_GRASS)
                .amountPerHour(20000)
                .stadiumDto(StadiumConverter.toStadiumDto(stadium))
                .build();

        FieldDto fieldDto2 = FieldDto.builder()
                .name("fdaffad")
                .width(20)
                .length(30)
                .outdoor(true)
                .grassCondition(GrassCondition.ARTIFICIAL_GRASS)
                .amountPerHour(30000)
                .stadiumDto(StadiumConverter.toStadiumDto(stadium))
                .build();

        fieldService.createField(fieldDto);
        fieldService.createField(fieldDto2);
    }

    @Test
    @Transactional
    void findAllByStadiumId() {
        List<FieldDto> foundFields = fieldService.searchAllField(StadiumConverter.toStadiumDto(stadium));

        assertThat(foundFields.size(), is(2));
    }
}