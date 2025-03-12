package com.yong.PlabFootball.member.service;

import com.yong.PlabFootball.member.dto.MemberProfileDto;
import com.yong.PlabFootball.member.entity.vo.Ability;
import com.yong.PlabFootball.member.entity.vo.FavoriteStyle;
import com.yong.PlabFootball.member.entity.vo.Gender;
import com.yong.PlabFootball.member.repository.MemberProfileRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class MemberProfileServiceTest {

    @Autowired
    private MemberProfileService service;

    @Autowired
    private MemberProfileRepository repository;

    private Long id;
    private String name = "Kang";
    private String playerName = "pajf";
    private String description = "hello my name is Kang";
    private Gender gender = Gender.MALE;
    private FavoriteStyle favoriteStyle = FavoriteStyle.ATTACK;
    private Ability ability = Ability.DRIBBLE;

    private MemberProfileDto dto = MemberProfileDto.builder()
            .name(name)
            .playerName(playerName)
            .description(description)
            .gender(gender)
            .favoriteStyle(favoriteStyle)
            .ability(ability)
            .build();

    @BeforeEach
    void setup() {
        MemberProfileDto createDto = service.createMemberProfile(dto);

        assertAll(
                () -> assertThat(createDto.getName(),is(name)),
                () -> assertThat(createDto.getPlayerName(),is(playerName)),
                () -> assertThat(createDto.getDescription(),is(description)),
                () -> assertThat(createDto.getGender(),is(gender)),
                () -> assertThat(createDto.getFavoriteStyle(),is(favoriteStyle)),
                () -> assertThat(createDto.getAbility(),is(ability))
        );

        this.dto = createDto;
        this.id = createDto.getId();
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void searchProfileById() {
        MemberProfileDto foundProfile = service.searchProfileById(dto);

        assertAll(
                () -> assertThat(foundProfile.getName(),is(name)),
                () -> assertThat(foundProfile.getPlayerName(),is(playerName)),
                () -> assertThat(foundProfile.getDescription(),is(description)),
                () -> assertThat(foundProfile.getGender(),is(gender)),
                () -> assertThat(foundProfile.getFavoriteStyle(),is(favoriteStyle)),
                () -> assertThat(foundProfile.getAbility(),is(ability))
        );
    }

    @Test
    void modifyMemberProfile() {
        String changeName = "Lee";
        String changePlayerName = "ChangName";
        String changeDescription = "change my description";
        Gender changeGender = Gender.FEMALE;
        FavoriteStyle changeFavoriteStyle = FavoriteStyle.DEFENSE;
        Ability changeAbility = Ability.GOALKEEPER;

        MemberProfileDto changeDto = MemberProfileDto.builder()
                .id(id)
                .name(changeName)
                .playerName(changePlayerName)
                .description(changeDescription)
                .gender(changeGender)
                .favoriteStyle(changeFavoriteStyle)
                .ability(changeAbility)
                .build();

        MemberProfileDto modifiedDto = service.modifyMemberProfile(changeDto);

        assertAll(
                () -> assertThat(modifiedDto.getName(),not(name)),
                () -> assertThat(modifiedDto.getPlayerName(),not(playerName)),
                () -> assertThat(modifiedDto.getDescription(),not(description)),
                () -> assertThat(modifiedDto.getGender(),not(gender)),
                () -> assertThat(modifiedDto.getFavoriteStyle(),not(favoriteStyle)),
                () -> assertThat(modifiedDto.getAbility(),not(ability)),
                () -> assertThat(modifiedDto.getName(),is(changeName)),
                () -> assertThat(modifiedDto.getPlayerName(),is(changePlayerName)),
                () -> assertThat(modifiedDto.getDescription(),is(changeDescription)),
                () -> assertThat(modifiedDto.getGender(),is(changeGender)),
                () -> assertThat(modifiedDto.getFavoriteStyle(),is(changeFavoriteStyle)),
                () -> assertThat(modifiedDto.getAbility(),is(changeAbility))
        );
    }
}