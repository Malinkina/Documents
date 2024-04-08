package ru.julia.infogenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TaskDocInfoGeneratorTest {
    @Mock
    private EmployeeInfoGenerator employeeInfoGenerator;
    @InjectMocks
    private TaskDocInfoGenerator taskDocInfoGenerator;

    @Test
    void generateIssueDate() {
        LocalDate date = taskDocInfoGenerator.generateIssueDate();
        assertEquals(LocalDate.now().plusDays(1), date);
    }

    @Test
    void generateExecutionTerm() {
        LocalDate date = taskDocInfoGenerator.generateExecutionTerm();
        assertEquals(LocalDate.now().plusDays(31), date);
    }

    @Test
    void generateResponsibleExecutive() {
        taskDocInfoGenerator.generateResponsibleExecutive();
        verify(employeeInfoGenerator, times(1)).generateEmployee();
    }

    @Test
    void generateControlMark() {
        Boolean controlMark = taskDocInfoGenerator.generateControlMark();
        assertNotNull(controlMark);
    }

    @Test
    void generateController() {
        taskDocInfoGenerator.generateController();
        Mockito.verify(employeeInfoGenerator, Mockito.times(1)).generateEmployee();
    }
}