package ru.julia.mapper.department;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.controller.dto.request.DepartmentRequestDto;
import ru.julia.servicelayer.model.DepartmentModel;

import java.util.List;
import java.util.UUID;

class DepartmentRequestDtoModelMapperTest {
    private static final DepartmentRequestDtoModelMapper MAPPER = Mappers.getMapper(DepartmentRequestDtoModelMapper.class);
    private static final String FULL_NAME = "Department";
    private static final String SHORT_NAME = "Dep";
    private static final String MANAGER = "Manager";
    private static final List<String> PHONE_NUMBERS = List.of("+7451361, +7845145454");
    private static final UUID ORGANIZATION_ID = UUID.fromString("75ddd782-3337-4d0b-b75f-c4665a473cbf");

    @Test
    void toModel() {
        DepartmentRequestDto requestDto = new DepartmentRequestDto(
                FULL_NAME, SHORT_NAME, MANAGER, PHONE_NUMBERS, ORGANIZATION_ID
        );
        DepartmentModel actual = MAPPER.toModel(requestDto);
        DepartmentModel expected = new DepartmentModel(
                null, FULL_NAME, SHORT_NAME, MANAGER, PHONE_NUMBERS, ORGANIZATION_ID
        );
        Assertions.assertEquals(expected, actual);
    }
}