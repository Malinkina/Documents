package ru.julia.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class IncomingDocRequestDto extends DocumentRequestDto {
    @NotNull
    private UUID senderId;
    @NotNull
    private UUID recipientId;

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
}
