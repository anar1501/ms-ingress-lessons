package com.ingress.managingtraveltourapi.model.request;

public record DestinationRequestDto(String location,
                                    String description,
                                    String visitDate,
                                    Long tourId) {
}
