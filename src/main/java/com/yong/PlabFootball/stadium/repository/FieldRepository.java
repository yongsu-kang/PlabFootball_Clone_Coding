package com.yong.PlabFootball.stadium.repository;

import com.yong.PlabFootball.stadium.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FieldRepository extends JpaRepository<Field,Long> {

    @Query("select f from Field f where f.stadium.id = :id")
    List<Field> findAllByStadiumId(@Param("id") Long id);
}
