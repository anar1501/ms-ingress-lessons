package com.ingress.managingtraveltourapi.model.request;

public record GuideRequestDto(String name,
                              String email,
                              String phoneNumber,
                              String availableFrom,
                              String availableTo,
                              Long tourId,
                              Long passportId) {
}
