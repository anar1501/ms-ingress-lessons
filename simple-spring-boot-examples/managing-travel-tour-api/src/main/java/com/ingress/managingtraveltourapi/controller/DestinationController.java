package com.ingress.managingtraveltourapi.controller;

import com.ingress.managingtraveltourapi.model.request.DestinationRequestDto;
import com.ingress.managingtraveltourapi.model.response.DestinationResponseDto;
import com.ingress.managingtraveltourapi.service.abstraction.DestinationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "/v1/destinations")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class DestinationController {
    DestinationService destinationService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void addDestination(@RequestBody DestinationRequestDto requestDto) {
        destinationService.addDestination(requestDto);
    }

    @GetMapping("/{tourId}")
    public List<DestinationResponseDto> getDestinationsForTour(@PathVariable Long tourId) {
        return destinationService.getDestinationsForTour(tourId);
    }
}
