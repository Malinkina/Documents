package ru.julia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.documents.Document;

import java.util.List;
import java.util.Map;
@Component
public class Starter {
    @Autowired
    DocumentsGeneration documentsGeneration;
    @Autowired
    Report report;
    public void start() throws DocumentExistsException {
        List<Document> documents = documentsGeneration.generateDocuments();
        Map<String, List<Document>> docs = report.reportGeneratedDocuments(documents);
        new Serialization().serialize(docs);
    }
}
