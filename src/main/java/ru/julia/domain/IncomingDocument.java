package ru.julia.domain;

import lombok.Data;

@Data
public class IncomingDocument extends Document {
    private String senderId;
    private String recipientId;
    private int outgoingNumber;
    private String outgoingRegDate;
}
