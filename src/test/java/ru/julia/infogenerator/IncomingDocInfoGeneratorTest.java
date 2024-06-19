package ru.julia.infogenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(MockitoExtension.class)
class IncomingDocInfoGeneratorTest {
    @Mock
    private EmployeeInfoGenerator employeeInfoGenerator;
    @InjectMocks
    private IncomingDocInfoGenerator incomingDocInfoGenerator;

    @Test
    void generateSender() {
        incomingDocInfoGenerator.generateSender();
        Mockito.verify(employeeInfoGenerator, Mockito.times(1)).generateEmployee();
    }

    @Test
    void generateRecipient() {
        incomingDocInfoGenerator.generateRecipient();
        Mockito.verify(employeeInfoGenerator, Mockito.times(1)).generateEmployee();
    }

    @Test
    void generateOutgoingNumber() {
        Integer outgoingNumber = incomingDocInfoGenerator.generateOutgoingNumber();
        assertTrue(outgoingNumber > 0 && outgoingNumber <= 100);
    }

    @Test
    void generateRegDate() {
        LocalDate date = incomingDocInfoGenerator.generateOutgoingRegDate();
        assertEquals(LocalDate.now(), date);
    }
}