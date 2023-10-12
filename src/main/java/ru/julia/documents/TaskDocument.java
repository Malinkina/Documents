package ru.julia.documents;

import ru.julia.staff.Person;

/**
 * Класс описывает документ-поручение
 */
public class TaskDocument extends Document {
    private String issueDate;
    private String executionTerm;
    private Person responsibleExecutive;
    private boolean controlMark;
    private Person controller;

    private TaskDocument() {
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

        public TaskDocumentBuilder responsibleExecutive(Person responsibleExecutive) {
            taskDocument.responsibleExecutive = responsibleExecutive;
            return this;
        }

        public TaskDocumentBuilder controlMark(boolean controlMark) {
            taskDocument.controlMark = controlMark;
            return this;
        }

        public TaskDocumentBuilder controller(Person controller) {
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
