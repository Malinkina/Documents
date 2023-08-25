package ru.julia;

import ru.julia.documents.Document;
import ru.julia.factories.DocumentFactory;
import ru.julia.factories.IncomingDocumentFactory;
import ru.julia.factories.OutgoingDocumentFactory;
import ru.julia.factories.TaskDocumentFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DocumentsGeneration {
    private final List<DocumentFactory> factories = Arrays.asList(
            new OutgoingDocumentFactory(),
            new TaskDocumentFactory(),
            new IncomingDocumentFactory());
    public List<Document> documents = new ArrayList<>();

    public void generateDocuments() throws DocumentExistsException {
        for (int i = 0; i < (int) (Math.random() * 20 + 1); i++) {
            DocumentFactory factory = factories.get((int) (Math.random() * 3));
            Document document = factory.create();
            if (GeneratedDocumentCheck.checkIfDocumentExists(document, documents)) {
                documents.add(document);
            } else {
                throw new DocumentExistsException("Документ с номером " + document.getRegNumber() + " уже существует");
            }
        }
    }
}


