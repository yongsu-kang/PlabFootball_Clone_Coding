package com.yong.PlabFootball.rental.exception;

import com.yong.PlabFootball.global.exception.InvalidValueException;

import java.time.LocalDateTime;

public class EndTimeInvalidException extends InvalidValueException {

    public EndTimeInvalidException(LocalDateTime value) {
        super("end time : " + value.toString() + " is illegal time");
    }
}
