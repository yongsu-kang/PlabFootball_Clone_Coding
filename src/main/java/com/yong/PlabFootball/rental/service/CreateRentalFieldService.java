package com.yong.PlabFootball.rental.service;

import com.yong.PlabFootball.rental.dto.ReservationFieldDto;
import com.yong.PlabFootball.rental.repository.RentalFieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateRentalFieldService {

    private final RentalFieldRepository rentalFieldRepository;

    public ReservationFieldDto CreateRentalField(ReservationFieldDto reservationFieldDto) {
        return null;
    }
}
