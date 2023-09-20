package ru.julia.factories;

import ru.julia.documents.TaskDocument;
import ru.julia.infogenerators.DocumentInfoGenerator;
import ru.julia.infogenerators.TaskDocumentInfoGenerator;

/**
 * Класс создает объект класса {@link TaskDocument}
 */
public class TaskDocumentFactory implements DocumentFactory {
    @Override
    public TaskDocument create() {
        return TaskDocument.newBuilder()
                .id(DocumentInfoGenerator.generateId())
                .name(DocumentInfoGenerator.generateName())
                .text(DocumentInfoGenerator.generateText())
                .regNumber(DocumentInfoGenerator.generateRegNumber())
                .regDate(DocumentInfoGenerator.generateRegDate())
                .author(DocumentInfoGenerator.generateAuthor())
                .issueDate(TaskDocumentInfoGenerator.generateIssueDate())
                .executionTerm(TaskDocumentInfoGenerator.generateExecutionTerm())
                .responsibleExecutive(TaskDocumentInfoGenerator.generateResponsibleExecutive())
                .controlMark(TaskDocumentInfoGenerator.generateControlMark())
                .controller(TaskDocumentInfoGenerator.generateController())
                .build();
    }
}
