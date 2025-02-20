package com.yong.PlabFootball.stadium.repository;

import com.yong.PlabFootball.stadium.entity.Stadium;

import java.util.List;

public interface StadiumQueryRepository {

    List<Stadium> searchAllStadiumWithField();
}
