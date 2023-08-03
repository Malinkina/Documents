package ru.julia.documents;

import ru.julia.documents.Document;

public class TaskDocument extends Document {
    String issueDate;
    String executionTerm;
    String responsibleExecutive;
    boolean controlMark;
    String controller;


    public TaskDocument(int id, String name, String text, int regNumber, String regDate, String author,
                        String issueDate, String executionTerm, String responsibleExecutive,
                        boolean controlMark, String controller) {
        super(id, name, text, regNumber, regDate, author);
        this.issueDate = issueDate;
        this.executionTerm = executionTerm;
        this.responsibleExecutive = responsibleExecutive;
        this.controlMark = controlMark;
        this.controller = controller;
    }
    public String toString() {
        return "Поручение " + "№ " + "Задание_" + regNumber + " от " + regDate + ". " + name;
    }
}
