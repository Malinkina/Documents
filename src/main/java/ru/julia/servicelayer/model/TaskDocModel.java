package ru.julia.servicelayer.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class TaskDocModel extends DocumentModel {
    private LocalDate issueDate;
    private LocalDate executionTerm;
    private UUID responsibleExecutiveId;
    private Boolean controlMark;
    private UUID controllerId;
}
