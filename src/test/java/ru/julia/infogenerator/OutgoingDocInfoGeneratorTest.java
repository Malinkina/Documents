package ru.julia.infogenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.julia.document.DeliveryType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class OutgoingDocInfoGeneratorTest {
    @Mock
    private EmployeeInfoGenerator employeeInfoGenerator;
    @InjectMocks
    private OutgoingDocInfoGenerator outgoingDocInfoGenerator;

    @Test
    void generateRecipient() {
        outgoingDocInfoGenerator.generateRecipient();
        Mockito.verify(employeeInfoGenerator, Mockito.times(1)).generateEmployee();
    }

    @Test
    void generateDeliveryType() {
        String deliveryType = outgoingDocInfoGenerator.generateDeliveryType();
        List<DeliveryType> deliveryTypeList = Arrays.asList(DeliveryType.values());
        List<String> deliveryTypes = new ArrayList<>();
        deliveryTypeList.forEach(type -> deliveryTypes.add(type.getValue()));
        assertTrue(deliveryTypes.contains(deliveryType));
    }
}