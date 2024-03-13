package ru.julia.dto.request;

import java.util.UUID;

public class OutgoingDocRequestDto extends DocumentRequestDto {
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
