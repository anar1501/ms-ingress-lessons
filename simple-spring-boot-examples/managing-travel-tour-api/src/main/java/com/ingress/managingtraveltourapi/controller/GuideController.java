package com.ingress.managingtraveltourapi.controller;

import com.ingress.managingtraveltourapi.model.request.GuideRequestDto;
import com.ingress.managingtraveltourapi.model.response.GuideResponseDto;
import com.ingress.managingtraveltourapi.service.abstraction.GuideService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "/v1/guides")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class GuideController{
    GuideService guideService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void addGuide(@RequestBody GuideRequestDto requestDto) {
        guideService.addGuide(requestDto);
    }

    @GetMapping("{tourId}")
    public List<GuideResponseDto> addTraveler(@PathVariable Long tourId) {
        return guideService.getToursBySpecificTraveler(tourId);
    }
}
