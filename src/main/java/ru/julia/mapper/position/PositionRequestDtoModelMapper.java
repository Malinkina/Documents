package ru.julia.mapper.position;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.julia.controller.dto.request.PositionRequestDto;
import ru.julia.servicelayer.model.PositionModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PositionRequestDtoModelMapper {
    PositionModel toModel(PositionRequestDto positionRequestDTO);
}
