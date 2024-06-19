package ru.julia.mapper.position;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.julia.dto.response.PositionResponseDto;
import ru.julia.orm.jpamodel.PositionJpa;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PositionJpaResponseDTOMapper {
    PositionResponseDto toResponseDto(PositionJpa positionJPA);
}
