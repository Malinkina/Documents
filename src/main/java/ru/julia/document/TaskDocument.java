package ru.julia.document;

import ru.julia.xml.xmlmodel.EmployeeXML;

/**
 * Класс описывает документ-поручение
 */
public class TaskDocument extends Document {
    private String issueDate;
    private String executionTerm;
    private EmployeeXML responsibleExecutive;
    private boolean controlMark;
    private EmployeeXML controller;

    private TaskDocument() {
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getExecutionTerm() {
        return executionTerm;
    }

    public EmployeeXML getResponsibleExecutive() {
        return responsibleExecutive;
    }

    public boolean isControlMark() {
        return controlMark;
    }

    public EmployeeXML getController() {
        return controller;
    }

    public String toString() {
        return "Поручение № " + super.toString();
    }

    /**
     * Класс присваивает значения полям класса {@link TaskDocument}
     */
    public static class TaskDocumentBuilder extends DocumentBuilder<TaskDocument, TaskDocumentBuilder>{
        TaskDocument taskDocument = new TaskDocument();
        public TaskDocumentBuilder issueDate(String issueDate) {
            taskDocument.issueDate = issueDate;
            return this;
        }

        public TaskDocumentBuilder executionTerm(String executionTerm) {
            taskDocument.executionTerm = executionTerm;
            return this;
        }

        public TaskDocumentBuilder responsibleExecutive(EmployeeXML responsibleExecutive) {
            taskDocument.responsibleExecutive = responsibleExecutive;
            return this;
        }

        public TaskDocumentBuilder controlMark(boolean controlMark) {
            taskDocument.controlMark = controlMark;
            return this;
        }

        public TaskDocumentBuilder controller(EmployeeXML controller) {
            taskDocument.controller = controller;
            return this;
        }

        @Override
        protected TaskDocument getDocument() {
            return taskDocument;
        }

        @Override
        public TaskDocument build() {
            return taskDocument;
        }
    }
}