package ru.julia.servicelayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.document.Document;
import ru.julia.exception.DocumentExistsException;
import ru.julia.factory.DocumentFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс генерирует документы
 */
@Component
public final class DocumentsGenerator {
    @Autowired
    private List<DocumentFactory<?>> factories;
    @Autowired
    private RegNumbersCheck storage;

    /**
     * Метод генерирует документы и передает в хранилище {@link RegNumbersCheck}
     */
    public <T> List<Document> generateDocuments(Class<T> factoryType, int quantity) {
        DocumentFactory<?> factory = getFactory(factoryType);
        List<Document> documents = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Document document = factory.create();
            try {
                storage.check(document.getRegNumber());
            } catch (DocumentExistsException e) {
                throw new RuntimeException(
                        "Document with registration number %s already exists".formatted(document.getRegNumber())
                );
            }
            documents.add(document);
        }
        return documents;
    }

    private <T> DocumentFactory<?> getFactory(Class<T> factoryType) {
        for (DocumentFactory<?> documentFactory : factories) {
            if (documentFactory.getClass() == factoryType) {
                return factories.get(factories.indexOf(documentFactory));
            }
        }
        throw new RuntimeException("No such factory with name %s".formatted(factoryType));
    }
}



