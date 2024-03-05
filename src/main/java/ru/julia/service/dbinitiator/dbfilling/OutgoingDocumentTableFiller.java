package ru.julia.service.dbinitiator.dbfilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.DocumentsGenerator;
import ru.julia.document.Document;
import ru.julia.document.OutgoingDocument;
import ru.julia.factory.OutgoingDocumentFactory;
import ru.julia.service.OutgoingDocumentService;
import ru.julia.service.mapper.OutgoingDocumentMapper;

import java.util.List;

@Component
public class OutgoingDocumentTableFiller implements TableFiller {
    @Autowired
    private DocumentsGenerator<OutgoingDocumentFactory> generator;
    @Autowired
    private OutgoingDocumentService service;
    @Autowired
    private OutgoingDocumentMapper mapper;

    @Override
    public void fill() {
        List<Document> documents = generator.generateDocuments(OutgoingDocumentFactory.class, 5);
        for (Document document : documents) {
            service.create(
                    mapper.outgoingDocumentToOutgoingDocumentModel((OutgoingDocument) document)
            );
        }
    }
}
