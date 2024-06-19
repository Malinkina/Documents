package ru.julia.servicelayer.model;

import java.time.LocalDate;
import java.util.UUID;

public class TaskDocModel extends DocumentModel {
    private LocalDate issueDate;
    private LocalDate executionTerm;
    private UUID responsibleExecutiveId;
    private Boolean controlMark;
    private UUID controllerId;

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

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

    public Boolean getControlMark() {
        return controlMark;
    }

    public void setControlMark(Boolean controlMark) {
        this.controlMark = controlMark;
    }

    public UUID getControllerId() {
        return controllerId;
    }

    public void setControllerId(UUID controllerId) {
        this.controllerId = controllerId;
    }
}
