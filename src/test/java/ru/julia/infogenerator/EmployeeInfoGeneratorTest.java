package ru.julia.infogenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.julia.xml.XmlReader;
import ru.julia.xml.xmlmodel.EmployeeXml;
import ru.julia.xml.xmlmodel.wrapper.EmployeeWrapper;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class EmployeeInfoGeneratorTest {
    @Mock
    private XmlReader reader;
    @InjectMocks
    private EmployeeInfoGenerator employeeInfoGenerator;

    @Test
    void generateEmployee() {
        EmployeeWrapper orgUnits = new EmployeeWrapper();
        orgUnits.getEmployees().add(createFirstEmployee());
        orgUnits.getEmployees().add(createSecondEmployee());
        Mockito.when(reader.readEmployee()).thenReturn(orgUnits);
        EmployeeXml employeeXml = employeeInfoGenerator.generateEmployee();
        assertNotNull(employeeXml);
    }

    private static EmployeeXml createFirstEmployee() {
        EmployeeXml employee = new EmployeeXml();
        employee.setId(UUID.fromString("4e91e9c6-e8dc-46d9-beed-05b55daf2969"));
        employee.setSurname("Ivanov");
        employee.setName("Ivan");
        employee.setPatronymic("Ivanovich");
        employee.setPhoto("Photo");
        employee.setDateOfBirth("01.01.1990");
        employee.setPhoneNumber("+799999999");
        employee.setDepartmentId(UUID.fromString("fa140557-ebae-4ee8-94c3-10673025da5e"));
        employee.setOrganizationId(UUID.fromString("dbff19cd-7311-4ebf-ba76-613d7aed5945"));
        employee.setPositionId(UUID.fromString("8e5aecac-12c1-4bee-8ba0-1d3422663561"));
        return employee;
    }
    private static EmployeeXml createSecondEmployee() {
        EmployeeXml employee = new EmployeeXml();
        employee.setId(UUID.fromString("14979687-fd29-460c-8a67-41b83597e2c0"));
        employee.setSurname("Petrov");
        employee.setName("Petr");
        employee.setPatronymic("Petrovich");
        employee.setPhoto("No photo");
        employee.setDateOfBirth("10.10.1991");
        employee.setPhoneNumber("+711111111");
        employee.setDepartmentId(UUID.fromString("fa140557-ebae-4ee8-94c3-10673025da5e"));
        employee.setOrganizationId(UUID.fromString("dbff19cd-7311-4ebf-ba76-613d7aed5945"));
        employee.setPositionId(UUID.fromString("8e5aecac-12c1-4bee-8ba0-1d3422663561"));
        return employee;
    }
}