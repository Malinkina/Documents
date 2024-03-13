package ru.julia.servicelayer.model;

import java.util.UUID;

public class IncomingDocModel extends DocumentModel {
    private UUID senderId;
    private UUID recipientId;
    private int outgoingNumber;
    private String outgoingRegDate;

    private IncomingDocModel() {
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

    public static class IncomingDocumentModelBuilder extends DocumentModelBuilder<IncomingDocModel, IncomingDocumentModelBuilder> {
        private IncomingDocModel incomingDocModel = new IncomingDocModel();

        public IncomingDocumentModelBuilder senderId(UUID senderId) {
            incomingDocModel.senderId = senderId;
            return this;
        }
        public IncomingDocumentModelBuilder recipientId(UUID recipientId) {
            incomingDocModel.recipientId = recipientId;
            return this;
        }
        public IncomingDocumentModelBuilder outgoingNumber(int outgoingNumber) {
            incomingDocModel.outgoingNumber = outgoingNumber;
            return this;
        }
        public IncomingDocumentModelBuilder outgoingRegDate(String outgoingRegDate) {
            incomingDocModel.outgoingRegDate = outgoingRegDate;
            return this;
        }

        @Override
        protected IncomingDocModel getDocument() {
            return incomingDocModel;
        }

        @Override
        public IncomingDocModel build() {
            return incomingDocModel;
        }
    }
}
