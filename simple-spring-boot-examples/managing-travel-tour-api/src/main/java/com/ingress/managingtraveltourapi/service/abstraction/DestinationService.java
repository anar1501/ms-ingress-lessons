package com.ingress.managingtraveltourapi.service.abstraction;

import com.ingress.managingtraveltourapi.model.request.DestinationRequestDto;
import com.ingress.managingtraveltourapi.model.response.DestinationResponseDto;

import java.util.List;

public interface DestinationService {
    void addDestination(DestinationRequestDto requestDto);

    List<DestinationResponseDto> getDestinationsForTour(Long tourId);
}
