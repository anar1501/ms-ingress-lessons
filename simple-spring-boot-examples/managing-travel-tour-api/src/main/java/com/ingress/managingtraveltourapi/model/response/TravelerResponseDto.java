package com.ingress.managingtraveltourapi.model.response;

public record TravelerResponseDto(Long id,
                                  String firstName,
                                  String lastName,
                                  String email) {
}
