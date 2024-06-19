package ru.julia.servicelayer.dbinitiator.dbfilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import ru.julia.mapper.department.DepartmentXmlModelMapper;
import ru.julia.servicelayer.service.DepartmentService;
import ru.julia.xml.XmlReader;

@Component
public class DepartmentTableFiller implements TableFiller, Ordered {
    @Autowired
    private XmlReader reader;
    @Autowired
    private DepartmentXmlModelMapper mapper;
    @Autowired
    private DepartmentService service;
    @Override
    public void fill() {
        reader
                .readDepartment()
                .getDepartments()
                .forEach(d -> service.create(mapper.toModel(d)));
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
