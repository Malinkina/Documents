package ru.julia.mapper.department;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.controller.dto.request.DepartmentRequestDto;
import ru.julia.servicelayer.model.DepartmentModel;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentRequestDtoModelMapperTest {
    private static final DepartmentRequestDtoModelMapper MAPPER = Mappers.getMapper(DepartmentRequestDtoModelMapper.class);
    private static final String FULL_NAME = "Department";
    private static final String SHORT_NAME = "Dep";
    private static final String MANAGER = "Manager";
    private static final List<String> PHONE_NUMBERS = List.of("+7451361, +7845145454");
    private static final UUID ORGANIZATION_ID = UUID.fromString("75ddd782-3337-4d0b-b75f-c4665a473cbf");

    @Test
    void toModel() {
        DepartmentRequestDto requestDto = new DepartmentRequestDto();
        requestDto.setFullName(FULL_NAME);
        requestDto.setShortName(SHORT_NAME);
        requestDto.setManager(MANAGER);
        requestDto.setPhoneNumbers(PHONE_NUMBERS);
        requestDto.setOrganizationId(ORGANIZATION_ID);
        DepartmentModel model = MAPPER.toModel(requestDto);
        assertEquals(FULL_NAME, model.getFullName());
        assertEquals(SHORT_NAME, model.getShortName());
        assertEquals(MANAGER, model.getManager());
        assertEquals(PHONE_NUMBERS, model.getPhoneNumbers());
        assertEquals(ORGANIZATION_ID, model.getOrganizationId());
    }
}