package ru.julia.documents;

public class TaskDocument extends Document {
    String issueDate;
    String executionTerm;
    String responsibleExecutive;
    boolean controlMark;
    String controller;

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public void setExecutionTerm(String executionTerm) {
        this.executionTerm = executionTerm;
    }

    public void setResponsibleExecutive(String responsibleExecutive) {
        this.responsibleExecutive = responsibleExecutive;
    }

    public void setControlMark(boolean controlMark) {
        this.controlMark = controlMark;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String toString() {
        return "Поручение " + "№ " + "Задание_" + regNumber + " от " + regDate + ". " + name;
    }
}
