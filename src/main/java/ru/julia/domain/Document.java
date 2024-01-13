package ru.julia.domain;

import lombok.Data;

import java.time.LocalDate;
@Data
public class Document {
    private String id;
    private int docId;
    private String name;
    private String text;
    private String regNumber;
    private LocalDate regDate;
    private String authorId;
}
