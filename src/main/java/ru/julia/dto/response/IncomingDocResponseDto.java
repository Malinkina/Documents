package ru.julia.dto.response;

import java.util.UUID;

public class IncomingDocResponseDto extends DocumentResponseDto {
    private UUID id;
    private String sender;
    private String recipient;
    private Integer outgoingNumber;
    private String outgoingRegDate;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
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
