package ru.julia.xml.xmlmodel;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс содержит списки оргштатных единиц
 */

@XmlRootElement(name = "staff")
public class OrgUnits {
    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
    List<EmployeeXml> employees = new ArrayList<>();

    @XmlElementWrapper(name = "organizations")
    @XmlElement(name = "organization")
    List<OrganizationXml> organizations = new ArrayList<>();

    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    List<DepartmentXml> departments = new ArrayList<>();
    @XmlElementWrapper(name = "positions")
    @XmlElement(name = "position")
    List<PositionXml> positions = new ArrayList<>();

    public List<EmployeeXml> getEmployees() {
        return employees;
    }

    public List<OrganizationXml> getOrganizations() {
        return organizations;
    }

    public List<DepartmentXml> getDepartments() {
        return departments;
    }

    public List<PositionXml> getPositions() {
        return positions;
    }
}
