package ru.julia.servicelayer.dbinitiator.dbfilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.document.Document;
import ru.julia.document.IncomingDocument;
import ru.julia.factory.IncomingDocumentFactory;
import ru.julia.mapper.document.incoming.IncomingDocToModelMapper;
import ru.julia.servicelayer.DocumentsGenerator;
import ru.julia.servicelayer.service.IncomingDocumentService;

import java.util.List;

@Component
public class IncomingDocTableFiller implements TableFiller {
    @Autowired
    private DocumentsGenerator generator;
    @Autowired
    private IncomingDocumentService service;
    @Autowired
    private IncomingDocToModelMapper mapper;

    @Override
    public void fill() {
        List<Document> documents = generator.generateDocuments(IncomingDocumentFactory.class, 1);
        documents.forEach(document -> service.create(mapper.toModel((IncomingDocument) document)));
    }
}
