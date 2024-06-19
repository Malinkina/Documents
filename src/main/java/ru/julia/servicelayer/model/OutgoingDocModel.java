package ru.julia.servicelayer.model;

import java.util.UUID;

public class OutgoingDocModel extends DocumentModel {
    private UUID recipientId;
    private String deliveryType;

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
}
