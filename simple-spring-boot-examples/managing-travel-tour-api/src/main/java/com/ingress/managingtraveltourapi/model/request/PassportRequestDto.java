package com.ingress.managingtraveltourapi.model.request;

public record PassportRequestDto(String passportNumber,
                                 String issueDate,
                                 String expiryDate,
                                 String country) {
}
