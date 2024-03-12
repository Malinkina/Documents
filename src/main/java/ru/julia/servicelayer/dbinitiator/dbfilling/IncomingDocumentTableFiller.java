package ru.julia.servicelayer.dbinitiator.dbfilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.servicelayer.DocumentsGenerator;
import ru.julia.document.Document;
import ru.julia.document.IncomingDocument;
import ru.julia.factory.IncomingDocumentFactory;
import ru.julia.servicelayer.service.IncomingDocumentService;
import ru.julia.mapper.IncomingDocumentMapper;

import java.util.List;

@Component
public class IncomingDocumentTableFiller implements TableFiller {
    @Autowired
    private DocumentsGenerator<IncomingDocumentFactory> generator;
    @Autowired
    private IncomingDocumentService service;
    @Autowired
    private IncomingDocumentMapper mapper;

    @Override
    public void fill() {
        List<Document> documents = generator.generateDocuments(IncomingDocumentFactory.class, 3);
        for (Document document : documents) {
            service.create(
                    mapper.incomingDocumentToModel((IncomingDocument) document)
            );
        }
    }
}
