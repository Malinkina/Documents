package ru.julia.dto.response;

public class TaskDocumentResponseDTO extends DocumentResponseDTO {
    private String issueDate;
    private String executionTerm;
    private String responsibleExecutive;
    private boolean controlMark;
    private String controller;

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

    public boolean isControlMark() {
        return controlMark;
    }

    public void setControlMark(boolean controlMark) {
        this.controlMark = controlMark;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }
}
