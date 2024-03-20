package ru.julia.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class OutgoingDocRequestDto extends DocumentRequestDto {
    @NotNull
    private UUID recipientId;
    @NotNull
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
