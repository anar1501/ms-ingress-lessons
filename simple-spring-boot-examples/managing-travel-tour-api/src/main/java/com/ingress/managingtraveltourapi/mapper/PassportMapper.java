package com.ingress.managingtraveltourapi.mapper;

import com.ingress.managingtraveltourapi.dao.entity.PassportEntity;
import com.ingress.managingtraveltourapi.dao.repository.GuideRepository;
import com.ingress.managingtraveltourapi.model.request.PassportRequestDto;
import com.ingress.managingtraveltourapi.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Objects;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), imports = {Objects.class,DateUtil.class}, uses = {DateUtil.class})
@RequiredArgsConstructor
public abstract class PassportMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "issueDate",expression = "java(DateUtil.stringToLocalDateTime(requestDto.issueDate()))")
    @Mapping(target = "expiryDate",  expression = "java(DateUtil.stringToLocalDateTime(requestDto.expiryDate()))")
    public abstract PassportEntity map(PassportRequestDto requestDto);
}
