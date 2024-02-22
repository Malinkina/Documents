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
    List<XMLEmployee> employees = new ArrayList<>();

    @XmlElementWrapper(name = "organizations")
    @XmlElement(name = "organization")
    List<XMLOrganization> organizations = new ArrayList<>();

    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    List<XMLDepartment> departments = new ArrayList<>();
    @XmlElementWrapper(name = "positions")
    @XmlElement(name = "position")
    List<XMLPosition> positions = new ArrayList<>();

    public List<XMLEmployee> getEmployees() {
        return employees;
    }

    public List<XMLOrganization> getOrganizations() {
        return organizations;
    }

    public List<XMLDepartment> getDepartments() {
        return departments;
    }

    public List<XMLPosition> getPositions() {
        return positions;
    }
}
