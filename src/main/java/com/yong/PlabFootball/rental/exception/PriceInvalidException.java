package com.yong.PlabFootball.rental.exception;

import com.yong.PlabFootball.global.exception.InvalidValueException;

public class PriceInvalidException extends InvalidValueException {

    public PriceInvalidException(int value) {
        super("price : " + value + " is illegal value");
    }
}
