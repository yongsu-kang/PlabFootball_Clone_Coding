package com.yong.PlabFootball.stadium.dto;

import com.yong.PlabFootball.stadium.entity.vo.Region;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class StadiumDto {
    private Long id;
    private String name;
    private String location;
    private boolean parking;
    private boolean toilet;
    private boolean vest;
    private boolean ball;
    private Region region;
}
