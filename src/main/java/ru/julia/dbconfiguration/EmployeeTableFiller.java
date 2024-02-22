package ru.julia.dbconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.service.EmployeeService;
import ru.julia.service.mapper.EmployeeMapper;
import ru.julia.xml.XMLReader;

@Component
public class EmployeeTableFiller {
    @Autowired
    private XMLReader reader;
    @Autowired
    private EmployeeService service;
    @Autowired
    private EmployeeMapper mapper;
    public void fillEmployee() {
        reader
                .readEmployee()
                .getEmployees()
                .forEach(e -> service.create(mapper.xmlEmployeeToEmployeeModel(e)));
    }
}
