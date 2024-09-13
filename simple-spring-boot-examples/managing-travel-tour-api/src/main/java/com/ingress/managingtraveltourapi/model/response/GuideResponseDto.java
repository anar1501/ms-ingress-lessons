package com.ingress.managingtraveltourapi.model.response;

import java.time.LocalDateTime;

public record GuideResponseDto(String name,
                               String email,
                               String phoneNumber,
                               LocalDateTime availableFrom,
                               LocalDateTime availableTo,
                               PassportResponseDto passportInfo) {
}
