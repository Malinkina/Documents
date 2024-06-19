package ru.julia.mapper.organization;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.controller.dto.request.OrganizationRequestDto;
import ru.julia.servicelayer.model.OrganizationModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrganizationRequestDtoModelMapperTest {
    private static final OrganizationRequestDtoModelMapper MAPPER = Mappers.getMapper(OrganizationRequestDtoModelMapper.class);
    private static final String FULL_NAME = "Organization";
    private static final String SHORT_NAME = "Org";
    private static final String MANAGER = "Manager";
    private static final List<String> PHONE_NUMBERS = List.of("+7451361, +7845145454");

    @Test
    void toModel() {
        OrganizationRequestDto requestDto = new OrganizationRequestDto();
        requestDto.setFullName(FULL_NAME);
        requestDto.setShortName(SHORT_NAME);
        requestDto.setManager(MANAGER);
        requestDto.setPhoneNumbers(PHONE_NUMBERS);
        OrganizationModel model = MAPPER.toModel(requestDto);
        assertEquals(FULL_NAME, model.getFullName());
        assertEquals(SHORT_NAME, model.getShortName());
        assertEquals(MANAGER, model.getManager());
        assertEquals(PHONE_NUMBERS, model.getPhoneNumbers());
    }
}