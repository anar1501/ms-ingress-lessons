package com.ingress.managingtraveltourapi.model.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TourResponseDto(Long id,
                              String name,
                              String description,
                              BigDecimal price,
                              LocalDateTime startDate,
                              LocalDateTime endDate) {
}
