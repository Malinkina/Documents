package ru.julia.infogenerator;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.document.Document;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.time.LocalDate;

@Component
public class DocumentInfoGenerator {
    @Autowired
    EmployeeInfoGenerator employeeInfoGenerator;

    public Integer generateId() {
        return ((int) ((Math.random() * 100) + 1));
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

    public EmployeeXml generateAuthor() {
        return employeeInfoGenerator.generateEmployee();
    }
}
