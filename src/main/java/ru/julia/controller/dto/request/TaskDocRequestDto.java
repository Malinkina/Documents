package ru.julia.controller.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public class TaskDocRequestDto extends DocumentRequestDto {
    @Future
    private LocalDate executionTerm;
    @NotNull
    private UUID responsibleExecutiveId;
    private Boolean controlMark;
    @NotNull
    private UUID controllerId;

    public LocalDate getExecutionTerm() {
        return executionTerm;
    }

    public void setExecutionTerm(LocalDate executionTerm) {
        this.executionTerm = executionTerm;
    }

    public UUID getResponsibleExecutiveId() {
        return responsibleExecutiveId;
    }

    public void setResponsibleExecutiveId(UUID responsibleExecutiveId) {
        this.responsibleExecutiveId = responsibleExecutiveId;
    }

    public boolean getControlMark() {
        return controlMark;
    }

    public void setControlMark(boolean controlMark) {
        this.controlMark = controlMark;
    }

    public UUID getControllerId() {
        return controllerId;
    }

    public void setControllerId(UUID controllerId) {
        this.controllerId = controllerId;
    }
}
