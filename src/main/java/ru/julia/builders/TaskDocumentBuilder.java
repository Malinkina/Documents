package ru.julia.builders;

import ru.julia.documents.TaskDocument;
import ru.julia.infogenerators.TaskDocumentInfoGenerator;
import ru.julia.representatives.InternalRepresentatives;

import java.util.Random;

public class TaskDocumentBuilder extends DocumentBuilder {
    String issueDate;
    String executionTerm;
    String responsibleExecutive;
    boolean controlMark;
    String controller;

    private TaskDocumentBuilder issueDate() {
        this.issueDate = TaskDocumentInfoGenerator.generateIssueDate();
        return this;
    }

    private TaskDocumentBuilder executionTerm() {
        this.executionTerm = TaskDocumentInfoGenerator.generateExecutionTerm();
        return this;
    }

    private TaskDocumentBuilder responsibleExecutive() {
        this.responsibleExecutive = InternalRepresentatives.randomRepresentative();
        return this;
    }

    private TaskDocumentBuilder controlMark() {
        this.controlMark = new Random().nextBoolean();
        return this;
    }

    private TaskDocumentBuilder controller() {
        this.controller = InternalRepresentatives.randomRepresentative();
        return this;
    }
    public void build(TaskDocument document) {
        super.build(document);
        issueDate().executionTerm().responsibleExecutive().controlMark().controller();
        document.setIssueDate(this.issueDate);
        document.setExecutionTerm(this.executionTerm);
        document.setResponsibleExecutive(this.responsibleExecutive);
        document.setControlMark(this.controlMark);
        document.setController(this.controller);
    }
}
