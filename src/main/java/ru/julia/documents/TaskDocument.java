package ru.julia.documents;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskDocument extends Document {
    private String issueDate;
    private String executionTerm;
    private String responsibleExecutive;
    private boolean controlMark;
    private String controller;

    private TaskDocument() {
    }

    public static TaskDocumentBuilder newBuilder() {
        return new TaskDocument().new TaskDocumentBuilder();
    }

    public String toString() {
        return "Поручение № " + super.getRegNumber()
                + " от " + super.getRegDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                + ". " + super.getName();
    }

    public class TaskDocumentBuilder {
        private TaskDocumentBuilder() {
        }

        public TaskDocumentBuilder id(int id) {
            setId(id);
            return this;
        }

        public TaskDocumentBuilder name(String name) {
            setName(name);
            return this;
        }

        public TaskDocumentBuilder text(String text) {
            setText(text);
            return this;
        }

        public TaskDocumentBuilder regNumber(String regNumber) {
            setRegNumber(regNumber);
            return this;
        }

        public TaskDocumentBuilder regDate(LocalDate regDate) {
            setRegDate(regDate);
            return this;
        }

        public TaskDocumentBuilder author(String author) {
            setAuthor(author);
            return this;
        }

        public TaskDocumentBuilder issueDate(String issueDate) {
            TaskDocument.this.issueDate = issueDate;
            return this;
        }

        public TaskDocumentBuilder executionTerm(String executionTerm) {
            TaskDocument.this.executionTerm = executionTerm;
            return this;
        }

        public TaskDocumentBuilder responsibleExecutive(String responsibleExecutive) {
            TaskDocument.this.responsibleExecutive = responsibleExecutive;
            return this;
        }

        public TaskDocumentBuilder controlMark(boolean controlMark) {
            TaskDocument.this.controlMark = controlMark;
            return this;
        }

        public TaskDocumentBuilder controller(String controller) {
            TaskDocument.this.controller = controller;
            return this;
        }

        public TaskDocument build() {
            return TaskDocument.this;
        }
    }
}
