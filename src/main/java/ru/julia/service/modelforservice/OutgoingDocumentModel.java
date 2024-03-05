package ru.julia.service.modelforservice;

import java.util.UUID;

public class OutgoingDocumentModel extends DocumentModel {
    private UUID recipientId;
    private String deliveryType;

    private OutgoingDocumentModel() {}

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
    public static class OutgoingDocumentModelBuilder extends DocumentModelBuilder<OutgoingDocumentModel, OutgoingDocumentModelBuilder> {
        private OutgoingDocumentModel outgoingDocumentModel = new OutgoingDocumentModel();
        public OutgoingDocumentModelBuilder recipient(UUID id) {
            outgoingDocumentModel.recipientId = id;
            return this;
        }
        public OutgoingDocumentModelBuilder deliveryType(String deliveryType) {
            outgoingDocumentModel.deliveryType = deliveryType;
            return this;
        }

        @Override
        protected OutgoingDocumentModel getDocument() {
            return outgoingDocumentModel;
        }

        @Override
        public OutgoingDocumentModel build() {
            return outgoingDocumentModel;
        }
    }
}
