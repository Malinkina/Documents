package ru.julia.staff;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "staff")

public class OrgUnits {
    @XmlElementWrapper(name = "persons")
    @XmlElement(name = "person")
    List<Person> personList = new ArrayList<>();

    @XmlElementWrapper(name = "organizations")
    @XmlElement(name = "organization")
    List<Organization> orgList = new ArrayList<>();

    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    List<Department> departmentList = new ArrayList<>();

    public List<Organization> getOrgList() {
        return orgList;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public List<Person> getPersonList() {
        return personList;
    }
}
