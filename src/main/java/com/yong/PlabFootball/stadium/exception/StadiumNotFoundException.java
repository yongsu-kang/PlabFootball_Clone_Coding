package com.yong.PlabFootball.stadium.exception;

import com.yong.PlabFootball.global.exception.EntityNotFoundException;

public class StadiumNotFoundException extends EntityNotFoundException {

    public StadiumNotFoundException(Long target) {
        super("stadium target : " + target + " is not found");
    }
}
