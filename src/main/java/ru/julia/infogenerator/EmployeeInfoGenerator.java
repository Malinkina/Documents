package ru.julia.infogenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.xml.XmlReader;
import ru.julia.xml.xmlmodel.EmployeeXml;

@Component
public class EmployeeInfoGenerator {
    @Autowired
    XmlReader xmlReader;

    public EmployeeXml generateEmployee() {
        return xmlReader
                .readEmployee()
                .getEmployees()
                .get((int) (Math.random() * 2));
    }
}
