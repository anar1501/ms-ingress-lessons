package com.ingress.managingtraveltourapi.service.concrete;

import com.ingress.managingtraveltourapi.dao.repository.DestinationRepository;
import com.ingress.managingtraveltourapi.dao.repository.TourRepository;
import com.ingress.managingtraveltourapi.exception.NotFoundException;
import com.ingress.managingtraveltourapi.mapper.DestinationMapper;
import com.ingress.managingtraveltourapi.model.request.DestinationRequestDto;
import com.ingress.managingtraveltourapi.model.response.DestinationResponseDto;
import com.ingress.managingtraveltourapi.service.abstraction.DestinationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ingress.managingtraveltourapi.model.enums.ExceptionConstants.TOUR_NOT_FOUND;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DestinationServiceHandler implements DestinationService {
    DestinationRepository destinationRepository;
    TourRepository tourRepository;
    DestinationMapper destinationMapper;

    @Override
    public void addDestination(DestinationRequestDto requestDto) {
        destinationRepository.save(destinationMapper.map(requestDto));
    }

    @Override
    public List<DestinationResponseDto> getDestinationsForTour(Long tourId) {
        return destinationMapper.map(destinationRepository.findByTourEntity(tourRepository.findById(tourId).orElseThrow(() -> new NotFoundException(TOUR_NOT_FOUND.getCode(), TOUR_NOT_FOUND.getMessage()))));
    }
}
