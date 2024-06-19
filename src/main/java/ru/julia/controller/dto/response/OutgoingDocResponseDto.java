package ru.julia.controller.dto.response;

import lombok.Data;

@Data
public class OutgoingDocResponseDto extends DocumentResponseDto {
    private String recipient;
    private String deliveryType;
}
