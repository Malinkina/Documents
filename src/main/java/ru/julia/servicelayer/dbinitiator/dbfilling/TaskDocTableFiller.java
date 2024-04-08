package ru.julia.servicelayer.dbinitiator.dbfilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.mapper.document.task.TaskDocToModelMapper;
import ru.julia.servicelayer.DocumentsGenerator;
import ru.julia.document.Document;
import ru.julia.document.TaskDocument;
import ru.julia.factory.TaskDocumentFactory;
import ru.julia.servicelayer.service.TaskDocumentService;

import java.util.List;

@Component
public class TaskDocTableFiller implements TableFiller {
    @Autowired
    private DocumentsGenerator generator;
    @Autowired
    private TaskDocumentService service;
    @Autowired
    private TaskDocToModelMapper mapper;

    @Override
    public void fill() {
        List<Document> documents = generator.generateDocuments(TaskDocumentFactory.class, 1);
        documents.forEach(document -> service.create(mapper.toModel((TaskDocument) document)));
    }
}
