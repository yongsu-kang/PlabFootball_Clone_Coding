package com.yong.PlabFootball.rental.repository;

import com.yong.PlabFootball.stadium.entity.Stadium;

import java.util.List;

public interface RentalFieldQueryRepository {

    List<Stadium> searchAllRentalFields();
}
