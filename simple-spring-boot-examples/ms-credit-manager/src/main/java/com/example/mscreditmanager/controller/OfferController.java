package com.example.mscreditmanager.controller;

import com.example.mscreditmanager.model.request.CreateCustomerRequest;
import com.example.mscreditmanager.model.response.CustomerResponse;
import com.example.mscreditmanager.model.response.OfferResponse;
import com.example.mscreditmanager.service.CustomerService;
import com.example.mscreditmanager.service.OfferService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping(path = "v1/offers")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class OfferController {

    OfferService offerService;

    @GetMapping
    public List<OfferResponse> getOffer() {
        return offerService.getOffer();
    }


}
