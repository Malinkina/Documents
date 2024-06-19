package ru.julia.servicelayer.dbinitiator.dbfilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.document.Document;
import ru.julia.document.OutgoingDocument;
import ru.julia.factory.OutgoingDocumentFactory;
import ru.julia.mapper.document.outgoing.OutgoingDocToModelMapper;
import ru.julia.servicelayer.DocumentsGenerator;
import ru.julia.servicelayer.service.OutgoingDocumentService;

import java.util.List;

@Component
public class OutgoingDocTableFiller implements TableFiller {
    @Autowired
    private DocumentsGenerator generator;
    @Autowired
    private OutgoingDocumentService service;
    @Autowired
    private OutgoingDocToModelMapper mapper;

    @Override
    public void fill() {
        List<Document> documents = generator.generateDocuments(OutgoingDocumentFactory.class, 1);
        documents.forEach(document -> service.create(mapper.toModel((OutgoingDocument) document)));
    }
}
