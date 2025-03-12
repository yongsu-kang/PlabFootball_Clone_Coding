package com.yong.PlabFootball.rental;

import com.yong.PlabFootball.rental.entity.RentalField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

class RentalFieldTest {

    @Test
    void createReservationField() {
        LocalDateTime startTime = LocalDateTime.now().plusDays(1);
        LocalDateTime endTime = startTime.plusHours(2);

        RentalField field = RentalField.builder()
                .startTime(startTime)
                .endTime(endTime)
                .isPossible(true)
                .build();

        assertAll(
                () -> assertThat(field.getStartTime(), is(startTime)),
                () -> assertThat(field.getEndTime(), is(endTime)),
                () -> assertThat(field.isPossible(), is(true))
        );
    }

    @Test
    @DisplayName("경기 시작 시간은 현시간보다 전이면 안된다.")
    void startTimeIsOverNow() {
        LocalDateTime startTimeMinusOneDay = LocalDateTime.now().minusDays(1);
        LocalDateTime startTimeOverNow = LocalDateTime.now().plusDays(1);
        LocalDateTime now = LocalDateTime.now();

        assertAll(
                () -> assertDoesNotThrow(
                        () -> RentalField.builder()
                                .startTime(startTimeOverNow)
                                .endTime(startTimeOverNow.plusHours(2))
                                .isPossible(true)
                                .build()),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> RentalField.builder()
                                .startTime(now)
                                .endTime(now.plusHours(2))
                                .isPossible(true)
                                .build()),
                () -> assertThrows(IllegalArgumentException.class, () -> RentalField.builder()
                        .startTime(startTimeMinusOneDay)
                        .endTime(startTimeMinusOneDay.plusHours(2))
                        .isPossible(true)
                        .build())
        );
    }

    @Test
    @DisplayName("endTime은 startTime보다 후여야 한다.")
    void endTimeIsOverStartTime() {
        LocalDateTime startTime = LocalDateTime.now().plusDays(1);
        LocalDateTime endTimeBeforeStartTime = startTime.minusHours(1);
        LocalDateTime endTimeOverStartTime = startTime.plusHours(2);

        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> RentalField.builder()
                                .startTime(startTime)
                                .endTime(endTimeBeforeStartTime)
                                .isPossible(true)
                                .build()
                ),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> RentalField.builder()
                                .startTime(startTime)
                                .endTime(startTime)
                                .isPossible(true)
                                .build()
                ),
                () -> assertDoesNotThrow(
                        () -> RentalField.builder()
                                .startTime(startTime)
                                .endTime(endTimeOverStartTime)
                                .isPossible(true)
                                .build()
                )
        );
    }
}