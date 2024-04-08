package ru.julia.servicelayer.dbinitiator.dbfilling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.julia.document.Document;
import ru.julia.document.OutgoingDocument;
import ru.julia.factory.OutgoingDocumentFactory;
import ru.julia.mapper.document.outgoing.OutgoingDocToModelMapper;
import ru.julia.servicelayer.DocumentsGenerator;
import ru.julia.servicelayer.model.OutgoingDocModel;
import ru.julia.servicelayer.service.OutgoingDocumentService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OutgoingDocTableFillerTest {
    @InjectMocks
    private OutgoingDocTableFiller tableFiller;
    @Mock
    private DocumentsGenerator generator;
    @Mock
    private OutgoingDocumentService service;
    @Mock
    private OutgoingDocToModelMapper mapper;

    @Test
    void fill() {
        List<Document> documents = new ArrayList<>();
        OutgoingDocument document = new OutgoingDocument.OutgoingDocumentBuilder().build();
        documents.add(document);
        when(generator.generateDocuments(OutgoingDocumentFactory.class, 1)).thenReturn(documents);
        OutgoingDocModel model = new OutgoingDocModel();
        when(mapper.toModel(document)).thenReturn(model);
        tableFiller.fill();
        verify(generator, times(1)).generateDocuments(OutgoingDocumentFactory.class, 1);
        verify(mapper, times(documents.size())).toModel(document);
        verify(service, times(documents.size())).create(model);
    }
}