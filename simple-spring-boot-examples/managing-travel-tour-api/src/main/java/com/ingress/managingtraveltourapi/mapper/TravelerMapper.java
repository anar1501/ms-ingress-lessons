package com.ingress.managingtraveltourapi.mapper;

import com.ingress.managingtraveltourapi.dao.entity.TourEntity;
import com.ingress.managingtraveltourapi.dao.entity.TravelerEntity;
import com.ingress.managingtraveltourapi.dao.repository.TourRepository;
import com.ingress.managingtraveltourapi.dao.repository.TravelerRepository;
import com.ingress.managingtraveltourapi.exception.NotFoundException;
import com.ingress.managingtraveltourapi.model.request.TravelerRequestDto;
import com.ingress.managingtraveltourapi.model.response.TravelerResponseDto;
import com.ingress.managingtraveltourapi.util.DateUtil;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static com.ingress.managingtraveltourapi.model.enums.ExceptionConstants.GUIDE_NOT_FOUND;
import static com.ingress.managingtraveltourapi.model.enums.ExceptionConstants.TOUR_NOT_FOUND;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), imports = {Objects.class}, uses = {DateUtil.class})
public abstract class TravelerMapper {

    @Autowired
    TourRepository tourRepository;

    @Mapping(target = "id", ignore = true)
    public abstract TravelerEntity map(TravelerRequestDto requestDto);

    public abstract TravelerResponseDto mapToResponseDto(TravelerEntity travelerEntity);

    public List<TravelerResponseDto> map(Set<TravelerEntity> travelerEntities) {
        return travelerEntities.stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }
}
