package ru.julia;

import ru.julia.documents.Document;

import java.util.List;

public class Main {
    public static void main(String[] args) throws DocumentExistsException {
        List<Document> documents = new DocumentsGeneration().generateDocuments();
        Report.getInstance().reportGeneratedDocuments(documents);
    }
}
