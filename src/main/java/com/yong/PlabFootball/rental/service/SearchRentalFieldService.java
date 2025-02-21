package com.yong.PlabFootball.rental.service;

import com.yong.PlabFootball.rental.repository.RentalFieldQueryRepository;
import com.yong.PlabFootball.rental.repository.RentalFieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchRentalFieldService {

    private final RentalFieldRepository rentalFieldRepository;
    private final RentalFieldQueryRepository queryRepository;


}
