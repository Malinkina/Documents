package ru.julia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dao.EmployeeDAO;
import ru.julia.domain.Employee;

import java.util.List;

@Component
public class EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;

    public void create(Employee employee) {
        employeeDAO.create(employee);
    }

    public Employee read(String id) {
        return employeeDAO.read(id);
    }

    public List<Employee> readAll() {
        return employeeDAO.readAll();
    }

    public void update(String id, Employee employee) {
        employeeDAO.update(id, employee);
    }

    public void delete(String id) {
        employeeDAO.delete(id);
    }
}
