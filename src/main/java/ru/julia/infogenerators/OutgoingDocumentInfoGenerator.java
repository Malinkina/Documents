package ru.julia.infogenerators;

import org.springframework.stereotype.Component;
import ru.julia.DeliveryTypes;
import ru.julia.XMLReader;
import ru.julia.documents.OutgoingDocument;
import ru.julia.staff.Person;

import java.util.Random;

/**
 * Класс создает и возвращает объект класса {@link OutgoingDocument}
 */
@Component
public class OutgoingDocumentInfoGenerator {
    public Person generateRecipient() {
        return XMLReader.readPerson();
    }

    public String generateDeliveryType() {
        DeliveryTypes[] deliveryTypes = DeliveryTypes.values();
        return deliveryTypes[new Random().nextInt(deliveryTypes.length)].getValue();
    }
}
