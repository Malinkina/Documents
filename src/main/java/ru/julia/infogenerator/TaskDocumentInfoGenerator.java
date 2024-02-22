package ru.julia.infogenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.document.TaskDocument;
import ru.julia.xml.xmlmodel.EmployeeXML;

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
    public EmployeeXML generateResponsibleExecutive() {
        return employeeInfoGenerator.generateEmployee();
    }
    public boolean generateControlMark() {
        return new Random().nextBoolean();
    }
    public EmployeeXML generateController() {
        return employeeInfoGenerator.generateEmployee();
    }
}
