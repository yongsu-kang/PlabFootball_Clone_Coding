package com.yong.PlabFootball.member.exception;

import com.yong.PlabFootball.global.exception.ErrorCode;
import com.yong.PlabFootball.global.exception.InvalidValueException;
import com.yong.PlabFootball.member.entity.vo.Email;

public class EmailDuplicateException extends InvalidValueException {

    public EmailDuplicateException(Email email) {
        super(email.getEmail(), ErrorCode.EMAIL_DUPLICATION);
    }
}
