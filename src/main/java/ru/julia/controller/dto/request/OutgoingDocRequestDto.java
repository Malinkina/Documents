package ru.julia.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;
@EqualsAndHashCode(callSuper = true)
@Data
public class OutgoingDocRequestDto extends DocumentRequestDto {
    @NotNull
    private UUID recipientId;
    @NotNull
    private String deliveryType;
}
