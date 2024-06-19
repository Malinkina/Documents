package ru.julia.servicelayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.document.Document;
import ru.julia.exception.DocumentExistsException;
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

    /**
     * Метод генерирует документы и передает в хранилище {@link RegNumbersStorage}
     */
    public List<Document> generateDocuments(Class<T> factoryType, int quantity) {
        DocumentFactory<?> factory = getFactory(factoryType);
        List<Document> documents = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Document document = factory.create();
            try {
                RegNumbersStorage.add(document.getRegNumber());
            } catch (DocumentExistsException e) {
                throw new RuntimeException(
                        "Document with registration number " + document.getRegNumber() + " already exists"
                );
            }
            documents.add(document);
        }
        return documents;
    }

    private DocumentFactory<?> getFactory(Class<T> factoryType) {
        for (DocumentFactory<?> documentFactory : factories) {
            if (documentFactory.getClass() == factoryType) {
                return factories.get(factories.indexOf(documentFactory));
            }
        }
        throw new RuntimeException("No such factory with name " + factoryType);
    }
}



