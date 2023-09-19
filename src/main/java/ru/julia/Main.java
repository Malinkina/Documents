package ru.julia;

import ru.julia.documents.Document;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws DocumentExistsException {
        List<Document> documents = new DocumentsGeneration().generateDocuments();
        Map<String, List<Document>> docs = Report.getInstance().reportGeneratedDocuments(documents);
        new Serialization().serialize(docs);
    }
}
