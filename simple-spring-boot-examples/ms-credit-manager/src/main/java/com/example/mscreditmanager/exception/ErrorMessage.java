package com.example.mscreditmanager.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorMessage {
    CUSTOMER_NOT_FOUND("NotFoundException", "Customer not found"),
    CREDIT_NOT_FOUND("CREDIT_NOT_FOUND", "Credit not found"),
    UNEXPECTED_EXCEPTION("UNEXPECTED_EXCEPTION", "Unexpected exception occurred");
    String code;
    String message;
}
