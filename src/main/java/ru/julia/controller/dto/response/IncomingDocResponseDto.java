package ru.julia.controller.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
@EqualsAndHashCode(callSuper = true)
@Data
public class IncomingDocResponseDto extends DocumentResponseDto {
    private String sender;
    private String recipient;
    private Integer outgoingNumber;
    private LocalDate outgoingRegDate;
}
