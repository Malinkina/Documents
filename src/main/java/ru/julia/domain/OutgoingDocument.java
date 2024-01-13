package ru.julia.domain;

import lombok.Data;

@Data
public class OutgoingDocument extends Document {
    private String recipientId;
    private String deliveryType;
}
