package com.yong.PlabFootball.rental.service;

import com.yong.PlabFootball.global.converter.ReservationConverter;
import com.yong.PlabFootball.rental.dto.RentalDto;
import com.yong.PlabFootball.rental.entity.Rental;
import com.yong.PlabFootball.rental.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReservationService {
    private final RentalRepository rentalRepository;

    public RentalDto createReservation(RentalDto rentalDto) {
        Rental rental = ReservationConverter.toReservationEntity(rentalDto);
        Rental savedRental = rentalRepository.save(rental);

        return ReservationConverter.toReservationDto(savedRental);
    }
}
