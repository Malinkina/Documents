package ru.julia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.service.dbinitiator.DatabaseInitiator;

@Component
public class Starter {
    @Autowired
    private DocumentsGeneration documentsGeneration;
    @Autowired
    private Report report;
    @Autowired
    private DatabaseInitiator databaseInitiator;
    public void start() throws DocumentExistsException {
        databaseInitiator.initialize();
        /*List<Document> documents = documentsGeneration.generateDocuments();
        Map<String, List<Document>> docs = report.reportGeneratedDocuments(documents);
        new Serialization().serialize(docs);*/
    }
}
