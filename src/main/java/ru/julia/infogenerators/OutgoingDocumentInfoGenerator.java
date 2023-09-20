package ru.julia.infogenerators;

import ru.julia.DeliveryTypes;
import ru.julia.XMLReader;
import ru.julia.documents.OutgoingDocument;
import ru.julia.staff.Person;

/**
 * Класс создает и возвращает объект класса {@link OutgoingDocument}
 */
public class OutgoingDocumentInfoGenerator {
    public static Person generateRecipient() {
        return XMLReader.readPerson();
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
