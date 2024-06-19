package ru.julia.servicelayer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
public abstract class DocumentModel {
    private UUID id;
    private Integer docId;
    private String name;
    private String text;
    private String regNumber;
    private LocalDate regDate;
    private UUID authorId;
}
