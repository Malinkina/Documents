package ru.julia.controller.dto.response;

import java.time.LocalDate;
import java.util.UUID;

public class TaskDocResponseDto extends DocumentResponseDto {
    private UUID id;
    private LocalDate issueDate;
    private String executionTerm;
    private String responsibleExecutive;
    private boolean controlMark;
    private String controller;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getExecutionTerm() {
        return executionTerm;
    }

    public void setExecutionTerm(String executionTerm) {
        this.executionTerm = executionTerm;
    }

    public String getResponsibleExecutive() {
        return responsibleExecutive;
    }

    public void setResponsibleExecutive(String responsibleExecutive) {
        this.responsibleExecutive = responsibleExecutive;
    }

    public Boolean getControlMark() {
        return controlMark;
    }

    public void setControlMark(Boolean controlMark) {
        this.controlMark = controlMark;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

}
