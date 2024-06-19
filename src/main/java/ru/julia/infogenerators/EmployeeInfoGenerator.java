package ru.julia.infogenerators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.XMLReader;
import ru.julia.staff.Employee;

@Component
public class EmployeeInfoGenerator {
    @Autowired
    XMLReader xmlReader;
    public Employee generateEmployee() {
        Employee employee = xmlReader.readEmployee().getEmployeeList().get((int) (Math.random() * 2));
        employee.setPosition(xmlReader.readPosition().getPositionList().get((int) (Math.random() * 2)));
        employee.setDepartment(xmlReader.readDepartment().getDepartmentList().get((int) (Math.random() * 2)));
        employee.setOrganization(xmlReader.readOrganization().getOrgList().get((int) (Math.random() * 2)));
        return employee;
    }
}