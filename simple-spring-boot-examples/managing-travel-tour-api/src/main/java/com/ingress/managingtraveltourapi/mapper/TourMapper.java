package com.ingress.managingtraveltourapi.mapper;

import com.ingress.managingtraveltourapi.dao.entity.TourEntity;
import com.ingress.managingtraveltourapi.dao.entity.TravelerEntity;
import com.ingress.managingtraveltourapi.dao.repository.DestinationRepository;
import com.ingress.managingtraveltourapi.dao.repository.GuideRepository;
import com.ingress.managingtraveltourapi.dao.repository.TravelerRepository;
import com.ingress.managingtraveltourapi.model.request.TourRequestDto;
import com.ingress.managingtraveltourapi.model.response.TourResponseDto;
import com.ingress.managingtraveltourapi.util.DateUtil;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), imports = {Objects.class,DateUtil.class}, uses = {DateUtil.class})
public abstract class TourMapper {

    @Autowired DestinationRepository destinationRepository;
    @Autowired GuideRepository guideRepository;
    @Autowired TravelerRepository travelerRepository;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "startDate", expression = "java(DateUtil.stringToLocalDateTime(requestDto.startDate()))")
    @Mapping(target = "endDate", expression = "java(DateUtil.stringToLocalDateTime(requestDto.endDate()))")
    @Mapping(target = "travelerEntities", expression = "java(mapToTravelers(requestDto.listOfTravelersId()))")
    public abstract TourEntity map(TourRequestDto requestDto);

    public abstract List<TourResponseDto> map(Set<TourEntity> tourEntities);

    protected Set<TravelerEntity> map(List<Long> travelersId) {
        return new HashSet<>(travelerRepository.findAllById(travelersId));
    }


}
