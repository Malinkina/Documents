package ru.julia.mapper.employee;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.controller.dto.response.EmployeeResponseDto;
import ru.julia.orm.jpamodel.EmployeeJpa;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeJpaResponseDtoMapperTest {
    private static final EmployeeJpaResponseDtoMapper MAPPER = Mappers.getMapper(EmployeeJpaResponseDtoMapper.class);
    private static final UUID ID = UUID.fromString("4e91e9c6-e8dc-46d9-beed-05b55daf2969");
    private static final String SURNAME = "Ivanov";
    private static final String NAME = "Ivan";
    private static final String PATRONYMIC = "Ivanovich";
    private static final String PHOTO = "Photo";
    private static final LocalDate DATE_OF_BIRTH = LocalDate.of(1990, 1, 1);
    private static final String PHONE_NUMBER = "+799999999";

    @Test
    void toResponseDto() {
        EmployeeJpa jpa = new EmployeeJpa();
        jpa.setId(ID);
        jpa.setSurname(SURNAME);
        jpa.setName(NAME);
        jpa.setPatronymic(PATRONYMIC);
        jpa.setPhoto(PHOTO);
        jpa.setDateOfBirth(DATE_OF_BIRTH);
        jpa.setPhoneNumber(PHONE_NUMBER);
        EmployeeResponseDto responseDto = MAPPER.toResponseDto(jpa);
        assertEquals(ID, responseDto.getId());
        assertEquals(SURNAME, responseDto.getSurname());
        assertEquals(NAME, responseDto.getName());
        assertEquals(PATRONYMIC, responseDto.getPatronymic());
        assertEquals(PHOTO, responseDto.getPhoto());
        assertEquals(DATE_OF_BIRTH, responseDto.getDateOfBirth());
        assertEquals(PHONE_NUMBER, responseDto.getPhoneNumber());
    }
}