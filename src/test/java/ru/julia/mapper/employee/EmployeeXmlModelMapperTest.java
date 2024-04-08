package ru.julia.mapper.employee;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.servicelayer.model.EmployeeModel;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeXmlModelMapperTest {
    private static final EmployeeXmlModelMapper MAPPER = Mappers.getMapper(EmployeeXmlModelMapper.class);
    private static final UUID ID = UUID.fromString("4e91e9c6-e8dc-46d9-beed-05b55daf2969");
    private static final String SURNAME = "Ivanov";
    private static final String NAME = "Ivan";
    private static final String PATRONYMIC = "Ivanovich";
    private static final String PHOTO = "Photo";
    private static final String DATE_OF_BIRTH = "01.01.1990";
    private static final String PHONE_NUMBER = "+799999999";
    private static final UUID DEPARTMENT_ID = UUID.fromString("fa140557-ebae-4ee8-94c3-10673025da5e");
    private static final UUID ORGANIZATION_ID = UUID.fromString("dbff19cd-7311-4ebf-ba76-613d7aed5945");
    private static final UUID POSITION_ID = UUID.fromString("8e5aecac-12c1-4bee-8ba0-1d3422663561");

    @Test
    void toModel() {
        EmployeeXml xml = new EmployeeXml();
        xml.setId(ID);
        xml.setSurname(SURNAME);
        xml.setName(NAME);
        xml.setPatronymic(PATRONYMIC);
        xml.setPhoto(PHOTO);
        xml.setDateOfBirth(DATE_OF_BIRTH);
        xml.setPhoneNumber(PHONE_NUMBER);
        xml.setDepartmentId(DEPARTMENT_ID);
        xml.setOrganizationId(ORGANIZATION_ID);
        xml.setPositionId(POSITION_ID);
        EmployeeModel model = MAPPER.toModel(xml);
        assertEquals(ID, model.getId());
        assertEquals(SURNAME, model.getSurname());
        assertEquals(NAME, model.getName());
        assertEquals(PATRONYMIC, model.getPatronymic());
        assertEquals(PHOTO, model.getPhoto());
        assertEquals(DATE_OF_BIRTH, model.getDateOfBirth());
        assertEquals(PHONE_NUMBER, model.getPhoneNumber());
        assertEquals(DEPARTMENT_ID, model.getDepartmentId());
        assertEquals(ORGANIZATION_ID, model.getOrganizationId());
        assertEquals(POSITION_ID, model.getPositionId());
    }
}