package ru.julia.builders;

import ru.julia.representatives.ExternalRepresentatives;
import ru.julia.representatives.InternalRepresentatives;
import ru.julia.documents.IncomingDocument;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IncomingDocumentBuilder extends DocumentBuilder {
    String sender;
    String recipient;
    int outgoingNumber;
    String outgoingRegDate;
    private IncomingDocumentBuilder buildSender() {
        this.sender = new InternalRepresentatives().randomRepresentative();
        return this;
    }
    private IncomingDocumentBuilder buildRecipient() {
        this.recipient = new ExternalRepresentatives().randomRepresentative();
        return this;
    }
    private IncomingDocumentBuilder buildOutgoingNumber() {
        this.outgoingNumber = (int) (Math.random() * 1234);
        return this;
    }
    private IncomingDocumentBuilder buildOutgoingRegDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.outgoingRegDate = localDate.format(formatter);
        return this;
    }

    @Override
    public IncomingDocument build() {
        IncomingDocumentBuilder.super.buildId().buildName().buildText().buildRegNumber().buildRegDate().buildAuthor();
        buildSender();
        buildRecipient();
        buildOutgoingNumber();
        buildOutgoingRegDate();
        return new IncomingDocument(super.id, super.name, super.text, super.regNumber, super.regDate, super.author,
                                    sender, recipient, outgoingNumber, outgoingRegDate);
    }
}
