package com.ingress.managingtraveltourapi.service.abstraction;

import com.ingress.managingtraveltourapi.model.request.TourRequestDto;
import com.ingress.managingtraveltourapi.model.response.TourResponseDto;

import java.util.List;

public interface TourService {
    void addTour(TourRequestDto requestDto);

    void assignGuideToTour(Long tourId, Long guideId);

    void addTraveler(Long tourId, Long travelerId);
    List<TourResponseDto> getToursBySpecificTraveler(Long travelerId);
}
