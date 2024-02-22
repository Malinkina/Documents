package ru.julia.infogenerator;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.document.Document;
import ru.julia.xml.xmlmodel.EmployeeXML;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Класс генерирует значения для полей класса {@link Document}
 */
@Component
public class DocumentInfoGenerator {
    @Autowired
    EmployeeInfoGenerator employeeInfoGenerator;
    public UUID generateUUID() {
        return UUID.randomUUID();
    }
    public int generateDocumentId() {
        return ((int) (Math.random() * 100));
    }

    public String generateName() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String generateText() {
        return RandomStringUtils.randomAlphabetic(20);
    }

    public String generateRegNumber() {
        return RandomStringUtils.randomAlphabetic(3).toLowerCase();
    }

    public LocalDate generateRegDate() {
        return LocalDate.now();
    }

    public EmployeeXML generateAuthor() {
        return employeeInfoGenerator.generateEmployee();
    }
}
