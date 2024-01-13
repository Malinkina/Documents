package ru.julia.document;

import ru.julia.staff.Employee;

/**
 * Класс описывает исходящий документ
 */
public class OutgoingDocument extends Document {
    private Employee recipient;
    private String deliveryType;

    private OutgoingDocument() {
    }

    public Employee getRecipient() {
        return recipient;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public String toString() {
        return "Исходящий № " + super.toString();
    }

    /**
     * Класс присваивает значения полям класса {@link OutgoingDocument}
     */
    public static class OutgoingDocumentBuilder extends DocumentBuilder<OutgoingDocument, OutgoingDocumentBuilder> {
        OutgoingDocument outgoingDocument = new OutgoingDocument();

        public OutgoingDocumentBuilder recipient(Employee recipient) {
            outgoingDocument.recipient = recipient;
            return this;
        }

        public OutgoingDocumentBuilder deliveryType(String deliveryType) {
            outgoingDocument.deliveryType = deliveryType;
            return this;
        }
        @Override
        protected OutgoingDocument getDocument() {
            return outgoingDocument;
        }

        @Override
        public OutgoingDocument build() {
            return outgoingDocument;
        }
    }
}