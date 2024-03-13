package ru.julia.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;
import ru.julia.staff.*;
import ru.julia.xml.xmlmodel.*;

import java.net.URL;

/**
 * Читает значения из XML-документов для полей классов {@link Employee}, {@link Department}, {@link Organization}, {@link Position}
 */
@Component
public class XmlReader {
    public OrgUnits readEmployee() {
        try {
            JAXBContext context = JAXBContext.newInstance(EmployeeXml.class, OrgUnits.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL resource = XmlReader.class.getClassLoader().getResource("employee.xml");
            OrgUnits employees = (OrgUnits) unmarshaller.unmarshal(resource);
            return employees;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public OrgUnits readOrganization() {
        try {
            JAXBContext context = JAXBContext.newInstance(OrganizationXml.class, OrgUnits.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL resource = XmlReader.class.getClassLoader().getResource("organization.xml");
            OrgUnits organizations = (OrgUnits) unmarshaller.unmarshal(resource);
            return organizations;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public OrgUnits readDepartment() {
        try {
            JAXBContext context = JAXBContext.newInstance(DepartmentXml.class, OrgUnits.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL resource = XmlReader.class.getClassLoader().getResource("department.xml");
            OrgUnits departments = (OrgUnits) unmarshaller.unmarshal(resource);
            return departments;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
    public OrgUnits readPosition() {
        try {
            JAXBContext context = JAXBContext.newInstance(PositionXml.class, OrgUnits.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL resource = XmlReader.class.getClassLoader().getResource("position.xml");
            OrgUnits positions = (OrgUnits) unmarshaller.unmarshal(resource);
            return positions;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
