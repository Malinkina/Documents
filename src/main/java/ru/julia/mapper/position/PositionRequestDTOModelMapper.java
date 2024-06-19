package ru.julia.mapper.position;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.julia.dto.request.PositionRequestDto;
import ru.julia.servicelayer.model.PositionModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PositionRequestDTOModelMapper {
    PositionModel toModel(PositionRequestDto positionRequestDTO);
}
