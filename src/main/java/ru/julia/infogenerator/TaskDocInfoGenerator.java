package ru.julia.infogenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.document.TaskDocument;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.time.LocalDate;
import java.util.Random;

@Component
public class TaskDocInfoGenerator {
    @Autowired
    EmployeeInfoGenerator employeeInfoGenerator;
    public LocalDate generateIssueDate() {
        return LocalDate.now().plusDays(1);
    }
    public LocalDate generateExecutionTerm() {
        return LocalDate.now().plusDays(31);
    }
    public EmployeeXml generateResponsibleExecutive() {
        return employeeInfoGenerator.generateEmployee();
    }
    public Boolean generateControlMark() {
        return new Random().nextBoolean();
    }
    public EmployeeXml generateController() {
        return employeeInfoGenerator.generateEmployee();
    }
}
