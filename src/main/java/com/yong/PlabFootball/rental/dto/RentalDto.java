package com.yong.PlabFootball.rental.dto;

import com.yong.PlabFootball.member.dto.MemberDto;
import com.yong.PlabFootball.rental.entity.vo.ReservationCondition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class RentalDto {
    private Long id;
    private ReservationCondition reservationCondition;
    private MemberDto memberDto;
    private ReservationFieldDto reservationFieldDto;
}
