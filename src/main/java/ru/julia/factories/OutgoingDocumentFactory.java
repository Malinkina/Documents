package ru.julia.factories;

import ru.julia.DeliveryTypes;
import ru.julia.builders.OutgoingDocumentBuilder;
import ru.julia.documents.OutgoingDocument;
import ru.julia.representatives.ExternalRepresentatives;

public class OutgoingDocumentFactory extends DocumentFactory {
    OutgoingDocumentBuilder outgoingDocumentBuilder = new OutgoingDocumentBuilder();
    public static String generateRecipient() {
        return ExternalRepresentatives.randomRepresentative();
    }

    public static String generateDeliveryType() {
        DeliveryTypes[] deliveryTypes = DeliveryTypes.values();
        String deliveryType = deliveryTypes[(int) (Math.random() * 3)].toString();
        switch (deliveryType) {
            case "MAIL" -> {
                return "почтой";
            }
            case "EMAIL" -> {
                return "емаилом";
            }
            case "PIGEON" -> {
                return "голубем";
            }
            case "UZEDO" -> {
                return "юзэдой";
            }
        }
        return null;
    }

    @Override
    public OutgoingDocument create() {
        OutgoingDocument outgoingDocument = new OutgoingDocument();
        outgoingDocumentBuilder.build(outgoingDocument);
        return outgoingDocument;
    }
}
