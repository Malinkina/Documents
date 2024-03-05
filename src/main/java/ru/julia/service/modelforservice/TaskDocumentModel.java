package ru.julia.service.modelforservice;

import java.util.UUID;

public class TaskDocumentModel extends DocumentModel {
    private String issueDate;
    private String executionTerm;
    private UUID responsibleExecutiveId;
    private boolean controlMark;
    private UUID controllerId;
    private TaskDocumentModel() {}

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
    public static class TaskDocumentModelBuilder extends DocumentModelBuilder<TaskDocumentModel, TaskDocumentModelBuilder> {
        private TaskDocumentModel taskDocumentModel = new TaskDocumentModel();
        public TaskDocumentModelBuilder issueDate(String issueDate) {
            taskDocumentModel.issueDate = issueDate;
            return this;
        }
        public TaskDocumentModelBuilder executionTerm(String executionTerm) {
            taskDocumentModel.executionTerm = executionTerm;
            return this;
        }
        public TaskDocumentModelBuilder responsibleExecutiveId(UUID responsibleExecutiveId) {
            taskDocumentModel.responsibleExecutiveId = responsibleExecutiveId;
            return this;
        }
        public TaskDocumentModelBuilder controlMark(boolean controlMark) {
            taskDocumentModel.controlMark = controlMark;
            return this;
        }
        public TaskDocumentModelBuilder controllerId(UUID controllerId) {
            taskDocumentModel.controllerId = controllerId;
            return this;
        }
        @Override
        protected TaskDocumentModel getDocument() {
            return taskDocumentModel;
        }

        @Override
        public TaskDocumentModel build() {
            return taskDocumentModel;
        }
    }
}
