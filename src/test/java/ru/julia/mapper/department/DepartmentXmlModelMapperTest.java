package ru.julia.mapper.department;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.servicelayer.model.DepartmentModel;
import ru.julia.xml.xmlmodel.DepartmentXml;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DepartmentXmlModelMapperTest {
    private static final DepartmentXmlModelMapper MAPPER = Mappers.getMapper(DepartmentXmlModelMapper.class);
    private static final UUID ID = UUID.fromString("5d634023-d092-4cca-bab2-7df2d357fad4");
    private static final String FULL_NAME = "Department";
    private static final String SHORT_NAME = "Dep";
    private static final String MANAGER = "Manager";
    private static final List<String> PHONE_NUMBERS = List.of("+7451361, +7845145454");
    private static final UUID ORGANIZATION_ID = UUID.fromString("75ddd782-3337-4d0b-b75f-c4665a473cbf");

    @Test
    void toModel() {
        DepartmentXml xml = new DepartmentXml();
        xml.setId(ID);
        xml.setFullName(FULL_NAME);
        xml.setShortName(SHORT_NAME);
        xml.setManager(MANAGER);
        xml.setPhoneNumbers(PHONE_NUMBERS);
        xml.setOrganizationId(ORGANIZATION_ID);
        DepartmentModel model = MAPPER.toModel(xml);
        assertEquals(ID, model.getId());
        assertEquals(FULL_NAME, model.getFullName());
        assertEquals(SHORT_NAME, model.getShortName());
        assertEquals(MANAGER, model.getManager());
        assertEquals(PHONE_NUMBERS, model.getPhoneNumbers());
        assertEquals(ORGANIZATION_ID, model.getOrganizationId());
    }
}