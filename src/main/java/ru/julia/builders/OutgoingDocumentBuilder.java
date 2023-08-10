package ru.julia.builders;

import ru.julia.documents.OutgoingDocument;
import ru.julia.factories.OutgoingDocumentFactory;

public class OutgoingDocumentBuilder extends DocumentBuilder {
    String recipient;
    String deliveryType;

    private OutgoingDocumentBuilder recipient() {
        this.recipient = OutgoingDocumentFactory.generateRecipient();
        return this;
    }

    private OutgoingDocumentBuilder deliveryType() {
        this.deliveryType = OutgoingDocumentFactory.generateDeliveryType();
        return this;
    }
    public void build(OutgoingDocument document) {
        super.build(document);
        recipient();
        deliveryType();
        document.setRecipient(this.recipient);
        document.setDeliveryType(this.deliveryType);
    }
}
