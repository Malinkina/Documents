package ru.julia.servicelayer.model;

import java.util.UUID;

public class IncomingDocumentModel extends DocumentModel {
    private UUID senderId;
    private UUID recipientId;
    private int outgoingNumber;
    private String outgoingRegDate;

    private IncomingDocumentModel() {
    }

    public UUID getSenderId() {
        return senderId;
    }

    public void setSenderId(UUID senderId) {
        this.senderId = senderId;
    }

    public UUID getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(UUID recipientId) {
        this.recipientId = recipientId;
    }

    public int getOutgoingNumber() {
        return outgoingNumber;
    }

    public void setOutgoingNumber(int outgoingNumber) {
        this.outgoingNumber = outgoingNumber;
    }

    public String getOutgoingRegDate() {
        return outgoingRegDate;
    }

    public void setOutgoingRegDate(String outgoingRegDate) {
        this.outgoingRegDate = outgoingRegDate;
    }

    public static class IncomingDocumentModelBuilder extends DocumentModelBuilder<IncomingDocumentModel, IncomingDocumentModelBuilder> {
        private IncomingDocumentModel incomingDocumentModel = new IncomingDocumentModel();

        public IncomingDocumentModelBuilder senderId(UUID senderId) {
            incomingDocumentModel.senderId = senderId;
            return this;
        }
        public IncomingDocumentModelBuilder recipientId(UUID recipientId) {
            incomingDocumentModel.recipientId = recipientId;
            return this;
        }
        public IncomingDocumentModelBuilder outgoingNumber(int outgoingNumber) {
            incomingDocumentModel.outgoingNumber = outgoingNumber;
            return this;
        }
        public IncomingDocumentModelBuilder outgoingRegDate(String outgoingRegDate) {
            incomingDocumentModel.outgoingRegDate = outgoingRegDate;
            return this;
        }

        @Override
        protected IncomingDocumentModel getDocument() {
            return incomingDocumentModel;
        }

        @Override
        public IncomingDocumentModel build() {
            return incomingDocumentModel;
        }
    }
}
