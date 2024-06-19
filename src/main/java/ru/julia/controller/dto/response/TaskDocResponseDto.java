package ru.julia.controller.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
@EqualsAndHashCode(callSuper = true)
@Data
public class TaskDocResponseDto extends DocumentResponseDto {
    private LocalDate issueDate;
    private String executionTerm;
    private String responsibleExecutive;
    private boolean controlMark;
    private String controller;
}
