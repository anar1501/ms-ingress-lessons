package com.ingress.managingtraveltourapi.model.request;

import java.math.BigDecimal;
import java.util.List;

public record TourRequestDto(String name,
                             String description,
                             BigDecimal price,
                             String startDate,
                             String endDate,
                             List<Long>listOfTravelersId) {
}
