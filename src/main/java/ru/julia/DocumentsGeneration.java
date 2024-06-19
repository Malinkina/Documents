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

    /**
     * Метод генерирует документы и передает в хранилище {@link RegNumbersStorage}
     */
    public List<Document> generateDocuments() throws DocumentExistsException {
        List<Document> documents = new ArrayList<>();
        for (int i = 0; i < (int) (Math.random() * 20 + 1); i++) {
            DocumentFactory factory = FACTORIES.get((int) (Math.random() * 3));
            Document document = factory.create();
            if (!RegNumbersStorage.getRegNumbers().contains(document.getRegNumber())) {
                RegNumbersStorage.getRegNumbers().add(document.getRegNumber());
                documents.add(document);
            } else {
                throw new DocumentExistsException();
            }
        }
        return documents;
    }
}


