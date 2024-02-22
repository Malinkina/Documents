package ru.julia.dbconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.service.DepartmentService;
import ru.julia.service.mapper.DepartmentMapper;
import ru.julia.xml.XMLReader;

@Component
public class DepartmentTableFiller {
    @Autowired
    private XMLReader reader;
    @Autowired
    private DepartmentMapper mapper;
    @Autowired
    private DepartmentService service;
    public void fillDepartment() {
        reader
                .readDepartment()
                .getDepartments()
                .forEach(d -> service.create(mapper.xmlDepartmentToDepartmentModel(d)));
    }
}
