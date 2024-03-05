package ru.julia.service.mapper;

import org.springframework.stereotype.Component;
import ru.julia.document.TaskDocument;
import ru.julia.orm.jpamodel.TaskDocumentJPA;
import ru.julia.service.modelforservice.TaskDocumentModel;
@Component
public class TaskDocumentMapper {
    public TaskDocumentModel taskDocumentToTaskDocumentModel(TaskDocument taskDocument) {
        TaskDocumentModel.TaskDocumentModelBuilder builder = new TaskDocumentModel.TaskDocumentModelBuilder();
        return builder
                .id(taskDocument.getId())
                .documentId(taskDocument.getDocumentId())
                .name(taskDocument.getName())
                .text(taskDocument.getText())
                .regNumber(taskDocument.getRegNumber())
                .regDate(taskDocument.getRegDate())
                .author(taskDocument.getAuthor())
                .issueDate(taskDocument.getIssueDate())
                .executionTerm(taskDocument.getExecutionTerm())
                .responsibleExecutiveId(taskDocument.getResponsibleExecutive().getId())
                .controlMark(taskDocument.isControlMark())
                .controllerId(taskDocument.getController().getId())
                .build();
    }
    public TaskDocumentJPA taskDocumentModelToTaskDocumentJpa(TaskDocumentModel taskDocumentModel) {
        TaskDocumentJPA taskDocumentJPA = new TaskDocumentJPA();
        taskDocumentJPA.setId(taskDocumentModel.getId());
        taskDocumentJPA.setDocumentId(taskDocumentModel.getDocumentId());
        taskDocumentJPA.setName(taskDocumentModel.getName());
        taskDocumentJPA.setText(taskDocumentModel.getText());
        taskDocumentJPA.setRegNumber(taskDocumentModel.getRegNumber());
        taskDocumentJPA.setRegDate(taskDocumentModel.getRegDate());
        taskDocumentJPA.setIssueDate(taskDocumentModel.getIssueDate());
        taskDocumentJPA.setExecutionTerm(taskDocumentModel.getExecutionTerm());
        taskDocumentJPA.setControlMark(taskDocumentModel.isControlMark());
        return taskDocumentJPA;
    }
}
