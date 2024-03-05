package ru.julia.service.dbinitiator.dbfilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import ru.julia.service.DepartmentService;
import ru.julia.service.mapper.DepartmentMapper;
import ru.julia.xml.XMLReader;

@Component
public class DepartmentTableFiller implements TableFiller, Ordered {
    @Autowired
    private XMLReader reader;
    @Autowired
    private DepartmentMapper mapper;
    @Autowired
    private DepartmentService service;
    @Override
    public void fill() {
        reader
                .readDepartment()
                .getDepartments()
                .forEach(d -> service.create(mapper.xmlDepartmentToDepartmentModel(d)));
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
