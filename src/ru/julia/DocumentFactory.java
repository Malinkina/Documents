package ru.julia;

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
