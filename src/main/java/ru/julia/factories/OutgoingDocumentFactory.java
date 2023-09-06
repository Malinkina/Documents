package ru.julia.factories;

import ru.julia.XMLReader;
import ru.julia.documents.OutgoingDocument;
import ru.julia.infogenerators.DocumentInfoGenerator;
import ru.julia.infogenerators.OutgoingDocumentInfoGenerator;

public class OutgoingDocumentFactory implements DocumentFactory {
    public OutgoingDocument create() {
        return OutgoingDocument.newBuilder()
                .id(DocumentInfoGenerator.generateId())
                .name(DocumentInfoGenerator.generateName())
                .text(DocumentInfoGenerator.generateText())
                .regNumber(DocumentInfoGenerator.generateRegNumber())
                .regDate(DocumentInfoGenerator.generateRegDate())
                .author(XMLReader.readPerson())
                .recipient(XMLReader.readPerson())
                .deliveryType(OutgoingDocumentInfoGenerator.generateDeliveryType())
                .build();
    }
}
