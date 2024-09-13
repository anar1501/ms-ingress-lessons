package com.ingress.managingtraveltourapi.service.concrete;

import com.ingress.managingtraveltourapi.dao.repository.GuideRepository;
import com.ingress.managingtraveltourapi.dao.repository.TourRepository;
import com.ingress.managingtraveltourapi.exception.NotFoundException;
import com.ingress.managingtraveltourapi.mapper.GuideMapper;
import com.ingress.managingtraveltourapi.model.request.GuideRequestDto;
import com.ingress.managingtraveltourapi.model.response.GuideResponseDto;
import com.ingress.managingtraveltourapi.service.abstraction.GuideService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ingress.managingtraveltourapi.model.enums.ExceptionConstants.TOUR_NOT_FOUND;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GuideServiceHandler implements GuideService {
    GuideRepository guideRepository;
    TourRepository tourRepository;
    GuideMapper guideMapper;

    @Override
    public void addGuide(GuideRequestDto requestDto) {
        guideRepository.save(guideMapper.map(requestDto));
    }

    @Override
    public List<GuideResponseDto> getToursBySpecificTraveler(Long tourId) {
        return guideMapper.map(tourRepository.findByIdWithGuidesAndPassport(tourId).orElseThrow(() -> new NotFoundException(TOUR_NOT_FOUND.getCode(), TOUR_NOT_FOUND.getMessage())).getGuideEntities());
    }

}
