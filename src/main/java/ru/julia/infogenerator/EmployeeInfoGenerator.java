package ru.julia.infogenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.XMLReader;
import ru.julia.staff.Employee;

@Component
public class EmployeeInfoGenerator {
    @Autowired
    XMLReader xmlReader;

    public Employee generateEmployee() {
        return xmlReader.readEmployee().getEmployeeList().get((int) (Math.random() * 2));
    }
}
