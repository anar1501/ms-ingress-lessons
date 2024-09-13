package com.ingress.managingtraveltourapi.exception;

import lombok.Getter;

@Getter
public class DateConflictException extends RuntimeException{
    String code;

    public DateConflictException(String message, String code) {
        super(message);
        this.code = code;
    }
}
