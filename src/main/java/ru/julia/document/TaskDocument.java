package ru.julia.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class TaskDocument extends Document {
    private LocalDate issueDate;
    private LocalDate executionTerm;
    private EmployeeXml responsibleExecutive;
    private Boolean controlMark;
    private EmployeeXml controller;

    public static class TaskDocumentBuilder extends DocumentBuilder<TaskDocument, TaskDocumentBuilder>{
        TaskDocument taskDocument = new TaskDocument();
        public TaskDocumentBuilder issueDate(LocalDate issueDate) {
            taskDocument.issueDate = issueDate;
            return this;
        }

        public TaskDocumentBuilder executionTerm(LocalDate executionTerm) {
            taskDocument.executionTerm = executionTerm;
            return this;
        }

        public TaskDocumentBuilder responsibleExecutive(EmployeeXml responsibleExecutive) {
            taskDocument.responsibleExecutive = responsibleExecutive;
            return this;
        }

        public TaskDocumentBuilder controlMark(Boolean controlMark) {
            taskDocument.controlMark = controlMark;
            return this;
        }

        public TaskDocumentBuilder controller(EmployeeXml controller) {
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