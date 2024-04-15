package ru.julia.servicelayer.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor

public class OutgoingDocModel extends DocumentModel {
    private UUID recipientId;
    private String deliveryType;
}
