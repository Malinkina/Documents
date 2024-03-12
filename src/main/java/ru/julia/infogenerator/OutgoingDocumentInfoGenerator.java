package ru.julia.infogenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.document.DeliveryTypes;
import ru.julia.document.OutgoingDocument;
import ru.julia.xml.xmlmodel.EmployeeXML;

import java.util.Random;

/**
 * Класс создает и возвращает объект класса {@link OutgoingDocument}
 */
@Component
public class OutgoingDocumentInfoGenerator {
    @Autowired
    EmployeeInfoGenerator employeeInfoGenerator;

    public EmployeeXML generateRecipient() {
        return employeeInfoGenerator.generateEmployee();
    }

    public String generateDeliveryType() {
        DeliveryTypes[] deliveryTypes = DeliveryTypes.values();
        return deliveryTypes[new Random().nextInt(deliveryTypes.length)].getValue();
    }
}
