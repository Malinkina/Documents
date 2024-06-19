package ru.julia.controller.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.UUID;
@EqualsAndHashCode(callSuper = true)
@Data
public class TaskDocRequestDto extends DocumentRequestDto {
    @Future
    private LocalDate executionTerm;
    @NotNull
    private UUID responsibleExecutiveId;
    private Boolean controlMark;
    @NotNull
    private UUID controllerId;
}
