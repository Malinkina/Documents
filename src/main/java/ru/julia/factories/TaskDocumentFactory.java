package ru.julia.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.documents.TaskDocument;
import ru.julia.infogenerators.DocumentInfoGenerator;
import ru.julia.infogenerators.TaskDocumentInfoGenerator;

/**
 * Класс создает объект класса {@link TaskDocument}
 */
@Component
public class TaskDocumentFactory implements DocumentFactory {
    @Autowired
    DocumentInfoGenerator documentInfoGenerator;
    @Autowired
    TaskDocumentInfoGenerator taskDocumentInfoGenerator;
    @Override
    public TaskDocument create() {
        return TaskDocument.newBuilder()
                .id(documentInfoGenerator.generateId())
                .name(documentInfoGenerator.generateName())
                .text(documentInfoGenerator.generateText())
                .regNumber(documentInfoGenerator.generateRegNumber())
                .regDate(documentInfoGenerator.generateRegDate())
                .author(documentInfoGenerator.generateAuthor())
                .issueDate(taskDocumentInfoGenerator.generateIssueDate())
                .executionTerm(taskDocumentInfoGenerator.generateExecutionTerm())
                .responsibleExecutive(taskDocumentInfoGenerator.generateResponsibleExecutive())
                .controlMark(taskDocumentInfoGenerator.generateControlMark())
                .controller(taskDocumentInfoGenerator.generateController())
                .build();
    }
}
