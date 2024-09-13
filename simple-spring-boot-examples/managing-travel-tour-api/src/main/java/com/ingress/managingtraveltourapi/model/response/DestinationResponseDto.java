package com.ingress.managingtraveltourapi.model.response;

import java.time.LocalDateTime;

public record DestinationResponseDto(Long id,
                                     String location,
                                     String description,
                                     LocalDateTime visitDate) {
}
