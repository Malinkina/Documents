package ru.julia.servicelayer.dbinitiator.dbfilling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.julia.document.Document;
import ru.julia.document.IncomingDocument;
import ru.julia.factory.IncomingDocumentFactory;
import ru.julia.mapper.document.incoming.IncomingDocToModelMapper;
import ru.julia.servicelayer.DocumentsGenerator;
import ru.julia.servicelayer.model.IncomingDocModel;
import ru.julia.servicelayer.service.IncomingDocumentService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IncomingDocTableFillerTest {
    @InjectMocks
    private IncomingDocTableFiller tableFiller;
    @Mock
    private DocumentsGenerator generator;
    @Mock
    private IncomingDocumentService service;
    @Mock
    private IncomingDocToModelMapper mapper;

    @Test
    void fill() {
        List<Document> documents = new ArrayList<>();
        IncomingDocument document = new IncomingDocument.IncomingDocumentBuilder().build();
        documents.add(document);
        when(generator.generateDocuments(IncomingDocumentFactory.class, 1)).thenReturn(documents);
        IncomingDocModel model = new IncomingDocModel();
        when(mapper.toModel(document)).thenReturn(model);
        tableFiller.fill();
        verify(generator, times(1)).generateDocuments(IncomingDocumentFactory.class, 1);
        verify(mapper, times(documents.size())).toModel(document);
        verify(service, times(documents.size())).create(model);
    }
}