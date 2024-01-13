package ru.julia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dao.OrganizationDAO;
import ru.julia.dbconfiguration.DatabaseInitiator;
import ru.julia.dbconfiguration.DocumentTableFiller;
import ru.julia.document.Document;

import java.util.List;
import java.util.Map;

@Component
public class Starter {
    @Autowired
    private DocumentsGeneration documentsGeneration;
    @Autowired
    private Report report;
    @Autowired
    private DatabaseInitiator databaseInitiator;
    @Autowired
    private DocumentTableFiller documentTableFiller;
    @Autowired
    OrganizationDAO organizationDAO;
    public void start() throws DocumentExistsException {
        //databaseInitiation.initialize();
        List<Document> documents = documentsGeneration.generateDocuments();
        Map<String, List<Document>> docs = report.reportGeneratedDocuments(documents);
        new Serialization().serialize(docs);
        documentTableFiller.fillDocumentTables(documents);
    }
}
