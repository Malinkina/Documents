package ru.julia.mapper.position;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.controller.dto.response.PositionResponseDto;
import ru.julia.orm.jpamodel.PositionJpa;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionJpaResponseDtoMapperTest {
    private static final PositionJpaResponseDtoMapper MAPPER = Mappers.getMapper(PositionJpaResponseDtoMapper.class);
    private static final UUID ID = UUID.fromString("d046bfbc-4b68-45dc-bbfd-7bd855717a8a");
    private static final String NAME = "Position";
    private static final int POSITION_ID = 123;

    @Test
    void toResponseDto() {
        PositionJpa jpa = new PositionJpa();
        jpa.setId(ID);
        jpa.setName(NAME);
        jpa.setPositionId(POSITION_ID);
        PositionResponseDto responseDto = MAPPER.toResponseDto(jpa);
        assertEquals(ID, responseDto.getId());
        assertEquals(NAME, jpa.getName());
        assertEquals(POSITION_ID, jpa.getPositionId());
    }
}