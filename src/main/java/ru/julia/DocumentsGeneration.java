package ru.julia;

import ru.julia.documents.Document;
import ru.julia.factories.DocumentFactory;
import ru.julia.factories.IncomingDocumentFactory;
import ru.julia.factories.OutgoingDocumentFactory;
import ru.julia.factories.TaskDocumentFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс генерирует документы
 */
public class DocumentsGeneration {
    private final static List<DocumentFactory> FACTORIES = Arrays.asList(
            new OutgoingDocumentFactory(),
            new TaskDocumentFactory(),
            new IncomingDocumentFactory());
    private static volatile DocumentsGeneration instance;

    private DocumentsGeneration() {
    }

    public static DocumentsGeneration getInstance() {
        if (instance == null) {
            synchronized (DocumentsGeneration.class) {
                if (instance == null) {
                    instance = new DocumentsGeneration();
                }
            }
        }
        return instance;
    }

    /**
     * Метод генерирует документы и передает в хранилище {@link RegNumbersStorage}
     */
    public List<Document> generateDocuments() throws DocumentExistsException {
        List<Document> documents = new ArrayList<>();
        for (int i = 0; i < (int) (Math.random() * 20 + 1); i++) {
            DocumentFactory factory = FACTORIES.get((int) (Math.random() * 3));
            Document document = factory.create();
            if (!RegNumbersStorage.getInstance().getRegNumbers().contains(document.getRegNumber())) {
                RegNumbersStorage.getInstance().getRegNumbers().add(document.getRegNumber());
                documents.add(document);
            } else {
                throw new DocumentExistsException();
            }
        }
        return documents;
    }
}


