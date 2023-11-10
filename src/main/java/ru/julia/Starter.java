package ru.julia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dao.IncomingDocumentDAO;
import ru.julia.dbconfiguration.DatabaseInitiator;
import ru.julia.dbconfiguration.DocumentTableFiller;

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
    IncomingDocumentDAO incomingDocumentDAO;
    public void start() throws DocumentExistsException {
        System.out.println(incomingDocumentDAO.getById("c7ac9e5c-39d0-4b03-9033-79b27e5cbec8").getOutgoingNumber());
        //databaseInitiation.initialize();
        /*List<Document> documents = documentsGeneration.generateDocuments();
        Map<String, List<Document>> docs = report.reportGeneratedDocuments(documents);
        new Serialization().serialize(docs);
        documentTableFiller.fillDocumentTables(documents);*/
    }
}
