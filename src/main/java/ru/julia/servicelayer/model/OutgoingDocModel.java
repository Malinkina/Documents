package ru.julia.servicelayer.model;

import java.util.UUID;

public class OutgoingDocModel extends DocumentModel {
    private UUID recipientId;
    private String deliveryType;

    private OutgoingDocModel() {}

    public UUID getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(UUID recipientId) {
        this.recipientId = recipientId;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }
    public static class OutgoingDocumentModelBuilder extends DocumentModelBuilder<OutgoingDocModel, OutgoingDocumentModelBuilder> {
        private OutgoingDocModel outgoingDocModel = new OutgoingDocModel();
        public OutgoingDocumentModelBuilder recipient(UUID id) {
            outgoingDocModel.recipientId = id;
            return this;
        }
        public OutgoingDocumentModelBuilder deliveryType(String deliveryType) {
            outgoingDocModel.deliveryType = deliveryType;
            return this;
        }

        @Override
        protected OutgoingDocModel getDocument() {
            return outgoingDocModel;
        }

        @Override
        public OutgoingDocModel build() {
            return outgoingDocModel;
        }
    }
}
