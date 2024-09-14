package com.example.mscreditmanager.service;

import com.example.mscreditmanager.dao.entity.OfferEntity;
import com.example.mscreditmanager.dao.repository.OfferRepository;
import com.example.mscreditmanager.model.response.CustomerResponse;
import com.example.mscreditmanager.model.response.OfferResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OfferService {
    OfferRepository offerRepository;

    public List<OfferResponse> getOffer() {
        List<OfferResponse> offerResponseList = new ArrayList<>();
        var offerList = offerRepository.findAll();
        offerList.forEach(offerEntity -> {
            if (!offerEntity.getAmount().equals(BigDecimal.valueOf(300))) {
                OfferResponse offerResponse = new OfferResponse();
                offerResponse.setMinimumAmount(offerEntity.getAmount());
                offerResponseList.add(offerResponse);
            }
        });
        return offerResponseList;
    }
}
