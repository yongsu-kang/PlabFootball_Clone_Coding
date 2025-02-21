package com.yong.PlabFootball.rental.entity;

import com.yong.PlabFootball.global.vo.BaseEntity;
import com.yong.PlabFootball.rental.exception.EndTimeInvalidException;
import com.yong.PlabFootball.rental.exception.PriceInvalidException;
import com.yong.PlabFootball.rental.exception.StartTimeInvalidException;
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
public class RentalField extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private boolean isPossible;

    @ManyToOne
    private Field field;

    @OneToOne
    private Rental rental;

    @Builder
    public RentalField(LocalDateTime startTime, LocalDateTime endTime, int price, boolean isPossible) {
        validateTime(startTime, endTime);
        validatePrice(price);
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.isPossible = isPossible;
    }

    private void validateTime(LocalDateTime startTime, LocalDateTime endTime) {
        validateStartTime(startTime);
        validateEndTime(startTime, endTime);
    }

    private void validateStartTime(LocalDateTime startTime) {
        if (!startTime.isAfter(LocalDateTime.now())) {
            throw new StartTimeInvalidException(startTime);
        }
    }

    private void validateEndTime(LocalDateTime startTime, LocalDateTime endTime) {
        if (!endTime.isAfter(startTime)) {
            throw new EndTimeInvalidException(endTime);
        }
    }

    private void validatePrice(int price) {
        if (price <= 0) {
            throw new PriceInvalidException(price);
        }
    }

    public void setRental(Rental rental) {
        this.rental = rental;
        this.isPossible = false;
    }
}
