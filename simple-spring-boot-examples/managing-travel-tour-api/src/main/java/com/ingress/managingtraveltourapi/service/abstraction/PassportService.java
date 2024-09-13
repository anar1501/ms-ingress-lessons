package com.ingress.managingtraveltourapi.service.abstraction;

import com.ingress.managingtraveltourapi.model.request.PassportRequestDto;

public interface PassportService {
    void addPassport(PassportRequestDto requestDto);
}
