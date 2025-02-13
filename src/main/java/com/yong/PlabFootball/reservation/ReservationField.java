package com.yong.PlabFootball.reservation;

import com.yong.PlabFootball.common.vo.BaseEntity;
import com.yong.PlabFootball.stadium.entity.Field;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationField extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private boolean isPossible;

    @ManyToOne
    private Field field;

    @OneToOne
    private Reservation reservation;

    @Builder
    public ReservationField(LocalDateTime startTime, LocalDateTime endTime, boolean isPossible) {
        validateTime(startTime, endTime);
        this.startTime = startTime;
        this.endTime = endTime;
        this.isPossible = isPossible;
    }

    private void validateTime(LocalDateTime startTime, LocalDateTime endTime) {
        validateStartTime(startTime);
        validateEndTime(startTime, endTime);
    }

    private void validateStartTime(LocalDateTime startTime) {
        if (!startTime.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("예약 시작 시간이 옳바르지 않습니다.");
        }
    }

    private void validateEndTime(LocalDateTime startTime, LocalDateTime endTime) {
        if (!endTime.isAfter(startTime)) {
            throw new IllegalArgumentException("예약 끝 시간이 옳바르지 않습니다.");
        }
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
        this.isPossible = false;
    }
}
