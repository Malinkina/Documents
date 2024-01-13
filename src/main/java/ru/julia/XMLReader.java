package ru.julia;

import org.springframework.stereotype.Component;
import ru.julia.staff.Department;
import ru.julia.staff.Employee;
import ru.julia.staff.OrgUnits;
import ru.julia.staff.Organization;
import ru.julia.staff.Position;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.URL;

/**
 * Читает значения из XML-документов для полей классов {@link Employee}, {@link Department}, {@link Organization}
 */
@Component
public class XMLReader {
    public OrgUnits readEmployee() {
        try {
            JAXBContext context = JAXBContext.newInstance(Employee.class, OrgUnits.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL resource = XMLReader.class.getClassLoader().getResource("employee.xml");
            OrgUnits employeesList = (OrgUnits) unmarshaller.unmarshal(resource);
            return employeesList;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public OrgUnits readOrganization() {
        try {
            JAXBContext context = JAXBContext.newInstance(Organization.class, OrgUnits.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL resource = XMLReader.class.getClassLoader().getResource("organization.xml");
            OrgUnits orgList = (OrgUnits) unmarshaller.unmarshal(resource);
            return orgList;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public OrgUnits readDepartment() {
        try {
            JAXBContext context = JAXBContext.newInstance(Department.class, OrgUnits.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL resource = XMLReader.class.getClassLoader().getResource("department.xml");
            OrgUnits departmentList = (OrgUnits) unmarshaller.unmarshal(resource);
            return departmentList;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
    public OrgUnits readPosition() {
        try {
            JAXBContext context = JAXBContext.newInstance(Position.class, OrgUnits.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL resource = XMLReader.class.getClassLoader().getResource("position.xml");
            OrgUnits positionList = (OrgUnits) unmarshaller.unmarshal(resource);
            return positionList;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
