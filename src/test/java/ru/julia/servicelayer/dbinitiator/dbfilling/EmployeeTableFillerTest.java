package ru.julia.servicelayer.dbinitiator.dbfilling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.julia.mapper.employee.EmployeeXmlModelMapper;
import ru.julia.servicelayer.model.EmployeeModel;
import ru.julia.servicelayer.service.EmployeeService;
import ru.julia.xml.XmlReader;
import ru.julia.xml.xmlmodel.EmployeeXml;
import ru.julia.xml.xmlmodel.wrapper.EmployeeWrapper;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeTableFillerTest {
    @InjectMocks
    private EmployeeTableFiller tableFiller;
    @Mock
    private XmlReader reader;
    @Mock
    private EmployeeService service;
    @Mock
    private EmployeeXmlModelMapper mapper;

    @Test
    void fill() {
        EmployeeWrapper orgUnits = new EmployeeWrapper();
        when(reader.readEmployee()).thenReturn(orgUnits);
        List<EmployeeXml> employees = orgUnits.getEmployees();
        EmployeeXml employeeXml = new EmployeeXml();
        employees.add(employeeXml);
        employees.add(employeeXml);
        EmployeeModel employeeModel = new EmployeeModel();
        when(mapper.toModel(employeeXml)).thenReturn(employeeModel);
        tableFiller.fill();
        verify(reader, times(1)).readEmployee();
        verify(mapper, times(employees.size())).toModel(employeeXml);
        verify(service, times(employees.size())).create(employeeModel);
    }

    @Test
    void getOrder() {
        int order = tableFiller.getOrder();
        Assertions.assertEquals(4, order);
    }
}