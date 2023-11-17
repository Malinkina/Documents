package ru.julia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dao.EmployeeDAO;
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
    EmployeeDAO employeeDAO;
    public void start() throws DocumentExistsException {
        employeeDAO.update("name", "Никита", "8d673582-47ba-41bc-9571-71715a15a85b");
        //databaseInitiation.initialize();
        /*List<Document> documents = documentsGeneration.generateDocuments();
        Map<String, List<Document>> docs = report.reportGeneratedDocuments(documents);
        new Serialization().serialize(docs);
        documentTableFiller.fillDocumentTables(documents);*/
    }
}
