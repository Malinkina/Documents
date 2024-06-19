package ru.julia.servicelayer.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class IncomingDocModel extends DocumentModel {
    private UUID senderId;
    private UUID recipientId;
    private Integer outgoingNumber;
    private LocalDate outgoingRegDate;
}
