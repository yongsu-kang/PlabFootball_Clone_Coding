package com.yong.PlabFootball.stadium.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yong.PlabFootball.rental.entity.QRentalField;
import com.yong.PlabFootball.stadium.entity.Stadium;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.yong.PlabFootball.stadium.entity.QField.*;
import static com.yong.PlabFootball.stadium.entity.QStadium.*;

@Repository
@RequiredArgsConstructor
public class StadiumQueryRepositoryImpl implements StadiumQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Stadium> searchAllStadiumWithField() {
        return queryFactory.selectFrom(stadium)
                .leftJoin(stadium.fields,field)
                .fetchJoin()
                .fetch();
    }

    @Override
    public List<Stadium> searchAllStadiumWithRentalFields() {
        return queryFactory.selectFrom(stadium)
                .leftJoin(stadium.fields,field)
                .leftJoin(field.rentalFields, QRentalField.rentalField)
                .fetch();
    }
}
