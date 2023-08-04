package ru.julia;

import ru.julia.builders.IncomingDocumentBuilder;
import ru.julia.builders.OutgoingDocumentBuilder;
import ru.julia.documents.IncomingDocument;
import ru.julia.documents.OutgoingDocument;
import ru.julia.documents.TaskDocument;
import ru.julia.builders.TaskDocumentBuilder;

public class DocumentFactory {
    OutgoingDocumentBuilder outgoingDocumentBuilder = new OutgoingDocumentBuilder();
    TaskDocumentBuilder taskDocumentBuilder = new TaskDocumentBuilder();
    IncomingDocumentBuilder incomingDocumentBuilder = new IncomingDocumentBuilder();

    public OutgoingDocument createOutgoingDocument() {
        return outgoingDocumentBuilder.build();
    }
    public TaskDocument createTaskDocument() {
        return taskDocumentBuilder.build();
    }
    public IncomingDocument createIncomingDocument() {
        return incomingDocumentBuilder.build();
    }
}
