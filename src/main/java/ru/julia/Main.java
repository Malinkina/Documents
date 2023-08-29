package ru.julia;

import ru.julia.documents.Document;

import java.util.List;

public class Main {
    public static void main(String[] args) throws DocumentExistsException {
        List<Document> documents = new DocumentsGeneration().generateDocuments();
        List<Document> documents1 = new DocumentsGeneration().generateDocuments();
        documents.addAll(documents1);
        Report.getInstance().reportGeneratedDocs(documents);
    }
}
