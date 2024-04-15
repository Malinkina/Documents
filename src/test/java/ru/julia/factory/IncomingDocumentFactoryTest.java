package ru.julia.factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.julia.document.IncomingDocument;
import ru.julia.infogenerator.DocumentInfoGenerator;
import ru.julia.infogenerator.IncomingDocInfoGenerator;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IncomingDocumentFactoryTest {
    @InjectMocks
    private IncomingDocumentFactory factory;
    @Mock
    private IncomingDocInfoGenerator incomingDocInfoGenerator;
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
        IncomingDocument.IncomingDocumentBuilder builder = factory.createBuilder();
        assertNotNull(builder);
    }

    @Test
    void fill() {
        IncomingDocument.IncomingDocumentBuilder builder = new IncomingDocument.IncomingDocumentBuilder();
        factory.fill(builder);
        verify(incomingDocInfoGenerator, times(1)).generateSender();
        verify(incomingDocInfoGenerator, times(1)).generateRecipient();
        verify(incomingDocInfoGenerator, times(1)).generateOutgoingNumber();
        verify(incomingDocInfoGenerator, times(1)).generateOutgoingRegDate();

    }

    @Test
    void create() {
        //GIVEN
        when(documentInfoGenerator.generateId()).thenReturn(ID);
        when(documentInfoGenerator.generateName()).thenReturn(NAME);
        when(documentInfoGenerator.generateText()).thenReturn(TEXT);
        when(documentInfoGenerator.generateRegNumber()).thenReturn(REG_NUMBER);
        when(documentInfoGenerator.generateRegDate()).thenReturn(REG_DATE);
        when(documentInfoGenerator.generateAuthor()).thenReturn(EMPLOYEE);
        //WHEN
        IncomingDocument actual = factory.create();
        //THEN
        IncomingDocument expected = new IncomingDocument.IncomingDocumentBuilder()
                .documentId(ID)
                .name(NAME)
                .text(TEXT)
                .regNumber(REG_NUMBER)
                .regDate(REG_DATE)
                .author(EMPLOYEE)
                .outgoingNumber(0)
                .build();
        assertEquals(expected, actual);
    }
}