package com.yong.PlabFootball.member.exception;

import com.yong.PlabFootball.global.exception.EntityNotFoundException;

public class EmailNotFoundException extends EntityNotFoundException {

    public EmailNotFoundException(String target) {
        super("member target : " + target + " is not found");
    }
}
