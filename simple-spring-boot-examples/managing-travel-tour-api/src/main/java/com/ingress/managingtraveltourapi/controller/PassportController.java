package com.ingress.managingtraveltourapi.controller;

import com.ingress.managingtraveltourapi.model.request.PassportRequestDto;
import com.ingress.managingtraveltourapi.service.abstraction.PassportService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "/v1/passports")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PassportController {
    PassportService passportService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void addPassport(@RequestBody PassportRequestDto requestDto) {
        passportService.addPassport(requestDto);
    }
}
