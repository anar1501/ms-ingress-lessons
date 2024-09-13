package com.ingress.managingtraveltourapi.service.concrete;

import com.ingress.managingtraveltourapi.dao.entity.GuideEntity;
import com.ingress.managingtraveltourapi.dao.entity.PassportEntity;
import com.ingress.managingtraveltourapi.dao.repository.PassportRepository;
import com.ingress.managingtraveltourapi.mapper.PassportMapper;
import com.ingress.managingtraveltourapi.model.request.PassportRequestDto;
import com.ingress.managingtraveltourapi.service.abstraction.PassportService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PassportServiceHandler implements PassportService {
    PassportRepository passportRepository;
    PassportMapper passportMapper;

    @Override
    public void addPassport(PassportRequestDto requestDto) {
        var passportEntity = passportMapper.map(requestDto);
        passportRepository.save(passportEntity);
    }
}
