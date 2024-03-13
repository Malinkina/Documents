package ru.julia.dto.request;

import java.util.UUID;

public class IncomingDocRequestDto extends DocumentRequestDto {
    private UUID senderId;
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
