package com.yong.PlabFootball.stadium.dto;

import com.yong.PlabFootball.stadium.entity.vo.Region;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateStadiumRequest {
    private String name;
    private String location;
    private boolean parking;
    private boolean toilet;
    private boolean vest;
    private boolean ball;
    private String region;

    public StadiumDto toStadiumDto() {
        return StadiumDto.builder()
                .name(this.name)
                .location(this.location)
                .parking(this.parking)
                .toilet(this.toilet)
                .vest(this.vest)
                .ball(this.ball)
                .region(Region.valueOf(region))
                .build();
    }

    @Override
    public String toString() {
        return "CreateStadiumRequest{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", parking=" + parking +
                ", toilet=" + toilet +
                ", vest=" + vest +
                ", ball=" + ball +
                ", region=" + region +
                '}';
    }
}
