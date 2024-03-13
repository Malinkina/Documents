package ru.julia.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.document.TaskDocument;
import ru.julia.infogenerator.TaskDocInfoGenerator;

/**
 * Класс создает объект класса {@link TaskDocument}
 */
@Component
public class TaskDocumentFactory extends AbstractDocumentFactory<TaskDocument, TaskDocument.TaskDocumentBuilder>{
    @Autowired
    private TaskDocInfoGenerator taskDocInfoGenerator;

    @Override
    public TaskDocument.TaskDocumentBuilder createBuilder() {
        return new TaskDocument.TaskDocumentBuilder();
    }

    @Override
    public void fill(TaskDocument.TaskDocumentBuilder builder) {
        builder
                .issueDate(taskDocInfoGenerator.generateIssueDate())
                .executionTerm(taskDocInfoGenerator.generateExecutionTerm())
                .responsibleExecutive(taskDocInfoGenerator.generateResponsibleExecutive())
                .controlMark(taskDocInfoGenerator.generateControlMark())
                .controller(taskDocInfoGenerator.generateController());
    }
}
