package com.ingress.managingtraveltourapi.mapper;

import com.ingress.managingtraveltourapi.dao.entity.GuideEntity;
import com.ingress.managingtraveltourapi.dao.entity.PassportEntity;
import com.ingress.managingtraveltourapi.dao.repository.PassportRepository;
import com.ingress.managingtraveltourapi.exception.NotFoundException;
import com.ingress.managingtraveltourapi.model.request.GuideRequestDto;
import com.ingress.managingtraveltourapi.model.response.GuideResponseDto;
import com.ingress.managingtraveltourapi.model.response.PassportResponseDto;
import com.ingress.managingtraveltourapi.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import static com.ingress.managingtraveltourapi.model.enums.ExceptionConstants.GUIDE_NOT_FOUND;
import static com.ingress.managingtraveltourapi.model.enums.ExceptionConstants.PASSPORT_NOT_FOUND;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), imports = {Objects.class, DateUtil.class, PassportMapper.class}, uses = {DateUtil.class, PassportMapper.class})
@RequiredArgsConstructor
public abstract class GuideMapper {

    PassportRepository passportRepository;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "availableFrom", expression = "java(DateUtil.stringToLocalDateTime(requestDto.availableFrom()))")
    @Mapping(target = "availableTo", expression = "java(DateUtil.stringToLocalDateTime(requestDto.availableTo()))")
    @Mapping(target = "passportEntity", expression = "java(setPassportEntity(requestDto.passportId()))")
    public abstract GuideEntity map(GuideRequestDto requestDto);

    @Named(value = "setPassportEntity")
    public PassportEntity setPassportEntity(Long passportId) {
        return passportRepository.findById(passportId).orElseThrow(() -> new NotFoundException(PASSPORT_NOT_FOUND.getCode(), GUIDE_NOT_FOUND.getMessage()));
    }

    @Mapping(source = "passportEntity", target = "passportInfo")
    public abstract GuideResponseDto map(GuideEntity guideEntity);

    public abstract List<GuideResponseDto> map(Set<GuideEntity> guideEntities);


    public abstract PassportResponseDto map(PassportEntity passportEntity);

}
