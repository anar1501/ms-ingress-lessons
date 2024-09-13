package com.ingress.managingtraveltourapi.model.response;

import java.time.LocalDateTime;

public record PassportResponseDto(String passportNumber,
                                  LocalDateTime issueDate,
                                  LocalDateTime expiryDate,
                                  String country) {
}
