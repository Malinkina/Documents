package ru.julia.mapper.document.outgoing;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.document.OutgoingDocument;
import ru.julia.servicelayer.model.OutgoingDocModel;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutgoingDocToModelMapperTest {
    private static final OutgoingDocToModelMapper MAPPER = Mappers.getMapper(OutgoingDocToModelMapper.class);
    public static final EmployeeXml EMPLOYEE = new EmployeeXml();
    private static final UUID ID = UUID.fromString("fee705e5-5753-48cc-8b18-9f2804ad5208");
    private static final Integer DOC_ID = 456;
    private static final String NAME = "Name";
    private static final String TEXT = "Text";
    private static final LocalDate REG_DATE = LocalDate.now();
    private static final String REG_NUMBER = "regNumber";
    private static final String DELIVERY_TYPE = "deliveryType";
    @Test
    void toModel() {
        EMPLOYEE.setId(ID);
        OutgoingDocument document = new OutgoingDocument.OutgoingDocumentBuilder()
                .documentId(DOC_ID)
                .name(NAME)
                .text(TEXT)
                .regDate(REG_DATE)
                .regNumber(REG_NUMBER)
                .author(EMPLOYEE)
                .recipient(EMPLOYEE)
                .deliveryType(DELIVERY_TYPE)
                .build();
        OutgoingDocModel model = MAPPER.toModel(document);
        assertEquals(DOC_ID, model.getDocId());
        assertEquals(NAME, model.getName());
        assertEquals(TEXT, model.getText());
        assertEquals(REG_DATE, model.getRegDate());
        assertEquals(REG_NUMBER, model.getRegNumber());
        assertEquals(EMPLOYEE.getId(), model.getAuthorId());
        assertEquals(DELIVERY_TYPE, model.getDeliveryType());
        assertEquals(EMPLOYEE.getId(), model.getRecipientId());
    }

    @Test
    void mapEmployee() {
        EmployeeXml employeeXml = new EmployeeXml();
        employeeXml.setId(ID);
        UUID id = MAPPER.mapEmployee(employeeXml);
        assertEquals(id, employeeXml.getId());
    }
}