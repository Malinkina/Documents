package ru.julia.servicelayer.model;

import java.util.UUID;

public class IncomingDocModel extends DocumentModel {
    private UUID senderId;
    private UUID recipientId;
    private Integer outgoingNumber;
    private String outgoingRegDate;

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

    public Integer getOutgoingNumber() {
        return outgoingNumber;
    }

    public void setOutgoingNumber(Integer outgoingNumber) {
        this.outgoingNumber = outgoingNumber;
    }

    public String getOutgoingRegDate() {
        return outgoingRegDate;
    }

    public void setOutgoingRegDate(String outgoingRegDate) {
        this.outgoingRegDate = outgoingRegDate;
    }
}
