package ru.julia.servicelayer.model;

import java.util.UUID;

public class TaskDocModel extends DocumentModel {
    private String issueDate;
    private String executionTerm;
    private UUID responsibleExecutiveId;
    private boolean controlMark;
    private UUID controllerId;
    private TaskDocModel() {}

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
    public static class TaskDocumentModelBuilder extends DocumentModelBuilder<TaskDocModel, TaskDocumentModelBuilder> {
        private TaskDocModel taskDocModel = new TaskDocModel();
        public TaskDocumentModelBuilder issueDate(String issueDate) {
            taskDocModel.issueDate = issueDate;
            return this;
        }
        public TaskDocumentModelBuilder executionTerm(String executionTerm) {
            taskDocModel.executionTerm = executionTerm;
            return this;
        }
        public TaskDocumentModelBuilder responsibleExecutiveId(UUID responsibleExecutiveId) {
            taskDocModel.responsibleExecutiveId = responsibleExecutiveId;
            return this;
        }
        public TaskDocumentModelBuilder controlMark(boolean controlMark) {
            taskDocModel.controlMark = controlMark;
            return this;
        }
        public TaskDocumentModelBuilder controllerId(UUID controllerId) {
            taskDocModel.controllerId = controllerId;
            return this;
        }
        @Override
        protected TaskDocModel getDocument() {
            return taskDocModel;
        }

        @Override
        public TaskDocModel build() {
            return taskDocModel;
        }
    }
}
