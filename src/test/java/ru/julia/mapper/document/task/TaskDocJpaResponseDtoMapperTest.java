package ru.julia.mapper.document.task;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;
import ru.julia.controller.dto.response.TaskDocResponseDto;
import ru.julia.orm.jpamodel.EmployeeJpa;
import ru.julia.orm.jpamodel.TaskDocJpa;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskDocJpaResponseDtoMapperTest {
    private static final TaskDocJpaResponseDtoMapper MAPPER = Mappers.getMapper(TaskDocJpaResponseDtoMapper.class);
    private static final UUID ID = UUID.fromString("1c1b791b-3f64-4977-9794-27fbdec48a23");
    private static final Integer DOC_ID = 1;
    private static final String NAME = "Name";
    private static final String TEXT = "Text";
    private static final String REG_NUMBER = "regNumber";
    private static final LocalDate REG_DATE = LocalDate.now();
    private static final EmployeeJpa AUTHOR = Mockito.mock(EmployeeJpa.class);
    private static final LocalDate ISSUE_DATE = LocalDate.now();
    private static final LocalDate EXECUTION_TERM = LocalDate.of(2024, 3, 31);
    private static final EmployeeJpa RESPONSIBLE_EXECUTIVE = Mockito.mock(EmployeeJpa.class);
    public static final Boolean CONTROL_MARK = true;
    public static final EmployeeJpa CONTROLLER = Mockito.mock(EmployeeJpa.class);

    @Test
    void toResponseDto() {
        TaskDocJpa jpa = new TaskDocJpa();
        jpa.setId(ID);
        jpa.setDocId(DOC_ID);
        jpa.setName(NAME);
        jpa.setText(TEXT);
        jpa.setRegNumber(REG_NUMBER);
        jpa.setRegDate(REG_DATE);
        jpa.setAuthor(AUTHOR);
        jpa.setIssueDate(ISSUE_DATE);
        jpa.setExecutionTerm(EXECUTION_TERM);
        jpa.setResponsibleExecutive(RESPONSIBLE_EXECUTIVE);
        jpa.setControlMark(CONTROL_MARK);
        jpa.setController(CONTROLLER);
        TaskDocResponseDto responseDto = MAPPER.toResponseDto(jpa);
        assertEquals(ID, responseDto.getId());
        assertEquals(DOC_ID, responseDto.getDocId());
        assertEquals(NAME, responseDto.getName());
        assertEquals(TEXT, responseDto.getText());
        assertEquals(REG_DATE, responseDto.getRegDate());
        assertEquals(ISSUE_DATE, responseDto.getIssueDate());
        assertEquals(CONTROL_MARK, responseDto.getControlMark());
    }

    @Test
    void mapAuthor() {
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