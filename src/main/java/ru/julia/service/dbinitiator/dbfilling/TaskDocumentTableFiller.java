package ru.julia.service.dbinitiator.dbfilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.DocumentsGenerator;
import ru.julia.document.Document;
import ru.julia.document.TaskDocument;
import ru.julia.factory.TaskDocumentFactory;
import ru.julia.service.TaskDocumentService;
import ru.julia.service.mapper.TaskDocumentMapper;

import java.util.List;

@Component
public class TaskDocumentTableFiller implements TableFiller {
    @Autowired
    private DocumentsGenerator<TaskDocumentFactory> generator;
    @Autowired
    private TaskDocumentService service;
    @Autowired
    private TaskDocumentMapper mapper;

    @Override
    public void fill() {
        List<Document> documents = generator.generateDocuments(TaskDocumentFactory.class, 2);
        for (Document document : documents) {
            service.create(
                    mapper.taskDocumentToTaskDocumentModel((TaskDocument) document)
            );
        }
    }
}
