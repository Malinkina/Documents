package ru.julia.service.dbinitiator.dbfilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.DocumentExistsException;
import ru.julia.DocumentsGenerator;
import ru.julia.document.Document;
import ru.julia.document.OutgoingDocument;
import ru.julia.factory.OutgoingDocumentFactory;
import ru.julia.service.DocumentService;
import ru.julia.service.OutgoingDocumentService;
import ru.julia.service.mapper.DocumentMapper;
import ru.julia.service.mapper.OutgoingDocumentMapper;

import java.util.List;

@Component
public class OutgoingDocumentTableFiller implements TableFiller {
    @Autowired
    private OutgoingDocumentFactory outgoingDocumentFactory;
    @Autowired
    private DocumentsGenerator<OutgoingDocumentFactory> generator;
    @Autowired
    private OutgoingDocumentService outgoingDocumentService;
    @Autowired
    private OutgoingDocumentMapper outgoingDocumentMapper;
    @Autowired
    private DocumentService documentService;
    @Autowired
    private DocumentMapper documentMapper;

    @Override
    public void fill() {
        List<Document> documents;
        try {
            documents = generator.generateDocuments(outgoingDocumentFactory, 5);
            for (Document document : documents) {
                documentService.create(documentMapper.documentToDocumentModel(document));
                outgoingDocumentService.create(
                        outgoingDocumentMapper.outgoingDocumentToOutgoingDocumentModel((OutgoingDocument) document)
                );
            }
        } catch (DocumentExistsException e) {
            throw new RuntimeException(e);
        }
    }
}
