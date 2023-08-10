package ru.julia.builders;


import ru.julia.factories.IncomingDocumentFactory;
import ru.julia.documents.IncomingDocument;

public class IncomingDocumentBuilder extends DocumentBuilder {
    String sender;
    String recipient;
    int outgoingNumber;
    String outgoingRegDate;
    private IncomingDocumentBuilder sender() {
        this.sender = IncomingDocumentFactory.generateSender();
        return this;
    }
    private IncomingDocumentBuilder recipient() {
        this.recipient = IncomingDocumentFactory.generateRecipient();
        return this;
    }
    private IncomingDocumentBuilder outgoingNumber() {
        this.outgoingNumber = IncomingDocumentFactory.generateOutgoingNumber();
        return this;
    }
    private IncomingDocumentBuilder outgoingRegDate() {
        this.outgoingRegDate = IncomingDocumentFactory.generateRegDate();
        return this;
    }
    public void build(IncomingDocument document) {
        super.build(document);
        sender();
        recipient();
        outgoingNumber();
        outgoingRegDate();
        document.setSender(this.sender);
        document.setRecipient(this.recipient);
        document.setOutgoingNumber(this.outgoingNumber);
        document.setOutgoingRegDate(this.outgoingRegDate);
    }
}
