package ru.julia.controller.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;
@Data
public abstract class DocumentResponseDto {
    private UUID id;
    private Integer docId;
    private String name;
    private String text;
    private LocalDate regDate;
    private String author;
}
