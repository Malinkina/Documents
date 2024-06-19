package ru.julia.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.julia.document.TaskDocument;
import ru.julia.infogenerator.DocumentInfoGenerator;
import ru.julia.infogenerator.TaskDocInfoGenerator;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskDocumentFactoryTest {
    @InjectMocks
    private TaskDocumentFactory factory;
    @Mock
    private TaskDocInfoGenerator taskDocInfoGenerator;
    @Mock
    private DocumentInfoGenerator documentInfoGenerator;
    public static final int ID = 1;
    public static final String NAME = "name";
    public static final String TEXT = "text";
    public static final String REG_NUMBER = "regNumber";
    public static final LocalDate REG_DATE = LocalDate.now();
    public static final EmployeeXml EMPLOYEE = new EmployeeXml();

    @Test
    void createBuilder() {
        TaskDocument.TaskDocumentBuilder builder = factory.createBuilder();
        Assertions.assertNotNull(builder);
    }

    @Test
    void fill() {
        TaskDocument.TaskDocumentBuilder builder = new TaskDocument.TaskDocumentBuilder();
        factory.fill(builder);
        verify(taskDocInfoGenerator, times(1)).generateController();
        verify(taskDocInfoGenerator, times(1)).generateResponsibleExecutive();
        verify(taskDocInfoGenerator, times(1)).generateExecutionTerm();
        verify(taskDocInfoGenerator, times(1)).generateIssueDate();
        verify(taskDocInfoGenerator, times(1)).generateControlMark();
    }

    @Test
    void create() {
        //GIVEN
        TaskDocument.TaskDocumentBuilder builder = new TaskDocument.TaskDocumentBuilder();
        when(documentInfoGenerator.generateId()).thenReturn(ID);
        when(documentInfoGenerator.generateName()).thenReturn(NAME);
        when(documentInfoGenerator.generateText()).thenReturn(TEXT);
        when(documentInfoGenerator.generateRegNumber()).thenReturn(REG_NUMBER);
        when(documentInfoGenerator.generateRegDate()).thenReturn(REG_DATE);
        when(documentInfoGenerator.generateAuthor()).thenReturn(EMPLOYEE);
        //WHEN
        TaskDocument actual = factory.create();
        //THEN
        TaskDocument expected = builder
                .documentId(ID)
                .name(NAME)
                .text(TEXT)
                .regNumber(REG_NUMBER)
                .regDate(REG_DATE)
                .author(EMPLOYEE)
                .build();
        assertEquals(expected, actual);
    }
}