package ru.julia.builders;

import ru.julia.documents.OutgoingDocument;
import ru.julia.infogenerators.OutgoingDocumentInfoGenerator;

public class OutgoingDocumentBuilder extends DocumentBuilder {
    String recipient;
    String deliveryType;

    private OutgoingDocumentBuilder recipient() {
        this.recipient = OutgoingDocumentInfoGenerator.generateRecipient();
        return this;
    }

    private OutgoingDocumentBuilder deliveryType() {
        this.deliveryType = OutgoingDocumentInfoGenerator.generateDeliveryType();
        return this;
    }
    public void build(OutgoingDocument document) {
        super.build(document);
        recipient().deliveryType();
        document.setRecipient(this.recipient);
        document.setDeliveryType(this.deliveryType);
    }
}
