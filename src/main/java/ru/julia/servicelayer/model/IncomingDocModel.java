package ru.julia.servicelayer.model;

import java.time.LocalDate;
import java.util.UUID;

public class IncomingDocModel extends DocumentModel {
    private UUID senderId;
    private UUID recipientId;
    private Integer outgoingNumber;
    private LocalDate outgoingRegDate;

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

    public LocalDate getOutgoingRegDate() {
        return outgoingRegDate;
    }

    public void setOutgoingRegDate(LocalDate outgoingRegDate) {
        this.outgoingRegDate = outgoingRegDate;
    }
}
