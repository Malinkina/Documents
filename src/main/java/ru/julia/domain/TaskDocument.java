package ru.julia.domain;

public class TaskDocument extends Document {
    private String issueDate;
    private String executionTerm;
    private String responsibleExecutiveId;
    private boolean controlMark;
    private String controllerId;

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

    public String getResponsibleExecutiveId() {
        return responsibleExecutiveId;
    }

    public void setResponsibleExecutiveId(String responsibleExecutiveId) {
        this.responsibleExecutiveId = responsibleExecutiveId;
    }

    public boolean isControlMark() {
        return controlMark;
    }

    public void setControlMark(boolean controlMark) {
        this.controlMark = controlMark;
    }

    public String getControllerId() {
        return controllerId;
    }

    public void setControllerId(String controllerId) {
        this.controllerId = controllerId;
    }
}
