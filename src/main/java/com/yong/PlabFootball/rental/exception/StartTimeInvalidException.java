package com.yong.PlabFootball.rental.exception;

import com.yong.PlabFootball.global.exception.InvalidValueException;

import java.time.LocalDateTime;

public class StartTimeInvalidException extends InvalidValueException {

    public StartTimeInvalidException(LocalDateTime value) {
        super("start time : " + value.toString() + " is illegal time");
    }
}
