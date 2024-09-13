package com.ingress.managingtraveltourapi.controller;

import com.ingress.managingtraveltourapi.model.request.TourRequestDto;
import com.ingress.managingtraveltourapi.model.response.TourResponseDto;
import com.ingress.managingtraveltourapi.service.abstraction.TourService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "/v1/tours")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TourController {

    TourService tourService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void addTour(@RequestBody TourRequestDto requestDto) {
        tourService.addTour(requestDto);
    }

    @PostMapping("/{tourId}/assign-guide/{guideId}")
    @ResponseStatus(ACCEPTED)
    public void assignGuideToTour(@PathVariable Long tourId, @PathVariable Long guideId) {
        tourService.assignGuideToTour(tourId, guideId);
    }

    @PostMapping("/{tourId}/add-traveler/{travelerId}")
    @ResponseStatus(CREATED)
    public void addTraveler(@PathVariable Long tourId, @PathVariable Long travelerId) {
        tourService.addTraveler(tourId, travelerId);
    }

    @GetMapping("{travelerId}")
    public List<TourResponseDto> addTraveler(@PathVariable Long travelerId) {
       return tourService.getToursBySpecificTraveler(travelerId);
    }

}
