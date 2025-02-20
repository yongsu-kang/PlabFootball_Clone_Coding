package com.yong.PlabFootball.stadium.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yong.PlabFootball.stadium.entity.QField;
import com.yong.PlabFootball.stadium.entity.QStadium;
import com.yong.PlabFootball.stadium.entity.Stadium;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.yong.PlabFootball.stadium.entity.QField.*;
import static com.yong.PlabFootball.stadium.entity.QStadium.*;

@Repository
@RequiredArgsConstructor
public class StadiumQueryRepositoryImpl implements StadiumQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Stadium> searchAllStadiumWithField() {

        return jpaQueryFactory.select(stadium)
                .from(stadium)
                .leftJoin(stadium.fields,field)
                .fetchJoin()
                .fetch();

    }
}
