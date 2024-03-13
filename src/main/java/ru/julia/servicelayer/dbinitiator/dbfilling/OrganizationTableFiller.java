package ru.julia.servicelayer.dbinitiator.dbfilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import ru.julia.mapper.organization.OrganizationXmlModelMapper;
import ru.julia.servicelayer.service.OrganizationService;
import ru.julia.xml.XmlReader;

@Component
public class OrganizationTableFiller implements TableFiller, Ordered {
    @Autowired
    private XmlReader reader;
    @Autowired
    private OrganizationService service;
    @Autowired
    private OrganizationXmlModelMapper mapper;
    @Override
    public void fill() {
        reader
                .readOrganization()
                .getOrganizations()
                .forEach(o -> service.create(mapper.toModel(o)));
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
