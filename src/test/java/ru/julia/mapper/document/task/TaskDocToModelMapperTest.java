package ru.julia.mapper.document.task;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.document.TaskDocument;
import ru.julia.servicelayer.model.TaskDocModel;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskDocToModelMapperTest {
    private static final TaskDocToModelMapper MAPPER = Mappers.getMapper(TaskDocToModelMapper.class);
    public static final EmployeeXml EMPLOYEE = new EmployeeXml();
    public static final UUID ID = UUID.fromString("13687c80-a12f-4f97-b194-5b618bce6e17");
    public static final int DOC_ID = 1;
    public static final String NAME = "Name";
    public static final String TEXT = "Text";
    public static final LocalDate REG_DATE = LocalDate.now();
    public static final String REG_NUMBER = "regNumber";
    public static final LocalDate ISSUE_DATE = LocalDate.of(2023, 1, 1);
    public static final LocalDate EXECUTION_TERM = LocalDate.of(2023, 1, 31);
    public static final boolean CONTROL_MARK = true;

    @Test
    void toModel() {
        EMPLOYEE.setId(ID);
        TaskDocument document = new TaskDocument.TaskDocumentBuilder()
                .documentId(DOC_ID)
                .name(NAME)
                .text(TEXT)
                .regDate(REG_DATE)
                .regNumber(REG_NUMBER)
                .author(EMPLOYEE)
                .issueDate(ISSUE_DATE)
                .executionTerm(EXECUTION_TERM)
                .responsibleExecutive(EMPLOYEE)
                .controlMark(CONTROL_MARK)
                .controller(EMPLOYEE)
                .build();
        TaskDocModel model = MAPPER.toModel(document);
        assertEquals(DOC_ID, model.getDocId());
        assertEquals(NAME, model.getName());
        assertEquals(TEXT, model.getText());
        assertEquals(REG_DATE, model.getRegDate());
        assertEquals(REG_NUMBER, model.getRegNumber());
        assertEquals(EMPLOYEE.getId(), model.getAuthorId());
        assertEquals(ISSUE_DATE, model.getIssueDate());
        assertEquals(EXECUTION_TERM, model.getExecutionTerm());
        assertEquals(CONTROL_MARK, model.getControlMark());
        assertEquals(EMPLOYEE.getId(), model.getControllerId());
    }

    @Test
    void mapEmployee() {
        EmployeeXml employeeXml = new EmployeeXml();
        employeeXml.setId(ID);
        UUID id = MAPPER.mapEmployee(employeeXml);
        assertEquals(id, employeeXml.getId());
    }
}