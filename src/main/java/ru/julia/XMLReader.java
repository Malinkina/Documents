package ru.julia;

import ru.julia.staff.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.URL;

public class XMLReader {
    public static Person readPerson() {
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class, OrgUnits.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL resource = XMLReader.class.getClassLoader().getResource("person.xml");
            OrgUnits persons = (OrgUnits) unmarshaller.unmarshal(resource);
            Person person = persons.getPersonList().get((int) (Math.random() * 2));
            return person;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Organization readOrganization() {
        try {
            JAXBContext context = JAXBContext.newInstance(Organization.class, OrgUnits.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL resource = XMLReader.class.getClassLoader().getResource("organization.xml");
            OrgUnits organizationList = (OrgUnits) unmarshaller.unmarshal(resource);
            Organization organization = organizationList.getOrgList().get((int) (Math.random() * 2));
            organization.setManager(readPerson());
            return organization;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Department readDepartment() {
        try {
            JAXBContext context = JAXBContext.newInstance(Department.class, OrgUnits.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL resource = XMLReader.class.getClassLoader().getResource("department.xml");
            OrgUnits departmentList = (OrgUnits) unmarshaller.unmarshal(resource);
            Department department = departmentList.getDepartmentList().get((int) (Math.random() * 2));
            department.setManager(readPerson());
            return department;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
