package ru.julia.staff;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс описывает оргштатную единицу
 */
@XmlRootElement(name = "staff")
public class OrgUnits {
    @XmlElementWrapper(name = "persons")
    @XmlElement(name = "employee")
    List<Employee> employeeList = new ArrayList<>();

    @XmlElementWrapper(name = "organizations")
    @XmlElement(name = "organization")
    List<Organization> orgList = new ArrayList<>();

    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    List<Department> departmentList = new ArrayList<>();
    @XmlElementWrapper(name = "positions")
    @XmlElement(name = "position")
    List<Position> positionList = new ArrayList<>();


    public List<Organization> getOrgList() {
        return orgList;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<Position> getPositionList() {
        return positionList;
    }
}
