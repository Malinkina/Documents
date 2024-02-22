package ru.julia.dbconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.service.OrganizationService;
import ru.julia.service.mapper.OrganizationMapper;
import ru.julia.xml.XMLReader;

@Component
public class OrganizationTableFiller {
    @Autowired
    private XMLReader reader;
    @Autowired
    private OrganizationMapper mapper;
    @Autowired
    private OrganizationService service;
    public void fillOrganization() {
        reader
                .readOrganization()
                .getOrganizations()
                .forEach(o -> service.create(mapper.xmlOrgToOrgModel(o)));
    }
}
