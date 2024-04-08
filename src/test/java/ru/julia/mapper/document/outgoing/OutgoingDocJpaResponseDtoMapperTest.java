package ru.julia.mapper.document.outgoing;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;
import ru.julia.controller.dto.response.OutgoingDocResponseDto;
import ru.julia.orm.jpamodel.EmployeeJpa;
import ru.julia.orm.jpamodel.OutgoingDocJpa;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OutgoingDocJpaResponseDtoMapperTest {
    private static final OutgoingDocJpaResponseDtoMapper MAPPER = Mappers.getMapper(OutgoingDocJpaResponseDtoMapper.class);
    private static final UUID ID = UUID.fromString("392739e5-3d70-4805-b599-a7b78978fedd");
    private static final Integer DOC_ID = 1;
    private static final String NAME = "Name";
    private static final String TEXT = "Text";
    private static final String REG_NUMBER = "regNumber";
    private static final LocalDate REG_DATE = LocalDate.now();
    private static final EmployeeJpa AUTHOR = Mockito.mock(EmployeeJpa.class);
    private static final EmployeeJpa RECIPIENT = Mockito.mock(EmployeeJpa.class);
    private static final String DELIVERY_TYPE = "deliveryType";

    @Test
    void toResponseDto() {
        OutgoingDocJpa jpa = new OutgoingDocJpa();
        jpa.setId(ID);
        jpa.setDocId(DOC_ID);
        jpa.setName(NAME);
        jpa.setText(TEXT);
        jpa.setRegDate(REG_DATE);
        jpa.setRegNumber(REG_NUMBER);
        jpa.setAuthor(AUTHOR);
        jpa.setRecipient(RECIPIENT);
        jpa.setDeliveryType(DELIVERY_TYPE);
        OutgoingDocResponseDto responseDto = MAPPER.toResponseDto(jpa);
        assertEquals(ID, responseDto.getId());
        assertEquals(DOC_ID, responseDto.getDocId());
        assertEquals(NAME, responseDto.getName());
        assertEquals(TEXT, responseDto.getText());
        assertEquals(REG_DATE, responseDto.getRegDate());
        assertEquals(DELIVERY_TYPE, responseDto.getDeliveryType());
    }

    @Test
    void mapEmployee() {
        String surname = "Ivanov";
        String name = "Ivan";
        String patronymic = "Ivanovich";
        EmployeeJpa employee = new EmployeeJpa();
        employee.setSurname(surname);
        employee.setName(name);
        employee.setPatronymic(patronymic);
        String mappedEmployee = MAPPER.mapEmployee(employee);
        assertTrue(mappedEmployee.contains(surname));
        assertTrue(mappedEmployee.contains(name));
        assertTrue(mappedEmployee.contains(patronymic));
        assertTrue(mappedEmployee.contains(" "));
    }
}