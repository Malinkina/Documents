package ru.julia.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.julia.document.OutgoingDocument;
import ru.julia.infogenerator.DocumentInfoGenerator;
import ru.julia.infogenerator.OutgoingDocInfoGenerator;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OutgoingDocumentFactoryTest {
    @InjectMocks
    private OutgoingDocumentFactory factory;
    @Mock
    private OutgoingDocInfoGenerator outgoingDocInfoGenerator;
    @Mock
    private DocumentInfoGenerator documentInfoGenerator;
    public static final int ID = 1;
    public static final String NAME = "name";
    public static final String TEXT = "text";
    public static final String REG_NUMBER = "regNumber";
    public static final LocalDate REG_DATE = LocalDate.now();
    public static final EmployeeXml EMPLOYEE = new EmployeeXml();

    @Test
    void createBuilder() {
        OutgoingDocument.OutgoingDocumentBuilder builder = factory.createBuilder();
        Assertions.assertNotNull(builder);
    }

    @Test
    void fill() {
        OutgoingDocument.OutgoingDocumentBuilder builder = new OutgoingDocument.OutgoingDocumentBuilder();
        factory.fill(builder);
        verify(outgoingDocInfoGenerator, times(1)).generateDeliveryType();
        verify(outgoingDocInfoGenerator, times(1)).generateRecipient();
    }

    @Test
    void create() {
        //GIVEN
        OutgoingDocument.OutgoingDocumentBuilder builder = new OutgoingDocument.OutgoingDocumentBuilder();
        when(documentInfoGenerator.generateId()).thenReturn(ID);
        when(documentInfoGenerator.generateName()).thenReturn(NAME);
        when(documentInfoGenerator.generateText()).thenReturn(TEXT);
        when(documentInfoGenerator.generateRegNumber()).thenReturn(REG_NUMBER);
        when(documentInfoGenerator.generateRegDate()).thenReturn(REG_DATE);
        when(documentInfoGenerator.generateAuthor()).thenReturn(EMPLOYEE);
        //WHEN
        OutgoingDocument actual = factory.create();
        //THEN
        OutgoingDocument expected = builder
                .documentId(ID)
                .name(NAME)
                .text(TEXT)
                .regNumber(REG_NUMBER)
                .regDate(REG_DATE)
                .author(EMPLOYEE)
                .build();
        assertEquals(expected, actual);
    }
}