package ru.julia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.document.Document;
import ru.julia.factory.AbstractDocumentFactory;
import ru.julia.factory.DocumentFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс генерирует документы
 */
@Component
public class DocumentsGenerator<T extends AbstractDocumentFactory> {
    @Autowired
    private List<DocumentFactory<?>> factories;
    @Autowired
    private RegNumbersStorage regNumbersStorage;

    /**
     * Метод генерирует документы и передает в хранилище {@link RegNumbersStorage}
     */
    public List<Document> generateDocuments(DocumentFactory factoryType, int quantity) throws DocumentExistsException {
        List<Document> documents = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            DocumentFactory<?> factory = factories.get(factories.indexOf(factoryType));
            Document document = factory.create();
            regNumbersStorage.add(document);
            documents.add(document);
        }
        return documents;

        /*for (int i = 0; i < (int) (Math.random() * 20 + 1); i++) {
            DocumentFactory<?> factory = factories.get((int) (Math.random() * 3));
            Document document = factory.create();
            regNumbersStorage.add(document);
            documents.add(document);
        }
        return documents;*/
    }
}


