package ru.julia.factories;

import ru.julia.XMLReader;
import ru.julia.documents.IncomingDocument;
import ru.julia.infogenerators.DocumentInfoGenerator;
import ru.julia.infogenerators.IncomingDocumentInfoGenerator;

public class IncomingDocumentFactory implements DocumentFactory {
    public IncomingDocument create() {
        return IncomingDocument.newBuilder()
                .id(DocumentInfoGenerator.generateId())
                .name(DocumentInfoGenerator.generateName())
                .text(DocumentInfoGenerator.generateText())
                .regNumber(DocumentInfoGenerator.generateRegNumber())
                .regDate(DocumentInfoGenerator.generateRegDate())
                .author(XMLReader.readPerson())
                .sender(XMLReader.readPerson())
                .recipient(XMLReader.readPerson())
                .outgoingNumber(IncomingDocumentInfoGenerator.generateOutgoingNumber())
                .outgoingRegDate(IncomingDocumentInfoGenerator.generateRegDate())
                .build();
    }
}