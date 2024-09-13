package com.ingress.managingtraveltourapi.model.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public enum ExceptionConstants {
    TOUR_NOT_FOUND("TOUR_NOT_FOUND","Tour not found"),
    GUIDE_NOT_FOUND("GUIDE_NOT_FOUND","Guide not found"),
    PASSPORT_NOT_FOUND("PASSPORT_NOT_FOUND","Passport not found"),
    TRAVELER_NOT_FOUND("TRAVELER_NOT_FOUND","Traveler not found"),
    GUIDE_NOT_AVAILABLE("GUIDE_NOT_AVAILABLE","Guide is not available for the tour dates"),
    DATE_CONFLICTS("DATE_CONFLICTS","Date conflict with another tour"),
    NO_PASSPORT_LINKAGE("NO_PASSPORT_LINKAGE","Guide must have a passport"),
    UNEXPECTED_EXCEPTION("UNEXPECTED_EXCEPTION", "Unexpected exception occurred");
    String code;
    String message;
}
