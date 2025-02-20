package com.yong.PlabFootball.member.exception;

import com.yong.PlabFootball.global.exception.EntityNotFoundException;

public class MemberNotFoundException extends EntityNotFoundException {

    public MemberNotFoundException(Long target) {
        super("member target : " + target + " is not found");
    }
}
