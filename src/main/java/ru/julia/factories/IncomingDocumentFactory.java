package ru.julia.factories;

import ru.julia.builders.IncomingDocumentBuilder;
import ru.julia.documents.IncomingDocument;

public class IncomingDocumentFactory implements DocumentFactory {
    IncomingDocumentBuilder incomingDocumentBuilder = new IncomingDocumentBuilder();
    public IncomingDocument create() {
        IncomingDocument incomingDocument = new IncomingDocument();
        incomingDocumentBuilder.build(incomingDocument);
        return incomingDocument;
    }
}
