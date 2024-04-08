package ru.julia.mapper.employee;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.controller.dto.request.EmployeeRequestDto;
import ru.julia.servicelayer.model.EmployeeModel;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeRequestDtoModelMapperTest {
    private static final EmployeeRequestDtoModelMapper MAPPER = Mappers.getMapper(EmployeeRequestDtoModelMapper.class);
    private static final String SURNAME = "Ivanov";
    private static final String NAME = "Ivan";
    private static final String PATRONYMIC = "Ivanovich";
    private static final String PHOTO = "Photo";
    private static final LocalDate DATE_OF_BIRTH = LocalDate.of(1990, 1, 1);
    private static final String PHONE_NUMBER = "+799999999";
    private static final UUID DEPARTMENT_ID = UUID.fromString("fa140557-ebae-4ee8-94c3-10673025da5e");
    private static final UUID ORGANIZATION_ID = UUID.fromString("dbff19cd-7311-4ebf-ba76-613d7aed5945");
    private static final UUID POSITION_ID = UUID.fromString("8e5aecac-12c1-4bee-8ba0-1d3422663561");

    @Test
    void toModel() {
        EmployeeRequestDto requestDto = new EmployeeRequestDto();
        requestDto.setSurname(SURNAME);
        requestDto.setName(NAME);
        requestDto.setPatronymic(PATRONYMIC);
        requestDto.setPhoto(PHOTO);
        requestDto.setDateOfBirth(DATE_OF_BIRTH);
        requestDto.setPhoneNumber(PHONE_NUMBER);
        requestDto.setDepartmentId(DEPARTMENT_ID);
        requestDto.setOrganizationId(ORGANIZATION_ID);
        requestDto.setPositionId(POSITION_ID);
        EmployeeModel model = MAPPER.toModel(requestDto);
        assertEquals(SURNAME, model.getSurname());
        assertEquals(NAME, model.getName());
        assertEquals(PATRONYMIC, model.getPatronymic());
        assertEquals(PHOTO, model.getPhoto());
        assertEquals(DATE_OF_BIRTH, model.getDateOfBirth());
        assertEquals(PHONE_NUMBER, model.getPhoneNumber());
        assertEquals(DEPARTMENT_ID, model.getDepartmentId());
        assertEquals(ORGANIZATION_ID, model.getOrganizationId());
        assertEquals(POSITION_ID, model.getPositionId());
    }
}