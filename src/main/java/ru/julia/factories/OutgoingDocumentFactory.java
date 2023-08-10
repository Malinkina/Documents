package ru.julia.factories;

import ru.julia.builders.OutgoingDocumentBuilder;
import ru.julia.documents.OutgoingDocument;

public class OutgoingDocumentFactory implements DocumentFactory {
    OutgoingDocumentBuilder outgoingDocumentBuilder = new OutgoingDocumentBuilder();
    @Override
    public OutgoingDocument create() {
        OutgoingDocument outgoingDocument = new OutgoingDocument();
        outgoingDocumentBuilder.build(outgoingDocument);
        return outgoingDocument;
    }
}
