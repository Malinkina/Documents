package ru.julia.builders;

import ru.julia.documents.TaskDocument;
import ru.julia.representatives.InternalRepresentatives;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class TaskDocumentBuilder extends DocumentBuilder {
    String issueDate;
    String executionTerm;
    String responsibleExecutive;
    boolean controlMark;
    String controller;

    private TaskDocumentBuilder buildIssueDate() {
        LocalDate localDate = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.issueDate = localDate.format(formatter);
        return this;
    }

    private TaskDocumentBuilder buildExecutionTerm() {
        LocalDate localDate = LocalDate.now().plusDays(31);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.executionTerm = localDate.format(formatter);
        return this;
    }

    private TaskDocumentBuilder buildResponsibleExecutive() {
        this.responsibleExecutive = new InternalRepresentatives().randomRepresentative();
        return this;
    }

    private TaskDocumentBuilder buildControlMark() {
        this.controlMark = new Random().nextBoolean();
        return this;
    }

    private TaskDocumentBuilder buildController() {
        this.controller = new InternalRepresentatives().randomRepresentative();
        return null;
    }

    @Override
    public TaskDocument build() {
        TaskDocumentBuilder.super.buildId().buildName().buildText().buildRegNumber().buildRegDate().buildAuthor();
        buildIssueDate();
        buildExecutionTerm();
        buildResponsibleExecutive();
        buildControlMark();
        if (controlMark) {
            buildController();
        } else {
            this.controller = "Без контролера";
        }
        while (controller.equals(responsibleExecutive))
            buildController();
        return new TaskDocument(super.id, super.name, super.text, super.regNumber, super.regDate, super.author,
                                    issueDate, executionTerm, responsibleExecutive, controlMark, controller);
    }
}
