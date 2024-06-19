package ru.julia.infogenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.document.IncomingDocument;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.time.LocalDate;

@Component
public class IncomingDocInfoGenerator {
    @Autowired
    private EmployeeInfoGenerator employeeInfoGenerator;

    public EmployeeXml generateSender() {
        return employeeInfoGenerator.generateEmployee();
    }

    public EmployeeXml generateRecipient() {
        return employeeInfoGenerator.generateEmployee();
    }

    public Integer generateOutgoingNumber() {
        return (Integer) ((int) ((Math.random() * 100) + 1));
    }

    public LocalDate generateOutgoingRegDate() {
        return LocalDate.now();
    }
}
