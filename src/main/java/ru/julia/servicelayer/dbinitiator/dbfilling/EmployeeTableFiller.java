package ru.julia.servicelayer.dbinitiator.dbfilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import ru.julia.mapper.employee.EmployeeXmlModelMapper;
import ru.julia.servicelayer.service.EmployeeService;
import ru.julia.xml.XmlReader;

@Component
public class EmployeeTableFiller implements TableFiller, Ordered {
    @Autowired
    private XmlReader reader;
    @Autowired
    private EmployeeService service;
    @Autowired
    private EmployeeXmlModelMapper mapper;
    @Override
    public void fill() {
        reader
                .readEmployee()
                .getEmployees()
                .forEach(e -> service.create(mapper.toModel(e)));
    }

    @Override
    public int getOrder() {
        return 4;
    }
}
