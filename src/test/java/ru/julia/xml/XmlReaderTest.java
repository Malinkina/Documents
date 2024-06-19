package ru.julia.xml;

import org.junit.jupiter.api.Test;
import ru.julia.xml.xmlmodel.DepartmentXml;
import ru.julia.xml.xmlmodel.EmployeeXml;
import ru.julia.xml.xmlmodel.OrganizationXml;
import ru.julia.xml.xmlmodel.PositionXml;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class XmlReaderTest {
    private static final XmlReader READER = new XmlReader();

    @Test
    void readEmployee() {
        List<EmployeeXml> employees = READER.readEmployee().getEmployees();
        assertFalse(employees.isEmpty());
    }

    @Test
    void readOrganization() {
        List<OrganizationXml> organizations = READER.readOrganization().getOrganizations();
        assertFalse(organizations.isEmpty());
    }

    @Test
    void readDepartment() {
        List<DepartmentXml> departments = READER.readDepartment().getDepartments();
        assertFalse(departments.isEmpty());
    }

    @Test
    void readPosition() {
        List<PositionXml> positions = READER.readPosition().getPositions();
        assertFalse(positions.isEmpty());
    }
}