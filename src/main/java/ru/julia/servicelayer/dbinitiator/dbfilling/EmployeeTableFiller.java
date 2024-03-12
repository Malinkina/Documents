package ru.julia.servicelayer.dbinitiator.dbfilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import ru.julia.servicelayer.service.EmployeeService;
import ru.julia.mapper.EmployeeMapper;
import ru.julia.xml.XMLReader;

@Component
public class EmployeeTableFiller implements TableFiller, Ordered {
    @Autowired
    private XMLReader reader;
    @Autowired
    private EmployeeService service;
    @Autowired
    private EmployeeMapper mapper;
    @Override
    public void fill() {
        reader
                .readEmployee()
                .getEmployees()
                .forEach(e -> service.create(mapper.xmlToModel(e)));
    }

    @Override
    public int getOrder() {
        return 4;
    }
}
