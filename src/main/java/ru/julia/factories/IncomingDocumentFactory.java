package ru.julia.factories;

import ru.julia.builders.DocumentBuilder;
import ru.julia.builders.IncomingDocumentBuilder;
import ru.julia.documents.IncomingDocument;
import ru.julia.representatives.ExternalRepresentatives;
import ru.julia.representatives.InternalRepresentatives;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IncomingDocumentFactory extends DocumentBuilder {
    IncomingDocumentBuilder incomingDocumentBuilder = new IncomingDocumentBuilder();
    public static String generateSender() {
        return InternalRepresentatives.randomRepresentative();
    }
    public static String generateRecipient() {
        return ExternalRepresentatives.randomRepresentative();
    }
    public static int generateOutgoingNumber() {
        return ((int) (Math.random() * 20));
    }
    public static String generateRegDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localDate.format(formatter);
    }
    public IncomingDocument create() {
        IncomingDocument incomingDocument = new IncomingDocument();
        incomingDocumentBuilder.build(incomingDocument);
        return incomingDocument;
    }
}
