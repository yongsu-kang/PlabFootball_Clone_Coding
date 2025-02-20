package com.yong.PlabFootball.global.exception;

public class EntityNotFoundException extends BusinessException{

    public EntityNotFoundException(String message) {
        super(message, ErrorCode.ENTITY_NOT_FOUND);
    }
}
