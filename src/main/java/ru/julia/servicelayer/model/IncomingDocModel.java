package ru.julia.servicelayer.model;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class IncomingDocModel extends DocumentModel {
    @Nonnull
    private UUID senderId;
    @Nonnull
    private UUID recipientId;
    @Nullable
    private Integer outgoingNumber;
    @Nullable
    private LocalDate outgoingRegDate;
}
