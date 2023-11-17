package ru.julia.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.documents.TaskDocument;
import ru.julia.infogenerators.TaskDocumentInfoGenerator;

/**
 * Класс создает объект класса {@link TaskDocument}
 */
@Component
public class TaskDocumentFactory extends AbstractDocumentFactory<TaskDocument, TaskDocument.TaskDocumentBuilder>{
    @Autowired
    private TaskDocumentInfoGenerator taskDocumentInfoGenerator;

    @Override
    public TaskDocument.TaskDocumentBuilder createBuilder() {
        return new TaskDocument.TaskDocumentBuilder();
    }

    @Override
    public void fill(TaskDocument.TaskDocumentBuilder builder) {
        builder
                .issueDate(taskDocumentInfoGenerator.generateIssueDate())
                .executionTerm(taskDocumentInfoGenerator.generateExecutionTerm())
                .responsibleExecutive(taskDocumentInfoGenerator.generateResponsibleExecutive())
                .controlMark(taskDocumentInfoGenerator.generateControlMark())
                .controller(taskDocumentInfoGenerator.generateController());
    }
}
