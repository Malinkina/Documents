package ru.julia.servicelayer.dbinitiator.dbfilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import ru.julia.servicelayer.service.OrganizationService;
import ru.julia.mapper.OrganizationMapper;
import ru.julia.xml.XMLReader;

@Component
public class OrganizationTableFiller implements TableFiller, Ordered {
    @Autowired
    private XMLReader reader;
    @Autowired
    private OrganizationMapper mapper;
    @Autowired
    private OrganizationService service;
    @Override
    public void fill() {
        reader
                .readOrganization()
                .getOrganizations()
                .forEach(o -> service.create(mapper.xmlToModel(o)));
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
