package com.ingress.managingtraveltourapi.service.abstraction;

import com.ingress.managingtraveltourapi.model.request.GuideRequestDto;
import com.ingress.managingtraveltourapi.model.response.GuideResponseDto;

import java.util.List;

public interface GuideService {
    void addGuide(GuideRequestDto requestDto);
    List<GuideResponseDto> getToursBySpecificTraveler(Long tourId);
}
