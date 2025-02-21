package com.yong.PlabFootball.rental.repository;

import com.yong.PlabFootball.rental.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
