
package ru.julia.servicelayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.julia.document.Document;
import ru.julia.document.IncomingDocument;
import ru.julia.document.OutgoingDocument;
import ru.julia.document.TaskDocument;
import ru.julia.exception.DocumentExistsException;
import ru.julia.factory.DocumentFactory;
import ru.julia.factory.IncomingDocumentFactory;
import ru.julia.factory.OutgoingDocumentFactory;
import ru.julia.factory.TaskDocumentFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DocumentsGeneratorTest {
    public static final String REG_NUMBER = "qaaqws";
    public static final Class<IncomingDocumentFactory> INCOMING_DOC_FACTORY_TYPE = IncomingDocumentFactory.class;
    public static final Class<OutgoingDocumentFactory> OUTGOING_DOC_FACTORY_TYPE = OutgoingDocumentFactory.class;
    public static final Class<TaskDocumentFactory> TASK_DOC_FACTORY_TYPE = TaskDocumentFactory.class;
    @InjectMocks
    private DocumentsGenerator generator;
    @Mock
    private IncomingDocumentFactory incomingDocumentFactory;
    @Mock
    private OutgoingDocumentFactory outgoingDocumentFactory;
    @Mock
    private TaskDocumentFactory taskDocumentFactory;
    @Spy
    private List<DocumentFactory<?>> factories = new ArrayList<>();
    @Mock
    private RegNumbersStorage storage;
    public static final int QUANTITY = 1;

    @BeforeEach
    public void init() {
        factories.add(incomingDocumentFactory);
        factories.add(outgoingDocumentFactory);
        factories.add(taskDocumentFactory);
    }

    @Test
    void generateIncomingDocuments() throws DocumentExistsException {
        //GIVEN
        IncomingDocument document = new IncomingDocument.IncomingDocumentBuilder().regNumber(REG_NUMBER).build();
        when(incomingDocumentFactory.create()).thenReturn(document);
        //WHEN
        List<Document> actual = generator.generateDocuments(INCOMING_DOC_FACTORY_TYPE, QUANTITY);
        //THEN
        verify(factories, times(1)).indexOf(incomingDocumentFactory);
        verify(factories, times(1)).get(0);
        verify(incomingDocumentFactory, times(QUANTITY)).create();
        verify(storage, times(1)).add(REG_NUMBER);
        IncomingDocument expectedDoc = new IncomingDocument.IncomingDocumentBuilder().regNumber(REG_NUMBER).build();
        List<Document> expectedList = List.of(expectedDoc);
        assertEquals(expectedList, actual);
    }

    @Test
    void generateOutgoingDocuments() throws DocumentExistsException {
        //GIVEN
        OutgoingDocument document = new OutgoingDocument.OutgoingDocumentBuilder().regNumber(REG_NUMBER).build();
        when(outgoingDocumentFactory.create()).thenReturn(document);
        //WHEN
        List<Document> actual = generator.generateDocuments(OUTGOING_DOC_FACTORY_TYPE, QUANTITY);
        //THEN
        verify(factories, times(1)).indexOf(outgoingDocumentFactory);
        verify(factories, times(1)).get(1);
        verify(outgoingDocumentFactory, times(QUANTITY)).create();
        verify(storage, times(1)).add(REG_NUMBER);
        OutgoingDocument expectedDoc = new OutgoingDocument.OutgoingDocumentBuilder().regNumber(REG_NUMBER).build();
        List<Document> expectedList = List.of(expectedDoc);
        assertEquals(expectedList, actual);
    }

    @Test
    void generateTaskDocuments() throws DocumentExistsException {
        //GIVEN
        TaskDocument document = new TaskDocument.TaskDocumentBuilder().regNumber(REG_NUMBER).build();
        when(taskDocumentFactory.create()).thenReturn(document);
        //WHEN
        List<Document> actual = generator.generateDocuments(TASK_DOC_FACTORY_TYPE, QUANTITY);
        //THEN
        verify(factories, times(1)).indexOf(taskDocumentFactory);
        verify(factories, times(1)).get(2);
        verify(taskDocumentFactory, times(QUANTITY)).create();
        verify(storage, times(1)).add(REG_NUMBER);
        TaskDocument expectedDoc = new TaskDocument.TaskDocumentBuilder().regNumber(REG_NUMBER).build();
        List<Document> expectedList = List.of(expectedDoc);
        assertEquals(expectedList, actual);
    }

    @Test
    void regNumberAlreadyExists() throws DocumentExistsException {
        //GIVEN
        doThrow(new DocumentExistsException()).when(storage).add(REG_NUMBER);
        IncomingDocument document = new IncomingDocument.IncomingDocumentBuilder().regNumber(REG_NUMBER).build();
        when(incomingDocumentFactory.create()).thenReturn(document);
        //WHEN & THEN
        assertThrows(RuntimeException.class, () -> generator.generateDocuments(INCOMING_DOC_FACTORY_TYPE, QUANTITY));
    }

    @Test
    void wrongFactoryType() {
        //WHEN
        Class<IncomingDocument> wrongFactoryType = IncomingDocument.class;
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> generator.generateDocuments(wrongFactoryType, QUANTITY));
        String actualErrorMessage = runtimeException.getMessage();
        //THEN
        String expectedErrorMessage = "No such factory with name %s".formatted(wrongFactoryType);
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    void zeroQuantity() {
        //GIVEN
        int zeroQuantity = 0;
        //WHEN
        List<Document> actual = generator.generateDocuments(INCOMING_DOC_FACTORY_TYPE, zeroQuantity);
        //THEN
        List<Document> expected = List.of();
        verify(incomingDocumentFactory, times(zeroQuantity)).create();
        assertEquals(expected, actual);
    }
}