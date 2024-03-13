package ru.julia.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.document.OutgoingDocument;
import ru.julia.infogenerator.OutgoingDocInfoGenerator;

/**
 * Класс создает объект класса {@link OutgoingDocument}
 */
@Component
public class OutgoingDocumentFactory extends AbstractDocumentFactory<OutgoingDocument, OutgoingDocument.OutgoingDocumentBuilder> {
    @Autowired
    private OutgoingDocInfoGenerator outgoingDocInfoGenerator;

    @Override
    public OutgoingDocument.OutgoingDocumentBuilder createBuilder() {
        return new OutgoingDocument.OutgoingDocumentBuilder();
    }

    @Override
    public void fill(OutgoingDocument.OutgoingDocumentBuilder builder) {
        builder
                .recipient(outgoingDocInfoGenerator.generateRecipient())
                .deliveryType(outgoingDocInfoGenerator.generateDeliveryType());
    }
}
