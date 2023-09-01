package ru.julia;

import ru.julia.staff.Department;
import ru.julia.staff.Organization;
import ru.julia.staff.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.URL;

public class XMLReader {
    public Person readPerson() {
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL resource1 = XMLReader.class.getClassLoader().getResource("person.xml");
            return (Person) unmarshaller.unmarshal(resource1);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Organization readOrganization() {
        try {
            JAXBContext context = JAXBContext.newInstance(Organization.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL resource = XMLReader.class.getClassLoader().getResource("organization.xml");
            Organization organization = (Organization) unmarshaller.unmarshal(resource);
            organization.setManager(readPerson());
            return organization;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Department readDepartment() {
        try {
            JAXBContext context = JAXBContext.newInstance(Department.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL resource = XMLReader.class.getClassLoader().getResource("department.xml");
            Department department = (Department) unmarshaller.unmarshal(resource);
            department.setManager(readPerson());
            return department;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
