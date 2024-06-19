package ru.julia.mapper.document.incoming;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.julia.document.IncomingDocument;
import ru.julia.servicelayer.model.IncomingDocModel;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
class IncomingDocToModelMapperTest {
    private static final IncomingDocToModelMapper MAPPER = Mappers.getMapper(IncomingDocToModelMapper.class);
    public static final EmployeeXml EMPLOYEE = new EmployeeXml();
    private static final UUID ID = UUID.fromString("fee705e5-5753-48cc-8b18-9f2804ad5208");
    private static final Integer DOC_ID = 456;
    private static final String NAME = "Name";
    private static final String TEXT = "Text";
    private static final LocalDate REG_DATE = LocalDate.now();
    private static final String REG_NUMBER = "reg_number";
    public static final Integer OUTGOING_NUMBER = 123;
    public static final LocalDate OUTGOING_REG_DATE = LocalDate.now();


    @Test
    void toModel() {
        EMPLOYEE.setId(ID);
        IncomingDocument document = new IncomingDocument.IncomingDocumentBuilder()
                .documentId(DOC_ID)
                .name(NAME)
                .text(TEXT)
                .regDate(REG_DATE)
                .regNumber(REG_NUMBER)
                .author(EMPLOYEE)
                .sender(EMPLOYEE)
                .recipient(EMPLOYEE)
                .outgoingNumber(OUTGOING_NUMBER)
                .outgoingRegDate(OUTGOING_REG_DATE)
                .build();
        IncomingDocModel model = MAPPER.toModel(document);
        assertEquals(DOC_ID, model.getDocId());
        assertEquals(NAME, model.getName());
        assertEquals(TEXT, model.getText());
        assertEquals(REG_DATE, model.getRegDate());
        assertEquals(REG_NUMBER, model.getRegNumber());
        assertEquals(EMPLOYEE.getId(), model.getAuthorId());
        assertEquals(document.getOutgoingNumber(), model.getOutgoingNumber());
        assertEquals(document.getOutgoingRegDate(), model.getOutgoingRegDate());
        assertEquals(EMPLOYEE.getId(), model.getSenderId());
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