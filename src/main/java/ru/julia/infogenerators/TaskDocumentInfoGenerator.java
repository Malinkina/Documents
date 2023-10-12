package ru.julia.infogenerators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.documents.TaskDocument;
import ru.julia.staff.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
/**
 * Класс создает и возвращает объект класса {@link TaskDocument}
 */
@Component
public class TaskDocumentInfoGenerator {
    @Autowired
    EmployeeInfoGenerator employeeInfoGenerator;
    public String generateIssueDate() {
        LocalDate localDate = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localDate.format(formatter);
    }
    public String generateExecutionTerm() {
        LocalDate localDate = LocalDate.now().plusDays(31);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localDate.format(formatter);
    }
    public Employee generateResponsibleExecutive() {
        return employeeInfoGenerator.generateEmployee();
    }
    public boolean generateControlMark() {
        return new Random().nextBoolean();
    }
    public Employee generateController() {
        return employeeInfoGenerator.generateEmployee();
    }
}
