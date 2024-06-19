package ru.julia.controller.dto.response;

import java.time.LocalDate;

public class IncomingDocResponseDto extends DocumentResponseDto {
    private String sender;
    private String recipient;
    private Integer outgoingNumber;
    private LocalDate outgoingRegDate;

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

    public LocalDate getOutgoingRegDate() {
        return outgoingRegDate;
    }

    public void setOutgoingRegDate(LocalDate outgoingRegDate) {
        this.outgoingRegDate = outgoingRegDate;
    }
}
