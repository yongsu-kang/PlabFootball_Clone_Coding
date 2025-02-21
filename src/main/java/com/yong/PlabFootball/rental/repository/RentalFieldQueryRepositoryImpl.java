package com.yong.PlabFootball.rental.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yong.PlabFootball.stadium.entity.Stadium;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.yong.PlabFootball.rental.entity.QReservationField.*;
import static com.yong.PlabFootball.stadium.entity.QField.*;
import static com.yong.PlabFootball.stadium.entity.QStadium.*;

@Repository
@RequiredArgsConstructor
public class RentalFieldQueryRepositoryImpl implements RentalFieldQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Stadium> searchAllRentalFields() {
        return queryFactory.selectFrom(stadium)
                .leftJoin(stadium, field.stadium)
                .fetchJoin()
                .leftJoin(field.reservationFields, reservationField)
                .fetchJoin()
                .fetch();
    }
}
