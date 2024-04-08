package ru.julia.mapper.position;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.julia.controller.dto.response.PositionResponseDto;
import ru.julia.orm.jpamodel.PositionJpa;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PositionJpaResponseDtoMapper {
    PositionResponseDto toResponseDto(PositionJpa positionJPA);
}
