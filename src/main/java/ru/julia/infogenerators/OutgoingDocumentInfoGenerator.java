package ru.julia.infogenerators;

import ru.julia.DeliveryTypes;
import ru.julia.representatives.ExternalRepresentatives;

public class OutgoingDocumentInfoGenerator {
    public static String generateRecipient() {
        return ExternalRepresentatives.representatives.get((int) (Math.random() * 3));
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
}
