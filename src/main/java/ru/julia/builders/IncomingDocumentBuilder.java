package ru.julia.builders;


import ru.julia.documents.IncomingDocument;
import ru.julia.infogenerators.IncomingDocumentInfoGenerator;

public class IncomingDocumentBuilder extends DocumentBuilder {
    String sender;
    String recipient;
    int outgoingNumber;
    String outgoingRegDate;
    private IncomingDocumentBuilder sender() {
        this.sender = IncomingDocumentInfoGenerator.generateSender();
        return this;
    }
    private IncomingDocumentBuilder recipient() {
        this.recipient = IncomingDocumentInfoGenerator.generateRecipient();
        return this;
    }
    private IncomingDocumentBuilder outgoingNumber() {
        this.outgoingNumber = IncomingDocumentInfoGenerator.generateOutgoingNumber();
        return this;
    }
    private IncomingDocumentBuilder outgoingRegDate() {
        this.outgoingRegDate = IncomingDocumentInfoGenerator.generateRegDate();
        return this;
    }
    public void build(IncomingDocument document) {
        super.build(document);
        sender().recipient().outgoingNumber().outgoingRegDate();
        document.setSender(this.sender);
        document.setRecipient(this.recipient);
        document.setOutgoingNumber(this.outgoingNumber);
        document.setOutgoingRegDate(this.outgoingRegDate);
    }
}
