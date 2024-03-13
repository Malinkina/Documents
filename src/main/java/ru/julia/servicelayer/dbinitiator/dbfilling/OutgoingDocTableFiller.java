package ru.julia.servicelayer.dbinitiator.dbfilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.servicelayer.DocumentsGenerator;
import ru.julia.document.Document;
import ru.julia.document.OutgoingDocument;
import ru.julia.factory.OutgoingDocumentFactory;
import ru.julia.servicelayer.service.OutgoingDocumentService;
import ru.julia.mapper.OutgoingDocumentMapper;

import java.util.List;

@Component
public class OutgoingDocTableFiller implements TableFiller {
    @Autowired
    private DocumentsGenerator<OutgoingDocumentFactory> generator;
    @Autowired
    private OutgoingDocumentService service;
    @Autowired
    private OutgoingDocumentMapper mapper;

    @Override
    public void fill() {
        List<Document> documents = generator.generateDocuments(OutgoingDocumentFactory.class, 1);
        for (Document document : documents) {
            service.create(
                    mapper.outgoingDocumentToModel((OutgoingDocument) document)
            );
        }
    }
}
