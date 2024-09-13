package com.ingress.managingtraveltourapi.service.concrete;

import com.ingress.managingtraveltourapi.dao.entity.TourEntity;
import com.ingress.managingtraveltourapi.dao.entity.TravelerEntity;
import com.ingress.managingtraveltourapi.dao.repository.GuideRepository;
import com.ingress.managingtraveltourapi.dao.repository.TourRepository;
import com.ingress.managingtraveltourapi.dao.repository.TravelerRepository;
import com.ingress.managingtraveltourapi.exception.DateConflictException;
import com.ingress.managingtraveltourapi.exception.NotFoundException;
import com.ingress.managingtraveltourapi.mapper.TourMapper;
import com.ingress.managingtraveltourapi.model.request.TourRequestDto;
import com.ingress.managingtraveltourapi.model.response.TourResponseDto;
import com.ingress.managingtraveltourapi.service.abstraction.TourService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.ingress.managingtraveltourapi.model.enums.ExceptionConstants.*;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TourServiceHandler implements TourService {
    TourRepository tourRepository;
    GuideRepository guideRepository;
    TravelerRepository travelerRepository;
    TourMapper tourMapper;

    @Override
    public void addTour(TourRequestDto requestDto) {
        var tourEntity = tourMapper.map(requestDto);
        var travelerEntities = tourEntity.getTravelerEntities();
        for (TravelerEntity travelerEntity : travelerEntities) {
            travelerEntity.setTourEntities(Collections.singleton(tourEntity));
        }
        tourRepository.save(tourEntity);
    }

    @Override
    public void assignGuideToTour(Long tourId, Long guideId) {
        var tour = tourRepository.findById(tourId).orElseThrow(() -> new NotFoundException(TOUR_NOT_FOUND.getCode(), TOUR_NOT_FOUND.getMessage()));
        var guide = guideRepository.findById(guideId).orElseThrow(() -> new NotFoundException(GUIDE_NOT_FOUND.getCode(), GUIDE_NOT_FOUND.getMessage()));
        if (guide.getAvailableFrom().isAfter(tour.getStartDate()) || guide.getAvailableTo().isBefore(tour.getEndDate())) {
            throw new NotFoundException(GUIDE_NOT_AVAILABLE.getCode(), GUIDE_NOT_AVAILABLE.getMessage());
        }
        for (TourEntity assignedTour : guide.getTourEntities()) {
            if (assignedTour.getEndDate().isAfter(tour.getStartDate()) && assignedTour.getStartDate().isBefore(tour.getEndDate())) {
                throw new DateConflictException(DATE_CONFLICTS.getCode(), DATE_CONFLICTS.getMessage());
            }
        }
        guide.setTourEntities(Collections.singleton(tour));
        var passport = guide.getPassportEntity();
        if (passport == null) {
            throw new NotFoundException(NO_PASSPORT_LINKAGE.getCode(), NO_PASSPORT_LINKAGE.getMessage());
        }
        tour.getGuideEntities().add(guide);
        tourRepository.save(tour);
    }

    @Override
    public void addTraveler(Long tourId, Long travelerId) {
        var tour = tourRepository.findById(tourId).orElseThrow(() -> new NotFoundException(TOUR_NOT_FOUND.getCode(), TOUR_NOT_FOUND.getMessage()));
        var traveler = travelerRepository.findById(travelerId).orElseThrow(() -> new NotFoundException(TRAVELER_NOT_FOUND.getCode(), TOUR_NOT_FOUND.getMessage()));
        tour.setTravelerEntities(Collections.singleton(traveler));
        traveler.setTourEntities(Collections.singleton(tour));
        tourRepository.save(tour);
    }

    @Override
    public List<TourResponseDto> getToursBySpecificTraveler(Long travelerId) {
        return tourMapper.map(travelerRepository.findById(travelerId).orElseThrow(() -> new NotFoundException(TRAVELER_NOT_FOUND.getCode(), TOUR_NOT_FOUND.getMessage())).getTourEntities());
    }
}
