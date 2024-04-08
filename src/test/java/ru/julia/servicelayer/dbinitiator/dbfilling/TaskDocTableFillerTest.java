package ru.julia.servicelayer.dbinitiator.dbfilling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.julia.document.Document;
import ru.julia.document.TaskDocument;
import ru.julia.factory.TaskDocumentFactory;
import ru.julia.mapper.document.task.TaskDocToModelMapper;
import ru.julia.servicelayer.DocumentsGenerator;
import ru.julia.servicelayer.model.TaskDocModel;
import ru.julia.servicelayer.service.TaskDocumentService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskDocTableFillerTest {
    @InjectMocks
    private TaskDocTableFiller tableFiller;
    @Mock
    private DocumentsGenerator generator;
    @Mock
    private TaskDocumentService service;
    @Mock
    private TaskDocToModelMapper mapper;

    @Test
    void fill() {
        List<Document> documents = new ArrayList<>();
        TaskDocument document = new TaskDocument.TaskDocumentBuilder().build();
        documents.add(document);
        when(generator.generateDocuments(TaskDocumentFactory.class, 1)).thenReturn(documents);
        TaskDocModel model = new TaskDocModel();
        when(mapper.toModel(document)).thenReturn(model);
        tableFiller.fill();
        verify(generator, times(1)).generateDocuments(TaskDocumentFactory.class, 1);
        verify(mapper, times(documents.size())).toModel(document);
        verify(service, times(documents.size())).create(model);
    }
}