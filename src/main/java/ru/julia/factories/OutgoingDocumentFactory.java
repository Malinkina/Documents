package ru.julia.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.documents.OutgoingDocument;
import ru.julia.infogenerators.DocumentInfoGenerator;
import ru.julia.infogenerators.OutgoingDocumentInfoGenerator;

/**
 * Класс создает объект класса {@link OutgoingDocument}
 */
@Component
public class OutgoingDocumentFactory implements DocumentFactory {
    @Autowired
    DocumentInfoGenerator documentInfoGenerator;
    @Autowired
    OutgoingDocumentInfoGenerator outgoingDocumentInfoGenerator;

    public OutgoingDocument create() {
        return new OutgoingDocument.OutgoingDocumentBuilder()
                .id(documentInfoGenerator.generateId())
                .name(documentInfoGenerator.generateName())
                .text(documentInfoGenerator.generateText())
                .regNumber(documentInfoGenerator.generateRegNumber())
                .regDate(documentInfoGenerator.generateRegDate())
                .author(documentInfoGenerator.generateAuthor())
                .recipient(outgoingDocumentInfoGenerator.generateRecipient())
                .deliveryType(outgoingDocumentInfoGenerator.generateDeliveryType())
                .build();
    }
}
