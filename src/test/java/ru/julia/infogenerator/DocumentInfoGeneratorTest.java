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
class DocumentInfoGeneratorTest {
    @Mock
    private EmployeeInfoGenerator employeeInfoGenerator;
    @InjectMocks
    private DocumentInfoGenerator documentInfoGenerator;

    @Test
    void generateId() {
        Integer id = documentInfoGenerator.generateId();
        assertTrue(id > 0 && id <= 100);
    }

    @Test
    void generateName() {
        String name = documentInfoGenerator.generateName();
        assertEquals(5, name.chars().count());
        assertTrue(name.chars().allMatch(Character::isLetter));
    }

    @Test
    void generateText() {
        String text = documentInfoGenerator.generateText();
        assertEquals(20, text.chars().count());
        assertTrue(text.chars().allMatch(Character::isLetter));
    }

    @Test
    void generateRegNumber() {
        String regNumber = documentInfoGenerator.generateRegNumber();
        assertEquals(3, regNumber.chars().count());
        assertTrue(regNumber.chars().allMatch(Character::isLetter));
        assertTrue(regNumber.chars().allMatch(Character::isLowerCase));

    }

    @Test
    void generateRegDate() {
        LocalDate date = documentInfoGenerator.generateRegDate();
        assertEquals(LocalDate.now(), date);
    }

    @Test
    void generateAuthor() {
        documentInfoGenerator.generateAuthor();
        Mockito.verify(employeeInfoGenerator, Mockito.times(1)).generateEmployee();
    }
}