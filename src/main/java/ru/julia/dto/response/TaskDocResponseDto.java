package ru.julia.dto.response;

import java.util.UUID;

public class TaskDocResponseDto extends DocumentResponseDto {
    private UUID id;
    private String issueDate;
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

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
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

    public Boolean isControlMark() {
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
