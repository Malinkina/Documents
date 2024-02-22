package ru.julia.xml.xmlmodel;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс содержит списки оргштатных единиц
 */
@Component
@XmlRootElement(name = "staff")
public class OrgUnits {
    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
    List<EmployeeXML> employees = new ArrayList<>();

    @XmlElementWrapper(name = "organizations")
    @XmlElement(name = "organization")
    List<OrganizationXML> organizations = new ArrayList<>();

    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    List<DepartmentXML> departments = new ArrayList<>();
    @XmlElementWrapper(name = "positions")
    @XmlElement(name = "position")
    List<PositionXML> positions = new ArrayList<>();

    public List<EmployeeXML> getEmployees() {
        return employees;
    }

    public List<OrganizationXML> getOrganizations() {
        return organizations;
    }

    public List<DepartmentXML> getDepartments() {
        return departments;
    }

    public List<PositionXML> getPositions() {
        return positions;
    }
}
