package ru.julia.servicelayer.dbinitiator.dbfilling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.julia.mapper.organization.OrganizationXmlModelMapper;
import ru.julia.servicelayer.model.OrganizationModel;
import ru.julia.servicelayer.service.OrganizationService;
import ru.julia.xml.XmlReader;
import ru.julia.xml.xmlmodel.OrganizationXml;
import ru.julia.xml.xmlmodel.wrapper.OrganizationWrapper;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrganizationTableFillerTest {
    @InjectMocks
    private OrganizationTableFiller tableFiller;
    @Mock
    private XmlReader reader;
    @Mock
    private OrganizationService service;
    @Mock
    private OrganizationXmlModelMapper mapper;

    @Test
    void fill() {
        OrganizationWrapper organizationWrapper = new OrganizationWrapper();
        when(reader.readOrganization()).thenReturn(organizationWrapper);
        List<OrganizationXml> organizations = organizationWrapper.getOrganizations();
        OrganizationXml organizationXml = new OrganizationXml();
        organizations.add(organizationXml);
        organizations.add(organizationXml);
        OrganizationModel organizationModel = new OrganizationModel();
        when(mapper.toModel(organizationXml)).thenReturn(organizationModel);
        tableFiller.fill();
        verify(reader, times(1)).readOrganization();
        verify(mapper, times(organizations.size())).toModel(organizationXml);
        verify(service, times(organizations.size())).create(organizationModel);
    }

    @Test
    void getOrder() {
        int order = tableFiller.getOrder();
        Assertions.assertEquals(1, order);
    }
}