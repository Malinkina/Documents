package ru.julia.mapper.organization;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.servicelayer.model.OrganizationModel;
import ru.julia.xml.xmlmodel.OrganizationXml;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationXmlModelMapperTest {
    private static final OrganizationXmlModelMapper MAPPER = Mappers.getMapper(OrganizationXmlModelMapper.class);
    private static final UUID ID = UUID.fromString("5d634023-d092-4cca-bab2-7df2d357fad4");
    private static final String FULL_NAME = "Organization";
    private static final String SHORT_NAME = "Org";
    private static final String MANAGER = "Manager";
    private static final List<String> PHONE_NUMBERS = List.of("+7451361, +7845145454");

    @Test
    void toModel() {
        OrganizationXml xml = new OrganizationXml();
        xml.setId(ID);
        xml.setFullName(FULL_NAME);
        xml.setShortName(SHORT_NAME);
        xml.setManager(MANAGER);
        xml.setPhoneNumbers(PHONE_NUMBERS);
        OrganizationModel model = MAPPER.toModel(xml);
        assertEquals(ID, model.getId());
        assertEquals(FULL_NAME, model.getFullName());
        assertEquals(SHORT_NAME, model.getShortName());
        assertEquals(MANAGER, model.getManager());
        assertEquals(PHONE_NUMBERS, model.getPhoneNumbers());
    }
}