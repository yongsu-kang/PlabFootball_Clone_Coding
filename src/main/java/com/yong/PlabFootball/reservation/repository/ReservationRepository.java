package com.yong.PlabFootball.reservation.repository;

import com.yong.PlabFootball.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
