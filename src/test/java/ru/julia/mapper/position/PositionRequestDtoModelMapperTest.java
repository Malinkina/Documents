package ru.julia.mapper.position;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.controller.dto.request.PositionRequestDto;
import ru.julia.servicelayer.model.PositionModel;

import static org.junit.jupiter.api.Assertions.*;

class PositionRequestDtoModelMapperTest {
    private static final PositionRequestDtoModelMapper MAPPER = Mappers.getMapper(PositionRequestDtoModelMapper.class);
    private static final String NAME = "Position";

    @Test
    void toModel() {
        PositionRequestDto requestDto = new PositionRequestDto();
        requestDto.setName(NAME);
        PositionModel model = MAPPER.toModel(requestDto);
        assertEquals(NAME, model.getName());
    }
}