package ru.julia.infogenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.document.IncomingDocument;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Класс генерирует значения для полей класса {@link IncomingDocument}
 */
@Component
public class IncomingDocInfoGenerator {
    @Autowired
    EmployeeInfoGenerator employeeInfoGenerator;
    public EmployeeXml generateSender() {
        return employeeInfoGenerator.generateEmployee();
    }
    public EmployeeXml generateRecipient() {
        return employeeInfoGenerator.generateEmployee();
    }
    public Integer generateOutgoingNumber() {
        return (Integer) ((int) (Math.random() * 100));
    }
    public String generateRegDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localDate.format(formatter);
    }
}
