package ru.julia.mapper.employee;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.controller.dto.response.EmployeeResponseDto;
import ru.julia.orm.jpamodel.DepartmentJpa;
import ru.julia.orm.jpamodel.EmployeeJpa;
import ru.julia.orm.jpamodel.OrganizationJpa;
import ru.julia.orm.jpamodel.PositionJpa;

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
        DepartmentJpa departmentJpa = new DepartmentJpa();
        departmentJpa.setId(ID);
        OrganizationJpa organizationJpa = new OrganizationJpa();
        organizationJpa.setId(ID);
        PositionJpa positionJpa = new PositionJpa();
        positionJpa.setId(ID);
        EmployeeJpa jpa = new EmployeeJpa(
                ID, SURNAME, NAME, PATRONYMIC, PHOTO, DATE_OF_BIRTH, PHONE_NUMBER,
                departmentJpa, positionJpa, organizationJpa
        );
        EmployeeResponseDto actual = MAPPER.toResponseDto(jpa);
        EmployeeResponseDto expected = new EmployeeResponseDto(
                ID, SURNAME, NAME, PATRONYMIC, PHOTO, DATE_OF_BIRTH, PHONE_NUMBER, ID, ID, ID
        );
        assertEquals(expected, actual);
    }


    @Test
    void getOrganizationIdFromOrganizationJpa() {
        OrganizationJpa organizationJpa = new OrganizationJpa();
        organizationJpa.setId(ID);
        UUID id = MAPPER.getOrganizationIdFromOrganizationJpa(organizationJpa);
        assertEquals(ID, id);
    }

    @Test
    void getDepartmentIdFromDepartmentJpa() {
        DepartmentJpa departmentJpa = new DepartmentJpa();
        departmentJpa.setId(ID);
        UUID id = MAPPER.getDepartmentIdFromDepartmentJpa(departmentJpa);
        assertEquals(ID, id);
    }

    @Test
    void getPositionIdFromPositionJpa() {
        PositionJpa positionJpa = new PositionJpa();
        positionJpa.setId(ID);
        UUID id = MAPPER.getPositionIdFromPositionJpa(positionJpa);
        assertEquals(ID, id);
    }
}