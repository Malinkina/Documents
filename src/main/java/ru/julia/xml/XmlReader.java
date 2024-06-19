package ru.julia.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;
import ru.julia.staff.Department;
import ru.julia.staff.Employee;
import ru.julia.staff.Organization;
import ru.julia.staff.Position;
import ru.julia.xml.xmlmodel.DepartmentXml;
import ru.julia.xml.xmlmodel.EmployeeXml;
import ru.julia.xml.xmlmodel.OrganizationXml;
import ru.julia.xml.xmlmodel.PositionXml;
import ru.julia.xml.xmlmodel.wrapper.DepartmentWrapper;
import ru.julia.xml.xmlmodel.wrapper.EmployeeWrapper;
import ru.julia.xml.xmlmodel.wrapper.OrganizationWrapper;
import ru.julia.xml.xmlmodel.wrapper.PositionWrapper;

import java.net.URL;

/**
 * Читает значения из XML-документов для полей классов {@link Employee}, {@link Department}, {@link Organization}, {@link Position}
 */
@Component
public class XmlReader {
    public EmployeeWrapper readEmployee() {
        try {
            JAXBContext context = JAXBContext.newInstance(EmployeeXml.class, EmployeeWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL resource = XmlReader.class.getClassLoader().getResource("employee.xml");
            EmployeeWrapper employees = (EmployeeWrapper) unmarshaller.unmarshal(resource);
            return employees;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public OrganizationWrapper readOrganization() {
        try {
            JAXBContext context = JAXBContext.newInstance(OrganizationXml.class, OrganizationWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL resource = XmlReader.class.getClassLoader().getResource("organization.xml");
            OrganizationWrapper organizations = (OrganizationWrapper) unmarshaller.unmarshal(resource);
            return organizations;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public DepartmentWrapper readDepartment() {
        try {
            JAXBContext context = JAXBContext.newInstance(DepartmentXml.class, DepartmentWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL resource = XmlReader.class.getClassLoader().getResource("department.xml");
            DepartmentWrapper departments = (DepartmentWrapper) unmarshaller.unmarshal(resource);
            return departments;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
    public PositionWrapper readPosition() {
        try {
            JAXBContext context = JAXBContext.newInstance(PositionXml.class, PositionWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL resource = XmlReader.class.getClassLoader().getResource("position.xml");
            PositionWrapper positions = (PositionWrapper) unmarshaller.unmarshal(resource);
            return positions;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
