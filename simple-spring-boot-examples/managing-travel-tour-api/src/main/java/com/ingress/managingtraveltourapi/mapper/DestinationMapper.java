package com.ingress.managingtraveltourapi.mapper;

import com.ingress.managingtraveltourapi.dao.entity.DestinationEntity;
import com.ingress.managingtraveltourapi.dao.entity.PassportEntity;
import com.ingress.managingtraveltourapi.dao.entity.TourEntity;
import com.ingress.managingtraveltourapi.dao.repository.TourRepository;
import com.ingress.managingtraveltourapi.exception.NotFoundException;
import com.ingress.managingtraveltourapi.model.request.DestinationRequestDto;
import com.ingress.managingtraveltourapi.model.response.DestinationResponseDto;
import com.ingress.managingtraveltourapi.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

import static com.ingress.managingtraveltourapi.model.enums.ExceptionConstants.*;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), imports = {Objects.class, DateUtil.class}, uses = {DateUtil.class})
@RequiredArgsConstructor
public abstract class DestinationMapper {

    @Autowired TourRepository tourRepository;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "visitDate", expression = "java(DateUtil.stringToLocalDateTime(requestDto.visitDate()))")
    @Mapping(target = "tourEntity", expression = "java(setTourEntity(requestDto.tourId()))")
    public abstract DestinationEntity map(DestinationRequestDto requestDto);

    public abstract List<DestinationResponseDto> map(List<DestinationEntity> requestDto);


    @Named(value = "setTourEntity")
    public TourEntity setTourEntity(Long tourId) {
        return tourRepository.findById(tourId).orElseThrow(() -> new NotFoundException(TOUR_NOT_FOUND.getCode(), GUIDE_NOT_FOUND.getMessage()));
    }
}
