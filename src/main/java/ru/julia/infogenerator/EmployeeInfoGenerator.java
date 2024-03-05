package ru.julia.infogenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.xml.XMLReader;
import ru.julia.xml.xmlmodel.EmployeeXML;

@Component
public class EmployeeInfoGenerator {
    @Autowired
    XMLReader xmlReader;

    public EmployeeXML generateEmployee() {
        return xmlReader
                .readEmployee()
                .getEmployees()
                .get((int) (Math.random() * 2));
    }
}
