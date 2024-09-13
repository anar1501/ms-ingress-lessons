package com.ingress.managingtraveltourapi.service.abstraction;

import com.ingress.managingtraveltourapi.model.request.DestinationRequestDto;
import com.ingress.managingtraveltourapi.model.request.TravelerRequestDto;
import com.ingress.managingtraveltourapi.model.response.TravelerResponseDto;

import java.util.List;

public interface TravelerService {
    void addTraveler(TravelerRequestDto requestDto,Long tourId);

    List<TravelerResponseDto> getTravelersForTour(Long tourId);
}
