package ru.julia.infogenerators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.DeliveryTypes;
import ru.julia.documents.OutgoingDocument;
import ru.julia.staff.Employee;

import java.util.Random;

/**
 * Класс создает и возвращает объект класса {@link OutgoingDocument}
 */
@Component
public class OutgoingDocumentInfoGenerator {
    @Autowired
    EmployeeInfoGenerator employeeInfoGenerator;

    public Employee generateRecipient() {
        return employeeInfoGenerator.generateEmployee();
    }

    public String generateDeliveryType() {
        DeliveryTypes[] deliveryTypes = DeliveryTypes.values();
        return deliveryTypes[new Random().nextInt(deliveryTypes.length)].getValue();
    }
}