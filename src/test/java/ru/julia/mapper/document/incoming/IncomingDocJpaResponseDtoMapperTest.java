package ru.julia.mapper.document.incoming;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;
import ru.julia.controller.dto.response.IncomingDocResponseDto;
import ru.julia.orm.jpamodel.EmployeeJpa;
import ru.julia.orm.jpamodel.IncomingDocJpa;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class IncomingDocJpaResponseDtoMapperTest {
    private static final IncomingDocJpaResponseDtoMapper MAPPER = Mappers.getMapper(IncomingDocJpaResponseDtoMapper.class);
    private static final UUID ID = UUID.fromString("1c1b791b-3f64-4977-9794-27fbdec48a23");
    private static final Integer DOC_ID = 1;
    private static final String NAME = "Name";
    private static final String TEXT = "Text";
    private static final String REG_NUMBER = "regNumber";
    private static final LocalDate REG_DATE = LocalDate.now();
    private static final EmployeeJpa AUTHOR = Mockito.mock(EmployeeJpa.class);
    private static final EmployeeJpa SENDER = Mockito.mock(EmployeeJpa.class);
    private static final EmployeeJpa RECIPIENT = Mockito.mock(EmployeeJpa.class);
    private static final Integer OUTGOING_NUMBER = 23;
    private static final LocalDate OUTGOING_REG_DATE = LocalDate.of(2023, 11, 30);

    @Test
    void toResponseDto() {
        IncomingDocJpa jpa = new IncomingDocJpa();
        jpa.setId(ID);
        jpa.setDocId(DOC_ID);
        jpa.setName(NAME);
        jpa.setText(TEXT);
        jpa.setRegNumber(REG_NUMBER);
        jpa.setRegDate(REG_DATE);
        jpa.setAuthor(AUTHOR);
        jpa.setSender(SENDER);
        jpa.setRecipient(RECIPIENT);
        jpa.setOutgoingNumber(OUTGOING_NUMBER);
        jpa.setOutgoingRegDate(OUTGOING_REG_DATE);
        IncomingDocResponseDto responseDto = MAPPER.toResponseDto(jpa);
        assertEquals(ID, responseDto.getId());
        assertEquals(DOC_ID, responseDto.getDocId());
        assertEquals(NAME, responseDto.getName());
        assertEquals(TEXT, responseDto.getText());
        assertEquals(REG_DATE, responseDto.getRegDate());
        assertEquals(OUTGOING_NUMBER, responseDto.getOutgoingNumber());
        assertEquals(OUTGOING_REG_DATE, responseDto.getOutgoingRegDate());
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