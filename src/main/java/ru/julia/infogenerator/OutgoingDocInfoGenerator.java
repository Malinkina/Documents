package ru.julia.infogenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.document.DeliveryType;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.util.Random;

@Component
public class OutgoingDocInfoGenerator {

    @Autowired
    EmployeeInfoGenerator employeeInfoGenerator;

    public EmployeeXml generateRecipient() {
        return employeeInfoGenerator.generateEmployee();
    }

    public String generateDeliveryType() {
        DeliveryType[] deliveryTypes = DeliveryType.values();
        return deliveryTypes[new Random().nextInt(deliveryTypes.length)].getValue();
    }
}
