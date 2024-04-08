package ru.julia.servicelayer.dbinitiator.dbfilling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.julia.mapper.department.DepartmentXmlModelMapper;
import ru.julia.servicelayer.model.DepartmentModel;
import ru.julia.servicelayer.service.DepartmentService;
import ru.julia.xml.XmlReader;
import ru.julia.xml.xmlmodel.DepartmentXml;
import ru.julia.xml.xmlmodel.OrgUnits;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentTableFillerTest {
    @InjectMocks
    private DepartmentTableFiller tableFiller;
    @Mock
    private XmlReader reader;
    @Mock
    private DepartmentXmlModelMapper mapper;
    @Mock
    private DepartmentService service;

    @Test
    void fill() {
        OrgUnits orgUnits = new OrgUnits();
        when(reader.readDepartment()).thenReturn(orgUnits);
        List<DepartmentXml> departments = orgUnits.getDepartments();
        DepartmentXml departmentXml = new DepartmentXml();
        departments.add(departmentXml);
        departments.add(departmentXml);
        DepartmentModel departmentModel = new DepartmentModel();
        when(mapper.toModel(departmentXml)).thenReturn(departmentModel);
        tableFiller.fill();
        verify(reader, times(1)).readDepartment();
        verify(mapper, times(departments.size())).toModel(departmentXml);
        verify(service, times(departments.size())).create(departmentModel);
    }

    @Test
    void getOrder() {
        int order = tableFiller.getOrder();
        Assertions.assertEquals(2, order);
    }
}