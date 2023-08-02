package ru.julia;

public class Report {
    DocumentGeneration documentGeneration = new DocumentGeneration();

    public void reportGeneratedDocs() {
    documentGeneration.generateDocuments();
    documentGeneration.convertListToMap(documentGeneration.documents);
        System.out.println(documentGeneration.authorAndDocument);
    }
}
