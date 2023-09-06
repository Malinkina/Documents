package ru.julia.factories;

import ru.julia.XMLReader;
import ru.julia.documents.TaskDocument;
import ru.julia.infogenerators.DocumentInfoGenerator;
import ru.julia.infogenerators.TaskDocumentInfoGenerator;

public class TaskDocumentFactory implements DocumentFactory {
    @Override
    public TaskDocument create() {
        return TaskDocument.newBuilder()
                .id(DocumentInfoGenerator.generateId())
                .name(DocumentInfoGenerator.generateName())
                .text(DocumentInfoGenerator.generateText())
                .regNumber(DocumentInfoGenerator.generateRegNumber())
                .regDate(DocumentInfoGenerator.generateRegDate())
                .author(XMLReader.readPerson())
                .issueDate(TaskDocumentInfoGenerator.generateIssueDate())
                .executionTerm(TaskDocumentInfoGenerator.generateExecutionTerm())
                .responsibleExecutive(XMLReader.readPerson())
                .controlMark(TaskDocumentInfoGenerator.generateControlMark())
                .controller(XMLReader.readPerson())
                .build();
    }
}
