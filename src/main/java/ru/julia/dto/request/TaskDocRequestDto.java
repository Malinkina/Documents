package ru.julia.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class TaskDocRequestDto extends DocumentRequestDto {
    @Future
    private String executionTerm;
    @NotNull
    private UUID responsibleExecutiveId;
    private Boolean controlMark;
    @NotNull
    private UUID controllerId;

    public String getExecutionTerm() {
        return executionTerm;
    }

    public void setExecutionTerm(String executionTerm) {
        this.executionTerm = executionTerm;
    }

    public UUID getResponsibleExecutiveId() {
        return responsibleExecutiveId;
    }

    public void setResponsibleExecutiveId(UUID responsibleExecutiveId) {
        this.responsibleExecutiveId = responsibleExecutiveId;
    }

    public boolean isControlMark() {
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
