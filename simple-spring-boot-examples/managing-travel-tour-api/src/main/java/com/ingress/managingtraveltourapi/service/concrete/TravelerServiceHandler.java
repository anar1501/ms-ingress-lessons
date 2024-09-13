package com.ingress.managingtraveltourapi.service.concrete;

import com.ingress.managingtraveltourapi.dao.entity.TourEntity;
import com.ingress.managingtraveltourapi.dao.entity.TravelerEntity;
import com.ingress.managingtraveltourapi.dao.repository.TourRepository;
import com.ingress.managingtraveltourapi.dao.repository.TravelerRepository;
import com.ingress.managingtraveltourapi.exception.NotFoundException;
import com.ingress.managingtraveltourapi.mapper.TravelerMapper;
import com.ingress.managingtraveltourapi.model.request.TravelerRequestDto;
import com.ingress.managingtraveltourapi.model.response.TravelerResponseDto;
import com.ingress.managingtraveltourapi.service.abstraction.TravelerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.ingress.managingtraveltourapi.model.enums.ExceptionConstants.TOUR_NOT_FOUND;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TravelerServiceHandler implements TravelerService {
    TravelerRepository travelerRepository;
    TourRepository tourRepository;
    TravelerMapper travelerMapper;

    @Override
    public void addTraveler(TravelerRequestDto requestDto, Long tourId) {
        var travelerEntity = travelerMapper.map(requestDto);
        var tourEntity = tourRepository.findById(tourId).orElseThrow(() -> new NotFoundException(TOUR_NOT_FOUND.getCode(), TOUR_NOT_FOUND.getMessage()));
        tourEntity.getTravelerEntities().add(travelerEntity);
        travelerEntity.getTourEntities().add(tourEntity);
        tourRepository.save(tourEntity);
    }

    @Override
    public List<TravelerResponseDto> getTravelersForTour(Long tourId) {
        var tour = tourRepository.findById(tourId).orElseThrow(() -> new NotFoundException(TOUR_NOT_FOUND.getCode(), TOUR_NOT_FOUND.getMessage()));
        var travelerEntities = tour.getTravelerEntities();
        return travelerMapper.map(travelerEntities);
    }
}
