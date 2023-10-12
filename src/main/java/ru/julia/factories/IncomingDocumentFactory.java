package ru.julia.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.documents.IncomingDocument;
import ru.julia.infogenerators.DocumentInfoGenerator;
import ru.julia.infogenerators.IncomingDocumentInfoGenerator;

/**
 * Класс создает объект класса {@link IncomingDocument}
 */
@Component
public class IncomingDocumentFactory implements DocumentFactory {
    @Autowired
    DocumentInfoGenerator documentInfoGenerator;
    @Autowired
    IncomingDocumentInfoGenerator incomingDocumentInfoGenerator;

    public IncomingDocument create() {
        return new IncomingDocument.IncomingDocumentBuilder()
                .id(documentInfoGenerator.generateId())
                .name(documentInfoGenerator.generateName())
                .text(documentInfoGenerator.generateText())
                .regNumber(documentInfoGenerator.generateRegNumber())
                .regDate(documentInfoGenerator.generateRegDate())
                .author(documentInfoGenerator.generateAuthor())
                .sender(incomingDocumentInfoGenerator.generateSender())
                .recipient(incomingDocumentInfoGenerator.generateRecipient())
                .outgoingNumber(incomingDocumentInfoGenerator.generateOutgoingNumber())
                .outgoingRegDate(incomingDocumentInfoGenerator.generateRegDate())
                .build();
    }
}