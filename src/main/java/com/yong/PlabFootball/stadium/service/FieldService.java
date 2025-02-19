package com.yong.PlabFootball.stadium.service;

import com.yong.PlabFootball.common.converter.StadiumConverter;
import com.yong.PlabFootball.stadium.dto.FieldDto;
import com.yong.PlabFootball.stadium.dto.StadiumDto;
import com.yong.PlabFootball.stadium.entity.Field;
import com.yong.PlabFootball.stadium.repository.FieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FieldService {
    private final FieldRepository fieldRepository;

    @Transactional
    public FieldDto createField(FieldDto fieldDto) {
        Field field = StadiumConverter.toFieldEntity(fieldDto);
        return StadiumConverter.toFieldDto(fieldRepository.save(field));
    }

    public FieldDto findById(FieldDto fieldDto) {
        return StadiumConverter.toFieldDto(fieldRepository.findById(fieldDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("wrong field Id")));
    }

    public List<FieldDto> findAllByStadiumId(StadiumDto stadiumDto) {
        return fieldRepository.findAllByStadiumId(stadiumDto.getId())
                .stream().map(StadiumConverter::toFieldDto)
                .toList();
    }

    public void deleteById(FieldDto fieldDto) {
        fieldRepository.deleteById(fieldDto.getId());
    }
}
