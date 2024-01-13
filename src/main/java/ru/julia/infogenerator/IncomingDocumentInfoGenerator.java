package ru.julia.infogenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.document.IncomingDocument;
import ru.julia.staff.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Класс генерирует значения для полей класса {@link IncomingDocument}
 */
@Component
public class IncomingDocumentInfoGenerator {
    @Autowired
    EmployeeInfoGenerator employeeInfoGenerator;
    public Employee generateSender() {
        return employeeInfoGenerator.generateEmployee();
    }
    public Employee generateRecipient() {
        return employeeInfoGenerator.generateEmployee();
    }
    public int generateOutgoingNumber() {
        return ((int) (Math.random() * 20));
    }
    public String generateRegDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localDate.format(formatter);
    }
}
