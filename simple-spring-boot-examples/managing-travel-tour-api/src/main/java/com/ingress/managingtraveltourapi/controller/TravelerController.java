package com.ingress.managingtraveltourapi.controller;

import com.ingress.managingtraveltourapi.model.request.TravelerRequestDto;
import com.ingress.managingtraveltourapi.model.response.TravelerResponseDto;
import com.ingress.managingtraveltourapi.service.abstraction.TravelerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "/v1/travelers")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TravelerController {
    TravelerService travelerService;

    @PostMapping("/{tourId}")
    @ResponseStatus(CREATED)
    public void addTraveler(@RequestBody TravelerRequestDto requestDto,@PathVariable Long tourId) {
        travelerService.addTraveler(requestDto,tourId);
    }

    @GetMapping("/{tourId}")
    public List<TravelerResponseDto> getTravelersForTour(@PathVariable Long tourId) {
        return travelerService.getTravelersForTour(tourId);
    }

}
